package model;


public class Pesawat<TujuanPesawat> {
    private String nama;
    private JenisPesawat jenisPesawat;
    private TujuanPesawat tujuanPesawat;

    public void setNama(String nama)
    {
        this.nama = nama;
    }

    public String getNama()
    {
        return nama;
    }

    public void setJenisPesawat(JenisPesawat jenisPesawat)
    {
        this.jenisPesawat = jenisPesawat;
    }

    public JenisPesawat getJenisPesawat()
    {
       return jenisPesawat;
    }
    public void setTujuanPesawat(TujuanPesawat tujuanPesawat)
    {
        this.tujuanPesawat = tujuanPesawat;
    }

    public TujuanPesawat getTujuanPesawat()
    {
        return tujuanPesawat = tujuanPesawat;
    }
}
