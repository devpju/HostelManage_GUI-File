package controller;

import java.util.List;
import model.Account;
import model.Room;
import model.Tenant;

public class StatisticManager {

    private static StatisticManager instance;

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }

    public int getQuantityAccount() {
        List<Account> accounts = AccountManager.getInstance().getAccounts();
        return accounts.size();
    }

    public int getQuantityRoomEmpty() {
        int count = 0;
        List<Room> rooms = RoomManager.getInstance().getRooms();
        for (Room room : rooms) {
            if (room.getStatus().equals("Sẵn sàng")) {
                count++;
            }
        }
        return count;
    }

    public int getQuantityTenantRenting() {
        List<Tenant> tenants = TenantManager.getInstance().getTenants();
        return tenants.size();
    }
}
