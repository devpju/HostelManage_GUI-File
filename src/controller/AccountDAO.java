package controller;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Account;

public class AccountDAO {

    private static File accountsFile = new File("account.dat");

    public static void writeAccounts(List<Account> accounts) {
        try (FileOutputStream fos = new FileOutputStream(accountsFile); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Lưu accounts vào file " + accountsFile + " thất bại!\nLỗi: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static List<Account> readAccounts() {
        List<Account> accounts;
        try (FileInputStream fis = new FileInputStream(accountsFile); ObjectInputStream ois = new ObjectInputStream(fis)) {
            accounts = (List<Account>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            accounts = new ArrayList<>();
            JOptionPane.showMessageDialog(null, "Đọc tài khoản từ file " + accountsFile + " thất bại!\nLỗi: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return accounts;
    }
}
