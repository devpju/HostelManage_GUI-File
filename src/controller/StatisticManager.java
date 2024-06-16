package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Account;
import model.Bill;
import model.Room;
import model.Statistic.StatisticByMonthChart;
import model.Tenant;

public class StatisticManager {

    private static StatisticManager instance;
    private List<Bill> bills;

    private StatisticManager() {
        bills = BillManager.getInstance().getBills();
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

    public List<StatisticByMonthChart> getRevenueByMonth(int year) {
        List<StatisticByMonthChart> revenues = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            int month = i;
            double totalElectricityCost = 0.0;
            double totalWaterCost = 0.0;
            double totalRoomRevenue = 0.0;
            double totalRevenue = 0.0;
            for (Bill bill : bills) {
                if (bill.getStatus().equals("Đã thanh toán")) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(bill.getStartAt());
                    if (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) == month) {
                        totalElectricityCost += bill.ElecCost();
                        totalWaterCost += bill.WaterCost();
                        totalRoomRevenue += bill.getRentCost();
                        totalRevenue += bill.sumCost();
                    }
                }
            }

            StatisticByMonthChart statistic = new StatisticByMonthChart(month + 1, totalElectricityCost, totalWaterCost, totalRoomRevenue, totalRevenue);
            revenues.add(statistic);
        }

        return revenues;
    }

    public int getQuantityTenantRenting() {
        List<Tenant> tenants = TenantManager.getInstance().getTenants();
        return tenants.size();
    }
}
