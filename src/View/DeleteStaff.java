/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Model.*;
import Controller.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author Asus
 */
public class DeleteStaff implements ActionListener{
    ControllerStaff control = new ControllerStaff();
    
    JFrame deleteDokter = new JFrame("DELETE STAFF");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("CLIENT");
    JButton menuDokter = new JButton("STAFF");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    
    JLabel nids = new JLabel("NIK");
    JButton delete = new JButton("DELETE");
    ArrayList<Staff> staffs= control.getAllStaff();
    String[] listnid;
    JComboBox nid;
    
    
    
    public DeleteStaff(){
        
        deleteDokter.setSize(1200, 620);
        deleteDokter.setLocationRelativeTo(null);
        deleteDokter.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,520,1170,50);
        isi.setBounds(10,10,1170,500);
        
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menuPasien.setBounds(320,10,90,30);
        menuDokter.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        menu.add(menuDokter);
        menu.add(menuPasien);
        menu.add(menuAdmin);
        
        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);
        delete.addActionListener(this);
        
        nids.setBounds(40, 20, 160, 25);
        
        delete.setBounds(100,80,120,30);
        
        listnid = new String[staffs.size()];
        
        for(int i = 0; i < staffs.size(); i++){
            Staff staff = staffs.get(i);
            listnid[i] = staff.getNIK();
        }
        
        nid = new JComboBox(listnid);
        nid.setBounds(100, 20, 160, 25);
        
        isi.add(delete);
        isi.add(nids);
        isi.add(nid);
        
        
        deleteDokter.add(isi);
        deleteDokter.add(menu);
        
        deleteDokter.setUndecorated(true);
        deleteDokter.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        deleteDokter.setVisible(true);
        deleteDokter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "CLIENT": 
                new MenuClient();
                deleteDokter.setVisible(false);
                break;
            case "STAFF":
                new MenuStaff();
                deleteDokter.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                deleteDokter.setVisible(false);
                break;
            case "DELETE":
                String strnid = String.valueOf(nid.getSelectedItem());;
                boolean delete = control.deletestaff(strnid);
                deleteDokter.setVisible(false);
                if(delete == true){
                    deleteDokter.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Data Sudah Di Hapus");
                    new MenuStaff();
                }
                break;
            default: 
                break;
        }
    }
}
