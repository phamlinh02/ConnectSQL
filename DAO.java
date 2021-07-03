/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Thuy Linh
 */
public class DAO {

    private Connection conn;

    public DAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databasename=QLUser";
            conn = DriverManager.getConnection(url, "sa", "sa");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addUser(User x) {

        try {
            String sql = "INSERT INTO tblUser VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, x.getMa());
            ps.setString(2, x.getTen());
            ps.setString(3, x.getEmail());
            ps.setString(4, x.getSdt());
            ps.setString(5, x.getGioitinh());
            ps.setString(6, x.getDiachi());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Đã có mã đó");
        }
        return false;
    }

    public ArrayList<User> getlistUser() {
        ArrayList<User> lst = new ArrayList<>();
        String sql = "SELECT * FROM tblUser";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User x = new User();
                x.setMa(rs.getString(1));
                x.setTen(rs.getString(2));
                x.setEmail(rs.getString(3));
                x.setSdt(rs.getString(4));
                x.setGioitinh(rs.getString(5));
                x.setDiachi(rs.getString(6));
                lst.add(x);
            }
        } catch (Exception e) {
        }
        return lst;
    }

    public boolean Delete(String ma) {
        try {
            String sql = "DELETE FROM tblUser where ma =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(User x) {

        try {
            String sql = "UPDATE tblUser set  ten= ? , email=?,sdt=?,gioitinh=?,diachi=? where ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, x.getTen());
            ps.setString(2, x.getEmail());
            ps.setString(3, x.getSdt());
            ps.setString(4, x.getGioitinh());
            ps.setString(5, x.getDiachi());
            ps.setString(6, x.getMa());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
