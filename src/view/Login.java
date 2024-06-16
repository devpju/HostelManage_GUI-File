package view;

import controller.manager.AccountManager;
import exception.EmptyInputException;
import exception.InvalidPasswordException;
import exception.ObjectExistsException;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.text.DefaultCaret;
import view.component.OptionPaneCustom;

public class Login extends javax.swing.JFrame {

    AccountManager accountManager;

    public Login() {
        accountManager = AccountManager.getInstance();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pswPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        cbShowPass = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setBackground(javax.swing.UIManager.getDefaults().getColor("Menu.icon.arrowColor"));

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(38, 162, 116));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ĐĂNG NHẬP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(13, 39, 51));

        txtUsername.setBackground(new java.awt.Color(13, 39, 51));
        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setText("admin");
        txtUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        DefaultCaret caret = (DefaultCaret) pswPassword.getCaret();
        caret.setBlinkRate(500); // Đặt tốc độ nhấp nháy của con trỏ
        txtUsername.setCaretColor(Color.WHITE); // Đặt màu con trỏ nhấp nháy

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tài khoản:");

        pswPassword.setBackground(new java.awt.Color(13, 39, 51));
        pswPassword.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        pswPassword.setForeground(new java.awt.Color(255, 255, 255));
        pswPassword.setText("Admin123");
        pswPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        pswPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pswPassword.setCaretColor(Color.WHITE); // Đặt màu con trỏ nhấp nháy

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mật khẩu:");

        cbShowPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbShowPass.setForeground(new java.awt.Color(255, 255, 255));
        cbShowPass.setText("Hiện mật khẩu");
        cbShowPass.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cbShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowPassActionPerformed(evt);
            }
        });

        btnLogin.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Đăng nhập");
        btnLogin.setBorder(null);
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(pswPassword)
                    .addComponent(cbShowPass, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(pswPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbShowPass)
                .addGap(27, 27, 27)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowPassActionPerformed
        if (cbShowPass.isSelected())
            pswPassword.setEchoChar((char) 0);
        else
            pswPassword.setEchoChar('\u25CF');
    }//GEN-LAST:event_cbShowPassActionPerformed

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        try {
            String username = txtUsername.getText().trim();
            String password = new String(pswPassword.getPassword()).trim();

            if (!accountManager.authenticate(username, password)) {
                pswPassword.setText("");
                throw new InvalidPasswordException("Mật khẩu không chính xác.");
            }
            OptionPaneCustom.showSuccessDialog(this, "Đăng nhập thành công!");
            new Admin().setVisible(true);
            this.dispose();
        } catch (ObjectExistsException e) {
            txtUsername.setText("");
            pswPassword.setText("");
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        } catch (InvalidPasswordException e) {
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        } catch (EmptyInputException e) {
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        } catch (Exception e) {
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnLoginMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox cbShowPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField pswPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
