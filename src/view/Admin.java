package view;

import controller.AccountManager;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import model.Account;

public class Admin extends javax.swing.JFrame {

    private static final Color DEFAULT_BACKGROUND_COLOR = new Color(89, 168, 105);
    private static final Color SELECTED_BACKGROUND_COLOR = new Color(103, 140, 167);

    public Admin() {
        initComponents();
        autoSetHeader();
        navHostel.setBackground(SELECTED_BACKGROUND_COLOR);
        showHostelForm();
    }

    private void updateMainContent(Component component) {
        mainContent.removeAll();
        mainContent.add(component).setVisible(true);
    }

    private void showHostelForm() {
        HostelForm hostelForm = new HostelForm();
        updateMainContent(hostelForm);
    }

    private void setColorNav(Color defaultColor, Color selectedColor, Component navSelected) {
        Component[] navComponents = {navHostel, navRoom, navBill, navContract, navStatistic, navAccount, navChangeInfo, navTenant};
        for (Component navComponent : navComponents) {
            navComponent.setBackground(defaultColor);
        }
        navSelected.setBackground(selectedColor);
    }

    private String getInitials(String fullName) {
        String[] nameParts = fullName.split("\\s+");
        if (nameParts.length < 2) {
            return fullName;
        }
        StringBuilder initials = new StringBuilder();
        for (int i = 0; i < nameParts.length - 1; i++) {
            initials.append(nameParts[i].charAt(0)).append(".");
        }
        initials.append(nameParts[nameParts.length - 1]);
        return initials.toString();
    }

