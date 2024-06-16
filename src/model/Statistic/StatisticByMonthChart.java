package model.Statistic;

public class StatisticByMonthChart {

    private int month;
    private double totalElectricityCost;
    private double totalWaterCost;
    private double totalRoomRevenue;
    private double totalRevenue;

    public StatisticByMonthChart() {
    }

    public StatisticByMonthChart(int month, double totalElectricityCost, double totalWaterCost, double totalRoomRevenue, double totalRevenue) {
        this.month = month;
        this.totalElectricityCost = totalElectricityCost;
        this.totalWaterCost = totalWaterCost;
        this.totalRoomRevenue = totalRoomRevenue;
        this.totalRevenue = totalRevenue;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getTotalElectricityCost() {
        return totalElectricityCost;
    }

    public void setTotalElectricityCost(double totalElectricityCost) {
        this.totalElectricityCost = totalElectricityCost;
    }

    public double getTotalWaterCost() {
        return totalWaterCost;
    }

    public void setTotalWaterCost(double totalWaterCost) {
        this.totalWaterCost = totalWaterCost;
    }

    public double getTotalRoomRevenue() {
        return totalRoomRevenue;
    }

    public void setTotalRoomRevenue(double totalRoomRevenue) {
        this.totalRoomRevenue = totalRoomRevenue;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString() {
        return "StatisticByMonth{"
                + "month=" + month
                + ", totalElectricityCost=" + totalElectricityCost
                + ", totalWaterCost=" + totalWaterCost
                + ", totalRoomRevenue=" + totalRoomRevenue
                + ", totalRevenue=" + totalRevenue
                + '}';
    }
}
