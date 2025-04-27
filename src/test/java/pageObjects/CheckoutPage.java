package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    By cartButton=By.cssSelector("img[alt='Cart']");
    By checkOutButton=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    By promoButton=By.cssSelector(".promoBtn");
    By placeOrderBtn=By.xpath("//button[contains(text(),'Place Order')]");
    By productName=By.cssSelector(".product-name");
    By promoCodeField=By.cssSelector("input.promoCode");
    By promoSuccessMessage=By.cssSelector(".promoInfo");
    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }
    public void CheckoutItems(){
        driver.findElement(cartButton).click();
        driver.findElement(checkOutButton).click();
    }
    public Boolean verifyPromoBtn(){
          //driver.findElement(promoBtn).click();
        return  driver.findElement(promoButton).isDisplayed();

    }
    public  Boolean verifyPlaceOrderBtn(){
        return  driver.findElement(placeOrderBtn).isDisplayed();
    }
    public String  getProductName(){
        return driver.findElement(productName).getText().split("-")[0].trim();
    }
    public void applyPromoCode() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//           wait.until(ExpectedConditions.elementToBeClickable(promoCodeField)).sendKeys("rahulshettyacademy");

            driver.findElement(promoCodeField).sendKeys("rahulshettyacademy");
            //Thread.sleep(1000);
            driver.findElement(promoButton).click();

            String promoMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(promoSuccessMessage)).getText();
            Assert.assertTrue(promoMessage.contains("Code applied"), "Promo code was not successfully applied.");
        }





    public void PlaceOrder(){

    driver.findElement(placeOrderBtn).click();
    }



}
