package model;

import exception.EmptyInputException;
import exception.InvalidNumberException;
import exception.InvalidPhoneNumberException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import util.RegexValidator;

public class Hostel implements Serializable {

    private String id;
    private String name;
    private String address;
    private String phone;
    private double elecUnitPrice;
    private double waterUnitPrice;
    private double internetCost;
    List<Room> rooms;

    public Hostel() {
        this.rooms = new ArrayList<>();
    }

    public Hostel(String id, String name, String address, String phone,
            double elecUnitPrice, double waterUnitPrice, double internetCost) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.elecUnitPrice = elecUnitPrice;
        this.waterUnitPrice = waterUnitPrice;
        this.internetCost = internetCost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws InvalidPhoneNumberException {
        if (!RegexValidator.isValidPhoneNumber(phone)) {
            throw new InvalidPhoneNumberException("Số điện thoại không hợp lệ.");
        }
        this.phone = phone;
    }

    public double getElecUnitPrice() {
        return elecUnitPrice;
    }

    public void setElecUnitPrice(double elecUnitPrice) throws InvalidNumberException {
        if (elecUnitPrice <= 0) {
            throw new InvalidNumberException("Đơn giá điện phải lớn hơn 0.");
        }
        this.elecUnitPrice = elecUnitPrice;
    }

    public double getWaterUnitPrice() {
        return waterUnitPrice;
    }

    public void setWaterUnitPrice(double waterUnitPrice) throws InvalidNumberException {
        if (waterUnitPrice <= 0) {
            throw new InvalidNumberException("Đơn giá nước phải lớn hơn 0.");
        }
        this.waterUnitPrice = waterUnitPrice;
    }

    public double getInternetCost() {
        return internetCost;
    }

    public void setInternetCost(double internetCost) throws InvalidNumberException {
        if (internetCost <= 0) {
            throw new InvalidNumberException("Tiền mạng phải lớn hơn 0.");
        }
        this.internetCost = internetCost;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hostel{" + "id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", elecUnitPrice=" + elecUnitPrice + ", waterUnitPrice=" + waterUnitPrice + ", internetCost=" + internetCost + ", rooms=" + rooms + '}';
    }

}
