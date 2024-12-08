import java.util.Objects;

public class HandoBaet extends SepedaMotor{
    public HandoBaet(String warnaMotor) {
        super(warnaMotor);
        this.ukuranTangki = 4;
    };

    public Boolean jalan() {
        boolean isJalan = super.jalan();
        if(!Objects.equals(super.cekKapanHabis(), "")) {
            System.out.println("MotoBaet akan habis pada "+super.cekKapanHabis());
        }
        return isJalan;
    };
};