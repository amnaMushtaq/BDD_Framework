package StepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.ProceedCheckoutPage;
import pageObjects.ThankyouPage;
import utilis.TestContextSetup;

public class CheckoutPageStepDefinition {
    TestContextSetup testContextSetup;
    CheckoutPage checkoutPage;
    ProceedCheckoutPage proceedCheckoutPage;
    ThankyouPage thankyouPage;
    public CheckoutPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
        this.checkoutPage=testContextSetup.pageObjectManager.CheckoutPage();
        this.proceedCheckoutPage = testContextSetup.pageObjectManager.ProceedCheckout();
        this.thankyouPage=testContextSetup.pageObjectManager.Thankyou();

    }


    @Then("^User proceeds to Checkout and Validate the (.+) items in checkout page$")
    public void user_Proceeds_To_Checkout_And_Validate_TheName_Items_In_CheckoutPage(String productName) throws InterruptedException {
        Thread.sleep(2000);
        checkoutPage.CheckoutItems();
        Thread.sleep(2000);
        String checkoutPageProduct = checkoutPage.getProductName();
        System.out.println("product on checkout page is " + checkoutPageProduct);
        Assert.assertTrue(checkoutPageProduct.contains(productName));

    }



    @Then("verify user has ability to enter promo code and place the order")
    public void verifyUserHasAbilityToEnterPromoCodeAndPlaceTheOrder() throws InterruptedException {

        Assert.assertTrue(checkoutPage.verifyPromoBtn(), "Promo button is not displayed");
        Assert.assertTrue(checkoutPage.verifyPlaceOrderBtn(),"Place Order button is not displayed");
        checkoutPage.applyPromoCode();
        checkoutPage.PlaceOrder();

        proceedCheckoutPage.selectCountry();
        proceedCheckoutPage.selectCheckmark();
        proceedCheckoutPage.Proceed();
//        Thread.sleep(5000);
        Assert.assertTrue(thankyouPage.getSuccessMessage().contains("Thank you"));



    }


}
