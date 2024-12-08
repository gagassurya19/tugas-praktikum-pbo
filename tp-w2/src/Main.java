
public class Main {
    public static void main(String[] args) {
        Prodi pr1 = new Prodi();
        Prodi pr2 = new Prodi();

        // setter
        pr1.setNama("Informatika");
        pr2.setNama("Rekayasa Perangkat Lunak");


        Mahasiswa mhs1 = new Mahasiswa();
        Mahasiswa mhs2 = new Mahasiswa();

        // setter
        mhs1.setNama("Heritsam Yuniawan");
        mhs1.setProdi(pr1);

        mhs2.setNama("Nugroho Rahmanto");
        mhs2.setProdi(pr2);

        // display mahasiswa
        mhs1.displayMahasiswa();
        mhs2.displayMahasiswa();

        // mengubah nama prodi
        pr1.setNama("Teknik Informatika");
        mhs1.setProdi(pr1);
        mhs1.setNama("Gagas Surya Laksana");
        
        // display mahasiswa
        mhs1.displayMahasiswa();
        
    }
}

class Prodi {
    private String nama;

    // setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    // getter
    public String getNama() {
        return nama;
    }
}

class Mahasiswa {
    private String nama;
    private Prodi prodi;

    // setter
    public void setNama(String nama){
        this.nama = nama;
    }

    public void setProdi(Prodi prodi) {
        this.prodi = prodi;
    }

    // getter
    public String getNama() {
        return nama;
    }
    
    public String getProdi() {
        return prodi.getNama();
    }

    public void displayMahasiswa() {
        System.out.println("\nNama: " + getNama());
        System.out.println("Prodi: " + getProdi());
    }
}