package controller;

import exception.EmptyInputException;
import exception.InvalidNumberException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Contract;
import model.Room;
import model.Tenant;
import util.FormatterUtil;

public class ContractManager {

    private static ContractManager instance;
    private List<Room> rooms;

    private ContractManager() {
        rooms = RoomManager.getInstance().getRooms();
    }

    public static ContractManager getInstance() {
        if (instance == null) {
            instance = new ContractManager();
        }
        return instance;
    }

    public List<Contract> getContracts() {
        List<Contract> contracts = new ArrayList<>();
        for (Room room : rooms) {
            List<Tenant> tenants = room.getTenants();
            for (Tenant tenant : tenants) {
                contracts.add(tenant.getContract());
            }
        }
        return contracts;
    }

    public Contract createNewContract(String id, Date startAt, Date endAt, String depositStr)
            throws InvalidNumberException, EmptyInputException {
        if (depositStr.trim().isEmpty()) {
            throw new EmptyInputException("Vui lòng nhập đầy đủ thông tin.");
        }
        double deposit;
        try {
            deposit = FormatterUtil.parsePrice(depositStr);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Tiền cọc không hơp lệ.");
        }
        Contract newContract = new Contract();
        newContract.setId(id);
        newContract.setStartAt(startAt);
        newContract.setEndAt(endAt);
        newContract.setDeposit(deposit);
        return newContract;
    }

    public void updateContractById(String contractId, Contract updatedContract) throws InvalidNumberException {
        for (Room room : rooms) {
            List<Tenant> tenants = room.getTenants();
            for (Tenant tenant : tenants) {
                if (contractId.equals(tenant.getContract().getId())) {
                    tenant.getContract().setId(updatedContract.getId());
                    tenant.getContract().setStartAt(updatedContract.getStartAt());
                    tenant.getContract().setEndAt(updatedContract.getEndAt());
                    tenant.getContract().setDeposit(updatedContract.getDeposit());
                    tenant.getContract().updateStatus();
                    HostelDAO.updateHostel();
                    return;
                }
            }
        }
    }

    public void cancleContract(String contractId, String newStatus) {
                System.out.println("1092382039480239840293");

        for (Room room : rooms) {
            List<Tenant> tenants = room.getTenants();
            for (Tenant tenant : tenants) {
                if (contractId.equals(tenant.getContract().getId())) {
                    tenant.getContract().setStatus(newStatus);
                    HostelDAO.updateHostel();
                    System.out.println("02903840912=");
                    return;
                }
            }
        }
    }

    public void cancleCancleContract(String contractId) {
        System.out.println("1092382039480239840293");
        for (Room room : rooms) {
            List<Tenant> tenants = room.getTenants();
            for (Tenant tenant : tenants) {
                if (contractId.equals(tenant.getContract().getId())) {
                    tenant.getContract().updateStatus();
                    HostelDAO.updateHostel();
                    return;
                }
            }
        }
    }

}
