package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utilis.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {
    TestContextSetup testContextSetup;
    public String offerPageProductName;
    OffersPage offersPage;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.offersPage = testContextSetup.pageObjectManager.OffersPage();

    }

    @When("^user searched for (.+) shortname in offers page$")
    public void userSearchedForShortnameInOffersPage(String shortName)  {

        switchToOffersPage();

        //OffersPage offersPage=new OffersPage(testContextSetup.driver);
        offersPage.searchItem(shortName);
       // Thread.sleep(1000);
        offerPageProductName = offersPage.getProductName().trim();
        System.out.println(offerPageProductName);


    }

    public void switchToOffersPage() {
        //if we switched to offer page -> skip below part
        //if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
        LandingPage landingPage = testContextSetup.pageObjectManager.LandingPage();
        landingPage.selectTopDeals();
        testContextSetup.genericUtilis.SwitchWindowToChild();


    }


    @Then("Validate product name in offers page matches with Landing Page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }
}



