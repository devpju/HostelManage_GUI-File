package QuanLyPhongTro;

import com.formdev.flatlaf.FlatLightLaf;
import controller.manager.AccountManager;
import controller.dao.HostelDAO;
import exception.EmptyInputException;
import exception.InvalidNameException;
import exception.InvalidNumberException;
import exception.InvalidPasswordException;
import exception.InvalidPhoneNumberException;
import exception.InvalidUsernameException;
import model.Account;
import model.Hostel;
import view.Login;

public class Main {

    public static void main(String[] args) throws EmptyInputException, InvalidUsernameException, InvalidPasswordException, InvalidNameException, InvalidPhoneNumberException, InvalidNumberException {
        FlatLightLaf.registerCustomDefaultsSource("style");
        FlatLightLaf.setup();
        
        // TẠO MỚI TÀI KHOẢN ĐĂNG NHẬP VÀ HOSTEL
//        Account ac = AccountManager.getInstance().createNewAccount("admin", "Admin123", "Trịnh Hoài Đức", "0987654321", "Admin");
//        AccountManager.getInstance().addNewAccount(ac);
//        Hostel hostel = new Hostel();
//        hostel.setId("PT01");
//        hostel.setName("Phương Giang");
//        hostel.setPhone("0931390580");
//        hostel.setAddress("Hà Nội");
//        hostel.setElecUnitPrice(3000);
//        hostel.setWaterUnitPrice(25000);
//        hostel.setInternetCost(100000);
//        HostelDAO.writeHostel(hostel);

        new Login().setVisible(true);

    }
}
