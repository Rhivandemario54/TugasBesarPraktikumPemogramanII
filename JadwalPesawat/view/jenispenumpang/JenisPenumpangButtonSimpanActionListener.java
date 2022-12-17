package view.jenispenumpang;

import java.awt.event.*;
import model.JenisPenumpang;

    public class JenisPenumpangButtonSimpanActionListener implements ActionListener{
    private JenisPenumpangFrame jenisPenumpangFrame;

    public JenisPenumpangButtonSimpanActionListener(JenisPenumpangFrame jenisPenumpangFrame)
    {
        this.jenisPenumpangFrame = jenisPenumpangFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String nama = this.jenisPenumpangFrame.getNama();
        JenisPenumpang jenisPenumpang = new JenisPenumpang();
        jenisPenumpang.setNama(nama);

        this.jenisPenumpangFrame.addJenisPenumpang(jenisPenumpang);
      }
    }

