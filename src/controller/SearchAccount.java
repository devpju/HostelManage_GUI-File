package controller;

import java.util.ArrayList;
import java.util.List;
import model.Account;

public class SearchAccount {

    private static List<Account> accounts = AccountManager.getInstance().getAccounts();

    private SearchAccount() {
    }

    public static List<Account> searchAll(String text) {
        List<Account> result = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getName().toLowerCase().contains(text.toLowerCase())
                    || account.getUsername().toLowerCase().contains(text.toLowerCase())
                    || account.getRole().toLowerCase().contains(text.toLowerCase())
                    || account.getPhone().contains(text)) {
                result.add(account);
            }
        }
        return result;
    }

    public static List<Account> searchByName(String text) {
        List<Account> result = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getName().toLowerCase().contains(text.toLowerCase())) {
                result.add(account);
            }
        }
        return result;
    }

    public static List<Account> searchByUserName(String text) {
        List<Account> result = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getUsername().toLowerCase().contains(text.toLowerCase())) {
                result.add(account);
            }
        }
        return result;
    }

    public static List<Account> searchByRole(String text) {
        List<Account> result = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getRole().toLowerCase().contains(text.toLowerCase())) {
                result.add(account);
            }
        }
        return result;
    }

    public static List<Account> searchByPhone(String text) {
        List<Account> result = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getPhone().contains(text)) {
                result.add(account);
            }
        }
        return result;
    }
}
