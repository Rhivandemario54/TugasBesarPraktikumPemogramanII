package src.view.AsalTerbang;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

import src.model.AsalTerbang;
import src.dao.AsalTerbangDao;

public class AsalTerbangFrame extends JFrame {
    private List<AsalTerbang> asalTerbangList;
    private JTextField textFieldAsalTerbang;
    private AsalTerbangTableModel tableModel;
    private AsalTerbangDao asalTerbangDao;

    public AsalTerbangFrame(AsalTerbangDao asalTerbangDao) {
        this.asalTerbangDao = asalTerbangDao;
        this.asalTerbangList = asalTerbangDao.findAll();


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelInput = new JLabel("Input Asal Terbang");
        labelInput.setBounds(10, 10, 200, 20);

        textFieldAsalTerbang = new JTextField();
        textFieldAsalTerbang.setBounds(10, 30, 200, 20);

        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(10, 60, 200, 20);


        javax.swing.JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 90, 200, 200);

        tableModel = new AsalTerbangTableModel(asalTerbangList);
        table.setModel(tableModel);

        AsalTerbangButtonSimpanActionListener actionListener = new AsalTerbangButtonSimpanActionListener(this, asalTerbangDao);

        buttonSimpan.addActionListener(actionListener);

        this.add(labelInput);
        this.add(textFieldAsalTerbang);
        this.add(buttonSimpan);
        this.add(scrollPane);

        
        this.setSize(300, 400);
        this.setLayout(null);
    }

    public String getAsal() {
        return textFieldAsalTerbang.getText();
    }

    public void addAsalTerbang(AsalTerbang asalTerbang) {
        tableModel.add(asalTerbang);
    }
}
