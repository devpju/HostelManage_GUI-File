package view;

import controller.SearchTenant;
import controller.TenantManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.Tenant;
import util.FormatterDisplay;
import view.component.OptionPaneCustom;

public class TenantForm extends javax.swing.JInternalFrame {

    private DefaultTableModel tblModel;
    private int rowSelected = -1;
    private Tenant tenantSelected;
    private TenantManager tenantManager;

    public TenantForm() {
        tenantManager = TenantManager.getInstance();
        initComponents();
        initTable();
        loadDataToTable(tenantManager.getTenants());
        customTable();
        customUI();
    }

    private void customUI() {
        BasicInternalFrameUI bif = (BasicInternalFrameUI) this.getUI();
        bif.setNorthPane(null);
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"STT", "Mã phòng", "ID", "Họ và tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Thời hạn hợp đồng"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblTenant.setModel(tblModel);
        tblTenant.setAutoCreateRowSorter(true);
    }

    public final void loadDataToTable(List<Tenant> tenants) {
        try {
            int stt = 1;
            tblModel.setRowCount(0);
            for (Tenant tenant : tenants) {
                System.out.println("--------------" + tenant);
                tblModel.addRow(new Object[]{
                    stt++,
                    tenant.getIdRoom(),
                    tenant.getId(),
                    tenant.getName(),
                    tenant.getGender(),
                    FormatterDisplay.formatDate(tenant.getDob()),
                    tenant.getPhone(),
                    tenant.getAddress(),
                    tenant.getContract().getStatus()
                });
            }
            System.out.println("Làm mới bảng tenants thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private void customTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
        for (int i = 0; i < tblTenant.getColumnCount(); i++) {
            if (i != 3) {
                tblTenant.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            } else {
                tblTenant.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
            }
        }
        UIManager.put("Table.showVerticalLines", true);
        tblTenant.setDefaultEditor(Object.class, null);
        TableColumnModel tcm = tblTenant.getColumnModel();
        tcm.getColumn(0).setMaxWidth(80);
        tcm.getColumn(0).setMinWidth(0);
        tcm.getColumn(1).setMaxWidth(100);
        tcm.getColumn(1).setMinWidth(90);
        tcm.getColumn(2).setMaxWidth(120);
        tcm.getColumn(2).setMinWidth(100);
        tcm.getColumn(4).setMaxWidth(100);
    }

    public String getIdRoom() {
        return tblTenant.getValueAt(rowSelected, 1).toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cbbSearchType = new javax.swing.JComboBox<>();
        txtSearchInput = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTenant = new javax.swing.JTable();

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
        jToolBar1.add(jSeparator1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/detail.png"))); // NOI18N
        jButton3.setText("Xem chi tiết");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setIconTextGap(-8);
        jButton3.setMargin(new java.awt.Insets(0, 10, 0, 10));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jToolBar1.add(jButton3);

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

        tblTenant.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblTenant.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTenant.setGridColor(new java.awt.Color(242, 242, 242));
        tblTenant.setRowHeight(30);
        tblTenant.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblTenant.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblTenant.setShowGrid(true);
        jScrollPane1.setViewportView(tblTenant);

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
        rowSelected = tblTenant.getSelectedRow();
        try {
            if (rowSelected == -1) {
                throw new Exception("Vui lòng chọn khách thuê để sửa!");
            }
            tenantSelected = tenantManager.getTenants().get(rowSelected);
            System.out.println("quy7iw9823984" +tenantSelected);
            new UpdateTenant(this, tenantSelected).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        rowSelected = tblTenant.getSelectedRow();
        try {
            if (rowSelected == -1) {
                throw new Exception("Vui lòng chọn khách thuê để xóa!");
            }

            String tenantId = tblTenant.getValueAt(rowSelected, 2).toString();
            if (OptionPaneCustom.showOptionDialog(this, "Bạn có đồng ý xóa khách thuê này không?",
                    "Xác nhận xóa khách thuê")) {
                TenantManager.getInstance().removeTenantById(tenantId);
                loadDataToTable(TenantManager.getInstance().getTenants());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void txtSearchInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchInputKeyReleased
        String luachon = (String) cbbSearchType.getSelectedItem();
        String searchContent = txtSearchInput.getText();
        List<Tenant> result = new ArrayList<>();
        switch (luachon) {
            case "Tất cả" ->
                result = SearchTenant.searchAll(searchContent);
            case "ID Khách thuê" ->
                result = SearchTenant.searchById(searchContent);
            case "ID Phòng" ->
                result = SearchTenant.searchByIdRoom(searchContent);
            case "Họ và tên" ->
                result = SearchTenant.searchByName(searchContent);
            case "Giới tính" ->
                result = SearchTenant.searchByGender(searchContent);
            case "Số điện thoại" ->
                result = SearchTenant.searchByPhone(searchContent);
            case "Địa chỉ" ->
                result = SearchTenant.searchByAddress(searchContent);
        }
        loadDataToTable(result);
    }//GEN-LAST:event_txtSearchInputKeyReleased

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        txtSearchInput.setText("");
        cbbSearchType.setSelectedIndex(0);
        loadDataToTable(tenantManager.getTenants());
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        new AddNewTenant(this).setVisible(true);
    }//GEN-LAST:event_btnAddMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        rowSelected = tblTenant.getSelectedRow();
        try {
            if (rowSelected == -1) {
                throw new Exception("Vui lòng chọn khách thuê để xem chi tiết!");
            }
            System.out.println(tenantManager.getTenants().get(rowSelected));
            tenantSelected = tenantManager.getTenants().get(rowSelected);
            new DetailTenant(tenantSelected).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbSearchType;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblTenant;
    private javax.swing.JTextField txtSearchInput;
    // End of variables declaration//GEN-END:variables
}
