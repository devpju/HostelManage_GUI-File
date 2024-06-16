package view;

import controller.manager.ContractManager;
import controller.search.SearchContract;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Contract;
import util.DateConverter;
import util.FormatterUtil;
import view.component.OptionPaneCustom;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import util.comparator_table.DoubleComparator;
import util.comparator_table.LocalDateComparator;
import util.comparator_table.StatusContractComparator;

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
        setupTableSorter();
        loadDataToTable(contractManager.getContracts());
    }

    // TẠO TABLE
    public final void initTable() {
        tblModel = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Integer.class;
                } else if (columnIndex >= 2 && columnIndex <= 3) {
                    return LocalDate.class;
                } else if (columnIndex == 5) {
                    return Double.class;
                } else {
                    return String.class;
                }
            }
        };
        String[] headerTbl = new String[]{"STT", "ID", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái", "Tiền cọc"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblContract.setModel(tblModel);
    }

    private void setupTableSorter() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tblModel);
        tblContract.setRowSorter(sorter);

        Comparator<String> doubleComparator = new DoubleComparator();
        Comparator<String> localDateComparator = new LocalDateComparator();
        Comparator<String> statusContractComparator = new StatusContractComparator();
        sorter.setComparator(5, doubleComparator);
        sorter.setComparator(2, localDateComparator);
        sorter.setComparator(3, localDateComparator);
        sorter.setComparator(4, statusContractComparator);
    }

    public final void loadDataToTable(List<Contract> contracts) {
        try {
            int stt = 1;
            tblModel.setRowCount(0);
            for (Contract contract : contracts) {
                tblModel.addRow(new Object[]{
                    stt++, contract.getId(),
                    FormatterUtil.localDateToStr(contract.getStartAt()),
                    FormatterUtil.localDateToStr(contract.getEndAt()),
                    contract.getStatus(),
                    FormatterUtil.formatPrice(contract.getDeposit())
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

        btnGroupFilter = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnUpdate = new javax.swing.JButton();
        btnEnd = new javax.swing.JButton();
        btnCancle = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cdateStart = new com.toedter.calendar.JDateChooser();
        cdateEnd = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContract = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        status1 = new javax.swing.JRadioButton();
        status2 = new javax.swing.JRadioButton();
        status3 = new javax.swing.JRadioButton();

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

        btnCancle.setBackground(new java.awt.Color(246, 246, 246));
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

        jButton1.setBackground(new java.awt.Color(246, 246, 246));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh_ver2.png"))); // NOI18N
        jButton1.setText("Làm mới");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setIconTextGap(-8);
        jButton1.setMargin(new java.awt.Insets(0, 10, 0, 10));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jToolBar1.add(jButton1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo ngày"));

        cdateStart.setDateFormatString("dd/MM/yyyy");
        cdateStart.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cdateStart.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cdateStartPropertyChange(evt);
            }
        });

        cdateEnd.setDateFormatString("dd/MM/yyyy");
        cdateEnd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cdateEnd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cdateEndPropertyChange(evt);
            }
        });

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
                    .addComponent(cdateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cdateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(cdateStart, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(cdateEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
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

        btnGroupFilter.add(status1);
        status1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        status1.setText("Sắp hết hạn");
        status1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                status1MouseClicked(evt);
            }
        });

        btnGroupFilter.add(status2);
        status2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        status2.setText("Đã hết hạn");
        status2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                status2MouseClicked(evt);
            }
        });

        btnGroupFilter.add(status3);
        status3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        status3.setText("Đã báo hủy");
        status3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                status3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(status1)
                .addGap(18, 18, 18)
                .addComponent(status2)
                .addGap(18, 18, 18)
                .addComponent(status3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(status1)
                    .addComponent(status2)
                    .addComponent(status3))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
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
                OptionPaneCustom.showSuccessDialog(this, "Bạn đã hủy báo hủy hợp đồng thành công!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCancleMouseClicked

    private void status1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_status1MouseClicked
        if (status1.isSelected()) {
            loadDataToTable(SearchContract.searchByStatus(status1.getText()));
            cdateStart.setDate(null);
            cdateEnd.setDate(null);
        }
    }//GEN-LAST:event_status1MouseClicked

    private void status2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_status2MouseClicked
        if (status2.isSelected()) {
            loadDataToTable(SearchContract.searchByStatus(status2.getText()));
            cdateStart.setDate(null);
            cdateEnd.setDate(null);
        }
    }//GEN-LAST:event_status2MouseClicked

    private void status3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_status3MouseClicked
        if (status3.isSelected()) {
            loadDataToTable(SearchContract.searchByStatus(status3.getText()));
            cdateStart.setDate(null);
            cdateEnd.setDate(null);
        }
    }//GEN-LAST:event_status3MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        btnGroupFilter.clearSelection();
        cdateStart.setDate(null);
        cdateEnd.setDate(null);
        loadDataToTable(ContractManager.getInstance().getContracts());
    }//GEN-LAST:event_jButton1MouseClicked

    private void cdateStartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cdateStartPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            Date startDate = cdateStart.getDate();
            Date endDate = cdateEnd.getDate();
            if (startDate != null && endDate != null) {
                btnGroupFilter.clearSelection();
                loadDataToTable(SearchContract.searchByDate(DateConverter.toLocalDate(startDate), DateConverter.toLocalDate(endDate)));
            }
        }
    }//GEN-LAST:event_cdateStartPropertyChange

    private void cdateEndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cdateEndPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            Date startDate = cdateStart.getDate();
            Date endDate = cdateEnd.getDate();
            if (startDate != null && endDate != null) {
                btnGroupFilter.clearSelection();
                loadDataToTable(SearchContract.searchByDate(DateConverter.toLocalDate(startDate), DateConverter.toLocalDate(endDate)));
            }
        }
    }//GEN-LAST:event_cdateEndPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnEnd;
    private javax.swing.ButtonGroup btnGroupFilter;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser cdateEnd;
    private com.toedter.calendar.JDateChooser cdateStart;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JRadioButton status1;
    private javax.swing.JRadioButton status2;
    private javax.swing.JRadioButton status3;
    private javax.swing.JTable tblContract;
    // End of variables declaration//GEN-END:variables
}
