package view.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.AttributeSet.ColorAttribute;
import java.awt.Font;

public class MainFrame extends JFrame {
    private final JButton buttonMermo;
    private final JButton buttonSorum;
    private final JButton buttonNamot;
    private JFrame frame;
    private ImageIcon carIcon;
    private JLabel myLabel;
    private Color color;

    public MainFrame() {
        
        // Tampilan >>>>
        carIcon = new ImageIcon(this.getClass().getResource("../bgwow.jpg"));
        myLabel = new JLabel(carIcon);
        myLabel.setSize(1360,800);
        // Tampilan <<<<

         // CSS Java untuk title apk dan icon 
        this.setTitle("Pendaftaran Booking pesawat");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../sorum.png")));
        
        JLabel labelInput = new JLabel("<<--Selamat Datang di pendaftaran booking pesawat-->>");
        labelInput.setForeground(Color.WHITE);
        labelInput.setBounds(30, 40, 450, 10);

        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int exit = JOptionPane.showConfirmDialog(null,
                        "Apakah anda yakin ingin keluar?", "Keluar",
                        JOptionPane.YES_NO_OPTION);

                if (exit == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        this.setSize(400, 700);
        this.setLayout(new FlowLayout());

        buttonMermo = new JButton("Jumlah penumpang");
        buttonMermo.setBounds(30, 200, 150, 40);
        buttonMermo.setBackground(color.LIGHT_GRAY);
        buttonMermo.setForeground(Color.BLACK);
        
        buttonSorum = new JButton("Pendaftaran");
        buttonSorum.setBounds(135, 100, 110, 40);
        buttonSorum.setBackground(color.LIGHT_GRAY);
        buttonSorum.setForeground(Color.BLACK);

        buttonNamot = new JButton("Tujuan");
        buttonNamot.setBounds(240, 200, 110, 40);
        buttonNamot.setBackground(color.LIGHT_GRAY);
        buttonNamot.setForeground(Color.BLACK);

        this.add(buttonMermo);
        this.add(buttonSorum);
        this.add(buttonNamot);
        this.add(labelInput);
        this.add(myLabel);
        this.setLayout(null);
    }

    public JButton getButtonMermo() {
        return buttonMermo;
    }

    public JButton getButtonSorum() {
        return buttonSorum;
    }

    public JButton getButtonNamot() {
        return buttonNamot;
    }

    public void addButtonMermoActionListener(ActionListener actionListener) {
        buttonMermo.addActionListener(actionListener);
    }

    public void addButtonSorumActionListener(ActionListener actionListener) {
        buttonSorum.addActionListener(actionListener);
    }

    public void addButtonNamotActionListener(ActionListener actionListener) {
        buttonNamot.addActionListener(actionListener);
    }
}
