public class Main {
    public static void main(String[] args) {
        Dokter dt1 = new Dokter("Maulana Malik", "Mata");
        Dokter dt2 = new Dokter("Fahryan Tresno", "Gigi");
        Dokter dt3 = new Dokter("Priyagung Makmur", "Telinga");

        Pasien ps1 = new Pasien("Adli Bahri", 20);
        Pasien ps2 = new Pasien("Adam Rafif", 55);
        Pasien ps3 = new Pasien("Alif Taufiq", 37);

        Pemesanan pm1 = new Pemesanan(dt1, ps1, "Selasa");
        Pemesanan pm2 = new Pemesanan(dt2, ps1, "Kamis");
        Pemesanan pm3 = new Pemesanan(dt2, ps2, "Selasa");
        Pemesanan pm4 = new Pemesanan(dt3, ps2, "Jumat");
        Pemesanan pm5 = new Pemesanan(dt1, ps3, "Senin");

        Pemesanan[] pemesananArr = { pm1, pm2, pm3, pm4, pm5};

        for (int i = 0; i < pemesananArr.length; i++) {
            System.out.println("Urutan ke-" + (i + 1));
            System.out.println("Nama Dokter\t: " + pemesananArr[i].getDokter().getNama());
            System.out.println("Spesialis\t: " + pemesananArr[i].getDokter().getSpesialis());
            System.out.println("Nama Pasien\t: " + pemesananArr[i].getPasien().getNama() + " (" + pemesananArr[i].getPasien().getUmur() + ")");
            System.out.println("Hari\t\t: " + pemesananArr[i].getHari());
            System.out.println();
        }
    }
}

