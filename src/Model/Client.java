/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Controller.ControllerClient;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Asus
 */
public class Client extends People implements InterfacePelayanan{
    private ArrayList<PelayananClien> listRiwayatClien = new ArrayList<PelayananClien>();
    private PelayananClien VIP;
    private String namapeliharaan;
    private String jenispeliharaan;
    private String genderpeliharaan;
    private String keluhan;
    
    public Client(){
        
    }
    
    public Client (PelayananClien VIP){
        this.VIP = VIP;
    }

    public Client(PelayananClien VIP, String namapeliharaan, String jenispeliharaan, String genderpeliharaan, String keluhan) {
        this.VIP = VIP;
        this.namapeliharaan = namapeliharaan;
        this.jenispeliharaan = jenispeliharaan;
        this.genderpeliharaan = genderpeliharaan;
        this.keluhan = keluhan;
    }

    public Client(PelayananClien VIP, String namapeliharaan, String jenispeliharaan, String genderpeliharaan, String keluhan, String NIK, String Nama, Date tglLahir, String gender, String Alamat, String Telepon) {
        super(NIK, Nama, tglLahir, gender, Alamat, Telepon);
        this.VIP = VIP;
        this.namapeliharaan = namapeliharaan;
        this.jenispeliharaan = jenispeliharaan;
        this.genderpeliharaan = genderpeliharaan;
        this.keluhan = keluhan;
    }

    public ArrayList<PelayananClien> getListRiwayatClien() {
        return listRiwayatClien;
    }

    public void setListRiwayatClien(ArrayList<PelayananClien> listRiwayatClien) {
        this.listRiwayatClien = listRiwayatClien;
    }

    public PelayananClien getVIP() {
        return VIP;
    }

    public void setVIP(PelayananClien VIP) {
        this.VIP = VIP;
    }

    public String getNamapeliharaan() {
        return namapeliharaan;
    }

    public void setNamapeliharaan(String namapeliharaan) {
        this.namapeliharaan = namapeliharaan;
    }

    public String getJenispeliharaan() {
        return jenispeliharaan;
    }

    public void setJenispeliharaan(String jenispeliharaan) {
        this.jenispeliharaan = jenispeliharaan;
    }

    public String getGenderpeliharaan() {
        return genderpeliharaan;
    }

    public void setGenderpeliharaan(String genderpeliharaan) {
        this.genderpeliharaan = genderpeliharaan;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Clien{" + "listRiwayatClien =" + listRiwayatClien + ", VIP =" + VIP + ", namapeliharaan =" + namapeliharaan + ", jenispeliharaan =" + jenispeliharaan + ", genderpeliharaan =" +genderpeliharaan+ ", keluhan =" +keluhan+ '}';
    }
    
    public void clienBaru(Client pt){
        ControllerClient c = new ControllerClient();
        boolean statusInsert = c.insertNewClient(pt);
        
        if(statusInsert == true){
            JOptionPane.showMessageDialog(null, "data berhasil dimasukkan ke database");
        }else{
            JOptionPane.showMessageDialog(null, "data gagal dimasukkan!");
        }
    }
}
