package eCommerce_app.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class AppiumUtils {

    //Touch Actions
    public static void tap(AndroidDriver driver, AndroidElement element){

        TouchAction touchAction = new TouchAction(driver);
        TapOptions tapOptions = new TapOptions();
        touchAction.tap(tapOptions.withElement(element(element))).perform();
    }

    public static void longPressOnElement(AndroidDriver driver,AndroidElement element,int duration){
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(element))
                .withDuration(Duration.ofSeconds(duration)))
                .release()
                .perform();
    }

    //General Utils
    public static void waitFor(int seconds){

        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

    }
    public static AndroidDriver<AndroidElement> getAndroidDriver(){

        File apkFile = new File("C:\\Users\\tanas\\Downloads\\AppiumProject\\src\\test\\resource\\General-Store.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 28");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,apkFile.getAbsolutePath());
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,300);
        URL serverUrl;
        try {
            serverUrl = new URL("http://localhost:4723/wd/hub");
        }catch (MalformedURLException ex){
            throw new RuntimeException(ex.getMessage());
        }


        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(serverUrl,desiredCapabilities);

        return driver;
    }


    public static AndroidElement scrollToElement(AndroidDriver<AndroidElement> driver, String locator){

       return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" + locator + ");");
    }

}
