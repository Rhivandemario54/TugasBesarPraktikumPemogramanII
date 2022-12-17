package view.pesawat;

import java.awt.event.*;
import model.*;

    public class PesawatButtonSimpanActionListener implements ActionListener{
    private PesawatFrame pesawatFrame;

    public PesawatButtonSimpanActionListener(PesawatFrame pesawatFrame)
    {
        this.pesawatFrame = pesawatFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String nama = this.pesawatFrame.getNama();
        JenisPesawat jenisPesawat = this.pesawatFrame.getJenisPesawat();
        Pesawat pesawat = new Pesawat();
        pesawat.setNama(nama);
        pesawat.setJenisPesawat(jenisPesawat);

        this.pesawatFrame.addMember(pesawat);
    }
 }

