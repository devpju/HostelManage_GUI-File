package view;

import controller.ContractManager;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Contract;
import util.FormatterDisplay;

public class ContractForm extends javax.swing.JInternalFrame {

    private DefaultTableModel tblModel;
    private ContractManager contractManager;
    private int rowSelected = -1;
    private Contract contractSelected;

    public ContractForm() {
        contractManager = ContractManager.getInstance();
        initComponents();
        customUI();
        initTable();
        customTable();
        loadDataToTable(contractManager.getContracts());
    }

    // TẠO TABLE
    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"STT", "ID", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái", "Tiền cọc"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblContract.setModel(tblModel);
        tblContract.setAutoCreateRowSorter(true);
    }

    // LOAD DATA CHO TABLE
    public final void loadDataToTable(List<Contract> contracts) {
        try {
            int stt = 1;
            tblModel.setRowCount(0);
            for (Contract contract : contracts) {
                tblModel.addRow(new Object[]{
                    stt++, contract.getId(), FormatterDisplay.formatDate(contract.getStartAt()), FormatterDisplay.formatDate(contract.getEndAt()),
                    contract.getStatus(), FormatterDisplay.formatPrice(contract.getDeposit())
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // CUSTOM UI
    private void customUI() {
        BasicInternalFrameUI bif = (BasicInternalFrameUI) this.getUI();
        bif.setNorthPane(null);
    }

    // CUSTOM TABLE
    private void customTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);

        for (int i = 0; i < tblContract.getColumnCount(); i++) {
            tblContract.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        UIManager.put("Table.showVerticalLines", true);
        tblContract.setDefaultEditor(Object.class, null);
        tblContract.getColumnModel().getColumn(0).setMaxWidth(90);

    }

    // LẤY CHỈ SỐ DÒNG ĐƯỢC CHỌN
    public int getRowSelected() {
        return this.rowSelected;
    }

    // LẤY ACCOUNT ĐƯỢC CHỌN
        public Contract getContractSelected() {
        return contractSelected;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnUpdate = new javax.swing.JButton();
        btnEnd = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cbbSearchType = new javax.swing.JComboBox<>();
        txtSearchInput = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContract = new javax.swing.JTable();

        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar1.setRollover(true);

        btnUpdate.setBackground(new java.awt.Color(246, 246, 246));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/signature.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.setFocusable(false);
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.setIconTextGap(-8);
        btnUpdate.setMargin(new java.awt.Insets(0, 10, 0, 10));
        btnUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        jToolBar1.add(btnUpdate);

        btnEnd.setBackground(new java.awt.Color(246, 246, 246));
        btnEnd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnEnd.setText("Báo kết thúc HĐ");
        btnEnd.setFocusable(false);
        btnEnd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEnd.setIconTextGap(-8);
        btnEnd.setMargin(new java.awt.Insets(0, 10, 0, 10));
        btnEnd.setMinimumSize(new java.awt.Dimension(100, 82));
        btnEnd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEndMouseClicked(evt);
            }
        });
        jToolBar1.add(btnEnd);

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
                .addComponent(txtSearchInput, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
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

        tblContract.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblContract.setModel(new javax.swing.table.DefaultTableModel(
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
        tblContract.setGridColor(new java.awt.Color(242, 242, 242));
        tblContract.setRowHeight(30);
        tblContract.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblContract.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblContract.setShowGrid(true);
        tblContract.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tblContract);
        if (tblContract.getColumnModel().getColumnCount() > 0) {
            tblContract.getColumnModel().getColumn(0).setHeaderValue("Tên tài khoản");
            tblContract.getColumnModel().getColumn(1).setHeaderValue("Họ và tên");
            tblContract.getColumnModel().getColumn(2).setHeaderValue("Số điện thoại");
            tblContract.getColumnModel().getColumn(3).setHeaderValue("Vai trò");
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

    private void btnEndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEndMouseClicked

    }//GEN-LAST:event_btnEndMouseClicked

    private void txtSearchInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchInputKeyReleased
//        String luachon = (String) cbbSearchType.getSelectedItem();
//        String searchContent = txtSearchInput.getText();
//        List<Account> result = new ArrayList<>();
//        switch (luachon) {
//            case "Tất cả" ->
//                result = SearchAccount.searchAll(searchContent);
//            case "Tên tài khoản" ->
//                result = SearchAccount.searchByUserName(searchContent);
//            case "Họ và tên" ->
//                result = SearchAccount.searchByName(searchContent);
//            case "Số điện thoại" ->
//                result = SearchAccount.searchByPhone(searchContent);
//            case "Vai trò" ->
//                result = SearchAccount.searchByRole(searchContent);
//        }
//        loadDataToTable(result);
    }//GEN-LAST:event_txtSearchInputKeyReleased

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
//        txtSearchInput.setText("");
//        cbbSearchType.setSelectedIndex(0);
//        loadDataToTable(this.accounts);

    }//GEN-LAST:event_btnResetMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        rowSelected = tblContract.getSelectedRow();
        try {
            if (rowSelected == -1) {
                throw new Exception("Vui lòng chọn hợp đồng để sửa!");
            }
            contractSelected = contractManager.getContracts().get(rowSelected);
            new UpdateContract(this, contractSelected).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnd;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbSearchType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblContract;
    private javax.swing.JTextField txtSearchInput;
    // End of variables declaration//GEN-END:variables
}
