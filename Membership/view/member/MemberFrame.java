package view.member;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import model.*;

public class MemberFrame extends JFrame {
    private List<JenisPesawat> jenisPesawatList;
    private List<Pesawat> pesawatList;
    private JTextField textFieldNama;
    private MemberTableModel tableModel;
    private JComboBox comboJenis;

    public MemberFrame(List<JenisPesawat> jenisPesawatList, List<Pesawat> memberList){
        this.jenisPesawatList = jenisPesawatList;
        this.pesawatList = pesawatList;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama");
        labelInput.setBounds(15,40,350,10);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15,60,350,30);

        JLabel labelJenis = new JLabel("Jenis Pesawat");
        labelJenis.setBounds(15,100,350,10);


        comboJenis = new JComboBox();
        comboJenis.setBounds(15,120,150,30);

        JButton button = new JButton("simpan");
        button.setBounds(15,160,100,40);

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,220,350,200);

        tableModel = new MemberTableModel(memberList);
        table.setModel(tableModel);

        MemberButtonSimpanActionListener actionListener = new MemberButtonSimpanActionListener(this);

        button.addActionListener(actionListener);

        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(labelJenis);
        this.add(comboJenis);
        this.add(scrollableTable);

        this.setSize(400,500);
        this.setLayout(null);
    }

    public void populatedComboJenis()
    {
       comboJenis.removeAllItems();
       for (JenisPesawat jenisMember: this.jenisPesawatList)
       {
        comboJenis.addItem(jenisMember.getNama());
       }
    }

    public String getNama()
    {
        return textFieldNama.getText();
    }

    public JenisPesawat getJenisMember()
    {
        return jenisPesawatList.get(comboJenis.getSelectedIndex());
    }

    public void addMember(Pesawat member)
    {
        tableModel.add(member);
        textFieldNama.setText("");
    }

}
