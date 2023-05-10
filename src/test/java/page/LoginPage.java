package page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Random;

public class LoginPage extends BasePage {

    Random random = new Random();
    int num = random.nextInt(100000);


    @FindBy(css = "input[data-qa='signup-name']")
    WebElement signUpName;

    @FindBy(css = "input[data-qa='signup-email']")
    WebElement signUpEmailAddress;

    @FindBy(css = "button[data-qa='signup-button']")
    WebElement signUpButton;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/h2")
    WebElement newUserSignUpText;


    public String getTitle() {
        System.out.println(driver.getTitle());
        return driver.getTitle();
    }

    public String getNewUserSignUpText() {
        return newUserSignUpText.getText();
    }

    public void waitForsignUpNameIsClickable() {
        signUpName = wait.until(ExpectedConditions.elementToBeClickable(signUpName));
    }

    public void fillInsignUpName(String name) {
        signUpName.sendKeys(name);
    }

    public void fillInsignUpEmailAddress(String email) {
        signUpEmailAddress.sendKeys(email);
    }

    public void clicksignUpButton() {
        signUpButton.click();
    }


    public void newUserSignUp() {
        waitForsignUpNameIsClickable();
        fillInsignUpEmailAddress("akarmi@gmail.com" + num);
        fillInsignUpName("Jane Doe");
        clicksignUpButton();
    }

}

