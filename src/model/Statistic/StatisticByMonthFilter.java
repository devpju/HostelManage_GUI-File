package model.Statistic;

import controller.BillManager;
import java.util.Calendar;
import java.util.List;
import model.Bill;

public class StatisticByMonthFilter {

    private int totalNumberElec = 0;
    private int totalNumberWater = 0;
    private double totalElecCost = 0;
    private double totalWaterCost = 0;
    private double totalInternetCost = 0;
    private double totalRentCost = 0;
    private double totalRevenue = 0;

    public StatisticByMonthFilter() {
    }

    public StatisticByMonthFilter(int month, int year) {
        statisticBills(month, year);
    }

    public final void statisticBills(int month, int year) {
        List<Bill> bills = BillManager.getInstance().getBills();
        for (Bill bill : bills) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(bill.getStartAt());
            int billMonth = cal.get(Calendar.MONTH) + 1;
            int billYear = cal.get(Calendar.YEAR);
            if ("Đã thanh toán".equals(bill.getStatus()) && billMonth == month && billYear == year) {
                totalNumberElec += bill.getNumberElec();
                totalNumberWater += bill.getNumberWater();
                totalElecCost += bill.ElecCost();
                totalWaterCost += bill.WaterCost();
                totalInternetCost += bill.getInternetCost();
                totalRevenue += bill.sumCost();
            }
        }
        totalRentCost = totalRevenue - totalWaterCost - totalInternetCost - totalElecCost;
    }

    // Getters for statistics
    public int getTotalNumberElec() {
        return totalNumberElec;
    }

    public int getTotalNumberWater() {
        return totalNumberWater;
    }

    public double getTotalRentCost() {
        return totalRentCost;
    }

    public double getTotalElecCost() {
        return totalElecCost;
    }

    public double getTotalWaterCost() {
        return totalWaterCost;
    }

    public double getTotalInternetCost() {
        return totalInternetCost;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

}
