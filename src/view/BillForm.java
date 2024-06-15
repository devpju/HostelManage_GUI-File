package view;

import controller.SearchBill;
import controller.BillManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import model.Bill;
import util.FormatterDisplay;
import view.component.OptionPaneCustom;

public class BillForm extends javax.swing.JInternalFrame {

    private DefaultTableModel tblModel;
    private int rowSelected = -1;
    private Bill billSelected;
    private BillManager billManager;

    public BillForm() {
        billManager = BillManager.getInstance();
        initComponents();
        initTable();
        loadDataToTable(billManager.getBills());
        customTable();
        customUI();
    }

    private void customUI() {
        BasicInternalFrameUI bif = (BasicInternalFrameUI) this.getUI();
        bif.setNorthPane(null);
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"STT", "Mã phòng", "ID", "Ngày lập", "Số điện", "Tiền điện",
            "Số nước", "Tiền nước", "Tiền mạng", "Tổng tiền", "Trạng thái"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblBill.setModel(tblModel);
        tblBill.setAutoCreateRowSorter(true);
    }

    public final void loadDataToTable(List<Bill> bills) {
        try {
            int stt = 1;
            tblModel.setRowCount(0);
            for (Bill bill : bills) {
                System.out.println(bill);
                tblModel.addRow(new Object[]{
                    stt++,
                    bill.getIdRoom(),
                    bill.getId(),
                    FormatterDisplay.formatDate(bill.getStartAt()),
                    bill.getNumberElec(),
                    FormatterDisplay.formatPrice(bill.ElecCost()),
                    bill.getNumberWater(),
                    FormatterDisplay.formatPrice(bill.WaterCost()),
                    FormatterDisplay.formatPrice(bill.getInternetCost()),
                    FormatterDisplay.formatPrice(bill.sumCost()),
                    bill.getStatus()
                });
            }
            System.out.println("Làm mới bảng bills thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private void customTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
        for (int i = 0; i < tblBill.getColumnCount(); i++) {
            tblBill.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        UIManager.put("Table.showVerticalLines", true);
        tblBill.setDefaultEditor(Object.class, null);

        tblBill.getColumnModel().getColumn(0).setMaxWidth(70);
        tblBill.getColumnModel().getColumn(4).setMaxWidth(70);
        tblBill.getColumnModel().getColumn(6).setMaxWidth(70);
        tblBill.getColumnModel().getColumn(10).setMinWidth(130);

    }

    public String getIdRoom() {
        return tblBill.getValueAt(rowSelected, 1).toString();
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
        tblBill = new javax.swing.JTable();

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
        btnAdd.setMargin(new java.awt.Insets(0, 10, 0, 10));
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
        btnUpdate.setMargin(new java.awt.Insets(0, 10, 0, 10));
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
        btnRemove.setMargin(new java.awt.Insets(0, 10, 0, 10));
        btnRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });
        jToolBar1.add(btnRemove);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        cbbSearchType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "ID Khách thuê", "ID Phòng", "Họ và tên", "Giới tính", "Số điện thoại", "Địa chỉ" }));

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
                .addComponent(cbbSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchInput)
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        tblBill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Họ và tên", "Ngày sinh", "Số điện thoại", "Địa chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBill.setGridColor(new java.awt.Color(242, 242, 242));
        tblBill.setRowHeight(30);
        tblBill.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblBill.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblBill.setShowGrid(true);
        jScrollPane1.setViewportView(tblBill);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
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

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        rowSelected = tblBill.getSelectedRow();
        try {
            if (rowSelected == -1) {
                throw new Exception("Vui lòng chọn khách thuê để sửa!");
            }
            billSelected = billManager.getBills().get(rowSelected);
            System.out.println(billSelected);
            new UpdateBill(this, billSelected).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        rowSelected = tblBill.getSelectedRow();
        try {
            if (rowSelected == -1) {
                throw new Exception("Vui lòng chọn khách thuê để xóa!");
            }

            String billId = tblBill.getValueAt(rowSelected, 2).toString();
            if (OptionPaneCustom.showOptionDialog(this, "Bạn có đồng ý xóa khách thuê này không?",
                    "Xác nhận xóa khách thuê")) {
                BillManager.getInstance().removeBillById(billId);
                loadDataToTable(BillManager.getInstance().getBills());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void txtSearchInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchInputKeyReleased
//        String luachon = (String) cbbSearchType.getSelectedItem();
//        String searchContent = txtSearchInput.getText();
//        List<Bill> result = new ArrayList<>();
//        switch (luachon) {
//            case "Tất cả" ->
//                result = SearchBill.searchAll(searchContent);
//            case "ID Khách thuê" ->
//                result = SearchBill.searchById(searchContent);
//            case "ID Phòng" ->
//                result = SearchBill.searchByIdRoom(searchContent);
//            case "Họ và tên" ->
//                result = SearchBill.searchByName(searchContent);
//            case "Giới tính" ->
//                result = SearchBill.searchByGender(searchContent);
//            case "Số điện thoại" ->
//                result = SearchBill.searchByPhone(searchContent);
//            case "Địa chỉ" ->
//                result = SearchBill.searchByAddress(searchContent);
//        }
//        loadDataToTable(result);
    }//GEN-LAST:event_txtSearchInputKeyReleased

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        txtSearchInput.setText("");
        cbbSearchType.setSelectedIndex(0);
        loadDataToTable(billManager.getBills());
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        new AddNewBill(this).setVisible(true);
    }//GEN-LAST:event_btnAddMouseClicked


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
    private javax.swing.JTable tblBill;
    private javax.swing.JTextField txtSearchInput;
    // End of variables declaration//GEN-END:variables
}
