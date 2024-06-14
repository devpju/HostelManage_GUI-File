package view.component;

import java.awt.Component;
import javax.swing.JOptionPane;

public class OptionPaneCustom {

    public static boolean showOptionDialog(Object parentComponent, String message, String title) {
        Object[] options = {"Có", "Không"};
        int choice = JOptionPane.showOptionDialog((Component) parentComponent,
                message,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        return choice == JOptionPane.YES_OPTION;
    }

    public static void showErrorDialog(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent,
                message,
                "Lỗi",
                JOptionPane.ERROR_MESSAGE);
    }
}
