package StepDefinitions;

import io.cucumber.java.After;
import utilis.TestContextSetup;

import java.io.IOException;

public class Hooks {
    TestContextSetup testContextSetup;
    public Hooks(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
    }
    @After
    public void AfterScenario() throws IOException {
        testContextSetup.testBase.WebDriverManger().quit();
    }
}
