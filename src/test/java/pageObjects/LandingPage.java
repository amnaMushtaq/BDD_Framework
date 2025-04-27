package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    WebDriver driver;
    public  LandingPage(WebDriver driver){
        this.driver=driver;

    }
     By search=By.cssSelector("input[type='search']");
     By productName=By.cssSelector("h4.product-name");
     By topDeals=By.linkText("Top Deals");
     By increment=By.cssSelector("a.increment");
     //By addToCartBtn=By.xpath("//button[contains(text(),'ADD TO CART')]");
    By addToCartBtn=By.cssSelector(".product-action button");

    public void searchItem(String name) throws InterruptedException {
        driver.findElement(search).sendKeys(name);
        Thread.sleep(1000);

    }
    public String getProductName(){
        return driver.findElement(productName).getText().split("-")[0].trim();
    }
    public void selectTopDeals(){
        driver.findElement(topDeals).click();
    }
    public String getTitleLandingPage(){
        return driver.getTitle();
    }
    public void incrementQuantity(int quantity){
        int i=quantity-1; // 1 qunaity is already added
        while(i>0) {
            driver.findElement(increment).click();
            i--;
        }

    }
    public void addToCart(){
        driver.findElement(addToCartBtn).click();
    }

}
