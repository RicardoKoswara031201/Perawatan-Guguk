/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import Controller.*;
import java.util.Date;
/**
 *
 * @author Asus
 */
public class InputStaff implements ActionListener{
    private ControllerStaff control = new ControllerStaff();
    JFrame inputDokter = new JFrame("INPUT STAFF");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("CLIENT");
    JButton menuDokter = new JButton("STAFF");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JButton submit = new JButton("SUBMIT");
    
    JLabel labNik = new JLabel("NIK");
    JLabel labNama = new JLabel("Nama");
    JLabel labTgllahir = new JLabel("Tanggal Lahir");
    JLabel labGender = new JLabel("Jenis Kelamin");
    JLabel labPoli = new JLabel("Keahlian");
    JLabel labNotelp = new JLabel("No Telepon");
    JLabel labAlamat = new JLabel("Alamat");
    JTextField textNik = new JTextField();
    JTextField textNama = new JTextField();
    UtilDateModel model = new UtilDateModel();
    Properties p = new Properties();
    JRadioButton male = new JRadioButton("Pria");
    JRadioButton female = new JRadioButton("Wanita");
    JTextField textNotelp = new JTextField();
    String[] listPoli = {"Organ Dalam Guguk", "Organ Dalam Kucing", "Dokter Kesehatan hewan"};
    JComboBox Poli = new JComboBox(listPoli);
    JTextField textAlamat = new JTextField();
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    
    public InputStaff(){
        //template
        inputDokter.setSize(1200, 620);
        inputDokter.setLocationRelativeTo(null);
        inputDokter.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,520,1170,50);
        isi.setBounds(10,10,1170,500);
        
        isi.setBackground(Color.GREEN);
        menu.setBackground(Color.GREEN);
        
        menuPasien.setBounds(320,10,90,30);
        menuDokter.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        menu.add(menuDokter);
        menu.add(menuPasien);
        menu.add(menuAdmin);
        
        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);
        //akhir template
        
        //isi menu
        
        labNik.setBounds(40, 10, 160, 25);
        isi.add(labNik);
        textNik.setBounds(120, 10, 160, 25);
        isi.add(textNik);
       
        labNama.setBounds(40, 90, 160, 25);
        isi.add(labNama);
        textNama.setBounds(120, 90, 160, 25);
        isi.add(textNama);
        
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        
        datePicker.setBounds(120, 50, 160, 25);
        labTgllahir.setBounds(40, 50, 160, 25);
        isi.add(labTgllahir);
        isi.add(datePicker);
        
        labGender.setBounds(40, 160, 160, 25);
        isi.add(labGender);
        
        male.setBounds(140, 165, 50, 15);
        female.setBounds(190, 165, 70, 15);
        
        male.setBackground(Color.GREEN);
        female.setBackground(Color.GREEN);
        
        ButtonGroup jenisK = new ButtonGroup();
        
        jenisK.add(male);
        jenisK.add(female);
        
        isi.add(male);
        isi.add(female);
        
        labPoli.setBounds(40, 200, 160, 25);
        isi.add(labPoli);
        Poli.setBounds(120, 200, 160, 25);
        isi.add(Poli);
        
        labNotelp.setBounds(40, 250, 160, 25);
        isi.add(labNotelp);
        textNotelp.setBounds(120, 250, 160, 25);
        isi.add(textNotelp);
        
        labAlamat.setBounds(40, 300, 160, 25);
        isi.add(labAlamat);
        isi.setBounds(120, 300, 160, 25);
        isi.add(isi);
        
        submit.setBounds(80,400,100, 25);
        submit.addActionListener(this);
        isi.add(submit);
        
        inputDokter.add(isi);
        inputDokter.add(menu);
        
        inputDokter.setUndecorated(true);
        inputDokter.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        inputDokter.setVisible(true);
        inputDokter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    }
    
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "CLIENT": 
                new MenuClient();
                inputDokter.setVisible(false);
                break;
            case "STAFF":
                new MenuStaff();
                inputDokter.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                inputDokter.setVisible(false);
                break;
            case "SUBMIT":
                String strnik = textNik.getText();
                String strnama = textNama.getText();
                String strlahir = model.getDay() + "-" + model.getMonth() + "-" + model.getYear();
                
                String strgender = "";
                if (male.isSelected()) {
                    strgender = male.getText();
                } else if (female.isSelected()) {
                    strgender = female.getText();
                }

                String strpoli = "";
                strpoli = String.valueOf(Poli.getSelectedItem());
                String strnotelp = textNotelp.getText();
                String stralamat = textAlamat.getText();
                
                Date lahir = (Date)datePicker.getModel().getValue();
                Staff staff = new Staff(strpoli, strnama, strnik, lahir, strgender, stralamat, strnotelp);
                boolean input = control.addStaff(staff);
                if(input == true){
                    inputDokter.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Data Sudah Di Tambah");
                    new MenuStaff();
                    inputDokter.setVisible(false);
                }                
            default: 
                break;
        }
    }
}
