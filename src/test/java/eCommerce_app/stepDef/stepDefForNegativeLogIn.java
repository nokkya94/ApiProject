package eCommerce_app.stepDef;

import eCommerce_app.pages.LogInPage;
import eCommerce_app.utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class stepDefForNegativeLogIn {

    static {
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }
    private static Logger LOG = LogManager.getLogger(stepDefForNegativeLogIn.class);
    AndroidDriver<AndroidElement> driver;
    LogInPage logInPage;

    @When("user is launching the app")
    public void user_is_launching_the_app() {
        LOG.info("Launching the app");
        driver = AppiumUtils.getAndroidDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @When("user is not providing sufficient input to log int")
    public void user_is_not_providing_sufficient_input_to_log_int() throws InterruptedException {
        LOG.info("Negative testing with insufficient input");
        logInPage = new LogInPage(driver);
        AppiumUtils.tap(driver,logInPage.dropDownCountry);
        AndroidElement canada = AppiumUtils.scrollToElement(driver,"text(\"Canada\")");
        LOG.info("Choosing a country - Canada");
        AppiumUtils.tap(driver,canada);
        /*
        AppiumUtils.tap(driver,logInPage.nameField);
        logInPage.nameField.sendKeys();
         */
        LOG.info("Choosing gender");
        AppiumUtils.tap(driver,logInPage.Female);
        LOG.info("Clock log in btn");
        AppiumUtils.tap(driver,logInPage.logIn);

    }


    @Then("user should be able to see Toast Message")
    public void user_should_be_able_to_see_toast_message() {
        LOG.info("User should see the 'Please enter your name' message");
        System.out.println(logInPage.Toast.getText());
        Assert.assertEquals("Please enter your name",logInPage.Toast.getText());
    }

}
