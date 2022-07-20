/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.ControllerClient;
import Model.Client;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
/**
 *
 * @author Asus
 */
public class ViewSearchClient implements ActionListener {
    JFrame viewSearchPasien = new JFrame("CARI CLIENT");
    JLabel NIKOutputLabel,namaLabel,tglLahirLabel,golonganPasienLabel,
            alamatLabel,noKontakLabel,genderLabel,namapet,jenispet,
            genderpet,keluhan,NIKInputLabel;
    JTextField NIKInputTextField;
    JButton buttonSearch;
    JPanel panelMenu,panelContent;
    JButton menuPasien = new JButton("CLIENT");
    JButton menuDokter = new JButton("STAFF");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    
    public ViewSearchClient(){
        NIKInputLabel = new JLabel("Masukkan NIK Client : ");
        NIKOutputLabel = new JLabel();
        namaLabel = new JLabel();
        tglLahirLabel = new JLabel();
        golonganPasienLabel = new JLabel();
        alamatLabel = new JLabel();
        noKontakLabel = new JLabel();
        genderLabel = new JLabel();
        namapet = new JLabel();
        jenispet = new JLabel();
        genderpet = new JLabel();
        keluhan = new JLabel();
        NIKInputTextField = new JTextField();
        panelContent = new JPanel();
        panelMenu = new JPanel();
        buttonSearch = new JButton("CARI CLIENT");
        
        viewSearchPasien.setSize(1200, 620);
        viewSearchPasien.setLocationRelativeTo(null);
        viewSearchPasien.setLayout(null);
        
        panelMenu.setLayout(null);
        panelContent.setLayout(null);
        
        panelMenu.setBounds(10,520,1170,50);
        panelContent.setBounds(10,10,1170,500);
        
        panelContent.setBackground(Color.ORANGE);
        panelMenu.setBackground(Color.ORANGE);
        
        menuPasien.setBounds(320,10,90,30);
        menuDokter.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        NIKInputLabel.setBounds(10, 10, 150, 25);
        NIKInputTextField.setBounds(170, 10, 120, 25);
        NIKOutputLabel.setBounds(10, 10, 200, 25);
        namaLabel.setBounds(10, 40, 200, 25);
        tglLahirLabel.setBounds(10, 70, 200, 25);
        golonganPasienLabel.setBounds(10, 100, 200, 25);
        alamatLabel.setBounds(10, 130, 200, 25);
        noKontakLabel.setBounds(10, 160, 200, 25);
        genderLabel.setBounds(10, 190, 200, 25);
        namapet.setBounds(10, 210, 200, 25);
        jenispet.setBounds(10, 240, 200, 25);
        genderpet.setBounds(10, 270, 200, 25);
        keluhan.setBounds(10, 290, 200, 25);
        
        buttonSearch.setBounds(100, 80, 150, 30);
        
        namaLabel.setVisible(false);
        tglLahirLabel.setVisible(false);
        golonganPasienLabel.setVisible(false);
        alamatLabel.setVisible(false);
        noKontakLabel.setVisible(false);
        genderLabel.setVisible(false);
        namapet.setVisible(false);
        jenispet.setVisible(false);
        genderpet.setVisible(false);
        keluhan.setVisible(false);
        
        panelContent.add(NIKInputLabel);
        panelContent.add(NIKInputTextField);
        
        panelContent.add(namaLabel);
        panelContent.add(tglLahirLabel);
        panelContent.add(golonganPasienLabel);
        panelContent.add(alamatLabel);
        panelContent.add(noKontakLabel);
        panelContent.add(genderLabel);
        panelContent.add(namapet);
        panelContent.add(jenispet);
        panelContent.add(genderpet);
        panelContent.add(keluhan);
        panelContent.add(buttonSearch);
        
        panelMenu.add(menuDokter);
        panelMenu.add(menuPasien);
        panelMenu.add(menuAdmin);
        
        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);
        buttonSearch.addActionListener(this);
        
        viewSearchPasien.add(panelContent);
        viewSearchPasien.add(panelMenu);
        viewSearchPasien.setLocationRelativeTo(null);
        viewSearchPasien.setUndecorated(true);
        viewSearchPasien.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        viewSearchPasien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewSearchPasien.setVisible(true);

        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "CLIENT": 
                new MenuClient();
                viewSearchPasien.setVisible(false);
                break;
            case "STAFF":
                new MenuStaff();
                viewSearchPasien.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                viewSearchPasien.setVisible(false);
                break;
            case "CARI CLIENT":
                Client p = ControllerClient.getClient(NIKInputTextField.getText());
                if(p != null){
                    NIKInputLabel.setVisible(false);
                    NIKInputTextField.setVisible(false); 
                    buttonSearch.setVisible(false);
                    
                    namaLabel.setVisible(true);
                    tglLahirLabel.setVisible(true);
                    golonganPasienLabel.setVisible(true);
                    alamatLabel.setVisible(true);
                    noKontakLabel.setVisible(true);
                    genderLabel.setVisible(true);
                    namapet.setVisible(true);
                    jenispet.setVisible(true);
                    genderpet.setVisible(true);
                    keluhan.setVisible(true);
                    
                    NIKOutputLabel.setText("NIK : " + p.getNIK());
                    namaLabel.setText("Nama : " + p.getNama());
                    tglLahirLabel.setText("Tanggal Lahir : " + p.getTglLahir());
                    golonganPasienLabel.setText("Pelayanan : " + p.getVIP());
                    alamatLabel.setText("alamat : " + p.getAlamat());
                    noKontakLabel.setText("no Kontak : " + p.getTelepon());
                    genderLabel.setText("Gender : " + p.getGender());
                    namapet.setText("Nama Pet : " + p.getNamapeliharaan());
                    jenispet.setText("Jenis Pet : " + p.getJenispeliharaan());
                    genderpet.setText("Gender Pet : " + p.getGenderpeliharaan());
                    keluhan.setText("Keluhan : " + p.getKeluhan());
                }else{
                    JOptionPane.showMessageDialog(null, "Data Pasien tidak ditemukan");
                }
                break;
            default: 
                break;
        }
    }
}
