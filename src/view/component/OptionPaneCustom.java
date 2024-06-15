package view.component;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.Timer;

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

    public static void showSuccessDialog(Component parentComponent, String message) {
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE);
        String title = "Thành công";
        final JOptionPane showMessageDialog = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE);
        final javax.swing.JDialog dialog = new javax.swing.JDialog((java.awt.Frame) null, title, false);
        dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setModal(true);
        dialog.setContentPane(showMessageDialog);
        Timer timer = new Timer(1000, (e) -> {
            dialog.setVisible(false);
            dialog.dispose();
        });
        timer.setRepeats(false);
        timer.start();
        dialog.pack();
        dialog.setLocationRelativeTo(parentComponent);
        dialog.setVisible(true);
    }
}
