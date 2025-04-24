package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class GreenKartStepDefinition {
    WebDriver driver;
    String landingPageProductName;
    String offerPageProductName;
    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

    }
    @When("usr searched with Shortname {string} and extracted actual name of product")
    public void usr_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        driver.findElement(By.cssSelector("input[type='search']")).sendKeys(shortName);
        Thread.sleep(1000);
        landingPageProductName=driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(landingPageProductName + " is extracted Product from Home Page");
    }
    @When("user searched for {string} shortname in offers page")
    public void userSearchedForShortnameInOffersPage(String shortName) throws InterruptedException {

        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> windows= driver.getWindowHandles();
        Iterator<String> it =windows.iterator();
        String parentWindow=it.next();
        String childWindow= it.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.cssSelector("#search-field")).sendKeys(shortName);
        Thread.sleep(1000);
        offerPageProductName=driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText().trim();
        System.out.println(offerPageProductName);


    }




    @Then("Validate product name in offers page matches with Landing Page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {
        Assert.assertEquals(offerPageProductName,offerPageProductName);
    }
}
