package view.main;

import module.DaoModule;
import view.pendaftaran.PendaftaranController;
import view.tujuan.TujuanController;
import view.jumlah.JumlahController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private final MainFrame mainFrame;
    private final PendaftaranController pendaftaranController;
    private final JumlahController jumlahController;
    private final TujuanController tujuanController;

    public MainController() {
        mainFrame = new MainFrame();
        DaoModule daoModule = new DaoModule();
        pendaftaranController = new PendaftaranController(daoModule);
        jumlahController = new JumlahController(daoModule);
        tujuanController = new TujuanController(daoModule);
        
        mainFrame.addButtonMermoActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showJumlahFrame();
            }
        });
        mainFrame.addButtonSorumActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPendaftaranFrame();
            }
        });
        mainFrame.addButtonNamotActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTujuanFrame();
            }
        });
    }

    public void showMainFrame() {
        this.mainFrame.setVisible(true);
    }

    public void showJumlahFrame() {
        jumlahController.showJumlahFrame();
    }

    public void showPendaftaranFrame() {
        pendaftaranController.showPendaftaranFrame();
    }

    public void showTujuanFrame() {
        tujuanController.showTujuanFrame();
    }
}
