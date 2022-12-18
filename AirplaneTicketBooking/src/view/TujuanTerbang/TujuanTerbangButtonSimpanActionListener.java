package src.view.TujuanTerbang;

import java.awt.event.*;
import java.util.UUID;

import src.model.TujuanTerbang;
import src.dao.TujuanTerbangDao;

public class TujuanTerbangButtonSimpanActionListener implements ActionListener {
    private TujuanTerbangFrame tujuanTerbangFrame;
    private TujuanTerbangDao tujuanTerbangDao;

    public TujuanTerbangButtonSimpanActionListener(TujuanTerbangFrame tujuanTerbangFrame, TujuanTerbangDao tujuanTerbangDao) {
        this.tujuanTerbangFrame = tujuanTerbangFrame;
        this.tujuanTerbangDao = tujuanTerbangDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tujuan = this.tujuanTerbangFrame.getTujuan();
        TujuanTerbang tujuanTerbang = new TujuanTerbang();
        tujuanTerbang.setId(UUID.randomUUID().toString());

        tujuanTerbang.setTujuan(tujuan);
 
        this.tujuanTerbangFrame.addTujuanTerbang(tujuanTerbang);
        this.tujuanTerbangDao.insert(tujuanTerbang);
         
     }
}