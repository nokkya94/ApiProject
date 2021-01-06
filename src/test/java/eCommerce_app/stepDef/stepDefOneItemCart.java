package eCommerce_app.stepDef;

import eCommerce_app.pages.CartPage;
import eCommerce_app.pages.LogInPage;
import eCommerce_app.pages.ProductsPage;
import eCommerce_app.utils.AppiumUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Do;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class stepDefOneItemCart {
    static {
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }
    private static Logger LOG = LogManager.getLogger(stepDefForNegativeLogIn.class);
    AndroidDriver<AndroidElement> driver;
    LogInPage logInPage;
    ProductsPage productsPage;
    @When("user is launching the ecommerceapp")
    public void user_is_launching_the_ecommerceapp() {
        LOG.info("Launching the app");
        driver = AppiumUtils.getAndroidDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @When("logs in successfully")
    public void logs_in_successfully() {

        LOG.info("Positive Log In starts here");
        logInPage = new LogInPage(driver);
        AppiumUtils.tap(driver,logInPage.dropDownCountry);
        AndroidElement canada = AppiumUtils.scrollToElement(driver,"text(\"Albania\")");
        LOG.info("Choosing a country - Albania");
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
    @When("user is adding one item to the cart")
    public void user_is_adding_one_item_to_the_cart() {
        LOG.info("Tap on add to cart for AirJordan1MidSe ");
        productsPage = new ProductsPage(driver);
        AppiumUtils.tap(driver,productsPage.addToCartBtnAirJordan1MidSe);
        LOG.info("Check number of items in cart element");
        System.out.println(productsPage.cartNumberOfItems.getText());
        Assert.assertEquals(productsPage.cartNumberOfItems.getText(),"1");
        AppiumUtils.tap(driver,productsPage.cartGetInBtn);
    }
    @Then("item should be displayed in the cart")
    public void item_should_be_displayed_in_the_cart() {
        LOG.info("Check if item is displayed in the cart");
        AndroidElement jordans = driver.findElement(By.xpath("//android.widget.TextView[@text='Air Jordan 1 Mid SE']"));
        Assert.assertTrue(jordans.isDisplayed());

    }

    @When("user is adding three items in the cart")
    public void user_is_adding_three_items_in_the_cart() {
        LOG.info("Finding the Elements :" +
                "Air Jordan 9 Retro, Jordan\n" +
                "Lift Off, Lebron Soldier 12");
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidElement AirJordan9Retro = AppiumUtils.scrollToElement(driver,"text(\"Air Jordan 9 Retro\")");
        AppiumUtils.tap(driver,productsPage.addToCartBtnAirJordan9Retro);
        AndroidElement JordanLiftOff = AppiumUtils.scrollToElement(driver,"text(\"Jordan Lift Off\")");
        AppiumUtils.tap(driver,productsPage.addToCartBtnJordanLiftOff);
       // AppiumUtils.tap(driver,productsPage.addToCartBtnLeBronSoldier12_);
    }

    @Then("items should be displayed in the cart")
    public void items_should_be_displayed_in_the_cart() {
        LOG.info("check if items are in the cart");
        ProductsPage productsPage = new ProductsPage(driver);
        AppiumUtils.tap(driver,productsPage.cartGetInBtn);
        AndroidElement AirJordanRetro = driver.findElementByAndroidUIAutomator("text(\"Air Jordan 9 Retro\")");
        AndroidElement JordanLiftOff = driver.findElementByAndroidUIAutomator("text(\"Jordan Lift Off\")");
        Assert.assertTrue(AirJordanRetro.isDisplayed());
        Assert.assertTrue(JordanLiftOff.isDisplayed());
    }

    String PG_3_listedPrice = "";
    String NikeSFBJunglePrice = "";
    @When("user is addnd two items in cart")
    public void user_is_addnd_two_items_in_cart() {
        LOG.info("Addinb two items in carte to check its prices");
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidElement scrollToPG3 = AppiumUtils.scrollToElement(driver,"text(\"PG 3\")");
        AppiumUtils.tap(driver,productsPage.addToCartBtnPG_3_);
        PG_3_listedPrice=productsPage.priceProductPagePG_3_.getText();
        System.out.println(PG_3_listedPrice);
        NikeSFBJunglePrice=productsPage.priceProductPageNikeSFBJungle.getText();
        System.out.println(NikeSFBJunglePrice);
        AndroidElement scrollToNikeSFBJungle = AppiumUtils.scrollToElement(driver,"text(\"Nike SFB Jungle\")");
        AppiumUtils.tap(driver,productsPage.addToCartBtnNikeSFBJungle);

    }



    @Then("items should be displayed in cart")
    public void items_should_be_displayed_in_cart() {
        LOG.info("check if items are in the cart");
        ProductsPage productsPage = new ProductsPage(driver);
        AppiumUtils.tap(driver,productsPage.cartGetInBtn);
        AndroidElement PG_3_ = driver.findElementByAndroidUIAutomator("text(\"PG 3\")");
        AndroidElement NikeSFBJung = driver.findElementByAndroidUIAutomator("text(\"Nike SFB Jungle\")");
        Assert.assertTrue(PG_3_.isDisplayed());
        Assert.assertTrue(NikeSFBJung.isDisplayed());
    }
    @Then("prices in the cart should be the same as listed")
    public void prices_in_the_cart_should_be_the_same_as_listed() {
        LOG.info("Comparing the prices from product page and cart page");
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(PG_3_listedPrice,cartPage.cartPricePG_3_.getText());
        Assert.assertEquals(NikeSFBJunglePrice,cartPage.cartPriceNikeSFBJungle.getText());
    }
    @Then("total price should be correct")
    public void total_price_should_be_correct() {
        LOG.info("Check if total price is correct");
        CartPage cartPage = new CartPage(driver);
        Double totalprice = Double.parseDouble(PG_3_listedPrice.substring(1))+Double.parseDouble(NikeSFBJunglePrice.substring(1));
        Double totalFromCart = Double.parseDouble(cartPage.cartTotalPrice.getText().substring(1));
        Assert.assertEquals(totalprice,totalFromCart);
    }

    @When("user is adding two items in the cart")
    public void user_is_adding_two_items_in_the_cart() {
        LOG.info("Adding two items in cart to check its prices for Scenario: adding two items and remove one");
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidElement scrollToPG3 = AppiumUtils.scrollToElement(driver,"text(\"PG 3\")");
        AppiumUtils.tap(driver,productsPage.addToCartBtnPG_3_);
        PG_3_listedPrice=productsPage.priceProductPagePG_3_.getText();
        System.out.println(PG_3_listedPrice);
        NikeSFBJunglePrice=productsPage.priceProductPageNikeSFBJungle.getText();
        System.out.println(NikeSFBJunglePrice);
        AndroidElement scrollToNikeSFBJungle = AppiumUtils.scrollToElement(driver,"text(\"Nike SFB Jungle\")");
        AppiumUtils.tap(driver,productsPage.addToCartBtnNikeSFBJungle);
    }


    @Then("items should be in the cart")
    public void items_should_be_in_the_cart() {
        LOG.info("check if items are in the cart");
        ProductsPage productsPage = new ProductsPage(driver);
        AppiumUtils.tap(driver,productsPage.cartGetInBtn);
        AndroidElement PG_3_ = driver.findElementByAndroidUIAutomator("text(\"PG 3\")");
        AndroidElement NikeSFBJung = driver.findElementByAndroidUIAutomator("text(\"Nike SFB Jungle\")");
        Assert.assertTrue(PG_3_.isDisplayed());
        Assert.assertTrue(NikeSFBJung.isDisplayed());
    }
    @Then("prices from cart should be the same as listed")
    public void prices_from_cart_should_be_the_same_as_listed() {
        LOG.info("Comparing the prices from product page and cart page");
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(PG_3_listedPrice,cartPage.cartPricePG_3_.getText());
        Assert.assertEquals(NikeSFBJunglePrice,cartPage.cartPriceNikeSFBJungle.getText());
    }
    @Then("verify if total price is correct")
    public void verify_if_total_price_is_correct() {
        LOG.info("Check if total price is correct");
        CartPage cartPage = new CartPage(driver);
        Double totalprice = Double.parseDouble(PG_3_listedPrice.substring(1))+Double.parseDouble(NikeSFBJunglePrice.substring(1));
        Double totalFromCart = Double.parseDouble(cartPage.cartTotalPrice.getText().substring(1));
        Assert.assertEquals(totalprice,totalFromCart);
    }
    @Then("remove one item from the cart")
    public void remove_one_item_from_the_cart() throws InterruptedException {
       LOG.info("Removing an item");
       CartPage cartPage = new CartPage(driver);
       AppiumUtils.tap(driver,cartPage.backFromCart);
       Thread.sleep(1000);
       ProductsPage productsPage = new ProductsPage(driver);
       AppiumUtils.tap(driver,productsPage.removeCartPG_3_prdPage);
    }
    @Then("verify that there is only one item in the cart")
    public void verify_that_there_is_only_one_item_in_the_cart() {
        LOG.info("Verify if there is only one item in the cart after deleting an item");
        ProductsPage productsPage = new ProductsPage(driver);
        AppiumUtils.tap(driver,productsPage.cartGetInBtn);
        CartPage cartPage = new CartPage(driver);
        System.out.println(cartPage.listOfItemsInCart.size());
        Assert.assertEquals(cartPage.listOfItemsInCart.size(),1);

    }
    @Then("verify the price for the item")
    public void verify_the_price_for_the_item() {
        LOG.info("Verify the price of the item from cart with listed price");
        CartPage cartPage = new CartPage(driver);
        System.out.println(cartPage.listOfPricesFromItemsInCart.get(0).getText());
        Double totalFromCart = Double.parseDouble(cartPage.listOfPricesFromItemsInCart.get(0).getText().substring(1));
        Double priceForNikeSFBJungle = Double.parseDouble(NikeSFBJunglePrice.substring(1));
        Assert.assertEquals(priceForNikeSFBJungle,totalFromCart);
    }
    @Then("verify the total price")
    public void verify_the_total_price() {
        LOG.info("Verify the total price from the cart");
        CartPage cartPage = new CartPage(driver);
        Double totalPriceFromlist = 0.0;
        for (AndroidElement price:cartPage.listOfPricesFromItemsInCart){
            totalPriceFromlist = Double.parseDouble(price.getText().substring(1));
        }
        System.out.println(totalPriceFromlist);
        Double totalFromCart = Double.parseDouble(cartPage.cartTotalPrice.getText().substring(1));
        Assert.assertEquals(totalPriceFromlist,totalFromCart);
    }

    String converseAllStartPriceProdPg = "";
    String jordan6RingsPriceProdPg = "";
    @When("user adds two items in the cart")
    public void user_adds_two_items_in_the_cart() {
        LOG.info("Adding two items in the cart from Scenario: @CompletePurchaseAndTapOnCheckBox");
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidElement converseAllStart = AppiumUtils.scrollToElement(driver,"text(\"Converse All Star\")");
        converseAllStartPriceProdPg=productsPage.priceProductPageConverseAllSt.getText();
        AppiumUtils.tap(driver,productsPage.addToCartConverseAllStar);
        AndroidElement jordant6Rings = AppiumUtils.scrollToElement(driver,"text(\"Jordan 6 Rings\")");
        jordan6RingsPriceProdPg=productsPage.priceProductPageJordan6Rings.getText();
        AppiumUtils.tap(driver,productsPage.addToCartJordan6Rings);

    }
    @Then("verify the items in the cart")
    public void verify_the_items_in_the_cart() {
        LOG.info("Verifying the added items are displayed in the cart");
        ProductsPage productsPage = new ProductsPage(driver);
        AppiumUtils.tap(driver,productsPage.cartGetInBtn);
        AndroidElement ConverseAllStarInCart = driver.findElementByAndroidUIAutomator("text(\"Converse All Star\")");
        AndroidElement Jordan6RingsInCart = driver.findElementByAndroidUIAutomator("text(\"Jordan 6 Rings\")");
        Assert.assertTrue(ConverseAllStarInCart.isDisplayed());
        Assert.assertTrue(Jordan6RingsInCart.isDisplayed());
    }
    @Then("verify the prices in the cart")
    public void verify_the_prices_in_the_cart() {
        LOG.info("Verifying the prices in the cart");
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.cartPriceForConverseAllStar.getText(),converseAllStartPriceProdPg);
        Assert.assertEquals(cartPage.cartPriceForJordan6Rings.getText(),jordan6RingsPriceProdPg);
    }
    @Then("verify the total price is correct")
    public void verify_the_total_price_is_correct() {
        LOG.info("Verifying if total price in cart is correct");
        CartPage cartPage = new CartPage(driver);
        Double expectedTotalPrice = Double.parseDouble(cartPage.cartPriceForConverseAllStar.getText().substring(1))+Double.parseDouble(cartPage.cartPriceForJordan6Rings.getText().substring(1));
        Double actualTotalPrice = Double.parseDouble(cartPage.cartTotalPrice.getText().substring(1));
        Assert.assertEquals(actualTotalPrice,expectedTotalPrice);
    }
    @Then("user taps on check box to receive emails")
    public void user_taps_on_check_box_to_receive_emails() {
        LOG.info("Checkbox for sending emails step");
        CartPage cartPage = new CartPage(driver);
        AppiumUtils.tap(driver,cartPage.checkBoxInCart);
    }
    @Then("user taps on button to visit website to complete purchase")
    public void user_taps_on_button_to_visit_website_to_complete_purchase() {
        LOG.info("Tap on visit the website button");
        CartPage cartPage = new CartPage(driver);
        AppiumUtils.tap(driver,cartPage.visitTheWebSiteButton);
    }
    @Then("user navigate to techtorial website from a mobile browser")
    public void user_navigate_to_techtorial_website_from_a_mobile_browser() {
        LOG.info("Getting back to home screend and press the chrome browser for navigating to techtorial");
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        AndroidElement chromeBrowser= driver.findElementByAndroidUIAutomator("text(\"Chrome\")");
        AppiumUtils.tap(driver,chromeBrowser);
        AndroidElement chromeSearchBox = driver.findElementByAndroidUIAutomator("text(\"Search or type web address\")");
        AppiumUtils.tap(driver,chromeSearchBox);
        AndroidElement searchBox = driver.findElementByAndroidUIAutomator("text(\"Search or type web address\")");
        searchBox.sendKeys("http://www.techtorialacademy.com/");
        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_ENTER));
        if(driver.isKeyboardShown()){
            LOG.info("Hiding keyboard");
            driver.hideKeyboard();
        }

    }
    @Then("verify that its on the home page of techtorial website")
    public void verify_that_its_on_the_home_page_of_techtorial_website() {
        LOG.info("Verifying if we are on home page of techtorial academy");
        AndroidElement titleOfHomePage = driver.findElement(By.xpath("//div[@class=\"slide-text\"]/h1"));
        Assert.assertTrue(titleOfHomePage.isDisplayed());
    }


}
