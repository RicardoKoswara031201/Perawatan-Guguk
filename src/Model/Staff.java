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
public class Staff extends People{
    private String Keahlian;
    
    public Staff(String Keahlian, String NIK, String Nama, Date tglLahir, String gender, String Alamat, String Telepon){   
        super(NIK,Nama,tglLahir,gender,Alamat,Telepon);
        this.Keahlian = Keahlian;
    }

    public String getKeahlian() {
        return Keahlian;
    }

    public void setKeahlian(String Keahlian) {
        this.Keahlian = Keahlian;
    }
    
    @Override
    public String toString() {
        return "Staff{" + " Keahlian=" + Keahlian + "}";
    }
}
