package view;

import controller.manager.RoomManager;
import controller.search.SearchRoom;
import controller.manager.BillManager;
import controller.manager.HostelManager;
import exception.EmptyInputException;
import exception.InvalidNumberException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.Room;
import model.Bill;
import util.FormatterUtil;
import view.component.OptionPaneCustom;

public class AddNewBill extends javax.swing.JFrame {

    private BillForm billHome;
    private DefaultTableModel tblModel;
    private List<Room> rooms = RoomManager.getInstance().getRooms();
    private int rowSelected = -1;
    private Room roomSelected;

    public AddNewBill(javax.swing.JInternalFrame parent) {
        initComponents();
        billHome = (BillForm) parent;
        UIManager.put("Table.showVerticalLines", true);
        tblRoomChooser.setDefaultEditor(Object.class, null);
        initTable();
        loadDataToTable(rooms);
    }

    public int getRowSelected() {
        return this.rowSelected;
    }

    public Room getRoomSelected() {
        return roomSelected;
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"STT", "ID", "Trạng thái"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblRoomChooser.setModel(tblModel);
    }

    public final void loadDataToTable(List<Room> rooms) {
        try {
            tblModel.setRowCount(0);
            int stt = 1;
            for (Room room : rooms) {
                tblModel.addRow(new Object[]{
                    stt++, room.getId().toUpperCase(), room.getStatus()
                });
            }
        } catch (Exception e) {
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        }
    }

