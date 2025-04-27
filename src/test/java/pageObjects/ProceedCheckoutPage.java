package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProceedCheckoutPage {
    WebDriver driver;
    By countryDropDown=By.tagName("select");
    By checkbox=By.cssSelector(".chkAgree");
    By proceedButton=By.xpath("//button[contains(text(),'Proceed')]");
    public ProceedCheckoutPage(WebDriver driver){

        this.driver=driver;
    }
    public void selectCountry(){
        WebElement dropdownElement=driver.findElement(countryDropDown);
        Select dropdown=new Select(dropdownElement);
        dropdown.selectByValue("Pakistan");


    }
    public void selectCheckmark(){
        driver.findElement(checkbox).click();
    }
    public void Proceed(){
        driver.findElement(proceedButton).click();

    }

}
