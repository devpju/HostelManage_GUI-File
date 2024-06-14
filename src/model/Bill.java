package model;

import controller.HostelManager;
import java.io.Serializable;

public class Bill implements Serializable {

    private String id;
    private String startAt;
    private double numberElec;
    private double numberWater;
    private double internetCost;
    private double elecUnitPrice;
    private double waterUnitPrice;
    private String status;

    public Bill() {
    }

    public Bill(String id, String startAt, double numberElec, double numberWater, String status) {
        this.id = id;
        this.startAt = startAt;
        this.numberElec = numberElec;
        this.numberWater = numberWater;
        this.status = status;
        autoSetUnitPrice();
    }

    public final void autoSetUnitPrice() {
        Hostel hostel = HostelManager.getInstance().getHostel();
        this.elecUnitPrice = hostel.getElecUnitPrice();
        this.waterUnitPrice = hostel.getWaterUnitPrice();
        this.internetCost = hostel.getInternetCost();
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public double getNumberElec() {
        return numberElec;
    }

    public void setNumberElec(double numberElec) {
        this.numberElec = numberElec;
    }

    public double getNumberWater() {
        return numberWater;
    }

    public void setNumberWater(double numberWater) {
        this.numberWater = numberWater;
    }

    public double getInternetCost() {
        return internetCost;
    }

    public void setInternetCost(double internetCost) {
        this.internetCost = internetCost;
    }

    public double getElecUnitPrice() {
        return elecUnitPrice;
    }

    public void setElecUnitPrice(double elecUnitPrice) {
        this.elecUnitPrice = elecUnitPrice;
    }

    public double getWaterUnitPrice() {
        return waterUnitPrice;
    }

    public void setWaterUnitPrice(double waterUnitPrice) {
        this.waterUnitPrice = waterUnitPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double ElecCost() {
        return this.elecUnitPrice * this.numberElec;
    }

    public double WaterCost() {
        return this.waterUnitPrice * this.numberWater;
    }

    public double sumCost() {
        return this.internetCost + ElecCost() + WaterCost();
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", startAt=" + startAt + ", numberElec=" + numberElec + ", numberWater=" + numberWater + ", internetCost=" + internetCost + ", elecUnitPrice=" + elecUnitPrice + ", waterUnitPrice=" + waterUnitPrice + '}';
    }

}
