package controller.search;

import controller.manager.RoomManager;
import java.util.ArrayList;
import java.util.List;
import model.Room;

public class SearchRoom {

    private static List<Room> rooms = RoomManager.getInstance().getRooms();

    private SearchRoom() {
    }

    public static List<Room> searchAll(String text) {
        List<Room> result = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getId().toLowerCase().contains(text.toLowerCase())
                    || room.getType().toLowerCase().contains(text.toLowerCase())
                    || room.getStatus().toLowerCase().contains(text.toLowerCase())
                    || String.valueOf(room.getArea()).contains(text)
                    || String.valueOf(room.getRentCost()).contains(text)) {
                result.add(room);
            }
        }
        return result;
    }

    public static List<Room> searchById(String text) {
        List<Room> result = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getId().toLowerCase().contains(text.toLowerCase())) {
                result.add(room);
            }
        }
        return result;
    }

    public static List<Room> searchByType(String text) {
        List<Room> result = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getType().toLowerCase().contains(text.toLowerCase())) {
                result.add(room);
            }
        }
        return result;
    }

    public static List<Room> searchByStatus(String text) {
        List<Room> result = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getStatus().toLowerCase().contains(text.toLowerCase())) {
                result.add(room);
            }
        }
        return result;
    }

    public static List<Room> searchByArea(String area) {
        List<Room> result = new ArrayList<>();
        for (Room room : rooms) {
            String areaString = String.valueOf(room.getArea());
            if (areaString.contains(String.valueOf(area))) {
                result.add(room);
            }
        }
        return result;
    }

    public static List<Room> searchByRentCost(String rentCost) {
        List<Room> result = new ArrayList<>();
        for (Room room : rooms) {
            String rentCostString = String.valueOf(room.getRentCost());
            if (rentCostString.contains(String.valueOf(rentCost))) {
                result.add(room);
            }
        }
        return result;
    }

}
