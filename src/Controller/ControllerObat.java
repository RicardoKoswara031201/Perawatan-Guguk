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
/**
 *
 * @author Asus
 */
public class ControllerObat {
    static DBHandler conn = new DBHandler();
    
    public ControllerObat(){
        
    }
    
    public static boolean addObat(KebutuhanGugukKucing obat){
        conn.connect();
        String query = "INSERT INTO kebutuhan VALUES(?,?,?,?) ";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);

            stmt.setString(1, obat.getIDObat());
            stmt.setString(2, obat.getNama());
            stmt.setInt(3, obat.getHargaBeli());
            stmt.setInt(4, obat.getHargaJual());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }        
    }

    public static KebutuhanGugukKucing getObat(String namaObat) {
        conn.connect();
        String query = "SELECT * FROM obat WHERE Nama_obat='" + namaObat + "'";
        KebutuhanGugukKucing obatPasien = new KebutuhanGugukKucing();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                obatPasien.setIDObat(rs.getString("ID_Obat"));
                obatPasien.setNama(rs.getString("Nama_obat"));
                obatPasien.setHargaBeli(rs.getInt("Harga_beli"));
                obatPasien.setHargaJual(rs.getInt("Harga_jual"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (obatPasien);
        
    }
    public static boolean insertResepObatPasien(String IDObat,String NIK){
        conn.connect();
        String query = "INSERT INTO Resep_kebutuhan VALUES(?,?) ";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, IDObat);
            stmt.setString(2, NIK);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        } 
    }
    
    public static String getIDObat(String namaObat) {
        conn.connect();
        String query = "SELECT ID_kebutuhan FROM kebutuhan WHERE Nama_kebutuhan='" + namaObat + "'";
        String IDObat = "";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                IDObat = rs.getString("ID_kebutuhan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (IDObat);
        
    }
    public static String getLastIDObat() {
        conn.connect();
        String query = "SELECT ID_kebutuhan FROM `kebutuhan` ORDER BY ID_kebutuhan DESC LIMIT 1";
        String IDObat = "";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                IDObat = rs.getString("ID_kebutuhan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int id = Integer.valueOf(IDObat.substring(1));
        return ("M00" + (id + 1));
        
    }
}
