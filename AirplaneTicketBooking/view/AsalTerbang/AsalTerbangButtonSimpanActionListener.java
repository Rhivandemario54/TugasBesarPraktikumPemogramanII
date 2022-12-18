package view.AsalTerbang;

import java.awt.event.*;
import model.AsalTerbang;

public class AsalTerbangButtonSimpanActionListener implements ActionListener {
    private AsalTerbangFrame asalTerbangFrame;

    public AsalTerbangButtonSimpanActionListener(AsalTerbangFrame asalTerbangFrame) {
        this.asalTerbangFrame = asalTerbangFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String asal = this.asalTerbangFrame.getAsal();
       AsalTerbang asalTerbang = new AsalTerbang();
       asalTerbang.setAsal(asal);

       this.asalTerbangFrame.addAsalTerbang(asalTerbang);
        
    }
}
