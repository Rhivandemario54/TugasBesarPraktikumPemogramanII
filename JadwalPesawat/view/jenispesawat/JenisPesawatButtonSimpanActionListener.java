package view.jenispesawat;

import java.awt.event.*;
import model.JenisPesawat;

    public class JenisPesawatButtonSimpanActionListener implements ActionListener{
    private JenisPesawatFrame jenisPesawatFrame;

    public JenisPesawatButtonSimpanActionListener(JenisPesawatFrame jenisPesawatFrame)
    {
        this.jenisPesawatFrame = jenisPesawatFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String nama = this.jenisPesawatFrame.getNama();
        JenisPesawat jenisPesawat = new JenisPesawat();
        jenisPesawat.setNama(nama);

        this.jenisPesawatFrame.addJenisPesawat(jenisPesawat);
      }
    }

