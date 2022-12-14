package ClassPenerbangan.view.Classpenerbangan;

import javax.swing.*;
import javax.swing.table.*;

public class ClassPenerbanganFrame {
    public static void main(String[] args) {
        // Buat frame utama
        JFrame frame = new JFrame("Dropdown dan Tabel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        // Buat panel utama dan tambahkan ke frame
        JPanel panel = new JPanel();
        frame.add(panel);
    
        // Buat dropdown menu dan tambahkan ke panel
        JComboBox<String> dropdown1 = new JComboBox<>();
        dropdown1.addItem("Jakarta");
        dropdown1.addItem("Bali");
        dropdown1.addItem("Jogja");
        panel.add(dropdown1);
        JComboBox<String> dropdown2 = new JComboBox<>();
        dropdown2.addItem("Bandung");
        dropdown2.addItem("Surabaya");
        dropdown2.addItem("Malang");
        panel.add(dropdown2);
        // Tampilkan frame
        frame.pack();
        frame.setVisible(true);
      }
}
