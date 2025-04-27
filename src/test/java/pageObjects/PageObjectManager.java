package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    WebDriver driver;
    LandingPage landingPage;
    OffersPage offersPage;
    CheckoutPage checkoutPage;
    ProceedCheckoutPage proceedCheckoutPage;
    ThankyouPage thankyouPage;

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
    public CheckoutPage CheckoutPage(){
        checkoutPage=new CheckoutPage(driver);
        return checkoutPage;

    }
    public ProceedCheckoutPage ProceedCheckout(){
        proceedCheckoutPage =new ProceedCheckoutPage(driver);
        return proceedCheckoutPage;

    }
    public ThankyouPage Thankyou(){
        thankyouPage =new ThankyouPage(driver);
        return thankyouPage;

    }


}
