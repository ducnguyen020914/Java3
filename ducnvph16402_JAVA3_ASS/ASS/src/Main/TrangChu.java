/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Login.DangNhapForm;
import javax.swing.JOptionPane;

/**
 *
 * @author 84985
 */
public class TrangChu extends javax.swing.JFrame {

    /**
     * Creates new form TrangChu
     */
    public TrangChu() {
        initComponents();
        this.setLocationRelativeTo(null);
        DangNhapForm form = new DangNhapForm(this.desktopPaneMain);
        form.setVisible(true);
        this.desktopPaneMain.add(form);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnlogin = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btngioithieu = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnexxit = new javax.swing.JButton();
        desktopPaneMain = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuitemlogin = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnitemexxit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btnlogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        btnlogin.setText("Đăng Xuất");
        btnlogin.setFocusable(false);
        btnlogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnlogin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        jToolBar1.add(btnlogin);
        jToolBar1.add(jSeparator1);

        btngioithieu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btngioithieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/work.png"))); // NOI18N
        btngioithieu.setText("Giới thiệu");
        btngioithieu.setFocusable(false);
        btngioithieu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btngioithieu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btngioithieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngioithieuActionPerformed(evt);
            }
        });
        jToolBar1.add(btngioithieu);
        jToolBar1.add(jSeparator2);

        btnexxit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnexxit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit.png"))); // NOI18N
        btnexxit.setText("Exit");
        btnexxit.setFocusable(false);
        btnexxit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnexxit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnexxit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexxitActionPerformed(evt);
            }
        });
        jToolBar1.add(btnexxit);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 1371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 168, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );

        desktopPaneMain.setBackground(new java.awt.Color(51, 204, 255));

        javax.swing.GroupLayout desktopPaneMainLayout = new javax.swing.GroupLayout(desktopPaneMain);
        desktopPaneMain.setLayout(desktopPaneMainLayout);
        desktopPaneMainLayout.setHorizontalGroup(
            desktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1691, Short.MAX_VALUE)
        );
        desktopPaneMainLayout.setVerticalGroup(
            desktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 697, Short.MAX_VALUE)
        );

        jMenu1.setText("Logout");

        mnuitemlogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnuitemlogin.setText("Logout");
        mnuitemlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuitemloginActionPerformed(evt);
            }
        });
        jMenu1.add(mnuitemlogin);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Giới thiệu");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Giới thiệu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Edit");

        mnitemexxit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnitemexxit.setText("Exit");
        mnitemexxit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnitemexxitActionPerformed(evt);
            }
        });
        jMenu2.add(mnitemexxit);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 176, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPaneMain)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(desktopPaneMain))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
         this.dispose();
        TrangChu t = new TrangChu();
         t.setVisible(true);
        
    }//GEN-LAST:event_btnloginActionPerformed

    private void btnexxitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexxitActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnexxitActionPerformed

    private void btngioithieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngioithieuActionPerformed
       JOptionPane.showMessageDialog(this,"Đức vjp pro tạo ra form này\nTuổi: 19\nSDT:0985840363","Giới thiệu",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btngioithieuActionPerformed

    private void mnuitemloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuitemloginActionPerformed
        this.dispose();
        TrangChu t = new TrangChu();
         t.setVisible(true);
    }//GEN-LAST:event_mnuitemloginActionPerformed

    private void mnitemexxitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnitemexxitActionPerformed
       this.dispose();
    }//GEN-LAST:event_mnitemexxitActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
           JOptionPane.showMessageDialog(this,"Đức vjp pro tạo ra form này\nTuổi: 19\nSDT:0985840363","Giới thiệu",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexxit;
    private javax.swing.JButton btngioithieu;
    private javax.swing.JButton btnlogin;
    private javax.swing.JDesktopPane desktopPaneMain;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mnitemexxit;
    private javax.swing.JMenuItem mnuitemlogin;
    // End of variables declaration//GEN-END:variables
}
