package view.jenismember;

import java.awt.event.*;
import model.JenisPesawat;

    public class JenisMemberButtonSimpanActionListener implements ActionListener{
    private JenisMemberFrame jenisMemberFrame;

    public JenisMemberButtonSimpanActionListener(JenisMemberFrame jenisMemberFrame)
    {
        this.jenisMemberFrame = jenisMemberFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String nama = this.jenisMemberFrame.getNama();
        JenisPesawat jenisMember = new JenisPesawat();
        jenisMember.setNama(nama);

        this.jenisMemberFrame.addJenisMember(jenisMember);
      }
    }

