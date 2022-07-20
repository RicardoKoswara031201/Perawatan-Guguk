/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
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
public class ControllerClient {
    public ControllerClient(){
        
    }
    static DBHandler conn = new DBHandler();
    
    public static ArrayList<Client> getAllClients() {
        ArrayList<Client> clients = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM Client";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Client client = new Client();
                client.setNIK(rs.getString("NIK"));
                client.setNama(rs.getString("Nama"));
                client.setTglLahir((Date) rs.getObject("Tgl_lahir"));
                client.setGender(rs.getString("Gender"));
                client.setAlamat(rs.getString("Alamat"));
                client.setTelepon(rs.getString("No_telepon"));
                client.setVIP((PelayananClien) rs.getObject("Pelayanan"));
                client.setNamapeliharaan(rs.getString("NamaPeliharaan"));
                client.setJenispeliharaan(rs.getString("JenisPeliharaan"));
                client.setGenderpeliharaan(rs.getString("GenderPeliharaan"));
                client.setKeluhan(rs.getString("Keluhan"));
                clients.add(client);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return (clients);
    }
    
    // SELECT WHERE
    public static Client getClient(String NIK) {
        conn.connect();
        String query = "SELECT * FROM Client WHERE NIK='" + NIK + "'";
        Client client = new Client();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                client.setNIK(rs.getString("NIK"));
                client.setNama(rs.getString("Nama"));
                client.setTglLahir((Date) rs.getObject("Tgl_lahir"));
                client.setGender(rs.getString("Gender"));
                client.setAlamat(rs.getString("Alamat"));
                client.setTelepon(rs.getString("No_telepon"));
                if(rs.getString("Pelayanan").equals("VIP")){
                    client.setVIP(PelayananClien.VIP);
                }else{
                    client.setVIP(PelayananClien.Non_VIP);
                }
                client.setNamapeliharaan(rs.getString("NamaPeliharaan"));
                client.setJenispeliharaan(rs.getString("JenisPeliharaan"));
                client.setGenderpeliharaan(rs.getString("GenderPeliharaan"));
                client.setKeluhan(rs.getString("Keluhan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (client);
        
    }
    
    // INSERT
    public static boolean insertNewClient(Client client) {
        conn.connect();
        String query = "INSERT INTO Client VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, client.getNIK());
            stmt.setString(2, client.getNama());
            stmt.setObject(3, client.getTglLahir());
            stmt.setString(4, client.getGender());
            stmt.setString(5, client.getAlamat());
            stmt.setString(6, client.getTelepon());
            stmt.setObject(7, String.valueOf(client.getVIP()));
            stmt.setString(8, client.getNamapeliharaan());
            stmt.setString(9, client.getJenispeliharaan());
            stmt.setString(10, client.getGenderpeliharaan());
            stmt.setString(11, client.getKeluhan());
            stmt.setString(12, Singleton.getInstance().getAdmin().getIdCabang());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
