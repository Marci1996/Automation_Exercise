package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;

    protected WebDriverWait wait;


    public final static String name = "PermanentName";
    public final static String email = "PermanentEmail@gmail.com";
    public final static String password = "PermanentPassword";



    public BasePage() {
        BaseClass baseClass = new BaseClass();
        driver = baseClass.initializeWebDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }


    public static void quit() {
        driver.quit();
        driver = null;
    }

    public static void openURL(String url) {
        driver.get(url);
    }

}
