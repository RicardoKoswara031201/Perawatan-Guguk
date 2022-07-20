/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import static Controller.ControllerStaff.conn;
import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
/**
 *
 * @author Asus
 */
public class ControllerAdmin {
    
    public static Admin getAdmin(String username){
        conn.connect();
        Admin admin = new Admin();
        String query = "SELECT * FROM admin WHERE username='" + username + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setIdCabang(rs.getString("Id_cabang"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (admin);
    }
    
    public static Cabang getCabang(String id){
        conn.connect();
        Cabang cabang = new Cabang();
        String query = "SELECT * FROM cabang WHERE ID_cabang = '" + id + "'";
        try {
            Statement stmt = conn.con.createStatement();
            System.out.println(id);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                cabang.setAlamat(rs.getString("Alamat"));
                cabang.setTelepon(rs.getString("No_telepon"));
                cabang.setNama(rs.getString("Nama_cabang"));
            }
            return(cabang);
        } catch (SQLException e) {
            e.printStackTrace();
            return(null);
        }
    }
}
