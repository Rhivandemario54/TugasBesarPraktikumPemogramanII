package module;

import dao.JumlahDao;
import dao.PendaftaranDao;
import dao.TujuanDao;

public class DaoModule {
    private final JumlahDao jumlahDao;
    private final PendaftaranDao pendaftaranDao;
    private final TujuanDao tujuanDao;

    public DaoModule() {
        this.jumlahDao = new JumlahDao();
        this.tujuanDao = new TujuanDao();
        this.pendaftaranDao = new PendaftaranDao();
    }

    public JumlahDao getJumlahDao() {
        return jumlahDao;
    }

    public TujuanDao getTujuanDao() {
        return tujuanDao;
    }

    public PendaftaranDao getPendaftaranDao() {
        return pendaftaranDao;
    }
}
