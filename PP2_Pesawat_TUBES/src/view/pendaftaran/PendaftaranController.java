package view.pendaftaran;

import model.Jumlah;
import model.Tujuan;
import model.Pendaftaran;
import module.DaoModule;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;

public class PendaftaranController {

    private final DaoModule daoModule;
    private final PendaftaranFrame pendaftaranFrame;
    private final PendaftaranPdfExport pendaftaranPdfExport;

    public PendaftaranController(DaoModule daoModule) {
        this.daoModule = daoModule;
        this.pendaftaranFrame = new PendaftaranFrame();
        this.pendaftaranPdfExport = new PendaftaranPdfExport();

        this.pendaftaranFrame.addButtonSimpanActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(pendaftaranFrame,
                        "Simpan Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    PendaftaranController.this.simpan();
                } else {
                    JOptionPane.showMessageDialog(pendaftaranFrame, "Anda tidak mengsimpan data");
                }
            }
        });

        this.pendaftaranFrame.addButtonExportPdfActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(pendaftaranFrame,
                        "Export PDF?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    PendaftaranController.this.exportPdf();
                } else {
                    JOptionPane.showMessageDialog(pendaftaranFrame, "Anda tidak mengexport PDF");
                }
            }
        });

        this.pendaftaranFrame.addButtonDeleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(pendaftaranFrame,
                        "Hapus Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    PendaftaranController.this.delete();
                } else {
                    JOptionPane.showMessageDialog(pendaftaranFrame, "Anda tidak menghapus data");
                }
            }
        });
    }

    public void showPendaftaranFrame() {
        List<Pendaftaran> pendaftaranList = daoModule.getPendaftaranDao().findAll();
        pendaftaranFrame.populatePendaftaranTable(pendaftaranList);
        List<Jumlah> jumlahList = daoModule.getJumlahDao().findAll();
        pendaftaranFrame.populateComboJumlah(jumlahList);
        List<Tujuan> tujuanList = daoModule.getTujuanDao().findAll();
        pendaftaranFrame.populateComboTujuan(tujuanList);
        
        pendaftaranFrame.setVisible(true);
    }

    public void simpan() {
        String namauser = this.pendaftaranFrame.getNamauser();
        String tgl_penerbangan = this.pendaftaranFrame.getTgl_penerbangan();
        String kelaspen = this.pendaftaranFrame.getKelaspen();
        Jumlah jumlahpen = this.pendaftaranFrame.getJumlahpen();
        Tujuan tujuanpen = this.pendaftaranFrame.getTujuanpen();
        if (namauser.isEmpty() || tgl_penerbangan.isEmpty() || kelaspen.isEmpty()) {
            this.pendaftaranFrame.showAlert("Form tidak boleh ada yang kosong");
        } else {
            Pendaftaran pendaftaran = new Pendaftaran();
            pendaftaran.setId(UUID.randomUUID().toString());
            pendaftaran.setNamauser(namauser);
            pendaftaran.setTgl_penerbangan(tgl_penerbangan);
            pendaftaran.setKelaspen(kelaspen);
            pendaftaran.setJumlah(jumlahpen);
            pendaftaran.setTujuan(tujuanpen);
            this.pendaftaranFrame.addPendaftaran(pendaftaran);
            daoModule.getPendaftaranDao().insert(pendaftaran);
        }
    }

    public void delete() {
        Pendaftaran namaP = new Pendaftaran();
        namaP.setId(this.pendaftaranFrame.takePendaftaran());

        if (namaP.getId() != "") {
            this.pendaftaranFrame.deletePendaftaran();
            daoModule.getPendaftaranDao().delete(namaP);
        } else {
            JOptionPane.showMessageDialog(this.pendaftaranFrame, "Tolong pilih baris tabel yang mau dihapus");
        }
    }

    public void exportPdf() {
        try {
            pendaftaranPdfExport.export(pendaftaranFrame.getPendaftaranList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
