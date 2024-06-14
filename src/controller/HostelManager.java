package controller;

import exception.EmptyInputException;
import exception.InvalidNumberException;
import exception.InvalidPhoneNumberException;
import model.Hostel;
import util.FormatterDisplay;

public class HostelManager {

    private static HostelManager instance;
    private Hostel hostel;

    private HostelManager() {
        this.hostel = HostelDAO.readHostel();
    }

    public static HostelManager getInstance() {
        if (instance == null) {
            instance = new HostelManager();
        }
        return instance;
    }

    public Hostel getHostel() {
        return this.hostel;
    }

    public Hostel createNewHostel(String id, String name, String address, String phone,
            String elecUnitPriceStr, String waterUnitPriceStr, String internetCostStr)
            throws EmptyInputException, InvalidNumberException, InvalidPhoneNumberException {

        if (id.trim().isEmpty() || name.trim().isEmpty() || address.trim().isEmpty() || phone.trim().isEmpty()
                || elecUnitPriceStr.trim().isEmpty() || waterUnitPriceStr.trim().isEmpty()
                || internetCostStr.trim().isEmpty()) {
            throw new EmptyInputException("Vui lòng điền đầy đủ thông tin.");
        }
        double elecUnitPrice, waterUnitPrice, internetCost;
        try {
            elecUnitPrice = FormatterDisplay.parsePrice(elecUnitPriceStr);
            waterUnitPrice = FormatterDisplay.parsePrice(waterUnitPriceStr);
            internetCost = FormatterDisplay.parsePrice(internetCostStr);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Số tiền không hợp lệ.");
        }

        Hostel newHostel = new Hostel();
        newHostel.setId(id);
        newHostel.setName(name);
        newHostel.setAddress(address);
        newHostel.setPhone(phone);
        newHostel.setElecUnitPrice(elecUnitPrice);
        newHostel.setWaterUnitPrice(waterUnitPrice);
        newHostel.setInternetCost(internetCost);

        return newHostel;
    }

    public void updateHostel(Hostel updatedHostel) throws InvalidPhoneNumberException, InvalidNumberException {
        this.hostel.setId(updatedHostel.getId());
        this.hostel.setName(updatedHostel.getName());
        this.hostel.setAddress(updatedHostel.getAddress());
        this.hostel.setPhone(updatedHostel.getPhone());
        this.hostel.setElecUnitPrice(updatedHostel.getElecUnitPrice());
        this.hostel.setWaterUnitPrice(updatedHostel.getWaterUnitPrice());
        this.hostel.setInternetCost(updatedHostel.getInternetCost());
        HostelDAO.writeHostel(this.hostel);
    }

}
