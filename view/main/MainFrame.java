package view.main;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import model.*;
import view.jenismember.JenisMemberFrame;
import view.member.MemberFrame;

public class MainFrame extends JFrame {
    private JenisMemberFrame jenisMemberFrame;
    private MemberFrame memberFrame;
    private List<JenisPesawat> jenisMemberList;
    private List<Pesawat> memberList;
    private JButton buttonJenisMember;
    private JButton buttonMember;
    private List<JenisPesawat> jenisMeberList;

    public MainFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(400,500);
        jenisMemberList = new ArrayList<JenisPesawat>();
        memberList = new ArrayList<Pesawat>();

        this.jenisMemberFrame = new JenisMemberFrame(jenisMemberList);
        this.memberFrame = new MemberFrame(jenisMemberList, memberList);

        this.setLayout(new FlowLayout());
        MainButtonActionListener actionListener = new MainButtonActionListener(this);

        this.buttonJenisMember = new JButton("Jenis Pesawat");
        this.buttonMember = new JButton("Pesawat");

        this.buttonJenisMember.addActionListener(actionListener);
        this.buttonMember.addActionListener(actionListener);

        this.add(buttonJenisMember);
        this.add(buttonMember);
    }

    public JButton getButtonJenisMember()
    {
        return buttonJenisMember;
    }

    public JButton getButtonMember()
    {
        return buttonMember;
    }

    public void showJenisMemberFrame()
    {
        if(jenisMemberFrame == null)
        {
            jenisMemberFrame = new JenisMemberFrame(jenisMemberList);
        }
        jenisMemberFrame.setVisible(true);
    }

    public void showMemberFrame()
    {
        if (memberFrame == null)
        {
            memberFrame = new MemberFrame(jenisMeberList, memberList);
        }
        memberFrame.populatedComboJenis();
        memberFrame.setVisible(true);
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run (){
                MainFrame f = new MainFrame();
                f.setVisible(true);
            }
        });
    }
    
}
