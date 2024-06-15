package controller;

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

    public static List<Contract> searchByDate(Date start, Date end) {
        List<Contract> result = new ArrayList<>();

        LocalDate startDate = DateConverter.toLocalDate(start);
        LocalDate endDate = DateConverter.toLocalDate(end);

        for (Contract contract : contracts) {
            LocalDate startAt = DateConverter.toLocalDate(contract.getStartAt());
            LocalDate endAt = DateConverter.toLocalDate(contract.getEndAt());

            if (startAt != null && endAt != null && isDateInRange(startDate, endDate, startAt, endAt)) {
                result.add(contract);
            }
        }

        return result;
    }

    private static boolean isDateInRange(LocalDate startRange, LocalDate endRange, LocalDate startDate, LocalDate endDate) {
        return !startDate.isBefore(startRange) && !endDate.isAfter(endRange);
    }
}
