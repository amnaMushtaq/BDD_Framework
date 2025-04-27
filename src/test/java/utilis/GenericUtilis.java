package utilis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class GenericUtilis {
    WebDriver driver;
    public GenericUtilis(WebDriver driver){
        this.driver=driver;
    }
    public void SwitchWindowToChild(){
        Set<String> windows= driver.getWindowHandles();
        Iterator<String> it =windows.iterator();
        String parentWindow=it.next();
        String childWindow= it.next();
        driver.switchTo().window(childWindow);

    }
    public void waitUntilAttributeContains(String shortName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(
                By.cssSelector("h4.product-name"),
                "textContent", shortName));
    }
}
