package view.tujuanpesawat;

import java.awt.event.*;
import model.TujuanPesawat;

    public class TujuanPesawatButtonSimpanActionListener implements ActionListener{
    private TujuanPesawatFrame tujuanPesawatFrame;

    public TujuanPesawatButtonSimpanActionListener(TujuanPesawatFrame tuuanPesawatFrame)
    {
        this.tujuanPesawatFrame = tujuanPesawatFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String nama = this.tujuanPesawatFrame.getNama();
        TujuanPesawat tujuanPesawat= new TujuanPesawat();
        tujuanPesawat.setNama(nama);

        this.tujuanPesawatFrame.addTujuanPesawat(tujuanPesawat);
      }
    }