package eCommerce_app.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    public LogInPage(AndroidDriver driver ){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    @AndroidFindBy(id = "android:id/text1")
    public AndroidElement dropDownCountry;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public AndroidElement nameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    public AndroidElement Male;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    public AndroidElement Female;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public AndroidElement logIn;

    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    public AndroidElement Toast;

}
