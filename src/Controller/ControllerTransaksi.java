/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import static Controller.ControllerStaff.conn;
import Model.*;
import Model.Singleton;
import Model.Transaksi;
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
public class ControllerTransaksi {
    static DBHandler conn = new DBHandler();
    
    public static boolean insertNewTransaksi(Transaksi transaksi) {
        conn.connect();
        String query = "INSERT INTO transaksi VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate= DateFor.format(transaksi.getTanggalMasuk()); 
            
            stmt.setString(1, getLastIDFromTransaksi());
            stmt.setObject(2, stringDate);
            stmt.setInt(3, transaksi.getJumlah());
            stmt.setInt(4, (int)transaksi.getHargaPelayanan());
            stmt.setInt(5, (int)transaksi.getHargaKebutuhan());
            stmt.setInt(6, (int)transaksi.getTotal());
            stmt.setString(7, Singleton.getInstance().getAdmin().getIdCabang());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static String getLastIDFromTransaksi(){
        String ID = "T000";
        conn.connect();
        String query = "SELECT Id_transaksi FROM transaksi ORDER BY Id_transaksi DESC LIMIT 1";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ID = rs.getString("Id_transaksi");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int intID = Integer.parseInt(ID.substring(1));
        return ("T00" + (intID + 1));
    }
    
    public static ArrayList<Transaksi> getAllTransaksi(String nik){
        ControllerClient control = new ControllerClient();
        conn.connect();
        ArrayList<Transaksi> listTransaksi = new ArrayList<Transaksi>();
        String query = "";
        if(nik.equals("")){
            query = "SELECT * FROM transaksi WHERE ID_cabang='" + Singleton.getInstance().getAdmin().getIdCabang() + "'";
        }else{
            query = "SELECT * FROM transaksi WHERE ID_cabang='" + Singleton.getInstance().getAdmin().getIdCabang() + "' and idPasien='" + nik +  "'and isBayar = '" + 0 + "'";
        }
        
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setIdTransaksi(rs.getString("ID_Transaksi"));
                transaksi.setClient(control.getClient(rs.getString("idPasien")));
                transaksi.setTanggalMasuk((Date)rs.getObject("Tanggal_masuk"));
                transaksi.setJumlah(rs.getInt("Jumlah"));
                transaksi.setHargaPelayanan(rs.getInt("Harga_konsul"));
                transaksi.setHargaKebutuhan(rs.getInt("Harga_obat"));
                transaksi.setTotal(rs.getInt("Total_harga"));
                boolean isBayar = false;
                if(rs.getInt("isBayar") == 1){
                    isBayar = true;
                }
                transaksi.setIsBayar(isBayar);
                transaksi.setIsBayar(true);
                listTransaksi.add(transaksi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTransaksi;
    }
    
    public static boolean insertTransaksibyBeliObat(Transaksi transaksi){
        conn.connect();
        String query = "UPDATE Transaksi SET Jumlah='" + transaksi.getJumlah() + "', "
                + "Harga_obat='" + transaksi.getHargaKebutuhan() + "', "
                + "Total_harga='" + transaksi.getTotal() + "', "
                + "isBayar='" + 1 + "' "
                + "WHERE ID_Transaksi='" + transaksi.getIdTransaksi() + "'";
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
