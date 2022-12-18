package view.main;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

import model.*;
import view.AsalTerbang.AsalTerbangFrame;
import view.TujuanTerbang.TujuanTerbangFrame;
import view.Penumpang.PenumpangFrame;

public class MainFrame extends JFrame {
    private AsalTerbangFrame asalTerbangFrame;
    private TujuanTerbangFrame tujuanTerbangFrame;
    private PenumpangFrame penumpangFrame;

    private List<AsalTerbang> asalTerbangList;
    private List<TujuanTerbang> tujuanTerbangList;
    private List<Penumpang> penumpangList;

    private JButton buttonAsalTerbang;
    private JButton buttonTujuanTerbang;
    private JButton buttonPenumpang;

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(500, 500);
        asalTerbangList = new ArrayList<AsalTerbang>();
        tujuanTerbangList = new ArrayList<TujuanTerbang>();
        penumpangList = new ArrayList<Penumpang>();

        this.setLayout(new FlowLayout());
        MainButtonActionListener actionListener = new MainButtonActionListener(this);

        this.buttonAsalTerbang = new JButton("Asal Terbang");
        this.buttonAsalTerbang.addActionListener(actionListener);

        this.buttonTujuanTerbang = new JButton("Tujuan Terbang");
        this.buttonTujuanTerbang.addActionListener(actionListener);

        this.buttonPenumpang = new JButton("Penumpang");
        this.buttonPenumpang.addActionListener(actionListener);

        this.add(buttonAsalTerbang);
        this.add(buttonTujuanTerbang);
        this.add(buttonPenumpang);
        
    }


    public JButton  getButtonAsalTerbang() {
        return buttonAsalTerbang;
    }

    public JButton getButtonTujuanTerbang() {
        return buttonTujuanTerbang;
    }

    public JButton getButtonPenumpang() {
        return buttonPenumpang;
    }

    public void showAsalTerbangFrame() {
        if (asalTerbangFrame == null) {
            asalTerbangFrame = new AsalTerbangFrame(asalTerbangList);
        }
        asalTerbangFrame.setVisible(true);
    }

    public void showTujuanTerbangFrame() {
        if (tujuanTerbangFrame == null) {
            tujuanTerbangFrame = new TujuanTerbangFrame(tujuanTerbangList);
        }
        tujuanTerbangFrame.setVisible(true);
    }

    public void showPenumpangFrame() {
        if (penumpangFrame == null) {
            penumpangFrame = new PenumpangFrame(asalTerbangList, tujuanTerbangList, penumpangList);
        }
        penumpangFrame.populateComboAsal();
        penumpangFrame.populateComboTujuan();
        penumpangFrame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame f = new MainFrame();
                f.setVisible(true);
            }
        });
    }

}
