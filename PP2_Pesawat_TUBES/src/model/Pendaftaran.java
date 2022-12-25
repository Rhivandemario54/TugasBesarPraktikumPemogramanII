package model;

// Getter AND Setter Halaman pendaftaran
public class Pendaftaran {
    private String id;
    private String namauser;
    private String tgl_penerbangan;
    private String kelaspen;
    private Jumlah jumlah;
    private Tujuan tujuan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamauser() {
        return namauser;
    }

    public void setNamauser(String namauser) {
        this.namauser = namauser;
    }

    public String getTgl_penerbangan() {
        return tgl_penerbangan;
    }

    public void setTgl_penerbangan(String tgl_penerbangan) {
        this.tgl_penerbangan = tgl_penerbangan;
    }

    public String getKelaspen() {
        return kelaspen;
    }

    public void setKelaspen(String kelaspen) {
        this.kelaspen = kelaspen;
    }

    public Jumlah getJumlah() {
        return jumlah;
    }

    public void setJumlah(Jumlah jumlah) {
        this.jumlah = jumlah;
    }

    public Tujuan getTujuan() {
        return tujuan;
    }

    public void setTujuan(Tujuan tujuan) {
        this.tujuan = tujuan;
    }

}
