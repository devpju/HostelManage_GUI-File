package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Bill;

public class SearchBill {

    private static List<Bill> bills = BillManager.getInstance().getBills();

    private SearchBill() {
    }

    public static List<Bill> searchAll(String text) {
        List<Bill> result = new ArrayList<>();
        for (Bill bill : bills) {
            if (bill.getId().toLowerCase().contains(text.toLowerCase())
                    || bill.getIdRoom().toLowerCase().contains(text.toLowerCase())
                    || bill.getStatus().toLowerCase().contains(text.toLowerCase())) {
                result.add(bill);
            }
        }
        return result;
    }

    public static List<Bill> searchById(String text) {
        List<Bill> result = new ArrayList<>();
        for (Bill bill : bills) {
            if (bill.getId().toLowerCase().contains(text.toLowerCase())) {
                result.add(bill);
            }
        }
        return result;
    }

    public static List<Bill> searchByIdRoom(String text) {
        List<Bill> result = new ArrayList<>();
        for (Bill bill : bills) {
            if (bill.getIdRoom().toLowerCase().contains(text.toLowerCase())) {
                result.add(bill);
            }
        }
        return result;
    }

    public static List<Bill> searchByStatus(String text) {
        List<Bill> result = new ArrayList<>();
        for (Bill bill : bills) {
            if (bill.getStatus().toLowerCase().contains(text.toLowerCase())) {
                result.add(bill);
            }
        }
        return result;
    }

    public static List<Bill> searchByDate(int month, int year, String text, String type) {
        List<Bill> billsToSearch = new ArrayList<>();
        List<Bill> result = new ArrayList<>();
        if (text.trim().isEmpty()) {
            billsToSearch = BillManager.getInstance().getBills();
        } else {
            switch (type) {
                case "Tất cả" ->
                    billsToSearch = searchAll(text);
                case "ID Khách thuê" ->
                    billsToSearch = searchById(text);
                case "ID Phòng" ->
                    billsToSearch = searchByIdRoom(text);
                case "Trạng thái" ->
                    billsToSearch = searchByStatus(text);
            }
        }
        Calendar cal = Calendar.getInstance();
        for (Bill bill : billsToSearch) {
            cal.setTime(bill.getStartAt());
            int billMonth = cal.get(Calendar.MONTH);
            int billYear = cal.get(Calendar.YEAR);
            if (billMonth == month && billYear == year) {
                result.add(bill);
            }
        }
        return result;
    }
}
