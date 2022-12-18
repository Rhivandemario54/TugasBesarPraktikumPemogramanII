package src.view.AsalTerbang;

import java.awt.event.*;
import java.util.UUID;

import src.model.AsalTerbang;
import src.dao.AsalTerbangDao;

public class AsalTerbangButtonSimpanActionListener implements ActionListener {
    private AsalTerbangFrame asalTerbangFrame;
    private AsalTerbangDao asalTerbangDao;

    public AsalTerbangButtonSimpanActionListener(AsalTerbangFrame asalTerbangFrame , AsalTerbangDao asalTerbangDao) {
        this.asalTerbangFrame = asalTerbangFrame;
        this.asalTerbangDao = asalTerbangDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String asal = this.asalTerbangFrame.getAsal();
       AsalTerbang asalTerbang = new AsalTerbang();
       asalTerbang.setId(UUID.randomUUID().toString());
       asalTerbang.setAsal(asal);

       this.asalTerbangFrame.addAsalTerbang(asalTerbang);
       this.asalTerbangDao.insert(asalTerbang);
        
    }
}