    public final void autoSetHeader() {
        Account currentAccount = AccountManager.getInstance().getCurrentAccount();
        if (currentAccount != null) {
            String initials = getInitials(currentAccount.getName());
            nameUser.setText(initials);
            roleUser.setText(currentAccount.getRole());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NAVBAR = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameUser = new javax.swing.JLabel();
        roleUser = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        navHostel = new javax.swing.JPanel();
        jjjjjjjjjjj = new javax.swing.JLabel();
        navRoom = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        navContract = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        navBill = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        navAccount = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        navStatistic = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        navChangeInfo = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        navTenant = new javax.swing.JPanel();
        jjjjjjjjjjj1 = new javax.swing.JLabel();
        mainContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm quản lý nhà trọ");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        NAVBAR.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thumb-header.png"))); // NOI18N

        nameUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nameUser.setForeground(new java.awt.Color(51, 255, 255));
        nameUser.setText("N.V Nam");

        roleUser.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        roleUser.setForeground(new java.awt.Color(255, 255, 255));
        roleUser.setText("Admin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameUser)
                    .addComponent(roleUser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nameUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roleUser)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(89, 168, 105));

        navHostel.setBackground(new java.awt.Color(103, 140, 167));
        navHostel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navHostelMouseClicked(evt);
            }
        });

        jjjjjjjjjjj.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jjjjjjjjjjj.setForeground(new java.awt.Color(255, 255, 255));
        jjjjjjjjjjj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jjjjjjjjjjj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        jjjjjjjjjjj.setText("NHÀ TRỌ");

        javax.swing.GroupLayout navHostelLayout = new javax.swing.GroupLayout(navHostel);
        navHostel.setLayout(navHostelLayout);
        navHostelLayout.setHorizontalGroup(
            navHostelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navHostelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jjjjjjjjjjj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navHostelLayout.setVerticalGroup(
            navHostelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navHostelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jjjjjjjjjjj)
                .addContainerGap())
        );

        navRoom.setBackground(new java.awt.Color(89, 168, 105));
        navRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navRoomMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/room.png"))); // NOI18N
        jLabel5.setText("PHÒNG TRỌ");

        javax.swing.GroupLayout navRoomLayout = new javax.swing.GroupLayout(navRoom);
        navRoom.setLayout(navRoomLayout);
        navRoomLayout.setHorizontalGroup(
            navRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navRoomLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navRoomLayout.setVerticalGroup(
            navRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navRoomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        navContract.setBackground(new java.awt.Color(89, 168, 105));
        navContract.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navContractMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/contract.png"))); // NOI18N
        jLabel6.setText("HỢP ĐỒNG");

        javax.swing.GroupLayout navContractLayout = new javax.swing.GroupLayout(navContract);
        navContract.setLayout(navContractLayout);
        navContractLayout.setHorizontalGroup(
            navContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navContractLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navContractLayout.setVerticalGroup(
            navContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navContractLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        navBill.setBackground(new java.awt.Color(89, 168, 105));
        navBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navBillMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill.png"))); // NOI18N
        jLabel7.setText("HÓA ĐƠN");

        javax.swing.GroupLayout navBillLayout = new javax.swing.GroupLayout(navBill);
        navBill.setLayout(navBillLayout);
        navBillLayout.setHorizontalGroup(
            navBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBillLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navBillLayout.setVerticalGroup(
            navBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBillLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap())
        );

        navAccount.setBackground(new java.awt.Color(89, 168, 105));
        navAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navAccountMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account.png"))); // NOI18N
        jLabel8.setText("TÀI KHOẢN");

        javax.swing.GroupLayout navAccountLayout = new javax.swing.GroupLayout(navAccount);
        navAccount.setLayout(navAccountLayout);
        navAccountLayout.setHorizontalGroup(
            navAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navAccountLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addGap(21, 21, 21))
        );
        navAccountLayout.setVerticalGroup(
            navAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap())
        );

        navStatistic.setBackground(new java.awt.Color(89, 168, 105));
        navStatistic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navStatisticMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/satistic.png"))); // NOI18N
        jLabel9.setText("THỐNG KÊ");

        javax.swing.GroupLayout navStatisticLayout = new javax.swing.GroupLayout(navStatistic);
        navStatistic.setLayout(navStatisticLayout);
        navStatisticLayout.setHorizontalGroup(
            navStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navStatisticLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navStatisticLayout.setVerticalGroup(
            navStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navStatisticLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        navChangeInfo.setBackground(new java.awt.Color(89, 168, 105));
        navChangeInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navChangeInfoMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/info.png"))); // NOI18N
        jLabel10.setText("ĐỔI THÔNG TIN");

        javax.swing.GroupLayout navChangeInfoLayout = new javax.swing.GroupLayout(navChangeInfo);
        navChangeInfo.setLayout(navChangeInfoLayout);
        navChangeInfoLayout.setHorizontalGroup(
            navChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navChangeInfoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addGap(21, 21, 21))
        );
        navChangeInfoLayout.setVerticalGroup(
            navChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navChangeInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap())
        );

        logout.setBackground(new java.awt.Color(89, 168, 105));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        jLabel11.setText("ĐĂNG XUẤT");

        javax.swing.GroupLayout logoutLayout = new javax.swing.GroupLayout(logout);
        logout.setLayout(logoutLayout);
        logoutLayout.setHorizontalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel11)
                .addGap(21, 21, 21))
        );
        logoutLayout.setVerticalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap())
        );

        navTenant.setBackground(new java.awt.Color(89, 168, 105));
        navTenant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navTenantMouseClicked(evt);
            }
        });

        jjjjjjjjjjj1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jjjjjjjjjjj1.setForeground(new java.awt.Color(255, 255, 255));
        jjjjjjjjjjj1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jjjjjjjjjjj1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tenant.png"))); // NOI18N
        jjjjjjjjjjj1.setText("KHÁCH THUÊ");

        javax.swing.GroupLayout navTenantLayout = new javax.swing.GroupLayout(navTenant);
        navTenant.setLayout(navTenantLayout);
        navTenantLayout.setHorizontalGroup(
            navTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navTenantLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jjjjjjjjjjj1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navTenantLayout.setVerticalGroup(
            navTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navTenantLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jjjjjjjjjjj1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navHostel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navContract, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navStatistic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navChangeInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navTenant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(navHostel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(navRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(navTenant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(navBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(navContract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(navStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(navAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(navChangeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout NAVBARLayout = new javax.swing.GroupLayout(NAVBAR);
        NAVBAR.setLayout(NAVBARLayout);
        NAVBARLayout.setHorizontalGroup(
            NAVBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        NAVBARLayout.setVerticalGroup(
            NAVBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NAVBARLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainContent.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout mainContentLayout = new javax.swing.GroupLayout(mainContent);
        mainContent.setLayout(mainContentLayout);
        mainContentLayout.setHorizontalGroup(
            mainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        mainContentLayout.setVerticalGroup(
            mainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(NAVBAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NAVBAR, javax.swing.GroupLayout.PREFERRED_SIZE, 700, Short.MAX_VALUE)
            .addComponent(mainContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        Object[] options = {"Có", "Hủy"};
        int choice = JOptionPane.showOptionDialog(this, "Bạn có muốn đăng xuất không?",
                "Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        if (choice == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logoutMouseClicked

    private void navAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navAccountMouseClicked
        if (!AccountManager.getInstance().getCurrentAccount().getRole().equals("Admin")) {
            JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập chức năng Tài khoản! Vui lòng liên hệ Admin!",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        setColorNav(DEFAULT_BACKGROUND_COLOR, SELECTED_BACKGROUND_COLOR, navAccount);

        AccountForm accountForm = new AccountForm();
        updateMainContent(accountForm);
    }//GEN-LAST:event_navAccountMouseClicked

    private void navHostelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navHostelMouseClicked
        setColorNav(DEFAULT_BACKGROUND_COLOR, SELECTED_BACKGROUND_COLOR, navHostel);

        HostelForm hostelForm = new HostelForm();
        updateMainContent(hostelForm);
    }//GEN-LAST:event_navHostelMouseClicked

    private void navRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navRoomMouseClicked
        setColorNav(DEFAULT_BACKGROUND_COLOR, SELECTED_BACKGROUND_COLOR, navRoom);

        RoomForm roomForm = new RoomForm();
        updateMainContent(roomForm);
    }//GEN-LAST:event_navRoomMouseClicked

    private void navBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navBillMouseClicked
        setColorNav(DEFAULT_BACKGROUND_COLOR, SELECTED_BACKGROUND_COLOR, navBill);

//        BillForm billForm = new BillForm();
//        updateMainContent(billForm);
    }//GEN-LAST:event_navBillMouseClicked

    private void navContractMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navContractMouseClicked
        setColorNav(DEFAULT_BACKGROUND_COLOR, SELECTED_BACKGROUND_COLOR, navContract);

//        ContractForm contractForm = new ContractForm();
//        updateMainContent(contractForm);
    }//GEN-LAST:event_navContractMouseClicked

    private void navStatisticMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navStatisticMouseClicked
        setColorNav(DEFAULT_BACKGROUND_COLOR, SELECTED_BACKGROUND_COLOR, navStatistic);

//        StatisticForm statisticForm = new StatisticForm();
//        updateMainContent(statisticForm);
    }//GEN-LAST:event_navStatisticMouseClicked

    private void navChangeInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navChangeInfoMouseClicked
        new UpdatePersonalAccount(this).setVisible(true);
    }//GEN-LAST:event_navChangeInfoMouseClicked

    private void navTenantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navTenantMouseClicked
        setColorNav(DEFAULT_BACKGROUND_COLOR, SELECTED_BACKGROUND_COLOR, navTenant);

        TenantForm tf = new TenantForm();
        mainContent.removeAll();
        mainContent.add(tf).setVisible(true);
    }//GEN-LAST:event_navTenantMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        Object[] options = {"Có", "Hủy"};
//        int choice = JOptionPane.showOptionDialog(this,
//                "Bạn có chắc chắn muốn thoát không?",
//                "Xác nhận thoát",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null, options, options[0]);
//
//        if (choice == JOptionPane.NO_OPTION) {
//            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//        } else {
//            setDefaultCloseOperation(EXIT_ON_CLOSE);
//        }
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel NAVBAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jjjjjjjjjjj;
    private javax.swing.JLabel jjjjjjjjjjj1;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel mainContent;
    private javax.swing.JLabel nameUser;
    private javax.swing.JPanel navAccount;
    private javax.swing.JPanel navBill;
    private javax.swing.JPanel navChangeInfo;
    private javax.swing.JPanel navContract;
    private javax.swing.JPanel navHostel;
    private javax.swing.JPanel navRoom;
    private javax.swing.JPanel navStatistic;
    private javax.swing.JPanel navTenant;
    private javax.swing.JLabel roleUser;
    // End of variables declaration//GEN-END:variables
}
