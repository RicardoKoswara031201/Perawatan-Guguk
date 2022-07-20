/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Model.Singleton;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;
/**
 *
 * @author Asus
 */
public class MainMenu implements ActionListener{
    JFrame frame = new JFrame("MAIN MENU");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuClient = new JButton("CLIENT");
    JButton menuStaff = new JButton("STAFF");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JLabel homePertama;
    JLabel homeKedua;
    JLabel homeKetiga;

    public MainMenu(){
        
        frame.setSize(1200, 650);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,520,1170,50);
        isi.setBounds(10,10,1170,500);
        
        menu.setBackground(Color.GREEN);
        isi.setBackground(Color.GREEN);

        menuClient.setBounds(320,10,90,30);
        menuStaff.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        menu.add(menuStaff);
        menu.add(menuClient);
        menu.add(menuAdmin);

        menuClient.addActionListener(this);
        menuStaff.addActionListener(this);
        menuAdmin.addActionListener(this);
        
        String homesPertama = "SELAMAT DATANG DI Home Pets";
        String homesKedua = "Peliharaan adalah teman semua orang";
        String homesKetiga = "Cabang : " + Singleton.getInstance().getCabang().getNama();
        
        homePertama = new JLabel(homesPertama);
        homeKedua = new JLabel(homesKedua);
        homeKetiga = new JLabel(homesKetiga);
        
        homePertama.setFont(new Font("Times New Roman", Font.BOLD, 33));
        homeKedua.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        homeKetiga.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        
        homePertama.setBounds(100, 20, 750, 100);
        homeKedua.setBounds(100, 110, 500, 100);
        homeKetiga.setBounds(100, 150, 500, 100);
   
        isi.add(homePertama);
        isi.add(homeKedua);
        isi.add(homeKetiga);

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
            case "CLIENT": 
                new MenuClient();
                frame.setVisible(false);
                break;
            case "STAFF":
                new MenuStaff();
                frame.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
}
