package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    WebDriver driver;
    LandingPage landingPage;
    OffersPage offersPage;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;

    }
    public LandingPage LandingPage(){
        landingPage=new LandingPage(driver);
        return landingPage;
    }
    public OffersPage OffersPage(){
        offersPage=new OffersPage(driver);
        return offersPage;
    }


}
