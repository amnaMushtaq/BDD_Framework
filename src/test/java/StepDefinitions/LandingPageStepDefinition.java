package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utilis.TestContextSetup;

import java.time.Duration;


public class LandingPageStepDefinition {
    TestContextSetup testContextSetup;
    LandingPage landingPage;
   public LandingPageStepDefinition(TestContextSetup testContextSetup){
       this.testContextSetup=testContextSetup;
        this.landingPage=testContextSetup.pageObjectManager.LandingPage();

   }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
       Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));

        //WebDriverManger
//        testContextSetup.driver = new ChromeDriver();
//        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
//        testContextSetup.driver.manage().window().maximize();

    }

    @When("^user searched with Shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {

        landingPage.searchItem(shortName);

        testContextSetup.landingPageProductName = landingPage.getProductName();
        System.out.println(testContextSetup.landingPageProductName + " is extracted Product from Home Page");
    }

    @When("^Added (.+) items of the selected product to cart$")
    public void addedItemsOfTheSelectedProductToCart(String quantity) {
       landingPage.incrementQuantity(Integer.parseInt(quantity)); //String is converted into integer
        landingPage.addToCart();
        System.out.println("clicked");


    }



}
