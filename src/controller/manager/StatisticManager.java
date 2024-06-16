package controller.manager;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.YearMonth;
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

        for (int i = 1; i <= 12; i++) {
            double totalElectricityCost = 0.0;
            double totalWaterCost = 0.0;
            double totalRoomRevenue = 0.0;
            double totalRevenue = 0.0;

            for (Bill bill : bills) {
                if (bill.getStatus().equals("Đã thanh toán")) {
                    LocalDate startAt = bill.getStartAt();
                    YearMonth billYearMonth = YearMonth.from(startAt);

                    if (billYearMonth.getYear() == year && billYearMonth.getMonthValue() == i) {
                        totalElectricityCost += bill.ElecCost();
                        totalWaterCost += bill.WaterCost();
                        totalRoomRevenue += bill.getRentCost();
                        totalRevenue += bill.sumCost();
                    }
                }
            }

            StatisticByMonthChart statistic = new StatisticByMonthChart(i, totalElectricityCost, totalWaterCost, totalRoomRevenue, totalRevenue);
            revenues.add(statistic);
        }

        return revenues;
    }

    public int getQuantityTenantRenting() {
        List<Tenant> tenants = TenantManager.getInstance().getTenants();
        return tenants.size();
    }
}
