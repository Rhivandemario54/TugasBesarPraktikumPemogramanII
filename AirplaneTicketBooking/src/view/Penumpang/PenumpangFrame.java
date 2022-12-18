package src.view.Penumpang;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;


import src.model.*;
import src.dao.PenumpangDao;
import src.dao.AsalTerbangDao;
import src.dao.TujuanTerbangDao;


public class PenumpangFrame extends JFrame {
    private List<AsalTerbang> asalTerbangList;
    private List<TujuanTerbang> tujuanTerbangList;
    private List<Penumpang> penumpangList;

    private JTextField textFieldNama;
    private JTextField textFieldUmur;
    private JTextField textFieldNoTelpon;

    private PenumpangTableModel tableModel;

    private JComboBox<String> comboAsal;
    private JComboBox<String> comboTujuan;
    
    private PenumpangDao penumpangDao;
    private AsalTerbangDao asalTerbangDao;
    private TujuanTerbangDao tujuanTerbangDao;

    public PenumpangFrame(PenumpangDao penumpangDao, AsalTerbangDao asalTerbangDao, TujuanTerbangDao tujuanTerbangDao){  
        this.asalTerbangDao = asalTerbangDao;
        this.tujuanTerbangDao = tujuanTerbangDao;
        this.penumpangDao = penumpangDao;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelInput = new JLabel("Input Data Penumpang");
        labelInput.setBounds(10, 10, 200, 20);

        JLabel labelNama = new JLabel("Nama");
        labelNama.setBounds(10, 40, 100, 20);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(10, 60, 200, 20);

        JLabel labelUmur = new JLabel("Umur");
        labelUmur.setBounds(10, 90, 100, 20);

        textFieldUmur = new JTextField();
        textFieldUmur.setBounds(10, 110, 200, 20);

        JLabel labelNoTelpon = new JLabel("No Telpon");
        labelNoTelpon.setBounds(10, 140, 100, 20);

        textFieldNoTelpon = new JTextField();
        textFieldNoTelpon.setBounds(10, 160, 200, 20);

        JLabel labelAsal = new JLabel("Asal");
        labelAsal.setBounds(10, 190, 100, 20);

        comboAsal = new JComboBox<String>();
        comboAsal.setBounds(10, 210, 200, 20);

        JLabel labelTujuan = new JLabel("Tujuan");
        labelTujuan.setBounds(10, 240, 100, 20);

        comboTujuan = new JComboBox<String>();
        comboTujuan.setBounds(10, 260, 200, 20);

        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(10, 290, 100, 20);

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(220, 10, 800, 300);

        tableModel = new PenumpangTableModel(penumpangList);
        table.setModel(tableModel);

        PenumpangButtonSimpanActionListener actionListener = new PenumpangButtonSimpanActionListener(this, penumpangDao);

        buttonSimpan.addActionListener(actionListener);

        this.add(labelInput);
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelUmur);
        this.add(textFieldUmur);
        this.add(labelNoTelpon);
        this.add(textFieldNoTelpon);
        this.add(labelAsal);
        this.add(comboAsal);
        this.add(labelTujuan);
        this.add(comboTujuan);
        this.add(buttonSimpan);
        this.add(scrollableTable);

        this.setSize(1100,500);
        this.setLayout(null);
    }

    public void populateComboAsal() {
        this.asalTerbangList = asalTerbangDao.findAll();
        comboAsal.removeAllItems();
        for (AsalTerbang asalTerbang: this.asalTerbangList) {
            comboAsal.addItem(asalTerbang.getAsal());
        }
    }

    public void populateComboTujuan() {
        this.tujuanTerbangList = tujuanTerbangDao.findAll();
        comboTujuan.removeAllItems();
        for (TujuanTerbang tujuanTerbang: this.tujuanTerbangList) {
            comboTujuan.addItem(tujuanTerbang.getTujuan());
        }
    }

    public String getNama() {
        return textFieldNama.getText();
    }

    public String getUmur() {
        return textFieldUmur.getText();
    }

    public String getNoTelpon() {
        return textFieldNoTelpon.getText();
    }

    public AsalTerbang GetAsalTerbang() {
        return asalTerbangList.get(comboAsal.getSelectedIndex());
    }

    public TujuanTerbang GetTujuanTerbang() {
        return tujuanTerbangList.get(comboTujuan.getSelectedIndex());
    }

    public void addPenumpang(Penumpang penumpang) {
        tableModel.add(penumpang);
        textFieldNama.setText("");
    }

    public void showAlert(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
