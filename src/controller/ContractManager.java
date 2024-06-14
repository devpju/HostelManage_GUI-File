package controller;

import exception.EmptyInputException;
import exception.InvalidNumberException;
import java.util.Date;
import java.util.List;
import model.Contract;
import model.Tenant;
import util.FormatterDisplay;

public class ContractManager {

    private static ContractManager instance;
    private List<Tenant> tenants;

    private ContractManager() {
        tenants = TenantManager.getInstance().getTenants();
    }

    public static ContractManager getInstance() {
        if (instance == null) {
            instance = new ContractManager();
        }
        return instance;
    }

    public Contract createNewContract(String id, Date startAt, Date endAt, String depositStr)
            throws InvalidNumberException, EmptyInputException {
        if (depositStr.trim().isEmpty()) {
            throw new EmptyInputException("Vui lòng nhập đầy đủ thông tin.");
        }
        double deposit = FormatterDisplay.parsePrice(depositStr);
        Contract newContract = new Contract();
        newContract.setId(id);
        newContract.setStartAt(startAt);
        newContract.setEndAt(endAt);
        newContract.setDeposit(deposit);
        return newContract;
    }
}
