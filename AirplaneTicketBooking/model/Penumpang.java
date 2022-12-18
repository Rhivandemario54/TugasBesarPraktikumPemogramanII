package model;

public class Penumpang {

    private String nama;
    private String noTelpon;
    private String umur;

    private AsalTerbang asalTerbang;
    private TujuanTerbang tujuanTerbang;

    // Setter

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoTelpon(String noTelpon) {
        this.noTelpon = noTelpon;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }


    public void setAsalTerbang(AsalTerbang asalTerbang) {
        this.asalTerbang = asalTerbang;
    }

    public void setTujuanTerbang(TujuanTerbang  tujuanTerbang) {
        this.tujuanTerbang = tujuanTerbang;
    }


    // Getter

    public String getNama() {
        return nama;
    }

    public String getNoTelpon() {
        return noTelpon;
    }

    public String getUmur() {
        return umur;
    }

    public AsalTerbang getAsalTerbang() {
        return asalTerbang;
    }

    public TujuanTerbang getTujuanTerbang() {
        return tujuanTerbang;
    }

}
