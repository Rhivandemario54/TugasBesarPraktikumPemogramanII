package Penumpang.view;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import Penumpang.model.*;

//  ini masih Salah Jangan diikutin, Tampilannya masih Acak.
public class JenisPenumpangFrame extends JFrame {
    private List<JenisPenumpang> jenisPenumpangList;
    private JTextField textFieldTiketDewasa;
    private JTextField textFieldTiketAnak;
    private JenisPenumpangTableModel tableModel;

    public JenisPenumpangFrame(List<JenisPenumpang>jenisPenumpangList) {
        this.jenisPenumpangList = jenisPenumpangList;

        // this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Masukan Jumlah Tiket Dewasa:");
        labelInput.setBounds(15,40,350,30);

        textFieldTiketDewasa = new JTextField();
        textFieldTiketDewasa.setBounds(15,60,350,30);

        // JComboBox<String> comboBox = new JComboBox<>();
        // comboBox.addItem("Satu");
        // comboBox.addItem("Dua");
        // comboBox.addItem("Tiga");

        JLabel labelInput2 = new JLabel("Masukan Jumlah Tiket Anak:");
        labelInput2.setBounds(15,90,350,30);

        textFieldTiketAnak = new JTextField();
        textFieldTiketAnak.setBounds(15,120,350,30);

        // JComboBox<String> comboBox2 = new JComboBox<>();
        // comboBox2.addItem("Satu");
        // comboBox2.addItem("Dua");
        // comboBox2.addItem("Tiga");
        
        JButton button = new JButton("Simpan");
        button.setBounds(15,160,100,30);

        javax.swing.JTable table = new JTable();
        JScrollPane ScrollableTable = new JScrollPane(table);
        ScrollableTable.setBounds(15,200,350,200);

        tableModel = new JenisPenumpangTableModel(jenisPenumpangList);
        table.setModel(tableModel);

        this.add(labelInput);
        this.add(textFieldTiketDewasa);
        this.add(labelInput2);
        this.add(textFieldTiketAnak);
        this.add(button);
        this.add(ScrollableTable);

        this.setSize(400,1000);
        this.setLayout(null);
        
    }

    public String getTiketDewasa() {
        return textFieldTiketDewasa.getText();
    }

    public String getTiketAnak() {
        return textFieldTiketAnak.getText();
    }

    public void addJenisPenumpang(JenisPenumpang jenisPenumpang) {
        tableModel.add(jenisPenumpang);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                List<JenisPenumpang> jenisPenumpangList = new ArrayList<>();
                JenisPenumpangFrame frame = new JenisPenumpangFrame(jenisPenumpangList);
                frame.setVisible(true);
            }
        });
    }
} 