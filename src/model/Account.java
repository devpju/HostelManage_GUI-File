package model;

import exception.EmptyInputException;
import exception.InvalidNameException;
import exception.InvalidPasswordException;
import exception.InvalidPhoneNumberException;
import exception.InvalidUsernameException;
import java.io.Serializable;
import java.util.Objects;
import util.RegexValidator;

public class Account implements Serializable {

    private String username;
    private String password;
    private String name;
    private String phone;
    private String role;

    public Account() {
    }

    public Account(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws EmptyInputException, InvalidUsernameException {
        if (!RegexValidator.isValidUsername(username)) {
            throw new InvalidUsernameException("Tên tài khoản tối thiểu 5 ký tự, phải bắt đầu bằng chữ hoa"
                    + " hoặc chữ thường, tiếp theo có thể chứa chữ cái, số và dấu gạch dưới.");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws EmptyInputException, InvalidPasswordException {
        if (!RegexValidator.isValidPassword(password)) {
            throw new InvalidPasswordException("Mật khẩu tối thiểu 8 ký tự, chứa ít nhất một chữ số, "
                    + "một chữ cái in hoa và một chữ thường.");
        }
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws EmptyInputException, InvalidNameException {
        if (!RegexValidator.isValidName(name)) {
            throw new InvalidNameException("Họ và tên không hợp lệ.");
        }
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws EmptyInputException, InvalidPhoneNumberException {
        if (!RegexValidator.isValidPhoneNumber(phone)) {
            throw new InvalidPhoneNumberException("Số điện thoại không hợp lệ.");
        }
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        return Objects.equals(this.username, other.username);
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", name=" + name + ", phone=" + phone + ", role=" + role + '}';
    }

}