    public Room getRoomSelect() {
        int roomRow = tblRoomChooser.getSelectedRow();
        Room room = RoomManager.getInstance().getRooms().get(roomRow);
        return room;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tblRoom = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        inputSearch = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRoomChooser = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtIdBill = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cdateStartAt = new com.toedter.calendar.JDateChooser();
        txtInterCost = new javax.swing.JTextField();
        btnAddT = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtNumberElec = new javax.swing.JTextField();
        txtNumberWater = new javax.swing.JTextField();
        txtElecCost = new javax.swing.JTextField();
        txtWaterCost = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbbStatus = new javax.swing.JComboBox<>();
        txtRentCost = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thêm hóa đơn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm phòng"));

        inputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputSearchKeyReleased(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(inputSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputSearch))
                .addContainerGap())
        );

        tblRoomChooser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Trạng thái"
            }
        ));
        tblRoomChooser.setShowGrid(true);
        tblRoomChooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoomChooserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRoomChooser);
        if (tblRoomChooser.getColumnModel().getColumnCount() > 0) {
            tblRoomChooser.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout tblRoomLayout = new javax.swing.GroupLayout(tblRoom);
        tblRoom.setLayout(tblRoomLayout);
        tblRoomLayout.setHorizontalGroup(
            tblRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tblRoomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tblRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        tblRoomLayout.setVerticalGroup(
            tblRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tblRoomLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách thuê", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        txtIdBill.setEditable(false);
        txtIdBill.setToolTipText("");

        jLabel2.setText("ID:");

        cdateStartAt.setLocale(new Locale("vi", "VN"));
        cdateStartAt.setDateFormatString("dd/MM/yyyy");

        txtInterCost.setEditable(false);

        btnAddT.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        btnAddT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddT.setForeground(new java.awt.Color(255, 255, 255));
        btnAddT.setText("Thêm hóa đơn");
        btnAddT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddTMouseClicked(evt);
            }
        });

        btnClose.setText("Đóng");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        txtNumberElec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumberElecKeyReleased(evt);
            }
        });

        txtNumberWater.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumberWaterKeyReleased(evt);
            }
        });

        txtElecCost.setEditable(false);

        txtWaterCost.setEditable(false);

        jLabel4.setText("Ngày lập:");

        jLabel6.setText("Số điện (kWh):");

        jLabel7.setText("Tiền điện:");

        jLabel9.setText("Số nước (m³):");

        jLabel10.setText("Tiền nước:");

        jLabel11.setText("Tiền mạng:");

        jLabel12.setText("Trạng thái:");

        cbbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa thanh toán", "Đã thanh toán" }));
        cbbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbStatusActionPerformed(evt);
            }
        });

        txtRentCost.setEditable(false);

        jLabel5.setText("Tiền thuê phòng:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdBill, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10)
                                    .addComponent(txtElecCost)
                                    .addComponent(jLabel7)
                                    .addComponent(txtWaterCost, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(150, 150, 150))
                                    .addComponent(cdateStartAt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(47, 47, 47))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtNumberWater, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumberElec, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12))
                                    .addGap(218, 218, 218))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(txtInterCost)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(txtRentCost, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(btnAddT, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cdateStartAt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdBill, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNumberElec, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtElecCost, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtWaterCost, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumberWater, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInterCost, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRentCost, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tblRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tblRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void inputSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputSearchKeyReleased

        String searchContent = inputSearch.getText();
        List<Room> result = SearchRoom.searchAll(searchContent);
        loadDataToTable(result);
    }//GEN-LAST:event_inputSearchKeyReleased

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        inputSearch.setText("");
        loadDataToTable(this.rooms);
    }//GEN-LAST:event_btnResetMouseClicked

    private void tblRoomChooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoomChooserMouseClicked
        rowSelected = tblRoomChooser.getSelectedRow();
        roomSelected = RoomManager.getInstance().getRooms().get(rowSelected);
        txtIdBill.setText(BillManager.getInstance().createIdBill(roomSelected));
        txtInterCost.setText(FormatterUtil.formatPrice(HostelManager.getInstance().getHostel().getInternetCost()));
        txtRentCost.setText(FormatterUtil.formatPrice(roomSelected.getRentCost()));
        Date currentDate = new Date();
        cdateStartAt.setDate(currentDate);

    }//GEN-LAST:event_tblRoomChooserMouseClicked

    private void btnAddTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddTMouseClicked
        try {

            if (rowSelected == -1) {
                throw new Exception("Chọn phòng để thêm hóa đơn mới mới!");
            }
            String id = txtIdBill.getText();
            Date startAt = cdateStartAt.getDate();
            String numberElecStr = txtNumberElec.getText();
            String numberWaterStr = txtNumberWater.getText();
            String status = cbbStatus.getSelectedItem().toString();
            String rentCostStr = txtRentCost.getText();
            Bill newBill = BillManager.getInstance().createNewBill(id, roomSelected.getId(), startAt, numberElecStr, numberWaterStr, rentCostStr, status);

            BillManager.getInstance().addNewBill(roomSelected, newBill);

            OptionPaneCustom.showSuccessDialog(this, "Thêm hóa đơn thành công!");

            billHome.loadDataToTable(BillManager.getInstance().getBills());
            txtIdBill.setText("");
            txtNumberElec.setText("");
            txtNumberWater.setText("");
            txtElecCost.setText("");
            txtWaterCost.setText("");
            txtInterCost.setText("");
            cdateStartAt.setDate(null);

        } catch (EmptyInputException e) {
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        } catch (InvalidNumberException e) {
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        } catch (Exception e) {
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnAddTMouseClicked

    private void txtNumberElecKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumberElecKeyReleased
        try {
            int numberElec = Integer.parseInt(txtNumberElec.getText());
            double elecUnitPrice = HostelManager.getInstance().getHostel().getElecUnitPrice();
            double elecCost = numberElec * elecUnitPrice;
            txtElecCost.setText(FormatterUtil.formatPrice(elecCost));
        } catch (NumberFormatException e) {
            txtElecCost.setText("");
        }
    }//GEN-LAST:event_txtNumberElecKeyReleased

    private void txtNumberWaterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumberWaterKeyReleased
        try {
            int numberWater = Integer.parseInt(txtNumberWater.getText());
            double waterUnitPrice = HostelManager.getInstance().getHostel().getWaterUnitPrice();
            double waterCost = numberWater * waterUnitPrice;
            txtWaterCost.setText(FormatterUtil.formatPrice(waterCost));
        } catch (NumberFormatException e) {
            txtWaterCost.setText("");
        }
    }//GEN-LAST:event_txtNumberWaterKeyReleased

    private void cbbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddT;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cbbStatus;
    private com.toedter.calendar.JDateChooser cdateStartAt;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel tblRoom;
    private javax.swing.JTable tblRoomChooser;
    private javax.swing.JTextField txtElecCost;
    private javax.swing.JTextField txtIdBill;
    private javax.swing.JTextField txtInterCost;
    private javax.swing.JTextField txtNumberElec;
    private javax.swing.JTextField txtNumberWater;
    private javax.swing.JTextField txtRentCost;
    private javax.swing.JTextField txtWaterCost;
    // End of variables declaration//GEN-END:variables
}
