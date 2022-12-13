package view.member;

import java.awt.event.*;
import model.*;

    public class MemberButtonSimpanActionListener implements ActionListener{
    private MemberFrame memberFrame;

    public MemberButtonSimpanActionListener(MemberFrame memberFrame)
    {
        this.memberFrame = memberFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String nama = this.memberFrame.getNama();
        JenisPesawat jenisMember = this.memberFrame.getJenisMember();
        Pesawat member = new Pesawat();
        member.setNama(nama);
        member.setJenisPesawat(jenisMember);

        this.memberFrame.addMember(member);
    }
 }

