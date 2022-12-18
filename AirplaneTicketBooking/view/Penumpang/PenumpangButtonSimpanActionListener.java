package view.Penumpang;

import java.awt.event.*;
import model.*;

public class PenumpangButtonSimpanActionListener implements ActionListener {
    private PenumpangFrame penumpangFrame;

    public PenumpangButtonSimpanActionListener(PenumpangFrame penumpangFrame) {
        this.penumpangFrame = penumpangFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = this.penumpangFrame.getNama();
        String noTelpon = this.penumpangFrame.getNoTelpon();
        String umur = this.penumpangFrame.getUmur();

        AsalTerbang asalTerbang = this.penumpangFrame.GetAsalTerbang();
        TujuanTerbang tujuanTerbang = this.penumpangFrame.GetTujuanTerbang();

        Penumpang penumpang = new Penumpang();

        penumpang.setNama(nama);
        penumpang.setNoTelpon(noTelpon);
        penumpang.setUmur(umur);
        penumpang.setAsalTerbang(asalTerbang);
        penumpang.setTujuanTerbang(tujuanTerbang);

        this.penumpangFrame.addPenumpang(penumpang);
        
        
    }

}

