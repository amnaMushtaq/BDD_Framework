package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utilis.TestContextSetup;


public class LandingPageStepDefinition {
    TestContextSetup testContextSetup;
   public LandingPageStepDefinition(TestContextSetup testContextSetup){
       this.testContextSetup=testContextSetup;

   }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {

        //WebDriverManger
//        testContextSetup.driver = new ChromeDriver();
//        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
//        testContextSetup.driver.manage().window().maximize();

    }

    @When("usr searched with Shortname {string} and extracted actual name of product")
    public void usr_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        LandingPage landingPage=testContextSetup.pageObjectManager.LandingPage();
        landingPage.searchItem(shortName);
       //testContextSetup.driver.findElement(By.cssSelector("input[type='search']")).sendKeys(shortName);
        Thread.sleep(1000);

        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName + " is extracted Product from Home Page");
    }



}
