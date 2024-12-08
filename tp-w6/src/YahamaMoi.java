import java.util.Objects;

public class YahamaMoi extends SepedaMotor{
    public YahamaMoi(String warna){
        super(warna);
        this.ukuranTangki = 5;
    };

    public Boolean jalan(){
        Boolean isJalan = super.jalan();
        if(!Objects.equals(super.cekKapanHabis(), "")) {
            System.out.println("Bensin akan habis pada " + super.cekKapanHabis());
        }
        return isJalan;
    };
};