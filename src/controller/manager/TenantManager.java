package controller.manager;

import controller.dao.HostelDAO;
import exception.EmptyInputException;
import exception.InvalidNameException;
import exception.InvalidNumberException;
import exception.InvalidPhoneNumberException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Contract;
import model.Room;
import model.Tenant;
import util.DateConverter;

public class TenantManager {

    private static TenantManager instance;
    private List<Room> rooms;
    private String idTenant;

    private TenantManager() {
        rooms = RoomManager.getInstance().getRooms();
    }

    public static TenantManager getInstance() {
        if (instance == null) {
            instance = new TenantManager();
        }
        return instance;
    }

    public String createIdTenant(Room selectedRoom) {
        List<Tenant> tenants = selectedRoom.getTenants();
        String idRoom = selectedRoom.getId();
        int maxId = 0;
        for (Tenant tenant : tenants) {
            String id = tenant.getId();
            if (id.startsWith("KT") && id.endsWith(idRoom)) {

                int num = Integer.parseInt(id.substring(2, id.length() - idRoom.length()));
                if (num > maxId) {
                    maxId = num;
                }
            }
        }
        idTenant = "KT" + (maxId + 1) + idRoom;
        return idTenant;
    }

    public String createIdContract() {
        return "HD" + idTenant;
    }

    public List<Tenant> getTenants() {
        List<Tenant> tenants = new ArrayList<>();
        for (Room room : rooms) {
            tenants.addAll(room.getTenants());
        }
        return tenants;
    }

    public List<Tenant> getTenantsByRoom(Room selectedRoom) {
        return selectedRoom.getTenants();
    }

    public Tenant createNewTenant(String id, String name, String idRoom, String gender,
            Date dob, String phone, String address, Contract contract)
            throws EmptyInputException, InvalidNameException, InvalidNumberException, InvalidPhoneNumberException {

        if (id.trim().isEmpty() || name.trim().isEmpty() || idRoom.trim().isEmpty() || phone.trim().isEmpty()
                || address.trim().isEmpty()) {
            throw new EmptyInputException("Vui lòng điền đầy đủ thông tin.");
        }

        Tenant newTenant = new Tenant();
        newTenant.setId(id);
        newTenant.setName(name);
        newTenant.setIdRoom(idRoom);
        newTenant.setGender(gender);
        newTenant.setDob(DateConverter.toLocalDate(dob));
        newTenant.setPhone(phone);
        newTenant.setAddress(address);
        newTenant.setContract(contract);
        return newTenant;
    }

    public void addNewTenant(Room selectedRoom, Tenant newTenant) {
        for (Room room : rooms) {
            if (room.equals(selectedRoom)) {
                room.getTenants().add(newTenant);
                HostelDAO.updateHostel();
                return;
            }
        }
    }

    public void removeTenantById(String tenantId) {
        for (Room room : rooms) {
            List<Tenant> tenants = room.getTenants();
            for (int i = 0; i < tenants.size(); i++) {
                if (tenants.get(i).getId().equals(tenantId)) {
                    tenants.remove(i);
                    HostelDAO.updateHostel();
                    return;
                }
            }
        }
    }

    public void updateTenantById(String tenantId, Tenant newTenant) {
        for (Room room : rooms) {
            List<Tenant> tenants = room.getTenants();
            for (int i = 0; i < tenants.size(); i++) {
                if (tenants.get(i).getId().equals(tenantId)) {
                    tenants.set(i, newTenant);
                    HostelDAO.updateHostel();
                    return;
                }
            }
        }
    }

}
