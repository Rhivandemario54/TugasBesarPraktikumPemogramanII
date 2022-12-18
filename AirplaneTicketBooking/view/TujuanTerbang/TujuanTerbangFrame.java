package view.TujuanTerbang;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import model.TujuanTerbang;

public class TujuanTerbangFrame extends JFrame {
    private List<TujuanTerbang> tujuanTerbangList;
    private JTextField textFieldTujuanTerbang;
    private TujuanTerbangTableModel tableModel;

    public TujuanTerbangFrame(List<TujuanTerbang> tujuanTerbangList) {
        this.tujuanTerbangList = tujuanTerbangList;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelInput = new JLabel("Input Tujuan Terbang");
        labelInput.setBounds(10, 10, 200, 20);

        textFieldTujuanTerbang = new JTextField();  
        textFieldTujuanTerbang.setBounds(10, 30, 200, 20);

        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(10, 60, 200, 20);


        javax.swing.JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 90, 200, 200);

        tableModel = new TujuanTerbangTableModel(tujuanTerbangList);
        table.setModel(tableModel);

        TujuanTerbangButtonSimpanActionListener actionListener = new TujuanTerbangButtonSimpanActionListener(this);

        buttonSimpan.addActionListener(actionListener);

        this.add(labelInput);
        this.add(textFieldTujuanTerbang);
        this.add(buttonSimpan);
        this.add(scrollPane);

        
        this.setSize(300, 400);
        this.setLayout(null);
    }

    public String getTujuan() {
        return textFieldTujuanTerbang.getText();
    }

    public void addTujuanTerbang(TujuanTerbang tujuanTerbang) {
        tableModel.add(tujuanTerbang);
    }
}
