/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Model.Singleton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
/**
 *
 * @author Asus
 */
public class MenuClient implements ActionListener{
    JFrame frame = new JFrame("MENU Client");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuClient = new JButton("Client");
    JButton menuStaff = new JButton("Staff");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JButton insertClientBaru, searchClient, beliObat, tambahRiwayatPeliharaan, lihatRiwayatPeliharaan;
    JLabel homePertama;
    
    public MenuClient(){

        insertClientBaru = new JButton("INSERT Client BARU");
        searchClient = new JButton("CARI Client");
        beliObat = new JButton("BELI OBAT");
        tambahRiwayatPeliharaan = new JButton("UPDATE RIWAYAT PELIHARAAN CLIENT");
        lihatRiwayatPeliharaan = new JButton("LIHAT RIWAYAT PELIHARAAN CLIENT");
        
        frame.setSize(1200, 620);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,520,1170,50);
        isi.setBounds(10,10,1170,500);
        
        isi.setBackground(Color.BLUE);
        menu.setBackground(Color.BLUE);
        
        menuClient.setBounds(320,10,90,30);
        menuStaff.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        menu.add(menuStaff);
        menu.add(menuClient);
        menu.add(menuAdmin);
        
        menuStaff.addActionListener(this);
        menuClient.addActionListener(this);
        menuAdmin.addActionListener(this);
        
        String homesPertama = "MENU Client";
        
        homePertama = new JLabel(homesPertama);
        
        homePertama.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        homePertama.setBounds(465, 20, 750, 100);
        insertClientBaru.setBounds(475, 100, 200, 50);
        searchClient.setBounds(475, 180, 200, 50);
        tambahRiwayatPeliharaan.setBounds(475, 260, 200, 50);
        lihatRiwayatPeliharaan.setBounds(475, 340, 200, 50);
        
        isi.add(homePertama);
        isi.add(insertClientBaru);
        isi.add(searchClient);
        isi.add(tambahRiwayatPeliharaan);
        isi.add(lihatRiwayatPeliharaan);
        
        insertClientBaru.addActionListener(this);
        searchClient.addActionListener(this);
        tambahRiwayatPeliharaan.addActionListener(this);
        lihatRiwayatPeliharaan.addActionListener(this);
        
        frame.add(isi);
        frame.add(menu);
           
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "Client": 
                new MenuClient();
                frame.setVisible(false);
                break;
            case "Staff":
                new MenuStaff();
                frame.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                frame.setVisible(false);
                break;
            case "INSERT CLIENT BARU":
                new ViewInsertClientBaru();
                break;
            case "CARI PASIEN":
                new ViewSearchPasien();
                frame.setVisible(false);
                break;
            case "UPDATE RIWAYAT PELIHARAAN CLIENT":
                new viewTambahRiwayatPeliharaan();
                frame.setVisible(false);
                break;
            case "LIHAT RIWAYAT PELIHARAAN CLIENT":
                new viewLihatRiwayat1Peliharaan();
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
}
