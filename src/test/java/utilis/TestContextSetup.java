package utilis;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {
    public WebDriver driver;
    public String landingPageProductName;
    public PageObjectManager pageObjectManager;
    public GenericUtilis genericUtilis;
    public TestBase testBase;

    public TestContextSetup() throws IOException {
        testBase=new TestBase();
        pageObjectManager=new PageObjectManager(testBase.WebDriverManger());
        genericUtilis=new GenericUtilis(testBase.WebDriverManger());

    }
}
