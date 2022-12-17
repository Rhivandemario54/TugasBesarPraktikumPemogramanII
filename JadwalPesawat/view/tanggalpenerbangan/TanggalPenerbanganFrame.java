package view.tanggalpenerbangan;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import model.JenisPesawat;
import model.TanggalPenerbangan;

    public class TanggalPenerbanganFrame extends JFrame 
    {
      private List<TanggalPenerbangan> tanggalPenerbanganList;
      private JTextField textFiedlNama;
      private TanggalPenerbanganTableModel tableModel;

      public TanggalPenerbanganFrame(List<TanggalPenerbangan> jenisMemberList){
        this.tanggalPenerbanganList = tanggalPenerbanganList;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama");
        labelInput.setBounds(15,40,350,10);

        textFiedlNama = new JTextField();
        textFiedlNama.setBounds(15,60,350,30);

        JButton button = new JButton();
        button.setBounds(15,100,100,30);

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,150,350,200);

        tableModel = new TanggalPenerbanganTableModel(jenisMemberList);
        table.setModel(tableModel);

        TanggalPenerbanganButtonSimpanActionListener actionListener = new TanggalPenerbanganButtonSimpanActionListener(this);

        button.addActionListener(actionListener);

        this.add(button);
        this.add(textFiedlNama);
        this.add(labelInput);
        this.add(scrollableTable);

        this.setSize(400,500);
        this.setLayout(null);
      }

      public String getNama()
      { 
        return textFiedlNama.getText();
      }

      public void addTanggalPenerbangan(TanggalPenerbangan tanggalPenerbangan)
      {
        tableModel.add(tanggalPenerbangan);
        textFiedlNama.setText("");
      }

	}

