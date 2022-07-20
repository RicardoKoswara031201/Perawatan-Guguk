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
public class MenuStaff implements ActionListener{
    JFrame frame = new JFrame("MenuStaff");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuClient = new JButton("CLIENT");
    JButton menuStaff = new JButton("STAFF");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JButton insertDokter = new JButton("INSERT Staff");
    JButton deleteDokter = new JButton("DELETE Staff");
    JLabel homePertama;
    
    public MenuStaff(){
        
        frame.setSize(1200, 620);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,520,1170,50);
        isi.setBounds(10,10,1170,500);
        
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menuClient.setBounds(320,10,90,30);
        menuStaff.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        menu.add(menuStaff);
        menu.add(menuClient);
        menu.add(menuAdmin);
        
        menuStaff.addActionListener(this);
        menuClient.addActionListener(this);
        menuAdmin.addActionListener(this);
        
        String homesPertama = "MENU Staff";
        
        homePertama = new JLabel(homesPertama);
        
        homePertama.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        homePertama.setBounds(465, 20, 750, 100);
        insertDokter.setBounds(475,100,200,50);
        deleteDokter.setBounds(475,180,200,50);
        
        isi.add(homePertama);
        isi.add(insertDokter);
        isi.add(deleteDokter);

        insertDokter.addActionListener(this);
        deleteDokter.addActionListener(this);

        frame.add(isi);
        frame.add(menu);
   
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        frame.setVisible(true);
    }

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
            case "INSERT STAFF":
                new InputStaff();
                frame.setVisible(false);
                break;
            case "DELETE STAFF":
                new DeleteStaff();
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
}
