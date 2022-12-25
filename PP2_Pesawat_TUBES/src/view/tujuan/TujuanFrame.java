package view.tujuan;

import model.Tujuan;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TujuanFrame extends JFrame {
    private List<Tujuan> tujuanList;
    private final JTextField textFieldTujuan;
    private TujuanTableModel tableModel;
    private final JTable table;
    private final JButton buttonSimpan;
    private final JButton buttonDelete;
    private ImageIcon carIcon;
    private JLabel myLabel;

    public TujuanFrame() {

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Tampilan >>>>
        carIcon = new ImageIcon(this.getClass().getResource("../bgwow.jpg"));
        myLabel = new JLabel(carIcon);
        myLabel.setSize(1360,800);
        // Tampilan <<<<
        // CSS Java untuk title apk dan icon 
        this.setTitle("<< Aplikasi Sorum Nota >>");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../sorum.png")));

        JLabel labelTitlee1 = new JLabel(" Halaman Inputan Tujuan Pesawat ");
        labelTitlee1.setBounds(50,15,350,10);
        labelTitlee1.setForeground(Color.white);

        JLabel labelInput = new JLabel("Tujuan Pesawat :");
        labelInput.setBounds(15, 280, 350, 10);
        labelInput.setForeground(Color.WHITE);
        textFieldTujuan = new JTextField();
        textFieldTujuan.setBounds(15, 300, 350, 30);
        buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 340, 100, 40);
        buttonDelete = new JButton("Hapus");
        buttonDelete.setBounds(130, 340, 100, 40);
        table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 40, 350, 200);

        this.add(buttonSimpan);
        this.add(buttonDelete);
        this.add(textFieldTujuan);
        this.add(labelInput);
        this.add(scrollableTable);
        this.add(labelTitlee1);
        
        this.add(myLabel);
        this.setSize(400, 700);
        this.setLayout(null);
    }

    public String getJenis() {
        return textFieldTujuan.getText();
    }

    public void addTujuanpen(Tujuan tujuanpen) {
        tableModel.add(tujuanpen);
        textFieldTujuan.setText("");
    }

    public String takeTujuan() {
        int[] selection = table.getSelectedRows();
        for (int i = 0; i < selection.length; i++) {
            selection[i] = table.convertRowIndexToModel(selection[i]);
        }

        if (selection.length > 0) {
            String tujuanpen = (String) tableModel.getValueAt(selection[0], 1);
            return tujuanpen;
        } else {
            return "";
        }
    }

    public void deleteTujuan() {
        int[] selection = table.getSelectedRows();
        for (int i = 0; i < selection.length; i++) {
            selection[i] = table.convertRowIndexToModel(selection[i]);
        }
        tableModel.remove(selection[0]);
    }

    public void addButtonSimpanActionListener(ActionListener actionListener) {
        buttonSimpan.addActionListener(actionListener);
    }

    public void addButtonDeleteActionListener(ActionListener actionListener) {
        buttonDelete.addActionListener(actionListener);
    }

    public void populateTujuanTable(List<Tujuan> tujuanList) {
        this.tujuanList = tujuanList;
        tableModel = new TujuanTableModel(tujuanList);
        table.setModel(tableModel);
    }
}