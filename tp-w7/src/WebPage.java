public class WebPage{
    private String webTitle = "";
    protected String loggedUsername = "";

    public WebPage(String title){
        this.webTitle = title;
    }

    protected void showHeader(){
        System.out.println("######################################");
        System.out.println("## "+this.webTitle+"                         ##");
        System.out.println("#-----------------------------------##");
    }

    protected void showFooter(){
        System.out.println("#-----------------------------------##");
        System.out.println("# Create by Gagas Surya Laksana     ##");
        System.out.println("######################################");
    }

    protected void showMainPage() {
    }

    public void showFullPage(){
        this.showHeader();
        this.showMainPage();
        this.showFooter();
    }
}
