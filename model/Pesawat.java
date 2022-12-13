package model;

public class Pesawat {
    private String nama;
    private JenisPesawat jenisPesawat;

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
}
