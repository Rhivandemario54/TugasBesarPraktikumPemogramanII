package view.jenispesawat;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import model.JenisPesawat;

    public class JenisPesawatFrame extends JFrame 
    {
      private List<JenisPesawat> jenisPesawatList;
      private JTextField textFiedlNama;
      private JenisPesawatTableModel tableModel;

      public JenisPesawatFrame(List<JenisPesawat> jenisMemberList){
        this.jenisPesawatList = jenisMemberList;

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

        tableModel = new JenisPesawatTableModel(jenisMemberList);
        table.setModel(tableModel);

        JenisPesawatButtonSimpanActionListener actionListener = new JenisPesawatButtonSimpanActionListener(this);

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

      public void addJenisPesawat(JenisPesawat jenisPesawat)
      {
        tableModel.add(jenisPesawat);
        textFiedlNama.setText("");
      }
    }
