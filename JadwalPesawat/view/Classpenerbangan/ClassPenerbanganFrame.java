package view.classpenerbangan;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import model.ClassPenerbangan;

    public class ClassPenerbanganFrame extends JFrame 
    {
      private List<ClassPenerbangan> classPenerbanganList;
      private JTextField textFiedlNama;
      private ClassPenerbanganTableModel tableModel;

      public ClassPenerbanganFrame(List<ClassPenerbangan> classPenerbanganList){
        this.classPenerbanganList = classPenerbanganList;

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

        tableModel = new ClassPenerbanganTableModel(classPenerbanganList);
        table.setModel(tableModel);

        ClassPenerbanganButtonSimpanActionListener actionListener = new ClassPenerbanganButtonSimpanActionListener(this);

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

      public void addClassPenerbangan(ClassPenerbangan classPenerbangan)
      {
        tableModel.add(classPenerbangan);
        textFiedlNama.setText("");
      }
    }

