/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.DiemSV;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 84985
 */
public class DAODiem {

    public static Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=FPL_DAOTAO";
        Connection con = DriverManager.getConnection(url, "sa", "020914");
        return con;
    }

    public static boolean insert(DiemSV d) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DAODiem.getConnection();
            String sql = "insert into GRADE(MaSV,TiengAnh,TinHoc,GDTC) Values(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, d.getMaSV());
            ps.setFloat(2, d.getTiengAnh());
            ps.setFloat(3, d.getTinHoc());
            ps.setFloat(4, d.getGDTC());
            int i = ps.executeUpdate();
            System.out.println(i);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mã sinh viên không tồn tại trong Bảng Student");
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

    public static boolean delete(String str) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DAODiem.getConnection();
            String sql = "delete from GRADE where MaSV = ?";
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean update(DiemSV d) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DAODiem.getConnection();
            String sql = "update Grade set TiengAnh = ?,TinHoc = ?,GDTC = ? where MaSV = ?";
            ps = con.prepareStatement(sql);
            ps.setFloat(1, d.getTiengAnh());
            ps.setFloat(2, d.getTinHoc());
            ps.setFloat(3, d.getGDTC());
            ps.setString(4, d.getMaSV());
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

    public static DiemSV find(String str) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DAODiem.getConnection();
            String sql = "select Hoten, GRADE.MaSV, TiengAnh , TinHoc , GDTC"
                    + " from GRADE inner join STUDENTS on GRADE.MaSV = STUDENTS.MaSV "
                    + "where GRADE.MaSV = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, str);
            rs = ps.executeQuery();
            if (rs.next()) {
                DiemSV d = new DiemSV();
                d.setHoTen(rs.getString(1));
                d.setMaSV(rs.getString(2));
                d.setTiengAnh(rs.getFloat(3));
                d.setTinHoc(rs.getFloat(4));
                d.setGDTC(rs.getFloat(5));
                return d;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static List<DiemSV> getAll() {
        List<DiemSV> list = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DAODiem.getConnection();
            String sql = "select top 3 HoTen,GRADE.MaSV,TiengAnh,TinHoc,GDTC\n" +
                         "from GRADE inner join STUDENTS on GRADE.MaSV = STUDENTS.MaSV \n" +
                         "order by (TiengAnh + TinHoc + GDTC)/3 desc";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                DiemSV d = new DiemSV();
                d.setHoTen(rs.getString("HoTen"));
                d.setMaSV(rs.getString("MaSV"));
                d.setTiengAnh(rs.getFloat("TiengAnh"));
                d.setTinHoc(rs.getFloat("TinHoc"));
                d.setGDTC(rs.getFloat("GDTC"));
                list.add(d);
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
    public static boolean checkTonTai(String maSV){
        try {
            Connection con  = DAODiem.getConnection();
            String sql = "select * from GRADE where MaSV = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSV);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
