public class Dokter{
    private String nama;
    private String spesialis;

    public Dokter(String nama, String spesialis){
        setNama(nama);
        setSpesialis(spesialis);
    }
    
    void setNama(String nama){
        this.nama = nama;
    }
    
    void setSpesialis(String spesialis){
        this.spesialis = spesialis;
    }
    
    String getNama(){
        return this.nama;
    }
    
    String getSpesialis(){
        return this.spesialis;
    }
}
