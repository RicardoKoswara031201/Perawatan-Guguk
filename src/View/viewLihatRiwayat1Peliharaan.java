/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.ControllerRiwayatPeliharaan;
import Model.RiwayatPeliharaan;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
/**
 *
 * @author Asus
 */
public class viewLihatRiwayat1Peliharaan implements ActionListener{
    JFrame lihatRiwayatPasien = new JFrame("Lihat Riwayat Peliharaan");
    JLabel NIKInputLabel,tglKunjunganInput,namaLabel;
    JTextField NIKInputField;
    JTable tableRiwayatPeliharaan;
    JButton lihatRiwayat;
    JPanel panelMenu,panelContent;
    JScrollPane scrollPane;
    JDatePickerImpl tglKunjungan;
    JDatePanelImpl datePanel;
    JButton menuPasien = new JButton("CLIENT");
    JButton menuDokter = new JButton("STAFF");
    JButton menuAdmin = new JButton("ADMINISTRASI");
   
    public viewLihatRiwayat1Peliharaan() {
        namaLabel = new JLabel("Nama : ");
        NIKInputLabel = new JLabel("NIK");
        NIKInputField = new JTextField();
        panelMenu = new JPanel();
        panelContent = new JPanel();
        lihatRiwayat = new JButton("LIHAT RIWAYAT");
        
        NIKInputLabel.setBounds(10,10,120,25);
        NIKInputField.setBounds(140,10,120,25);
        lihatRiwayat.setBounds(100, 80, 150, 30);
        
        menuPasien.setBounds(320,10,90,30);
        menuDokter.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        panelContent.add(NIKInputLabel);
        panelContent.add(NIKInputField);
        panelContent.add(lihatRiwayat);
        
        panelMenu.add(menuDokter);
        panelMenu.add(menuPasien);
        panelMenu.add(menuAdmin);
        
        lihatRiwayatPasien.setSize(1200, 620);
        lihatRiwayatPasien.setLocationRelativeTo(null);
        lihatRiwayatPasien.setLayout(null);
        panelMenu.setLayout(null);
        panelContent.setLayout(null);
        panelMenu.setBounds(10,520,1170,50);
        panelContent.setBounds(10,10,1170,500);
        panelMenu.setBackground(Color.GREEN);
        panelContent.setBackground(Color.GREEN);
        
        lihatRiwayat.addActionListener(this);
        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);
        
        lihatRiwayatPasien.add(panelContent);
        lihatRiwayatPasien.add(panelMenu);
        lihatRiwayatPasien.setUndecorated(true);
        lihatRiwayatPasien.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        lihatRiwayatPasien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lihatRiwayatPasien.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "CLIENT": 
                new MenuClient();
                lihatRiwayatPasien.setVisible(false);
                break;
            case "STAFF":
                new MenuStaff();
                lihatRiwayatPasien.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                lihatRiwayatPasien.setVisible(false);
                break;
            case "LIHAT RIWAYAT":
                String[] column = {"tgl kunjungan","keluhan","penyakit","resep obat"};
                ArrayList<RiwayatPeliharaan> RP = ControllerRiwayatPeliharaan.getAllRiwayatPeliharaans(NIKInputField.getText());
                ArrayList<String> resepObat = ControllerRiwayatPeliharaan.getResepObat1Peliharaan(NIKInputField.getText());
                StringBuffer sb = new StringBuffer();
                String data[][] = new String[RP.size()][4];
                for(int i = 0; i < RP.size(); i++){
                    data[i][0] = String.valueOf(RP.get(i).getTanggalKunjungan());
                    data[i][1] = RP.get(i).getKeluhan();
                    data[i][2] = RP.get(i).getPenyakit();
                    for(String s : resepObat){
                        sb.append(s);
                        sb.append(",");
                    }
                    String str = sb.toString();
                    data[i][3] = str;
                }
                tableRiwayatPeliharaan = new JTable(data,column);
                scrollPane = new JScrollPane(tableRiwayatPeliharaan);
                scrollPane.setBounds(10,150,910,200);
                panelContent.add(scrollPane);
                break;
            default: 
                break;
        }
    }
}
