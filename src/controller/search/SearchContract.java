package controller.search;

import controller.manager.ContractManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Contract;
import util.DateConverter;

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

    public static List<Contract> searchByDate(LocalDate startDate, LocalDate endDate) {
        List<Contract> result = new ArrayList<>();
        for (Contract contract : contracts) {
            LocalDate startAt = contract.getStartAt();
            LocalDate endAt = contract.getEndAt();
            if (!endDate.isBefore(startAt) && !startDate.isAfter(endAt)) {
                result.add(contract);
            }
        }

        return result;
    }

}
