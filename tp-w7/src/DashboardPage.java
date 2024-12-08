public class DashboardPage extends WebPage implements Loginable {
    public DashboardPage(String title){
        super(title);
    }

    public void login(String input) {
        this.loggedUsername = input;
        if(this.loggedUsername != null){
            System.out.println(this.loggedUsername+" berhasil login ke halaman Dashboard");
        }
    }

    protected void showMainPage(){
        if(this.loggedUsername == null || this.loggedUsername == ""){
            System.out.println("# Akses ditutup untuk user guest    ##");
            System.out.println("# Mohon login terlebih dahulu       ##");
        } else {
            System.out.println("# Dashboard Page - "+this.loggedUsername+"  ##");
            System.out.println("# Opsi-opsi page dashboard          ##");
            System.out.println("# dsb.                              ##");
        }
    };
}
