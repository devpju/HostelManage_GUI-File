package model;

import exception.InvalidNameException;
import exception.InvalidPhoneNumberException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import util.RegexValidator;

public class Tenant implements Serializable {

    private String id;
    private String name;
    private String idRoom;
    private String gender;
    private LocalDate dob;
    private String phone;
    private String address;
    private Contract contract;

    public Tenant() {
    }

    public Tenant(String id, String name, String idRoom, String gender,
            LocalDate dob, String phone, String address, Contract contract) {
        this.id = id;
        this.name = name;
        this.idRoom = idRoom;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.contract = contract;
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

    public void setName(String name) throws InvalidNameException {
        if (!RegexValidator.isValidName(name)) {
            throw new InvalidNameException("Họ và tên không hợp lệ.");
        }
        this.name = name;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Tenant other = (Tenant) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Tenant{" + "id=" + id + ", name=" + name + ", idRoom=" + idRoom + ", gender=" + gender + ", dob=" + dob + ", phone=" + phone + ", address=" + address + ", contract=" + contract + '}';
    }

}
