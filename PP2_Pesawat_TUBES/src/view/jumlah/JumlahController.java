package view.jumlah;

import model.Jumlah;
import module.DaoModule;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;

public class JumlahController {
    private final DaoModule daoModule;
    private final JumlahFrame jumlahFrame;

    public JumlahController(DaoModule daoModule) {
        this.daoModule = daoModule;
        jumlahFrame = new JumlahFrame();

        jumlahFrame.addButtonSimpanActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(jumlahFrame,
                        "Simpan Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    simpan();
                } else {
                    JOptionPane.showMessageDialog(jumlahFrame, "Anda tidak menyimpan data");
                }
            }
        });

        jumlahFrame.addButtonDeleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(jumlahFrame,
                        "Hapus Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    delete();
                } else {
                    JOptionPane.showMessageDialog(jumlahFrame, "Anda tidak menghapus data");
                }
            }
        });
    }

    public void showJumlahFrame() {
        List<Jumlah> jumlahList = daoModule.getJumlahDao().findAll();
        jumlahFrame.populateJumlahTable(jumlahList);
        jumlahFrame.setVisible(true);
    }

    public void simpan() {
        String jumlah = this.jumlahFrame.getJenis();
        if (jumlah.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this.jumlahFrame, "Form tidak boleh ada yang kosong");
        } else {
            Jumlah jumlahh = new Jumlah();
            jumlahh.setId(UUID.randomUUID().toString());
            jumlahh.setJumlahpen(jumlah);
            this.jumlahFrame.addJumlahpen(jumlahh);
            daoModule.getJumlahDao().insert(jumlahh);
        }
    }

    public void delete() {
        Jumlah jumlah = new Jumlah();
        jumlah.setId(this.jumlahFrame.takeJumlahpen());

        if (jumlah.getId() != "") {
            this.jumlahFrame.deleteJumlahpen();
            daoModule.getJumlahDao().delete(jumlah);
        } else {
            JOptionPane.showMessageDialog(this.jumlahFrame, "Tolong pilih baris tabel yang mau dihapus");
        }
    }
}
