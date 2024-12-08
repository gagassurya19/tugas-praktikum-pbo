public class Main {
    public static void main(String[] args) {
      SepedaMotor sp = new SepedaMotor("Hitam");
      HandoBaet hb = new HandoBaet("Biru");
      YahamaMoi ym = new YahamaMoi("Merah");

      System.out.println("Status Awal Sepeda Motor:");
      System.out.println("\t"+sp.jalan());
      System.out.println("Status Awal HandoBaet:");
      System.out.println("\t"+hb.jalan());
      System.out.println("Status Awal YahamaMoi:");
      System.out.println("\t"+ym.jalan());

      System.out.println("----------------------------");

      System.out.println("Status Terbaru Sepeda Motor:");
      sp.isiTangkiFull();
      sp.jalan();
      System.out.println(sp.cekKapanHabis());

      System.out.println("\nStatus Terbaru HandoBaet:");
      hb.isiTangkiFull();
      hb.jalan();

      System.out.println("\nStatus Terbaru YahamaMoi:");
      ym.isiTangkiFull();
      ym.jalan();
    };
};