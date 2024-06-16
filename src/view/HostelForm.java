package view;

import controller.manager.HostelManager;
import exception.EmptyInputException;
import exception.InvalidNumberException;
import exception.InvalidPhoneNumberException;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import model.Hostel;
import view.component.OptionPaneCustom;
import util.FormatterUtil;

public final class HostelForm extends javax.swing.JInternalFrame {

    private HostelManager hostelManager;

    public HostelForm() {
        hostelManager = HostelManager.getInstance();
        initComponents();
        customUI();
        setInfoHostel(hostelManager.getHostel());
    }

    private void customUI() {
        BasicInternalFrameUI bif = (BasicInternalFrameUI) this.getUI();
        bif.setNorthPane(null);
    }

    public void setInfoHostel(Hostel hostel) {
        headingNameHostel.setText(("NHÀ TRỌ " + hostel.getName()).toUpperCase());
        txtNameHostel.setText(hostel.getName());
        txtAddressHostel.setText(hostel.getAddress());
        txtPhoneHostel.setText(FormatterUtil.formatPhoneNumber(hostel.getPhone()));
        txtElecUnit.setText(FormatterUtil.formatPrice(hostel.getElecUnitPrice()));
        txtWaterUnit.setText(FormatterUtil.formatPrice(hostel.getWaterUnitPrice()));
        txtInternetCost.setText(FormatterUtil.formatPrice(hostel.getInternetCost()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        headingNameHostel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtNameHostel = new javax.swing.JTextField();
        txtPhoneHostel = new javax.swing.JTextField();
        txtAddressHostel = new javax.swing.JTextField();
        txtElecUnit = new javax.swing.JTextField();
        txtInternetCost = new javax.swing.JTextField();
        txtWaterUnit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        headingNameHostel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        headingNameHostel.setForeground(new java.awt.Color(255, 255, 255));
        headingNameHostel.setText("NHÀ TRỌ PHƯƠNG GIANG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headingNameHostel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(headingNameHostel)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        txtNameHostel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        txtPhoneHostel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        txtAddressHostel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        txtElecUnit.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        txtInternetCost.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        txtWaterUnit.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Tên nhà trọ:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Địa chỉ:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Số điện thoại:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Đơn giá điện (VNĐ):");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Đơn giá nước (VNĐ):");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Giá internet (VNĐ):");

        btnUpdate.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Sửa thông tin nhà trọ");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnReset.setText("Hủy bỏ");
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
                .addGap(133, 133, 133)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhoneHostel, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtAddressHostel, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNameHostel, javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtElecUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(136, 136, 136)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtWaterUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(txtInternetCost)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
                .addGap(100, 100, 100))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNameHostel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(txtAddressHostel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPhoneHostel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtElecUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWaterUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInternetCost, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        setInfoHostel(hostelManager.getHostel());
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        try {
            String name = txtNameHostel.getText();
            String address = txtAddressHostel.getText();
            String phone = FormatterUtil.parsePhoneNumber(txtPhoneHostel.getText());
            String elecUnitPriceStr = txtElecUnit.getText();
            String waterUnitPriceStr = txtWaterUnit.getText();
            String internetCostStr = txtInternetCost.getText();
            Hostel updatedHostel = HostelManager.getInstance().createNewHostel(hostelManager.getHostel().getId(),
                    name, address, phone, elecUnitPriceStr, waterUnitPriceStr, internetCostStr);

            if (OptionPaneCustom.showOptionDialog(this,
                    "Bạn có đồng ý thay đổi thông tin nhà trọ không?",
                    "Xác nhận thay đổi thông tin nhà trọ")) {

                HostelManager.getInstance().updateHostel(updatedHostel);
                setInfoHostel(updatedHostel);
                OptionPaneCustom.showSuccessDialog(this, "Sửa thông tin nhà trọ thành công!");
            }
        } catch (EmptyInputException e) {
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        } catch (InvalidNumberException e) {
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        } catch (InvalidPhoneNumberException e) {
            txtPhoneHostel.setText("");
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        } catch (Exception e) {
            OptionPaneCustom.showErrorDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel headingNameHostel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtAddressHostel;
    private javax.swing.JTextField txtElecUnit;
    private javax.swing.JTextField txtInternetCost;
    private javax.swing.JTextField txtNameHostel;
    private javax.swing.JTextField txtPhoneHostel;
    private javax.swing.JTextField txtWaterUnit;
    // End of variables declaration//GEN-END:variables
}
