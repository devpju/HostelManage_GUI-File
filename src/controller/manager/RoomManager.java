package controller.manager;

import controller.dao.HostelDAO;
import exception.EmptyInputException;
import exception.InvalidNumberException;
import java.util.ArrayList;
import java.util.List;
import model.Bill;
import model.Room;
import model.Tenant;
import util.FormatterUtil;

public class RoomManager {

    private static RoomManager instance;
    private List<Room> rooms;

    private RoomManager() {
        rooms = HostelManager.getInstance().getHostel().getRooms();
    }

    public static RoomManager getInstance() {
        if (instance == null) {
            instance = new RoomManager();
        }
        return instance;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room createNewRoom(String id, String areaStr, String type, String rentCostStr, String status)
            throws EmptyInputException, InvalidNumberException {

        if (id.trim().isEmpty() || areaStr.trim().isEmpty() || rentCostStr.trim().isEmpty()) {
            throw new EmptyInputException("Vui lòng điền đầy đủ thông tin.");
        }

        double area;
        try {
            area = Double.parseDouble(areaStr);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Diện tích không hợp lệ.");
        }

        double rentCost;
        try {
            rentCost = FormatterUtil.parsePrice(rentCostStr);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Giá thuê không hợp lệ.");
        }

        Room newRoom = new Room();
        newRoom.setId(id);
        newRoom.setType(type);
        newRoom.setStatus(status);
        newRoom.setArea(area);
        newRoom.setRentCost(rentCost);
        newRoom.setTenants(new ArrayList<>());
        newRoom.setBills(new ArrayList<>());

        return newRoom;
    }

    public void addNewRoom(Room newRoom) {
        rooms.add(newRoom);
        HostelDAO.updateHostel();
    }

    public void removeRoom(int indexToRemove) {
        rooms.remove(indexToRemove);
        HostelDAO.updateHostel();
    }

    public void updateRoom(int index, Room updatedRoom) {
        Room oldRoom = rooms.get(index);
        List<Bill> oldBills = oldRoom.getBills();
        List<Tenant> oldTenants = oldRoom.getTenants();
        updatedRoom.setBills(oldBills);
        updatedRoom.setTenants(oldTenants);
        rooms.set(index, updatedRoom);
        HostelDAO.updateHostel();
    }

    public boolean isRoomExist(String idRoom) {
        Room room = new Room(idRoom);
        return rooms.contains(room);
    }

}
