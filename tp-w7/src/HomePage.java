public class HomePage extends WebPage implements Loginable{
    public HomePage(String title){
        super(title);
    };

    public void login(String input){
        this.loggedUsername = input;
        if(this.loggedUsername != null){
            System.out.println("Selamat datang dihalaman Home, "+this.loggedUsername+"!");
        }
    };

    protected void showMainPage(){
        if(this.loggedUsername == null || this.loggedUsername == ""){
            System.out.println("# Selamat data                      ##");
            System.out.println("# Anda sedang berada di home page   ##");
            System.out.println("# Ini penjelasan umum home page     ##");
        } else {
            System.out.println("# Selamat datang, "+this.loggedUsername+"!  ##");
            System.out.println("# Anda sedang berada di home page   ##");
            System.out.println("# Ini penjelasan khusus home page   ##");
        }
    };
}