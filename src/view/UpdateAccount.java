package view;

import controller.AccountDAO;
import controller.AccountManager;
import exception.EmptyInputException;
import exception.InvalidNameException;
import exception.InvalidPasswordException;
import exception.InvalidPhoneNumberException;
import exception.InvalidUsernameException;
import model.Account;
import raven.toast.Notifications;
import view.component.OptionPaneCustom;

public class UpdateAccount extends javax.swing.JFrame {

    private AccountForm accountForm;
    private AccountManager accountManager;

    public UpdateAccount(javax.swing.JInternalFrame parent) {
        accountForm = (AccountForm) parent;
        accountManager = AccountManager.getInstance();
        initComponents();
        initFields();
        initToast();
    }

    public final void initFields() {
        Account accountSelected = accountForm.getAccountSelected();
        txtUsername.setText(accountSelected.getUsername());
        pswPass.setText(accountSelected.getPassword());
        pswConfirmPass.setText(accountSelected.getPassword());
        txtName.setText(accountSelected.getName());
        txtPhone.setText(accountSelected.getPhone());
        cbbRole.setSelectedItem(accountSelected.getRole());
    }

    public final void initToast() {
        Notifications.getInstance().setJFrame(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        pswPass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbbRole = new javax.swing.JComboBox<>();
        btnUpdateInfo = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        pswConfirmPass = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(89, 168, 105));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SỬA THÔNG TIN TÀI KHOẢN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        txtUsername.setEditable(false);
        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Tên tài khoản:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Mật khẩu mới:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Họ và tên:");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        pswPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Vai trò:");

        cbbRole.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Admin" }));

        btnUpdateInfo.setBackground(new java.awt.Color(89, 168, 105));
        btnUpdateInfo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUpdateInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateInfo.setText("Sửa thông tin");
        btnUpdateInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateInfoMouseClicked(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnClose.setText("Hủy");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        pswConfirmPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Xác nhận mật khẩu mới:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(cbbRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPhone)
                        .addComponent(txtName)
                        .addComponent(pswPass)
                        .addComponent(txtUsername)
                        .addComponent(pswConfirmPass)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pswPass, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pswConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateInfoMouseClicked
        try {
            String username = txtUsername.getText().trim();
            String password = new String(pswPass.getPassword()).trim();
            String passwordConfirm = new String(pswConfirmPass.getPassword()).trim();
            String name = txtName.getText().trim();
            String phone = txtPhone.getText().trim();
            String role = cbbRole.getSelectedItem().toString();

            if (!password.equals(passwordConfirm)) {
                throw new InvalidPasswordException("Mật khẩu xác nhận không trùng khớp.");
            }

            Account updatedAccount = accountManager.createNewAccount(username, password, name, phone, role);

            if (OptionPaneCustom.showOptionDialog(this, "Bạn có đồng ý thay đổi thông tin tài khoản không?",
                    "Xác nhận thay đổi thông tin tài khoản")) {

                accountManager.updateAccountInfo(accountForm.getRowSelected(), updatedAccount);

                Notifications.getInstance().show(Notifications.Type.SUCCESS,
                        Notifications.Location.TOP_CENTER, "Sửa thông tin tài khoản thành công!");

                accountForm.loadDataToTable(AccountDAO.readAccounts());
                this.dispose();
            }
        } catch (EmptyInputException e) {
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        } catch (InvalidPasswordException e) {
            pswPass.setText("");
            pswConfirmPass.setText("");
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        } catch (InvalidUsernameException e) {
            txtUsername.setText("");
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        } catch (InvalidNameException e) {
            txtName.setText("");
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        } catch (InvalidPhoneNumberException e) {
            txtPhone.setText("");
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        } catch (Exception e) {
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateInfoMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnUpdateInfo;
    private javax.swing.JComboBox<String> cbbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pswConfirmPass;
    private javax.swing.JPasswordField pswPass;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
