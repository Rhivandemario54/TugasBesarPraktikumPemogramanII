package view.tujuan;

import model.Tujuan;
import module.DaoModule;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;

public class TujuanController {
    private final DaoModule daoModule;
    private final TujuanFrame tujuanFrame;

    public TujuanController(DaoModule daoModule) {
        this.daoModule = daoModule;
        tujuanFrame = new TujuanFrame();

        tujuanFrame.addButtonSimpanActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(tujuanFrame,
                        "Simpan Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    simpan();
                } else {
                    JOptionPane.showMessageDialog(tujuanFrame, "Anda tidak menyimpan data");
                }
            }
        });

        tujuanFrame.addButtonDeleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(tujuanFrame,
                        "Hapus Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    delete();
                } else {
                    JOptionPane.showMessageDialog(tujuanFrame, "Anda tidak menghapus data");
                }
            }
        });
    }

    public void showTujuanFrame() {
        List<Tujuan> tujuanList = daoModule.getTujuanDao().findAll();
        tujuanFrame.populateTujuanTable(tujuanList);
        tujuanFrame.setVisible(true);
    }

    public void simpan() {
        String tujuan = this.tujuanFrame.getJenis();
        if (tujuan.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this.tujuanFrame, "Form tidak boleh ada yang kosong");
        } else {
            Tujuan tujuann = new Tujuan();
            tujuann.setId(UUID.randomUUID().toString());
            tujuann.setTujuanpen(tujuan);
            this.tujuanFrame.addTujuanpen(tujuann);
            daoModule.getTujuanDao().insert(tujuann);
        }
    }

    public void delete() {
        Tujuan tujuan = new Tujuan();
        tujuan.setId(this.tujuanFrame.getJenis());

        if (tujuan.getId() != "") {
            this.tujuanFrame.deleteTujuan();
            daoModule.getTujuanDao().delete(tujuan);
        } else {
            JOptionPane.showMessageDialog(this.tujuanFrame, "Tolong pilih baris tabel yang mau dihapus");
        }
    }
}
