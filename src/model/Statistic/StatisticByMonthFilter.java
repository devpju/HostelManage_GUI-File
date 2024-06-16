package model.Statistic;

import controller.manager.BillManager;
import java.time.LocalDate;
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
            LocalDate startAt = bill.getStartAt();
            int billMonth = startAt.getMonthValue();
            int billYear = startAt.getYear();

            if ("Đã thanh toán".equals(bill.getStatus()) && billMonth == month && billYear == year) {
                totalNumberElec += bill.getNumberElec();
                totalNumberWater += bill.getNumberWater();
                totalElecCost += bill.ElecCost();
                totalWaterCost += bill.WaterCost();
                totalInternetCost += bill.getInternetCost();
                totalRentCost += bill.getRentCost();
                totalRevenue += bill.sumCost();
            }
        }
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
