public class Pemesanan{
    private Dokter dokter;
    private Pasien pasien;
    private String hari;
    
    public Pemesanan(Dokter dokter, Pasien pasien, String hari){
        setDokter(dokter);
        setPasien(pasien);
        setHari(hari);
    }
    
    void setDokter(Dokter dokter){
        this.dokter = dokter;
    }
    
    void setPasien(Pasien pasien){
        this.pasien = pasien;
    }
    
    void setHari(String hari){
        this.hari = hari;
    }
    
    Dokter getDokter(){
        return this.dokter;
    }
    
    Pasien getPasien(){
        return this.pasien;
    }
    
    String getHari(){
        return this.hari;
    }
}
