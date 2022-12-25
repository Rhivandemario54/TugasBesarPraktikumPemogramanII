package view.pendaftaran;

import model.Jumlah;
import model.Tujuan;
import model.Pendaftaran;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.text.StyleConstants;
import javax.swing.text.SimpleAttributeSet;


public class PendaftaranFrame extends JFrame {
    private ImageIcon carIcon;
    private JLabel myLabel;
    private List<Jumlah> jumlahList;
    private List<Tujuan> tujuanList;
    private List<Pendaftaran> pendaftaranList;
    private final JTextField textFieldNama;
    private final JTextField textFieldAlamat;
    private JRadioButton radioButtonL;
    private JRadioButton radioButtonP;
    private PendaftaranTableModel tableModel;
    private final JComboBox<String> comboMerek;
    private final JComboBox<String> comboNamot;
    private final JButton buttonSimpan;
    private final JButton buttonDelete;
    private final JButton buttonExportPdf;
    private final JTable table;

    

    public PendaftaranFrame() {
        // Tampilan >>>>
        carIcon = new ImageIcon(this.getClass().getResource("../bgwow.jpg"));
        myLabel = new JLabel(carIcon);
        myLabel.setSize(1360,800);
        // Tampilan <<<<

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelTitlee1 = new JLabel(" Halaman Pendaftaran Booking pesawat ");
        labelTitlee1.setBounds(120,15,350,10);
        labelTitlee1.setForeground(Color.white);

        JLabel labelInputNama = new JLabel("Nama User:");
        labelInputNama.setBounds(15, 40, 350, 10);
        labelInputNama.setForeground(Color.white);
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        JLabel labelInputAlamat = new JLabel("Tanggal Penerbangan :");
        labelInputAlamat.setBounds(15, 100, 350, 10);
        labelInputAlamat.setForeground(Color.white);
        textFieldAlamat = new JTextField();
        textFieldAlamat.setBounds(15, 120, 350, 30);

        JLabel labelJenisMotor = new JLabel("Kelas Penerbangan :");
        labelJenisMotor.setForeground(Color.white);
        labelJenisMotor.setBounds(15, 150, 350, 30);
        radioButtonL = new JRadioButton("reguler", true);
        radioButtonL.setBounds(15, 175, 350, 30);
        radioButtonP = new JRadioButton("VVIP");
        radioButtonP.setBounds(15, 200, 350, 30);

        JLabel labelJenis = new JLabel("Tujuan :");
        labelJenis.setForeground(Color.white);
        labelJenis.setBounds(15, 240, 350, 10);
        comboMerek = new JComboBox<String>();
        comboMerek.setBounds(15, 260, 150, 30);

        JLabel labelNamotor = new JLabel("Jumlah Penumpang :");
        labelNamotor.setBounds(200, 240, 350, 10);
        labelNamotor.setForeground(Color.white);
        comboNamot = new JComboBox<String>();
        comboNamot.setBounds(200, 260, 150, 30);

        buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 315, 100, 40);

        buttonDelete = new JButton("Hapus");
        buttonDelete.setBounds(140, 315, 100, 40);

        buttonExportPdf = new JButton("Export PDF");
        buttonExportPdf.setBounds(260, 315, 100, 40);

        JLabel labelTitlee = new JLabel("<< TABEL DAFTAR NOTA PEMBELIAN MOTOR >>");
        labelTitlee.setBounds(50,390,350,10);
        labelTitlee.setForeground(Color.white);

        table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(5, 410, 370, 200);

        // CSS Java untuk title apk dan icon 
        this.setTitle("<< Aplikasi Sorum Nota >>");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../sorum.png")));
    
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButtonL);
        bg.add(radioButtonP);

        this.add(buttonSimpan);
        this.add(buttonDelete);
        this.add(buttonExportPdf);
        this.add(textFieldNama);
        this.add(labelInputNama);
        this.add(textFieldAlamat);
        this.add(labelInputAlamat);
        this.add(radioButtonL);
        this.add(radioButtonP);
        this.add(labelJenisMotor);
        this.add(labelJenis);
        this.add(comboMerek);
        this.add(labelNamotor);
        this.add(comboNamot);
        this.add(scrollableTable);
        this.add(labelTitlee);
        this.add(labelTitlee1);
        this.add(myLabel);

        this.setSize(400, 700);
        this.setLayout(null);
    }

    public void populatePendaftaranTable(List<Pendaftaran> pendaftaranList) {
        this.pendaftaranList = pendaftaranList;
        tableModel = new PendaftaranTableModel(pendaftaranList);
        table.setModel(tableModel);
    }

    public void populateComboTujuan(List<Tujuan> tujuanList) {
        this.tujuanList = tujuanList;
        comboMerek.removeAllItems();
        for (Tujuan tujuan : tujuanList) {
            comboMerek.addItem(tujuan.getTujuanpen());
        }
    }

    public void populateComboJumlah(List<Jumlah> jumlahList) {
        this.jumlahList = jumlahList;
        comboNamot.removeAllItems();
        for (Jumlah jumlah : jumlahList) {
            comboNamot.addItem(jumlah.getJumlahpen());
        }
    }

    public String getNamauser() {
        return textFieldNama.getText();
    }

    public String getTgl_penerbangan() {
        return textFieldAlamat.getText();
    }

    public String getKelaspen() {
        String kelaspen = "";

        if (radioButtonL.isSelected()) {
            kelaspen = radioButtonL.getText();
        }
        if (radioButtonP.isSelected()) {
            kelaspen = radioButtonP.getText();
        }
        return kelaspen;
    }

    public Tujuan getTujuanpen() {
        return tujuanList.get(comboMerek.getSelectedIndex());
    }

    public Jumlah getJumlahpen() {
        return jumlahList.get(comboNamot.getSelectedIndex());
    }

    public void addPendaftaran(Pendaftaran pendaftaran) {
        tableModel.add(pendaftaran);
        textFieldNama.setText("");
        textFieldAlamat.setText("");
    }

    public String takePendaftaran() {
        int[] selection = table.getSelectedRows();
        for (int i = 0; i < selection.length; i++) {
            selection[i] = table.convertRowIndexToModel(selection[i]);
        }

        if (selection.length > 0) {
            String namaPendaftar = (String) tableModel.getValueAt(selection[0], 5);
            return namaPendaftar;
        } else {
            return "";
        }
    }

    public void deletePendaftaran() {
        int[] selection = table.getSelectedRows();
        for (int i = 0; i < selection.length; i++) {
            selection[i] = table.convertRowIndexToModel(selection[i]);
        }
        tableModel.remove(selection[0]);
    }

    public void showAlert(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void addButtonSimpanActionListener(ActionListener actionListener) {
        buttonSimpan.addActionListener(actionListener);
    }

    public void addButtonExportPdfActionListener(ActionListener actionListener) {
        buttonExportPdf.addActionListener(actionListener);
    }

    public void addButtonDeleteActionListener(ActionListener actionListener) {
        buttonDelete.addActionListener(actionListener);
    }

    public List<Pendaftaran> getPendaftaranList() {
        return pendaftaranList;
    }
}
