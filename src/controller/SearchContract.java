package controller;

import java.util.ArrayList;
import java.util.List;
import model.Contract;

public class SearchContract {

    private static List<Contract> contracts = ContractManager.getInstance().getContracts();

    private SearchContract() {
    }

    public static List<Contract> searchByStatus(String text) {
        List<Contract> result = new ArrayList<>();
        for (Contract contract : contracts) {
            switch (text) {
                case "Đã hết hạn" -> {
                    if (contract.getStatus().contains("Đã hết hạn")) {
                        result.add(contract);
                    }
                }
                case "Đã báo hủy" -> {
                    System.out.println("2139-0-091");
                    if (contract.getStatus().startsWith("Hủy HĐ")) {
                        result.add(contract);
                    }
                }
                case "Sắp hết hạn" -> {
                    if (contract.getStatus().startsWith("Còn")) {
                        String daysStr = contract.getStatus().split(" ")[1];
                        int remainingDays = Integer.parseInt(daysStr);

                        if (remainingDays <= 10) {
                            result.add(contract);
                        }
                    }
                }
            }
        }
        return result;
    }
}
