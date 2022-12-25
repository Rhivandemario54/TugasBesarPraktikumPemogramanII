package view.jumlah;

import model.Jumlah;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.List;

public class JumlahFrame extends JFrame {
    private List<Jumlah> jumlahList;
    private final JTextField textFieldMermo;
    private JumlahTableModel tableModel;
    private final JTable table;
    private final JButton buttonSimpan;
    private final JButton buttonDelete;
    private ImageIcon carIcon;
    private JLabel myLabel;

    public JumlahFrame() {

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Tampilan >>>>
        carIcon = new ImageIcon(this.getClass().getResource("../bgwow.jpg"));
        myLabel = new JLabel(carIcon);
        myLabel.setSize(1360,800);
        // Tampilan <<<<
        // CSS Java untuk title apk dan icon 
        this.setTitle("<< Aplikasi Sorum Nota >>");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../sorum.png")));

        JLabel labelTitlee1 = new JLabel(" Halaman Inputan jumlah penumpang ");
        labelTitlee1.setBounds(110,15,350,10);
        labelTitlee1.setForeground(Color.white);

        JLabel labelInput = new JLabel("jumlah penumpang :");
        labelInput.setForeground(Color.WHITE);
        labelInput.setBounds(15, 280, 350, 10);
        textFieldMermo = new JTextField();
        textFieldMermo.setBounds(15, 300, 350, 30);
        buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 340, 100, 40);
        buttonDelete = new JButton("Hapus");
        buttonDelete.setBounds(130, 340, 100, 40);
        table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 40, 350, 200);

        this.add(buttonSimpan);
        this.add(buttonDelete);
        this.add(textFieldMermo);
        this.add(labelInput);
        this.add(scrollableTable);
        this.add(labelTitlee1);        
        this.add(myLabel);

        this.setSize(400, 700);
        this.setLayout(null);
    }

    public String getJenis() {
        return textFieldMermo.getText();
    }

    public void addJumlahpen(Jumlah jumlahpen) {
        tableModel.add(jumlahpen);
        textFieldMermo.setText("");
    }

    public String takeJumlahpen() {
        int[] selection = table.getSelectedRows();
        for (int i = 0; i < selection.length; i++) {
            selection[i] = table.convertRowIndexToModel(selection[i]);
        }

        if (selection.length > 0) {
            String jumlahpen = (String) tableModel.getValueAt(selection[0], 1);
            return jumlahpen;
        } else {
            return "";
        }
    }

    public void deleteJumlahpen() {
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

    public void populateJumlahTable(List<Jumlah> jumlahList) {
        this.jumlahList = jumlahList;
        tableModel = new JumlahTableModel(jumlahList);
        table.setModel(tableModel);
    }
}