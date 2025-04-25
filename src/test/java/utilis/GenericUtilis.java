package utilis;

import org.openqa.selenium.WebDriver;

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
}
