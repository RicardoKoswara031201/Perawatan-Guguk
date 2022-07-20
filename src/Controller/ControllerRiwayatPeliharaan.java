/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.RiwayatPeliharaan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Asus
 */
public class ControllerRiwayatPeliharaan {
    
    static DBHandler conn = new DBHandler();
    
    public ControllerRiwayatPeliharaan(){
        
    }
    
    public static ArrayList<RiwayatPeliharaan> getAllRiwayatPeliharaan() {
        ArrayList<RiwayatPeliharaan> RPs = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM riwayat_peliharaan";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RiwayatPeliharaan RP = new RiwayatPeliharaan();
                RP.setPenyakit(rs.getString("Penyakit"));
                RP.setTanggalKunjungan((Date) rs.getObject("Tgl_kunjungan"));
                RP.setKeluhan(rs.getString("Keluhan"));
                RP.setKebutuhan(getKebutuhanPeliharaan());
                RPs.add(RP);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (RPs);
    }
    
    public static ArrayList<String> getKebutuhanPeliharaan(){
        ArrayList<String> resepObat = new ArrayList<>();
        conn.connect();
        String query = "SELECT a.Nama_kebutuhan "
                + "FROM kebutuhan a,resep_kebutuhan b,riwayat_peliharaan c "
                + "WHERE a.Id_kebutuhan = b.Id_kebutuhan "
                + "AND b.NIK = c.NIK ";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String RO = new String();
                RO = rs.getString("Nama_kebutuhan");
                resepObat.add(RO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resepObat;
    }
    
    public static ArrayList<RiwayatPeliharaan> getAllRiwayatPeliharaans(String NIK) {
        ArrayList<RiwayatPeliharaan> RPs = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM Riwayat_Pasien WHERE NIK = '" + NIK + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RiwayatPeliharaan RP = new RiwayatPeliharaan();
                RP.setPenyakit(rs.getString("Penyakit"));
                RP.setTanggalKunjungan((Date) rs.getObject("Tgl_kunjungan"));
                RP.setKeluhan(rs.getString("Keluhan"));
                RPs.add(RP);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (RPs);
    }
    // SELECT WHERE
    public static RiwayatPeliharaan getRiwayatPeliharaan(String NIK) {
        conn.connect();
        String query = "SELECT * FROM Riwayat_Pasien WHERE NIK='" + NIK + "'";
        RiwayatPeliharaan RP = new RiwayatPeliharaan();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RP.setPenyakit(rs.getString("Penyakit"));
                RP.setTanggalKunjungan((Date) rs.getObject("Tgl_kunjungan"));
                RP.setKeluhan(rs.getString("Keluhan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (RP);
        
    }
    
    // INSERT
    public static boolean insertNewRiwayatPeliharaan(RiwayatPeliharaan RP,String NIK) {
        conn.connect();
        String query = "INSERT INTO Riwayat_Pasien VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, getLastIDFromRiwayatPeliharaan(NIK));
            stmt.setString(2, RP.getPenyakit());
            stmt.setObject(3, RP.getTanggalKunjungan());
            stmt.setString(4, RP.getKeluhan());
            stmt.setString(5, NIK);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static int getLastIDFromRiwayatPeliharaan(String NIK){
        int ID = 0;
        conn.connect();
        String query = "SELECT Id_riwayat FROM riwayat_peliharaan ORDER BY Id_riwayat DESC LIMIT 1";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ID = rs.getInt("Id_riwayat");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ID + 1);
    }

    // UPDATE
    public static boolean updateRiwayatPeliharaan(String Penyakit,Date tglKunjungan,String Keluhan,String NIK) {
        conn.connect();
        String query = "UPDATE Riwayat_Peliharaan SET Penyakit='" + Penyakit + "', "
                + "Tgl_kunjungan='" + tglKunjungan+ "', "
                + "Keluhan='" + Keluhan+ "' "
                + " WHERE NIK='" + NIK+ "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static ArrayList<String> getResepObat1Peliharaan(String NIK){
        ArrayList<String> resepObat = new ArrayList<>();
        conn.connect();
        String query = "SELECT a.Nama_obat "
                + "FROM kebutuhan a,Resep_Kebutuhan b,riwayat_peliharaan c,client d "
                + "WHERE a.ID_Kebutuhan = b.ID_Kebutuhan "
                + "AND b.NIK = c.NIK "
                + "AND c.NIK = d.NIK "
                + "AND d.NIK = " + NIK;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String RO = new String();
                RO = rs.getString("Nama_kebutuhan");
                resepObat.add(RO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resepObat;
    }
    
    //paramnya id obat sama NIK pasien
    public static boolean insertNewResepObat(String NIK,String IdObat){
        conn.connect();
        String query = "INSERT INTO Riwayat_Pelharaan VALUES(?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
