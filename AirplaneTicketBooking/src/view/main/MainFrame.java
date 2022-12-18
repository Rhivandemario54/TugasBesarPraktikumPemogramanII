package src.view.main;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

import src.model.*;
import src.view.AsalTerbang.AsalTerbangFrame;
import src.view.TujuanTerbang.TujuanTerbangFrame;
import src.view.Penumpang.PenumpangFrame;
import src.dao.*;

public class MainFrame extends JFrame {
    private AsalTerbangFrame asalTerbangFrame;
    private TujuanTerbangFrame tujuanTerbangFrame;
    private PenumpangFrame penumpangFrame;

    private AsalTerbangDao asalTerbangDao;
    private TujuanTerbangDao tujuanTerbangDao;
    private PenumpangDao penumpangDao;

    private JButton buttonAsalTerbang;
    private JButton buttonTujuanTerbang;
    private JButton buttonPenumpang;

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(500, 500);

        this.asalTerbangDao = new AsalTerbangDao();
        this.tujuanTerbangDao = new TujuanTerbangDao();
        this.penumpangDao = new PenumpangDao();

        this.asalTerbangFrame = new AsalTerbangFrame(asalTerbangDao);
        this.tujuanTerbangFrame = new TujuanTerbangFrame(tujuanTerbangDao);
        this.penumpangFrame = new PenumpangFrame(penumpangDao, asalTerbangDao, tujuanTerbangDao);


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
            asalTerbangFrame = new AsalTerbangFrame(asalTerbangDao);
        }
        asalTerbangFrame.setVisible(true);
    }

    public void showTujuanTerbangFrame() {
        if (tujuanTerbangFrame == null) {
            tujuanTerbangFrame = new TujuanTerbangFrame(tujuanTerbangDao);
        }
        tujuanTerbangFrame.setVisible(true);
    }

    public void showPenumpangFrame() {
        if (penumpangFrame == null) {
            penumpangFrame = new PenumpangFrame(penumpangDao, asalTerbangDao, tujuanTerbangDao);
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
