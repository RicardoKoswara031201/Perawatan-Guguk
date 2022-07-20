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
public abstract class People {
    private String NIK;
    private String Nama;
    private Date tglLahir;
    private String gender;
    private String Alamat;
    private String Telepon;
    
    public People(){
        
    }

    public People(String NIK, String Nama, Date tglLahir, String gender, String Alamat, String Telepon) {
        this.NIK = NIK;
        this.Nama = Nama;
        this.tglLahir = tglLahir;
        this.gender = gender;
        this.Alamat = Alamat;
        this.Telepon = Telepon;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
    
    @Override
    public String toString() {
        return super.toString() + "User{" + "Nama=" + Nama + ", NIK=" + NIK + ", tglLahir=" + tglLahir + ", gender=" + gender + ", Alamat=" + Alamat + ", Telepon=" + Telepon + '}';
    }
}
