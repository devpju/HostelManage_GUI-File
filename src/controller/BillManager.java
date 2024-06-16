package controller;

import exception.EmptyInputException;
import exception.InvalidNumberException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Room;
import model.Bill;
import util.FormatterUtil;

public class BillManager {

    private static BillManager instance;
    private List<Room> rooms;

    private BillManager() {
        rooms = RoomManager.getInstance().getRooms();
    }

    public static BillManager getInstance() {
        if (instance == null) {
            instance = new BillManager();
        }
        return instance;
    }

    public String createIdBill(Room selectedRoom) {
        List<Bill> bills = selectedRoom.getBills();
        String idRoom = selectedRoom.getId();
        int maxId = 0;
        for (Bill bill : bills) {
            String id = bill.getId();
            if (id.startsWith("BI") && id.endsWith(idRoom)) {
                int num = Integer.parseInt(id.substring(2, id.length() - idRoom.length()));
                if (num > maxId) {
                    maxId = num;
                }
            }
        }
        String idBill = "BI" + (maxId + 1) + idRoom;
        return idBill;
    }

    public List<Bill> getBills() {
        List<Bill> bills = new ArrayList<>();
        for (Room room : rooms) {
            bills.addAll(room.getBills());
        }
        return bills;
    }

    public List<Bill> getBillsByRoom(Room selectedRoom) {
        return selectedRoom.getBills();
    }

    public Bill createNewBill(String id, String idRoom, Date startAt, String numberElecStr, String numberWaterStr, String rentCostStr, String status)
            throws EmptyInputException, InvalidNumberException {

        if (id.trim().isEmpty() || numberElecStr.trim().isEmpty() || numberWaterStr.trim().isEmpty() || idRoom.trim().isEmpty()) {
            throw new EmptyInputException("Vui lòng điền đầy đủ thông tin.");
        }

        Bill newBill = new Bill();
        newBill.setId(id);
        newBill.setIdRoom(idRoom);
        newBill.setStartAt(startAt);
        double rentCost = FormatterUtil.parsePrice(rentCostStr);
        int numberElec;
        try {
            numberElec = Integer.parseInt(numberElecStr);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Số điện không hợp lệ.");
        }
        int numberWater;
        try {
            numberWater = Integer.parseInt(numberWaterStr);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Số nước không hợp lệ.");
        }
        newBill.setNumberElec(numberElec);
        newBill.setNumberWater(numberWater);
        newBill.setStatus(status);
        newBill.setUnitPrice();
        newBill.setRentCost(rentCost);
        return newBill;
    }

    public void addNewBill(Room selectedRoom, Bill newBill) {
        for (Room room : rooms) {
            if (room.equals(selectedRoom)) {
                room.getBills().add(newBill);
                HostelDAO.updateHostel();
                return;
            }
        }
    }

    public void removeBillById(String billId) {
        for (Room room : rooms) {
            List<Bill> bills = room.getBills();
            for (int i = 0; i < bills.size(); i++) {
                if (bills.get(i).getId().equals(billId)) {
                    bills.remove(i);
                    HostelDAO.updateHostel();
                    return;
                }
            }
        }
    }

    public void updateBillById(String billId, Bill newBill) {
        for (Room room : rooms) {
            List<Bill> bills = room.getBills();
            for (int i = 0; i < bills.size(); i++) {
                if (bills.get(i).getId().equals(billId)) {
                    bills.set(i, newBill);
                    HostelDAO.updateHostel();
                    return;
                }
            }
        }
    }

}
