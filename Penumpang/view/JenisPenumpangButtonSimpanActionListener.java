package Penumpang.view;

//  ini masih PlaceHolder Jangan diikutin, masih belum bisa.

import java.awt.event.*;
import Penumpang.model.*;

public class JenisPenumpangButtonSimpanActionListener implements ActionListener {
  private JenisPenumpangFrame jenisPenumpangFrame;

  public JenisPenumpangButtonSimpanActionListener(JenisPenumpangFrame jenisPenumpangFrame) {
    this.jenisPenumpangFrame = jenisPenumpangFrame;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String tiketDewasa = this.jenisPenumpangFrame.getTiketDewasa();
    String tiketAnak = this.jenisPenumpangFrame.getTiketAnak();

    // jenisPenumpang.setTiketDewasa(tiketDewasa);
    // jenisPenumpang.setTiketAnak(tiketAnak);

    JenisPenumpang jenisPenumpang = new JenisPenumpang();
    this.jenisPenumpangFrame.addJenisPenumpang(jenisPenumpang);
  }
}

//  ini masih PlaceHolder Jangan diikutin, masih belum bisa


