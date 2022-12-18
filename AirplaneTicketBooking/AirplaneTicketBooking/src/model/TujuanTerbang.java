package src.model;

public class TujuanTerbang {
    private String id;
    private String tujuan;

    //  Setter
    public void setId(String id){
        this.id = id;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }
    
    // Getter
    public String getTujuan() {
        return tujuan;
    }

    public String getId() {
        return id;
    }
}
