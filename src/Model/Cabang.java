/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;
/**
 *
 * @author Asus
 */
public class Cabang {
    private String Alamat;
    private String Telepon;
    private String Nama;
    private String idCabang;
    private ArrayList<Staff> liststaff = new ArrayList<Staff>();
    private ArrayList<KebutuhanGugukKucing> listkebutuhan = new ArrayList<KebutuhanGugukKucing>();
    private ArrayList<Transaksi> listTransaksi = new ArrayList<Transaksi>();
    
    public Cabang(){
        
    }

    public Cabang(ArrayList<Staff> liststaff,ArrayList<KebutuhanGugukKucing> listkebutuhan,ArrayList<Transaksi> listTransaksi,String Alamat, String Telepon, String Nama, String idCabang) {
        this.liststaff = liststaff;
        this.listkebutuhan = listkebutuhan;
        this.listTransaksi = listTransaksi;
        this.Alamat = Alamat;
        this.Telepon = Telepon;
        this.Nama = Nama;
        this.idCabang = idCabang;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getTelepon() {
        return Telepon;
    }

    public void setTelepon(String Telepon) {
        this.Telepon = Telepon;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getIdCabang() {
        return idCabang;
    }

    public void setIdCabang(String idCabang) {
        this.idCabang = idCabang;
    }

    public ArrayList<Staff> getListstaff() {
        return liststaff;
    }

    public void setListstaff(ArrayList<Staff> liststaff) {
        this.liststaff = liststaff;
    }

    public ArrayList<KebutuhanGugukKucing> getListkebutuhan() {
        return listkebutuhan;
    }

    public void setListkebutuhan(ArrayList<KebutuhanGugukKucing> listkebutuhan) {
        this.listkebutuhan = listkebutuhan;
    }

    public ArrayList<Transaksi> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(ArrayList<Transaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }
    
    @Override
    public String toString() {
        return "Cabang{" + "Alamat=" + Alamat + ", Telepon=" + Telepon + ", Nama=" + Nama + ", IdCabang=" +idCabang+'}';
    }
}
