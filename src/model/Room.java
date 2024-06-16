package model;

import exception.EmptyInputException;
import exception.InvalidNumberException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room implements Serializable {

    private String id;
    private double area;
    private String type;
    private double rentCost;
    private String status;
    private List<Tenant> tenants;
    private List<Bill> bills;

    public Room() {
        this.tenants = new ArrayList<>();
        this.bills = new ArrayList<>();
    }

    public Room(String id) {
        this.id = id;
    }

    public Room(String id, double area, String type, double rentCost, String status) {
        this.id = id;
        this.area = area;
        this.type = type;
        this.rentCost = rentCost;
        this.status = status;
        this.bills = new ArrayList<>();
        this.tenants = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws EmptyInputException {
        this.id = id;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) throws InvalidNumberException {
        if (area <= 0) {
            throw new InvalidNumberException("Diện tích phòng phải lớn hơn 0.");
        }
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) throws InvalidNumberException {
        if (rentCost <= 0) {
            throw new InvalidNumberException("Giá thuê phòng phải lớn hơn 0.");
        }
        this.rentCost = rentCost;
    }

    public String getStatus() {
        autoSetStatus();
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Tenant> getTenants() {
        return tenants;
    }

    public void setTenants(List<Tenant> tenants) {
        this.tenants = tenants;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Room other = (Room) obj;
        return Objects.equals(this.id, other.id);
    }

    public void autoSetStatus() {
        if (this.status.equals("Đang sửa chữa")) {
            return;
        }
        if (!this.tenants.isEmpty()) {
            this.status = "Đang được thuê";

        } else {
            this.status = "Sẵn sàng";
        }
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", area=" + area + ", type=" + type + ", rentCost=" + rentCost + ", status=" + status + ", tenants=" + tenants + ", bills=" + bills + '}';
    }

}
