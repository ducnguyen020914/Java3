/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 84985
 */
public class DAOST {

    public static Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=FPL_DAOTAO";
        Connection con = DriverManager.getConnection(url, "sa", "020914");
        return con;
    }

    public static boolean insert(Student sv) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DAOST.getConnection();
            String sql = "insert into STUDENTS Values(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getHoTen());
            ps.setString(3, sv.getEmail());
            ps.setString(4, sv.getSDT());
            ps.setBoolean(5, sv.isGioiTinh());
            ps.setString(6, sv.getDiaChi());
            ps.setString(7, sv.getHinh());
               int i = ps.executeUpdate();
            System.out.println(i);
            
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mã Sinh viên đã tồn tại");
            return false;
        } finally {
            try {
                con.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static boolean checkSV(String str) {
        try {
            Connection con = DAODiem.getConnection();
            String sql = "select top 1 * from GRADE where MaSV = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, str);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

    public static boolean delete(String str) {
       
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DAOST.getConnection();
            String sql = " delete from STUDENTS where MaSV = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, str);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return false;
    }

    public static boolean update(Student sv) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DAOST.getConnection();
            String sql = "Update STUDENTS set HoTen = ?, Email = ?,SODT = ? "
                    + ",GioiTinh = ?,DiaChi = ?,Hinh = ? where MaSV = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, sv.getHoTen());
            ps.setString(2, sv.getEmail());
            ps.setString(3, sv.getSDT());
            ps.setBoolean(4, sv.isGioiTinh());
            ps.setString(5, sv.getDiaChi());
            ps.setString(6, sv.getHinh());
            ps.setString(7, sv.getMaSV());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DAOST.getConnection();
            String sql = "select * from STUDENTS";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Student s = new Student();
                s.setMaSV(rs.getString(1));
                s.setHoTen(rs.getString(2));
                s.setEmail(rs.getString(3));
                s.setSDT(rs.getString(4));
                s.setGioiTinh(rs.getBoolean(5));
                s.setDiaChi(rs.getString(6));
                s.setHinh(rs.getString(7));
                list.add(s);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                st.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
