package eCommerce_app.stepDef;

import eCommerce_app.pages.LogInPage;
import eCommerce_app.pages.ProductsPage;
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

public class stepDefForPositiveLogIn {

    static {
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }
    private static Logger LOG = LogManager.getLogger(stepDefForNegativeLogIn.class);
    AndroidDriver<AndroidElement> driver;
    LogInPage logInPage;

    @When("user is launching the app2")
    public void user_is_launching_the_app2() {
        LOG.info("Launching the app");
        driver = AppiumUtils.getAndroidDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @When("user is providing sufficient input")
    public void user_is_providing_sufficient_input() {

        LOG.info("Positive Log In starts here");
        logInPage = new LogInPage(driver);
        AppiumUtils.tap(driver,logInPage.dropDownCountry);
        AndroidElement canada = AppiumUtils.scrollToElement(driver,"text(\"Canada\")");
        LOG.info("Choosing a country - Canada");
        AppiumUtils.tap(driver,canada);
        AppiumUtils.tap(driver,logInPage.nameField);
        logInPage.nameField.sendKeys("Techtorial");
        if(driver.isKeyboardShown()){
            LOG.info("Hiding keyboard");
            driver.hideKeyboard();
        }
        LOG.info("Choosing gender");
        AppiumUtils.tap(driver,logInPage.Female);
        LOG.info("Clock log in btn");
        AppiumUtils.tap(driver,logInPage.logIn);
    }
    @Then("user should be able to verify log in info")
    public void user_should_be_able_to_verify_log_in_info() {
        LOG.info("Verify LogIn");
        ProductsPage productsPage = new ProductsPage(driver);
        System.out.println(productsPage.productsHeader.getText());
        Assert.assertTrue(productsPage.productsHeader.isDisplayed());
    }

}
