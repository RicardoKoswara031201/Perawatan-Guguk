/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import Model.Singleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Asus
 */
public class ControllerStaff {
    static DBHandler conn = new DBHandler();
    
    public static ArrayList<Staff> getAllStaff(){
        conn.connect();
        ArrayList<Staff> staffs = new ArrayList<Staff>();
        String query = "SELECT * FROM staff WHERE Id_Cabang='" + Singleton.getInstance().getAdmin().getIdCabang() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setNIK(rs.getString("NIK"));
                staff.setNama(rs.getString("Nama"));
                staff.setTglLahir((Date)rs.getObject("Tgl_lahir"));
                staff.setGender(rs.getString("Gender"));
                staff.setKeahlian(rs.getString("Keahlian"));
                staff.setTelepon(rs.getString("No_Telepon"));
                staff.setAlamat(rs.getString("Alamat"));
                staffs.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffs;
    }
    
    public static Staff getStaff(String nik){
        conn.connect();
        Staff staff = new Staff();
        String query = "SELECT * FROM staff WHERE NIK='" + nik + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                staff.setNIK(rs.getString("NIK"));
                staff.setNama(rs.getString("Nama"));
                staff.setTglLahir((Date)rs.getObject("Tgl_lahir"));
                staff.setGender(rs.getString("Gender"));
                staff.setKeahlian(rs.getString("Keahlian"));
                staff.setTelepon(rs.getString("No_Telepon"));
                staff.setAlamat(rs.getString("Alamat"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (staff);
    }
    
    public static boolean addStaff(Staff staff){
        conn.connect();
        String query = "INSERT INTO staff VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, staff.getNIK());
            stmt.setString(2, staff.getNama());
            stmt.setObject(3, staff.getTglLahir());
            stmt.setString(4, staff.getGender());
            stmt.setString(5, staff.getKeahlian());
            stmt.setString(6, staff.getTelepon());
            stmt.setString(7, staff.getAlamat());
            stmt.setString(8, Singleton.getInstance().getAdmin().getIdCabang());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static boolean updateStaff(Staff staff, String tgllahir){
        conn.connect();
        String query = "UPDATE staff SET nik='" + staff.getNIK() + "', "
                + "nama='" + staff.getNama() + "', "
                + "Tgl_Lahir='" + tgllahir + "', "
                + "Gender='" + staff.getGender() + "', "
                + "Keahlian='" + staff.getKeahlian() + "', "
                + "No_Telepon='" + staff.getTelepon() + "', "
                + "Alamat='" + staff.getAlamat() + "', "
                + "ID_cabang='" + Singleton.getInstance().getAdmin().getIdCabang() + "' "
                + "WHERE nik='" + staff.getNIK() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static boolean deletestaff(String strnid){
        conn.connect();

        String query = "DELETE FROM staff WHERE nik='" + strnid + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
