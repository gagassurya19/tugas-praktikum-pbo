public class Main {
    public static void main(String[] args) {
        String title = "WEB GUE ";
        DashboardPage dp = new DashboardPage(title);
        HomePage hp = new HomePage(title);

        dp.showFullPage();
        hp.showFullPage();

        dp.login("Nafisa");
        dp.showFullPage();
        hp.login("Andini");
        hp.showFullPage();
    }
}