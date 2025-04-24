package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utilis.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {
    TestContextSetup testContextSetup;
    public String offerPageProductName;
    public OfferPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;

    }

    @When("user searched for {string} shortname in offers page")
    public void userSearchedForShortnameInOffersPage(String shortName) throws InterruptedException {

        testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
        Set<String> windows= testContextSetup.driver.getWindowHandles();
        Iterator<String> it =windows.iterator();
        String parentWindow=it.next();
        String childWindow= it.next();
        testContextSetup.driver.switchTo().window(childWindow);
        testContextSetup.driver.findElement(By.cssSelector("#search-field")).sendKeys(shortName);
        Thread.sleep(1000);
        offerPageProductName=testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText().trim();
        System.out.println(offerPageProductName);


    }




    @Then("Validate product name in offers page matches with Landing Page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {
        Assert.assertEquals(offerPageProductName,offerPageProductName);
    }
}
