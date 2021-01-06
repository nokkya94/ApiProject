package eCommerce_app.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    public CartPage(AndroidDriver driver ){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Air Jordan 1 Mid SE']")
    public AndroidElement AirJordan1MidSe;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Air Jordan 9 Retro']")
    public AndroidElement AirJordan9Retro;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Jordan Lift Off]")
    public AndroidElement JordanLiftOff;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='LeBron Soldier 12]")
    public AndroidElement LebronSoldier;

    @AndroidFindBy(xpath = "//\t\n" +
            "android.widget.TextView[@text='PG 3']/following-sibling::\t\n" +
            "android.widget.LinearLayout/\t\n" +
            "android.widget.TextView")
    public AndroidElement cartPricePG_3_;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nike SFB Jungle']/following-sibling::android.widget.LinearLayout/android.widget.TextView")
    public AndroidElement cartPriceNikeSFBJungle;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    public AndroidElement cartTotalPrice;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_back")
    public AndroidElement backFromCart;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout")
    public List<AndroidElement> listOfItemsInCart;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
    public List<AndroidElement> listOfPricesFromItemsInCart;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Converse All Star']/following-sibling::android.widget.LinearLayout/android.widget.TextView")
    public AndroidElement cartPriceForConverseAllStar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Jordan 6 Rings']/following-sibling::android.widget.LinearLayout/android.widget.TextView")
    public AndroidElement cartPriceForJordan6Rings;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")
    public AndroidElement checkBoxInCart;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Visit to the website to complete purchase']")
    public AndroidElement visitTheWebSiteButton;



}
