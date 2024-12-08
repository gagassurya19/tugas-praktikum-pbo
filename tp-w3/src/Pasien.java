public class Pasien{
    private String nama;
    private Integer umur;

    public Pasien(String nama, Integer umur){
        setNama(nama);
        setUmur(umur);
    }

    void setNama(String nama){
        this.nama = nama;
    }

    void setUmur(Integer umur){
        this.umur = umur;
    }

    String getNama(){
        return this.nama;
    }

    Integer getUmur(){
        return this.umur;
    }
}
