package model;

import controller.HostelManager;
import exception.InvalidNumberException;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Bill implements Serializable {

    private String id;
    private String idRoom;
    private Date startAt;
    private int numberElec;
    private int numberWater;
    private double internetCost;
    private double elecUnitPrice;
    private double waterUnitPrice;
    private String status;

    public Bill() {
    }

    public Bill(String id, String idRoom, Date startAt, int numberElec, int numberWater, String status) {
        this.id = id;
        this.startAt = startAt;
        this.numberElec = numberElec;
        this.numberWater = numberWater;
        this.status = status;
        setUnitPrice();
    }

    public final void setUnitPrice() {
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

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public int getNumberElec() {
        return numberElec;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public void setNumberElec(int numberElec) throws InvalidNumberException {
        if (numberElec <= 0) {
            throw new InvalidNumberException("Số điện phải lớn hơn 0.");
        }
        this.numberElec = numberElec;
    }

    public int getNumberWater() {
        return numberWater;
    }

    public void setNumberWater(int numberWater) throws InvalidNumberException {
        if (numberWater <= 0) {
            throw new InvalidNumberException("Số nước phải lớn hơn 0.");
        }
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
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bill other = (Bill) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", idRoom=" + idRoom + ", startAt=" + startAt + ", numberElec=" + numberElec + ", numberWater=" + numberWater + ", internetCost=" + internetCost + ", elecUnitPrice=" + elecUnitPrice + ", waterUnitPrice=" + waterUnitPrice + ", status=" + status + '}';
    }

}
