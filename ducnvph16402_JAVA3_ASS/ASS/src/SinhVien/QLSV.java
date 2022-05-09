/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinhVien;

import Service.DAOST;
import Model.Student;
import java.awt.Color;
import java.awt.Image;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 84985
 */
public class QLSV extends javax.swing.JInternalFrame {

    private DefaultTableModel mol;
    private List<Student> listsv = new ArrayList<>();
    String image = null;
    int i = -1;

    public QLSV() {
        initComponents();
        this.setLocation(250, 0);
        String[] collum = {"Mã SV", "Họ Tên", "Email", "SDT", "Giới Tính", "Địa chỉ", "Hình"};
        this.mol = new DefaultTableModel(collum, 0);
        this.tblsinhvien.setModel(mol);
        this.rdonam.setSelected(true);
        this.getList();
        this.fillTable();
     
    }

    public boolean checkForm() {
        this.txtmasv.setBackground(Color.white);
        if (this.txtmasv.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã sinh viên không để trống");
            this.txtmasv.setBackground(Color.yellow);
            this.txtmasv.requestFocus();
            return false;
        }
        String pattern = "[pP]{1}[hH]{1}\\d{5,7}";
        if(!this.txtmasv.getText().matches(pattern)){
             JOptionPane.showMessageDialog(this, "Mã sinh viên sai định dạng PH{5,7}");
            this.txtmasv.setBackground(Color.yellow);
            this.txtmasv.requestFocus();
            return false;
        }
        this.txthoten.setBackground(Color.white);
        if (this.txthoten.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Họ tên không để trống");
            this.txthoten.setBackground(Color.yellow);
            this.txthoten.requestFocus();
            return false;
        }
        this.txtemail.setBackground(Color.white);
        if (this.txtemail.getText().trim().isEmpty()) {
           String hoTen = this.txthoten.getText();
           String[] arr = hoTen.split(" ");
           StringBuilder sb = new StringBuilder();
           sb.append(khongDau(arr[arr.length - 1]));
           for( int i = 0;i <= arr.length - 2;i++){
               sb.append(arr[i].charAt(0));
           }
           sb.append(this.txtmasv.getText());
           sb.append("@fpt.edu.vn");
           this.txtemail.setText(sb.toString().toLowerCase());
        }
        String mau = "\\w+@\\w+(\\.\\w+){1,2}";
        if (!this.txtemail.getText().matches(mau)) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng");
            this.txtemail.setBackground(Color.yellow);
            this.txtemail.requestFocus();
            return false;
        }
        this.txtSDT.setBackground(Color.white);
        if (this.txtSDT.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "SDT không để trống");
            this.txtSDT.setBackground(Color.yellow);
            this.txtSDT.requestFocus();
            return false;
        }
        String mau1 = "0\\d{9,10}";
        if (!this.txtSDT.getText().matches(mau1)) {
            JOptionPane.showMessageDialog(this, "SDT từ 10-11 số");
            this.txtSDT.setBackground(Color.yellow);
            this.txtSDT.requestFocus();
            return false;
        }
        this.txtdiachi.setBackground(Color.white);
        if (this.txtdiachi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không để trống");
            this.txtdiachi.setBackground(Color.yellow);
            this.txtdiachi.requestFocus();
            return false;
        }
        return true;
    }
    public String khongDau(String value){
        String term = Normalizer.normalize(value, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(term).replaceAll("").replace("đ", "d").replace("Đ", "d");
    }

    public void reset() {
        this.txtmasv.setText("");
        this.txthoten.setText("");
        this.txtemail.setText("");
        this.txtSDT.setText("");
        this.rdonam.setSelected(true);
        this.txtdiachi.setText("");
        this.image = null;
        this.lblimage.setIcon(null);

        this.i = -1;
    }

    public void getList() {
        this.listsv = DAOST.getAll();
    }

    public void fillTable() {
        this.mol = (DefaultTableModel) tblsinhvien.getModel();
        mol.setRowCount(0);
        for (Student x : listsv) {
            mol.addRow(new Object[]{
                x.getMaSV(), x.getHoTen(), x.getEmail(), x.getSDT(), x.isGioiTinh(), x.getDiaChi(), x.getHinh()
            });
        }
    }

    public void showdetail() {
        Student s = this.listsv.get(i);
        this.txtmasv.setText(s.getMaSV());
        this.txthoten.setText(s.getHoTen());
        this.txtemail.setText(s.getEmail());
        this.txtSDT.setText(s.getSDT());
        if (s.isGioiTinh()) {
            this.rdonam.setSelected(true);
        } else {
            this.rdonu.setSelected(true);
        }
        this.txtdiachi.setText(s.getDiaChi());
        ImageIcon icon = new ImageIcon(s.getHinh());
        this.lblimage.setIcon(icon);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtmasv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        rdonam = new javax.swing.JRadioButton();
        rdonu = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        btnchonanh = new javax.swing.JButton();
        lblimage = new javax.swing.JLabel();
        btnnew = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        txthoten = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdiachi = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsinhvien = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        jLabel2.setText("MaSV:");

        jLabel3.setText("Họ tên:");

        jLabel4.setText("Email:");

        jLabel5.setText("Số ĐT:");

        jLabel6.setText("Giới tính");

        jLabel7.setText("Địa chỉ:");

        buttonGroup1.add(rdonam);
        rdonam.setText("Nam");

        buttonGroup1.add(rdonu);
        rdonu.setText("Nữ");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnchonanh.setText("chọn ảnh");
        btnchonanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchonanhActionPerformed(evt);
            }
        });

        lblimage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblimageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnchonanh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnchonanh, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/plus.png"))); // NOI18N
        btnnew.setText("New");
        btnnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewActionPerformed(evt);
            }
        });

        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pencil.png"))); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        txtdiachi.setColumns(20);
        txtdiachi.setRows(5);
        jScrollPane2.setViewportView(txtdiachi);

        tblsinhvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblsinhvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsinhvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblsinhvien);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdonam)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdonu)))
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnnew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnnew, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdonam)
                                    .addComponent(rdonu)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        if (!checkForm()) {
            return;
        }
        Student sv = new Student();
        sv.setMaSV(this.txtmasv.getText());
        sv.setHoTen(this.txthoten.getText());
        sv.setEmail(this.txtemail.getText());
        sv.setSDT(this.txtSDT.getText());
        sv.setGioiTinh(this.rdonam.isSelected() ? true : false);
        sv.setDiaChi(this.txtdiachi.getText());
        sv.setHinh(this.image == null ? "No Avatar" : image);
        if (DAOST.insert(sv)) {
            JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm sinh viên thất bại");
        }

        this.getList();
        this.fillTable();
        this.reset();
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnchonanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchonanhActionPerformed
        JFileChooser jfc = new JFileChooser("D:\\driver\\JAVA 3\\ASS\\ducnvph16402_JAVA3_ASS\\ASS\\src\\image");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("image only",
                ImageIO.getReaderFileSuffixes());
        jfc.setFileFilter(filter);
        int s = jfc.showOpenDialog(this);
        if (s == JFileChooser.APPROVE_OPTION) {
            String file = jfc.getSelectedFile().getAbsolutePath();
            this.image = file;
            ImageIcon icon = new ImageIcon(file);
            lblimage.setIcon(icon);
        }
    }//GEN-LAST:event_btnchonanhActionPerformed

    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed
        this.reset();
    }//GEN-LAST:event_btnnewActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        if (this.txtmasv.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Phải nhập mã Sinh viên");
            this.txtmasv.requestFocus();
            return;
        }
        if (!DAOST.checkSV(this.txtmasv.getText())) {
            JOptionPane.showMessageDialog(this, "Sinh viên này đang có điểm !\n Hãy xóa điểm trước khi Xóa thông tin Sinh Viên");
        } else {
            if (DAOST.delete(this.txtmasv.getText())) {
                JOptionPane.showMessageDialog(this, "Xóa sinh viên thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Không có Mã Sinh Viên bạn muốn xóa");
            }
        }
        this.getList();
        this.fillTable();
        this.reset();

    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        if (!checkForm()) {
            return;
        }
        Student sv = new Student();
        sv.setMaSV(this.txtmasv.getText());
        sv.setHoTen(this.txthoten.getText());
        sv.setEmail(this.txtemail.getText());
        sv.setSDT(this.txtSDT.getText());
        sv.setGioiTinh(this.rdonam.isSelected() ? true : false);
        sv.setDiaChi(this.txtdiachi.getText());
        sv.setHinh(this.image == null ? "No Avatar" : image);
        if (DAOST.update(sv)) {
            JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Không có mã sinh viên bạn muốn cập nhật");
        }
        this.getList();
        this.fillTable();
        this.reset();


    }//GEN-LAST:event_btnupdateActionPerformed

    private void tblsinhvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsinhvienMouseClicked
        this.i = tblsinhvien.getSelectedRow();
        this.showdetail();
    }//GEN-LAST:event_tblsinhvienMouseClicked

    private void lblimageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblimageMouseClicked
        JFileChooser jfc = new JFileChooser("D:\\driver\\JAVA 3\\ASS\\ducnvph16402_JAVA3_ASS\\ASS\\src\\image");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("image only",
                ImageIO.getReaderFileSuffixes());
        jfc.setFileFilter(filter);
        int s = jfc.showOpenDialog(this);
        if (s == JFileChooser.APPROVE_OPTION) {
            String file = jfc.getSelectedFile().getAbsolutePath();
            this.image = file;
            ImageIcon icon = new ImageIcon(file);
            lblimage.setIcon(icon);
        }
    }//GEN-LAST:event_lblimageMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnchonanh;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnnew;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblimage;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JRadioButton rdonu;
    private javax.swing.JTable tblsinhvien;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextArea txtdiachi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtmasv;
    // End of variables declaration//GEN-END:variables
}
