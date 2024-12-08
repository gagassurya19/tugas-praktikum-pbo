import java.time.LocalDateTime;

public class SepedaMotor {
    private String warnaMotor;
    protected Integer ukuranTangki;
    private LocalDateTime waktuIsiBensin;

    public SepedaMotor(String warnaMotor) {
        this.warnaMotor = warnaMotor;
        this.ukuranTangki = 3;
        this.waktuIsiBensin = null;
    }

    public void isiTangkiFull() {
        this.waktuIsiBensin = LocalDateTime.now();
        System.out.println("Waktu Saat ini: "+this.waktuIsiBensin);
    };

    public String cekKapanHabis() {
        if (this.waktuIsiBensin == null) {
            return "";
        }
        LocalDateTime waktuHabis = this.waktuIsiBensin.plusHours(this.ukuranTangki * 1);
        return waktuHabis.toString().substring(0, 19).replace("T", " ");
    }

    public Boolean jalan() {
        if(this.waktuIsiBensin != null){
            System.out.println("Sepeda motor sedang berjalan");
            return true;
        }

        System.out.println("Bensin habis, sepeda motor tidak dapat jalan");
        return false;
    };
};
