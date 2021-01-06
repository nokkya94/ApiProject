package eCommerce_app.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    public ProductsPage(AndroidDriver driver ){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
    public AndroidElement productsHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Air Jordan 1 Mid SE']")
    public AndroidElement AirJordan1MidSe;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Air Jordan 1 Mid SE']//following-sibling::android.widget.LinearLayout[@index='3']")
    public AndroidElement priceAndCartElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Air Jordan 1 Mid SE']//following-sibling::android.widget.LinearLayout[@index='3']/android.widget.TextView[@text='ADD TO CART']")
    public AndroidElement addToCartBtnAirJordan1MidSe;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/counterText")
    public AndroidElement cartNumberOfItems;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']/following-sibling::\t\n" +
            "android.widget.LinearLayout")
    public AndroidElement cartGetInBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Air Jordan 9 Retro']")
    public AndroidElement AirJordan9Retro;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Air Jordan 9 Retro']//following-sibling::android.widget.LinearLayout[@index='3']/android.widget.TextView[@text='ADD TO CART']")
    public AndroidElement addToCartBtnAirJordan9Retro;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Jordan Lift Off]")
    public AndroidElement JordanLiftOff;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Jordan Lift Off']//following-sibling::android.widget.LinearLayout[@index='3']/android.widget.TextView[@text='ADD TO CART']")
    public AndroidElement addToCartBtnJordanLiftOff;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='LeBron Soldier 12']")
    public AndroidElement LebronSoldier;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='LeBron Soldier 12']//following-sibling::android.widget.LinearLayout[@index='3']/android.widget.TextView[@text='ADD TO CART']")
    public AndroidElement addToCartBtnLeBronSoldier12_;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PG 3']//following-sibling::android.widget.LinearLayout[@index='3']/android.widget.TextView[@text='ADD TO CART']")
    public AndroidElement addToCartBtnPG_3_;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PG 3']/following-sibling::android.widget.LinearLayout/android.widget.TextView[1]")
    public AndroidElement priceProductPagePG_3_;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nike SFB Jungle']//following-sibling::android.widget.LinearLayout[@index='3']/android.widget.TextView[@text='ADD TO CART']")
    public AndroidElement addToCartBtnNikeSFBJungle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nike SFB Jungle']/following-sibling::android.widget.LinearLayout/android.widget.TextView[1]")
    public AndroidElement priceProductPageNikeSFBJungle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PG 3']//following-sibling::android.widget.LinearLayout[@index='3']/android.widget.TextView[@text='ADDED TO CART']" )
    public AndroidElement removeCartPG_3_prdPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Converse All Star']//following-sibling::android.widget.LinearLayout[@index='3']/android.widget.TextView[@text='ADD TO CART']")
    public AndroidElement addToCartConverseAllStar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Jordan 6 Rings']//following-sibling::android.widget.LinearLayout[@index='3']/android.widget.TextView[@text='ADD TO CART']")
    public AndroidElement addToCartJordan6Rings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Converse All Star']/following-sibling::android.widget.LinearLayout/android.widget.TextView[1]")
    public AndroidElement priceProductPageConverseAllSt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Jordan 6 Rings']/following-sibling::android.widget.LinearLayout/android.widget.TextView[1]")
    public AndroidElement priceProductPageJordan6Rings;



}
