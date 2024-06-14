package view;

import controller.RoomManager;
import controller.SearchRoom;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Room;
import util.FormatterDisplay;
import view.component.OptionPaneCustom;

public class RoomForm extends javax.swing.JInternalFrame {

    private DefaultTableModel tblModel;
    private List<Room> rooms;
    private int rowSelected = -1;
    private Room roomSelected;

    public RoomForm() {
        rooms = RoomManager.getInstance().getRooms();
        initComponents();
        initUI();
        initTable();
        loadDataToTable(rooms);

    }

    public int getRowSelected() {
        return this.rowSelected;
    }

    public Room getRoomSelected() {
        return roomSelected;
    }

    private void initUI() {
        BasicInternalFrameUI bif = (BasicInternalFrameUI) this.getUI();
        bif.setNorthPane(null);
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"STT", "ID", "Diện tích", "Loại phòng", "Giá thuê", "Trạng thái"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblRoom.setModel(tblModel);
        tblRoom.setAutoCreateRowSorter(true);
        customTable();
    }

    public final void loadDataToTable(List<Room> rooms) {
        try {
            tblModel.setRowCount(0);
            int stt = 1;
            for (Room room : rooms) {

                tblModel.addRow(new Object[]{
                    stt++, room.getId().toUpperCase(), room.getArea(), room.getType(),
                    FormatterDisplay.formatPrice(room.getRentCost()), room.getStatus()
                });
            }
            System.out.println("Làm mới bảng rooms thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private void customTable() {
        UIManager.put("Table.showVerticalLines", true);
        tblRoom.setDefaultEditor(Object.class, null);
        tblRoom.getColumnModel().getColumn(0).setMaxWidth(90);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < tblRoom.getColumnCount(); i++) {
            tblRoom.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cbbSearchType = new javax.swing.JComboBox<>();
        txtSearchInput = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRoom = new javax.swing.JTable();

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
        jToolBar1.add(jButton3);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-bill.png"))); // NOI18N
        jButton1.setText("Thêm hóa đơn");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setIconTextGap(-8);
        jButton1.setMargin(new java.awt.Insets(0, 10, 0, 10));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-tenant.png"))); // NOI18N
        jButton2.setText("Thêm khách");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setIconTextGap(-8);
        jButton2.setMargin(new java.awt.Insets(0, 10, 0, 10));
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        cbbSearchType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "ID", "Diện tích", "Loại phòng", "Giá thuê", "Trạng thái" }));

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
                .addComponent(txtSearchInput, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

        tblRoom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên phòng", "Diện tích", "Kiểu phòng", "Giá thuê", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRoom.setGridColor(new java.awt.Color(242, 242, 242));
        tblRoom.setRowHeight(30);
        tblRoom.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblRoom.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblRoom.setShowGrid(true);
        jScrollPane1.setViewportView(tblRoom);
        if (tblRoom.getColumnModel().getColumnCount() > 0) {
            tblRoom.getColumnModel().getColumn(0).setMaxWidth(50);
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

        rowSelected = tblRoom.getSelectedRow();
        try {
            if (rowSelected == -1) {
                throw new Exception("Vui lòng chọn tài khoản để chỉnh sửa!");
            }
            roomSelected = rooms.get(rowSelected);
            new UpdateRoom(this).setVisible(true);
        } catch (Exception e) {
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        rowSelected = tblRoom.getSelectedRow();
        try {
            if (rowSelected == -1) {
                throw new Exception("Vui lòng chọn phòng để xóa!");
            }
//
            if (OptionPaneCustom.showOptionDialog(this, "Bạn có đồng ý xóa phòng này không?",
                    "Xác nhận xóa phòng")) {
                RoomManager.getInstance().removeRoom(rowSelected);
                loadDataToTable(RoomManager.getInstance().getRooms());
            }

        } catch (Exception e) {
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void txtSearchInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchInputKeyReleased
        String luachon = (String) cbbSearchType.getSelectedItem();
        String searchContent = txtSearchInput.getText();
        List<Room> result = new ArrayList<>();
        switch (luachon) {
            case "Tất cả" ->
                result = SearchRoom.searchAll(searchContent);
            case "ID" ->
                result = SearchRoom.searchById(searchContent);
            case "Loại phòng" ->
                result = SearchRoom.searchByType(searchContent);
            case "Giá thuê" ->
                result = SearchRoom.searchByRentCost(searchContent);
            case "Trạng thái" ->
                result = SearchRoom.searchByStatus(searchContent);
            case "Diện tích" ->
                result = SearchRoom.searchByArea(searchContent);
        }
        loadDataToTable(result);
    }//GEN-LAST:event_txtSearchInputKeyReleased

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        txtSearchInput.setText("");
        cbbSearchType.setSelectedIndex(0);
        loadDataToTable(this.rooms);
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        new AddNewRoom(this).setVisible(true);
    }//GEN-LAST:event_btnAddMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbSearchType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblRoom;
    private javax.swing.JTextField txtSearchInput;
    // End of variables declaration//GEN-END:variables
}
