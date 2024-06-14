package view;

import controller.AccountDAO;
import controller.AccountManager;
import controller.SearchAccount;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Account;
import view.component.OptionPaneCustom;
import util.FormatterDisplay;

public class AccountForm extends javax.swing.JInternalFrame {

    private DefaultTableModel tblModel;
    private AccountManager accountManager;
    private List<Account> accounts;
    private int rowSelected = -1;
    private Account accountSelected;

    public AccountForm() {
        accountManager = AccountManager.getInstance();
        accounts = accountManager.getAccounts();
        initComponents();
        customeUI();
        initTable();
        customTable();
        loadDataToTable(accounts);
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"STT", "Tên tài khoản", "Họ và tên", "Số điện thoại", "Vai trò"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblAccount.setModel(tblModel);
        tblAccount.setAutoCreateRowSorter(true);
    }

    public final void loadDataToTable(List<Account> accounts) {
        try {
            int stt = 1;
            tblModel.setRowCount(0);
            for (Account acc : accounts) {
                tblModel.addRow(new Object[]{
                    stt++, acc.getUsername(), acc.getName(),
                    FormatterDisplay.formatPhoneNumber(acc.getPhone()), acc.getRole()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void customeUI() {
        BasicInternalFrameUI bif = (BasicInternalFrameUI) this.getUI();
        bif.setNorthPane(null);
    }

    private void customTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);

        for (int i = 0; i < tblAccount.getColumnCount(); i++) {
            tblAccount.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        UIManager.put("Table.showVerticalLines", true);
        tblAccount.setDefaultEditor(Object.class, null);
        tblAccount.getColumnModel().getColumn(0).setMaxWidth(90);

    }

    public int getRowSelected() {
        return this.rowSelected;
    }

    public Account getAccountSelected() {
        return accountSelected;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cbbSearchType = new javax.swing.JComboBox<>();
        txtSearchInput = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAccount = new javax.swing.JTable();

        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar1.setRollover(true);

        btnAdd.setBackground(new java.awt.Color(246, 246, 246));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setIconTextGap(-8);
        btnAdd.setMargin(new java.awt.Insets(0, 25, 0, 25));
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        jToolBar1.add(btnAdd);

        btnUpdate.setBackground(new java.awt.Color(246, 246, 246));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.setFocusable(false);
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.setIconTextGap(-8);
        btnUpdate.setMargin(new java.awt.Insets(0, 25, 0, 25));
        btnUpdate.setMinimumSize(new java.awt.Dimension(100, 82));
        btnUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        jToolBar1.add(btnUpdate);

        btnRemove.setBackground(new java.awt.Color(246, 246, 246));
        btnRemove.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remove.png"))); // NOI18N
        btnRemove.setText("Xóa");
        btnRemove.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemove.setIconTextGap(-8);
        btnRemove.setMargin(new java.awt.Insets(0, 25, 0, 25));
        btnRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });
        jToolBar1.add(btnRemove);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        cbbSearchType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Tên tài khoản", "Họ và tên", "Số điện thoại", "Vai trò" }));

        txtSearchInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchInputKeyReleased(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchInput, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReset)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tblAccount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên tài khoản", "Họ và tên", "Số điện thoại", "Vai trò"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAccount.setGridColor(new java.awt.Color(242, 242, 242));
        tblAccount.setRowHeight(30);
        tblAccount.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblAccount.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblAccount.setShowGrid(true);
        tblAccount.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tblAccount);
        if (tblAccount.getColumnModel().getColumnCount() > 0) {
            tblAccount.getColumnModel().getColumn(0).setHeaderValue("Tên tài khoản");
            tblAccount.getColumnModel().getColumn(1).setHeaderValue("Họ và tên");
            tblAccount.getColumnModel().getColumn(2).setHeaderValue("Số điện thoại");
            tblAccount.getColumnModel().getColumn(3).setHeaderValue("Vai trò");
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        new AddNewAccount(this).setVisible(true);
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        rowSelected = tblAccount.getSelectedRow();
        try {
            if (rowSelected == -1) {
                throw new Exception("Vui lòng chọn tài khoản để chỉnh sửa!");
            }

            accountSelected = accountManager.getAccounts().get(rowSelected);
            if (accountSelected.equals(accountManager.getCurrentAccount())) {
                throw new Exception("Bạn đang sử dụng tài khoản này! Không thể sửa tại đây!");
            }

            new UpdateAccount(this).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        rowSelected = tblAccount.getSelectedRow();
        try {
            if (rowSelected == -1) {
                throw new Exception("Vui lòng chọn tài khoản để xóa!");
            }

            accountSelected = accountManager.getAccounts().get(rowSelected);
            if (accountSelected.equals(accountManager.getCurrentAccount())) {
                throw new Exception("Bạn đang sử dụng tài khoản này! Không thể xóa!");
            }

            if (OptionPaneCustom.showOptionDialog(this,
                    "Bạn có đồng ý xóa tài khoản này không?", "Xác nhận xóa tài khoản")) {
                accountManager.removeAccount(rowSelected);
                loadDataToTable(AccountDAO.readAccounts());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void txtSearchInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchInputKeyReleased
        String typeSearch = (String) cbbSearchType.getSelectedItem();
        String searchContent = txtSearchInput.getText();
        List<Account> result = new ArrayList<>();
        switch (typeSearch) {
            case "Tất cả" ->
                result = SearchAccount.searchAll(searchContent);
            case "Tên tài khoản" ->
                result = SearchAccount.searchByUserName(searchContent);
            case "Họ và tên" ->
                result = SearchAccount.searchByName(searchContent);
            case "Số điện thoại" ->
                result = SearchAccount.searchByPhone(searchContent);
            case "Vai trò" ->
                result = SearchAccount.searchByRole(searchContent);
        }
        loadDataToTable(result);
    }//GEN-LAST:event_txtSearchInputKeyReleased

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        txtSearchInput.setText("");
        cbbSearchType.setSelectedIndex(0);
        loadDataToTable(this.accounts);
    }//GEN-LAST:event_btnResetMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbSearchType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblAccount;
    private javax.swing.JTextField txtSearchInput;
    // End of variables declaration//GEN-END:variables
}
