import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterClass;



public class RegisterUser {


    @BeforeClass
    public void setup()
    {
        BaseClass.initializeWebDriver();
    }
    @Test
    public void openUrl() throws InterruptedException
    {
        BaseClass.driver.get("https://automationexercise.com/");
    }
    @AfterClass
    public void tearDown()
    {
        BaseClass.quit();
    }

}
