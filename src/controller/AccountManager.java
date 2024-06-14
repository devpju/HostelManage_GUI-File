package controller;

import exception.EmptyInputException;
import exception.InvalidNameException;
import exception.InvalidPasswordException;
import exception.InvalidPhoneNumberException;
import exception.InvalidUsernameException;
import exception.ObjectExistsException;
import java.util.List;
import model.Account;

public class AccountManager {

    private static AccountManager instance;
    private Account currentAccount;
    private List<Account> accounts;

    private AccountManager() {
        this.accounts = AccountDAO.readAccounts();
    }

    public static AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    // XỬ LÝ LOGIN
    public boolean isAccountExist(String username) {
        Account accountToCheck = new Account(username);
        return this.accounts.contains(accountToCheck);
    }

    public boolean authenticate(String username, String password)
            throws EmptyInputException, ObjectExistsException {
        if (username.isEmpty() || password.isEmpty()) {
            throw new EmptyInputException("Tài khoản và mật khẩu không được để trống!");
        }
        if (!isAccountExist(username)) {
            throw new ObjectExistsException("Tài khoản không tồn tại!");
        }
        for (Account account : accounts) {
            if (username.equals(account.getUsername()) && password.equals(account.getPassword())) {
                this.currentAccount = account;
                return true;
            }
        }
        return false;
    }

    // XỬ LÝ THAY ĐỔI THÔNG TIN TÀI KHOẢN CÁ NHÂN
    public void updatePersonalAccountInfo(String newName, String newPhone)
            throws EmptyInputException, InvalidNameException, InvalidPhoneNumberException {
        currentAccount.setName(newName);
        currentAccount.setPhone(newPhone);
        AccountDAO.writeAccounts(this.accounts);
    }

    public boolean updatePersonalAccountPassword(String newPass)
            throws EmptyInputException, InvalidPasswordException {
        this.currentAccount.setPassword(newPass);
        AccountDAO.writeAccounts(this.accounts);
        return true;
    }

    // XỬ LÝ TÀI KHOẢN NGƯỜI DÙNG
    public Account createNewAccount(String username, String password, String name, String phone, String role)
            throws EmptyInputException, InvalidUsernameException, InvalidPasswordException,
            InvalidNameException, InvalidPhoneNumberException {
        if (username.trim().isEmpty() || password.trim().isEmpty() || name.trim().isEmpty() || phone.trim().isEmpty()) {
            throw new EmptyInputException("Vui lòng điền đầy đủ thông tin.");
        }
        Account newAccount = new Account();
        newAccount.setUsername(username);
        newAccount.setPassword(password);
        newAccount.setName(name);
        newAccount.setPhone(phone);
        newAccount.setRole(role);
        return newAccount;
    }

    public void addNewAccount(Account newAccount) {
        this.accounts.add(newAccount);
        AccountDAO.writeAccounts(this.accounts);
    }

    public void updateAccountInfo(int positionToUpdate, Account updatedAccount) {
        this.accounts.set(positionToUpdate, updatedAccount);
        AccountDAO.writeAccounts(this.accounts);
    }

    public void removeAccount(int positionToRemove) {
        this.accounts.remove(positionToRemove);
        AccountDAO.writeAccounts(this.accounts);
    }

}
