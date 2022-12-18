package src.view.Penumpang;

import java.awt.event.*;
import java.util.UUID;

import src.model.*;
import src.dao.PenumpangDao;

public class PenumpangButtonSimpanActionListener implements ActionListener {
    private PenumpangFrame penumpangFrame;
    private PenumpangDao penumpangDao;

    public PenumpangButtonSimpanActionListener(PenumpangFrame penumpangFrame, PenumpangDao penumpangDao) {
        this.penumpangFrame = penumpangFrame;
        this.penumpangDao = penumpangDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = this.penumpangFrame.getNama();
        if (nama.isEmpty()) {
            this.penumpangFrame.showAlert("Nama tidak boleh kosong");
            return;
        }
        String noTelpon = this.penumpangFrame.getNoTelpon();
        if (noTelpon.isEmpty()) {
            this.penumpangFrame.showAlert("No Telpon tidak boleh kosong");
            return;
        }
        String umur = this.penumpangFrame.getUmur();
        if (umur.isEmpty()) {
            this.penumpangFrame.showAlert("Umur tidak boleh kosong");
            return;
        }

        AsalTerbang asalTerbang = this.penumpangFrame.GetAsalTerbang();
        TujuanTerbang tujuanTerbang = this.penumpangFrame.GetTujuanTerbang();

        Penumpang penumpang = new Penumpang();

        penumpang.setId(UUID.randomUUID().toString());

        penumpang.setNama(nama);
        penumpang.setNoTelpon(noTelpon);
        penumpang.setUmur(umur);
        penumpang.setAsalTerbang(asalTerbang);
        penumpang.setTujuanTerbang(tujuanTerbang);

        this.penumpangFrame.addPenumpang(penumpang);
        this.penumpangDao.insert(penumpang);
        
        
    }

}

