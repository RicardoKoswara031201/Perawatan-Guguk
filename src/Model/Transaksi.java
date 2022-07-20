/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Date;
/**
 *
 * @author Asus
 */
public class Transaksi implements InterfacePelayanan{
    private String idTransaksi;
    private Date tanggalMasuk;
    private int jumlah;
    private double hargaPelayanan;
    private double total;
    private double hargaKebutuhan;
    private Client client;
    private boolean isBayar;
    
    public Transaksi(){
        
    }

    public Transaksi(String idTransaksi, Date tanggalMasuk, int jumlah, double hargaPelayanan, double total, double hargaKebutuhan, Client client, boolean isBayar) {
        this.idTransaksi = idTransaksi;
        this.tanggalMasuk = tanggalMasuk;
        this.jumlah = jumlah;
        this.hargaPelayanan = hargaPelayanan;
        this.total = total;
        this.hargaKebutuhan = hargaKebutuhan;
        this.client = client;
        this.isBayar = isBayar;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHargaPelayanan() {
        return hargaPelayanan;
    }

    public void setHargaPelayanan(double hargaPelayanan) {
        this.hargaPelayanan = hargaPelayanan;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getHargaKebutuhan() {
        return hargaKebutuhan;
    }

    public void setHargaKebutuhan(double hargaKebutuhan) {
        this.hargaKebutuhan = hargaKebutuhan;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean getIsBayar() {
        return isBayar;
    }

    public void setIsBayar(boolean isBayar) {
        this.isBayar = isBayar;
    }
    
    @Override
    public String toString() {
        return "Transaksi{" + "idTransaksi=" + idTransaksi + ", tanggakMasuk=" + tanggalMasuk + ", jumlah=" + jumlah + ", hargaPelayanan=" + hargaPelayanan + ", hargaKebutuhan=" + hargaKebutuhan + ", total=" + total + '}';
    }
}
