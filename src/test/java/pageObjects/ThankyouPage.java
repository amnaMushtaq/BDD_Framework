package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankyouPage {
    WebDriver driver;
    By successMessage=By.cssSelector("#root .products");
    public ThankyouPage(WebDriver driver){
        this.driver=driver;

    }

    public String getSuccessMessage(){
        System.out.println("Message is " +driver.findElement(successMessage).getText());
        return driver.findElement(successMessage).getText();
    }
}
