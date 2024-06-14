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
import view.component.OptionPaneCustom;

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

    public int getRowSelected() {
        return this.rowSelected;
    }

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
        btnCancle = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContract = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();

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
        btnEnd.setText("Báo hủy HĐ");
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

        btnCancle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancle.png"))); // NOI18N
        btnCancle.setText("Hủy báo");
        btnCancle.setFocusable(false);
        btnCancle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancle.setIconTextGap(-8);
        btnCancle.setMargin(new java.awt.Insets(0, 10, 0, 10));
        btnCancle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancleMouseClicked(evt);
            }
        });
        jToolBar1.add(btnCancle);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo ngày"));

        jDateChooser1.setDateFormatString("dd/MM/yyyy");
        jDateChooser1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jDateChooser2.setDateFormatString("dd/MM/yyyy");
        jDateChooser2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Ngày bắt đầu:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ngày kết thúc:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap())
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc theo trạng thái", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 95, Short.MAX_VALUE)
        );

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEndMouseClicked
        rowSelected = tblContract.getSelectedRow();
        try {
            if (rowSelected == -1) {
                throw new Exception("Vui lòng chọn hợp đồng để hủy!");
            }
            contractSelected = contractManager.getContracts().get(rowSelected);
            if (contractSelected.getStatus().equals("Đã hết hạn")) {
                throw new Exception("Hợp đồng này đã hết hạn. Không thể báo hủy.");
            }
            new CancleContract(this, contractSelected).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEndMouseClicked

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

    private void btnCancleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancleMouseClicked
        rowSelected = tblContract.getSelectedRow();
        try {
            if (rowSelected == -1) {
                throw new Exception("Vui lòng chọn hợp đồng để hủy báo hợp đồng!");
            }
            if (OptionPaneCustom.showOptionDialog(this, "Bạn có muốn hủy bỏ ngày báo hủy hợp đồng này không?",
                    "Hủy báo hủy hợp đồng")) {
                contractSelected = contractManager.getContracts().get(rowSelected);
                ContractManager.getInstance().cancleCancleContract(contractSelected.getId());
                loadDataToTable(ContractManager.getInstance().getContracts());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCancleMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnEnd;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblContract;
    // End of variables declaration//GEN-END:variables
}
