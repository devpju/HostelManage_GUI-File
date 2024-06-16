package QuanLyPhongTro;

import com.formdev.flatlaf.FlatLightLaf;
import controller.manager.AccountManager;
import controller.dao.HostelDAO;
import controller.manager.HostelManager;
import exception.EmptyInputException;
import exception.InvalidNameException;
import exception.InvalidNumberException;
import exception.InvalidPasswordException;
import exception.InvalidPhoneNumberException;
import exception.InvalidUsernameException;
import java.util.Locale;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Account;
import model.Hostel;
import view.Admin;
import view.HostelForm;
import view.Login;

public class Main {

    public static void main(String[] args) throws EmptyInputException, InvalidUsernameException, InvalidPasswordException, InvalidNameException, InvalidPhoneNumberException, InvalidNumberException {
        FlatLightLaf.registerCustomDefaultsSource("style");
        FlatLightLaf.setup();
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
