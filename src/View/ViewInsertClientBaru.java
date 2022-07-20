/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.ControllerViewClient;
import Model.Client;
import Model.DateLabelFormatter;
import Model.PelayananClien;
import Model.InterfacePelayanan;
import Model.Staff;
import Model.People;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/**
 *
 * @author Asus
 */
public class ViewInsertClientBaru implements InterfacePelayanan{
    JFrame viewInsertNewPatient = new JFrame("FORM Client BARU");
    JLabel NIKLabel,namaLabel,tglLahirLabel,alamatLabel,noKontakLabel,golonganLabel,
            genderLabel,namapet,genderpet,jenispet,keluhan;
    JTextField NIKTextField,namaTextField,alamatTextField,noKontakTextField,namapettext,jenispettext,keluhantext;
    JRadioButton VIPRadioButton,nonVIPRadioButton,
            wanitaRadioButton,priaRadioButton,
            betinaRadioButton,jantanRadioButton;
    ButtonGroup genderButtonGroup,golonganButtonGroup,genderpetButtonGroup;
    JButton insertNewPatient;
    JDatePickerImpl tglLahir;
    JDatePanelImpl datePanel;
    JPanel panelContent,panelMenu,panelWithScroll;
    JScrollPane panelScroll;
    GridBagLayout gbl;
    GridBagConstraints gbc;
    ControllerViewClient CVP;
    
    public ViewInsertClientBaru(){
        NIKLabel = new JLabel("NIK");
        namaLabel = new JLabel("Nama Lengkap");
        tglLahirLabel = new JLabel("Tanggal Lahir");
        alamatLabel = new JLabel("Alamat Pasien");
        noKontakLabel = new JLabel("no Kontak Client");
        golonganLabel = new JLabel("Golongan Client");
        genderLabel = new JLabel("Jenis Kelamin Client");
        namapet = new JLabel("Nama Peliharaan");
        jenispet = new JLabel("Jenis Peliharaan");
        genderpet = new JLabel("Jenis Kelamin Peliharaan");
        keluhan= new JLabel("Keluhan");
        
        NIKTextField = new JTextField(20);
        namaTextField = new JTextField(20);
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        tglLahir = new JDatePickerImpl(datePanel,new DateLabelFormatter());
        alamatTextField = new JTextField(20);
        noKontakTextField = new JTextField(20);
        VIPRadioButton = new JRadioButton("VIP");
        nonVIPRadioButton = new JRadioButton("NON VIP");
        wanitaRadioButton = new JRadioButton("Wanita");
        priaRadioButton = new JRadioButton("Pria");
        namapettext = new JTextField(20);
        jenispettext = new JTextField(20);
        betinaRadioButton = new JRadioButton("Betina");
        jantanRadioButton = new JRadioButton("Jantan");
        keluhantext = new JTextField(20);

        genderpetButtonGroup = new ButtonGroup();
        genderButtonGroup = new ButtonGroup();
        golonganButtonGroup = new ButtonGroup();

        genderButtonGroup.add(wanitaRadioButton);
        genderButtonGroup.add(priaRadioButton);
        golonganButtonGroup.add(VIPRadioButton);
        golonganButtonGroup.add(nonVIPRadioButton);
        genderpetButtonGroup.add(betinaRadioButton);
        genderpetButtonGroup.add(jantanRadioButton);

        insertNewPatient = new JButton("TAMBAH CLIENT BARU");
        panelContent = new JPanel();
        panelMenu = new JPanel();
        panelWithScroll = new JPanel();
        CVP = new ControllerViewClient();
        gbc = new GridBagConstraints();
        gbl = new GridBagLayout();
        panelWithScroll.setLayout(gbl);
        panelScroll = new JScrollPane(){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(600, 500);
            };
        };
        panelScroll.setViewportView(panelWithScroll);
        
        CVP.setGBC(gbc, 0.5, 0.5, 1, 1, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(NIKLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 1, GridBagConstraints.PAGE_START);
        panelWithScroll.add(NIKTextField,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 2, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(namaLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 2, GridBagConstraints.PAGE_START);
        panelWithScroll.add(namaTextField,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 3, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(namapet,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 3, GridBagConstraints.PAGE_START);
        panelWithScroll.add(namapettext,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 4, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(jenispet,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 5, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(jenispettext,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 5, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(keluhan,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 3, 5, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(keluhantext,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 6, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(golonganLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 7, GridBagConstraints.LINE_START);
        panelWithScroll.add(VIPRadioButton,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 8, GridBagConstraints.LINE_START);
        panelWithScroll.add(nonVIPRadioButton,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 8, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(tglLahirLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 9, GridBagConstraints.PAGE_START);
        panelWithScroll.add(tglLahir,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 9, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(alamatLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 10, GridBagConstraints.PAGE_START);
        panelWithScroll.add(alamatTextField,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 11, GridBagConstraints.PAGE_START);
        panelWithScroll.add(alamatTextField,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 11, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(noKontakLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 12, GridBagConstraints.PAGE_START);
        panelWithScroll.add(noKontakTextField,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 12, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(genderLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 13, GridBagConstraints.LINE_START);
        panelWithScroll.add(wanitaRadioButton,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 13, GridBagConstraints.LINE_START);
        panelWithScroll.add(priaRadioButton,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 14, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(genderpet,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 14, GridBagConstraints.LINE_START);
        panelWithScroll.add(betinaRadioButton,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 15, GridBagConstraints.LINE_START);
        panelWithScroll.add(jantanRadioButton,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 16, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(insertNewPatient,gbc);
        
        panelContent.add(panelScroll,gbc);
        
        viewInsertNewPatient.setContentPane(panelContent);
        viewInsertNewPatient.pack();
        viewInsertNewPatient.setLocationByPlatform(true);
        viewInsertNewPatient.setVisible(true);
        viewInsertNewPatient.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        insertNewPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client pt = new Client();
                pt.setNIK(NIKTextField.getText());
                pt.setNama(namaTextField.getText());
                pt.setNamapeliharaan(namapettext.getText());
                pt.setJenispeliharaan(jenispettext.getText());
                pt.setKeluhan(keluhantext.getText());
                pt.setAlamat(alamatTextField.getText());
                pt.setTglLahir((Date)tglLahir.getModel().getValue());
                pt.setTelepon(noKontakTextField.getText());
                String gender = "";
                if(wanitaRadioButton.isSelected()){
                    gender = "Wanita";
                }else if(priaRadioButton.isSelected()){
                    gender = "Pria";
                }
                String petgender = "";
                if(betinaRadioButton.isSelected()){
                    gender = "Betina";
                }else if(jantanRadioButton.isSelected()){
                    gender = "Jantan";
                }
                if(VIPRadioButton.isSelected()){
                    pt.setVIP(VIP);
                }else if(nonVIPRadioButton.isSelected()){
                    pt.setVIP(Non_VIP);
                }
                pt.setGender(gender);
                pt.setGenderpeliharaan(petgender);
                pt.setListRiwayatClien(new ArrayList<>());
                
                pt.clienBaru(pt);
                viewInsertNewPatient.dispose();
            }
        });
    }
}
