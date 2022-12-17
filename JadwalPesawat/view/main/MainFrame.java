package view.main;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import model.*;
import view.jenispesawat.JenisPesawatFrame;
import view.pesawat.PesawatFrame;
import view.tujuanpesawat.TujuanPesawatFrame;

public class MainFrame extends JFrame {
    private JenisPesawatFrame jenisPesawatFrame;
    private PesawatFrame pesawatFrame;
    private TujuanPesawatFrame TujuanPesawatFrame;
    private List<JenisPesawat> jenisPesawatList;
    private List<Pesawat> pesawatList;
    private List<TujuanPesawatFrame> tujuanPesawatList;
    private JButton buttonJenisPesawat;
    private JButton buttonPesawat;
    private JButton buttonTujuanPesawat;

    public MainFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(400,500);
        jenisPesawatList = new ArrayList<JenisPesawat>();
        pesawatList = new ArrayList<Pesawat>();

        this.jenisPesawatFrame = new JenisPesawatFrame(jenisPesawatList);
        this.pesawatFrame = new PesawatFrame(jenisPesawatList, pesawatList);

        this.setLayout(new FlowLayout());
        MainButtonActionListener actionListener = new MainButtonActionListener(this);

        this.buttonJenisPesawat = new JButton("Jenis Pesawat");
        this.buttonPesawat = new JButton("Pesawat");
        this.buttonTujuanPesawat = new JButton("Tujuan Pesawat");

        this.buttonJenisPesawat.addActionListener(actionListener);
        this.buttonPesawat.addActionListener(actionListener);

        this.add(buttonJenisPesawat);
        this.add(buttonPesawat);
    }

    public JButton getButtonJenisPesawat()
    {
        return buttonJenisPesawat;
    }

    public JButton getButtonpesawat()
    {
        return buttonPesawat;
    }
    public JButton getTujuanPesawat()
    {
        return buttonTujuanPesawat;
    }

    public void showJenisMemberFrame()
    {
        if(jenisPesawatFrame == null)
        {
            jenisPesawatFrame = new JenisPesawatFrame(jenisPesawatList);
        }
        jenisPesawatFrame.setVisible(true);
    }

    public void showMemberFrame()
    {
        if (pesawatFrame == null)
        {
            pesawatFrame = new PesawatFrame(jenisPesawatList, pesawatList);
        }
        pesawatFrame.populatedComboJenis();
        pesawatFrame.setVisible(true);
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run (){
                MainFrame f = new MainFrame();
                f.setVisible(true);
            }
        });
    }

    public void showJenisPesawatrFrame() {
    }

    public void showPesawatrFrame() {
    }

	public void showTujuanPesawat() {
	}
    
}
