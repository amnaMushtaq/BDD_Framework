package utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    WebDriver driver;
    public WebDriver WebDriverManger() throws IOException {

        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
        Properties prop=new Properties();
        prop.load(fis);
        String url=prop.getProperty("QAUrl");


        if (driver == null) { //driver should be initialized only once
            if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            }
            if (prop.getProperty("browser").equalsIgnoreCase("firefox")){
                driver=new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
            driver.manage().window().maximize();
        }
        return driver;
    }
}
