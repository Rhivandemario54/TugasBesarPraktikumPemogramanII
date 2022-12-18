package view.TujuanTerbang;

import java.awt.event.*;
import model.TujuanTerbang;

public class TujuanTerbangButtonSimpanActionListener implements ActionListener {
    private TujuanTerbangFrame tujuanTerbangFrame;

    public TujuanTerbangButtonSimpanActionListener(TujuanTerbangFrame tujuanTerbangFrame) {
        this.tujuanTerbangFrame = tujuanTerbangFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tujuan = this.tujuanTerbangFrame.getTujuan();
        TujuanTerbang tujuanTerbang = new TujuanTerbang();
        tujuanTerbang.setTujuan(tujuan);
 
        this.tujuanTerbangFrame.addTujuanTerbang(tujuanTerbang);
         
     }
}