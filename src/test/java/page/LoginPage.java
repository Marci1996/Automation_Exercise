package page;

import base.BasePage;
import base.GenerateRandom;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.Random;

public class LoginPage extends BasePage {


    GenerateRandom randomString = new GenerateRandom();
    Random random = new Random();
    int num = random.nextInt(100000);

    HomePage homePage = new HomePage();


    // signup elements
    @FindBy(css = "input[data-qa='signup-name']")
    WebElement signUpName;

    @FindBy(css = "input[data-qa='signup-email']")
    WebElement signUpEmailAddress;

    @FindBy(css = "button[data-qa='signup-button']")
    WebElement signUpButton;



    //@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/h2")
    @FindBy(xpath = "//div[contains(@class, 'signup-form')]/h2")
    WebElement newUserSignUpText;


    // login elements
    @FindBy(css = "input[data-qa='login-email']")
    WebElement logInEmailAddress;

    @FindBy(css = "input[data-qa='login-password']")
    WebElement password;

    @FindBy(css = "button[data-qa='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    WebElement logOutButton;


    // signup methods
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

    public void userSignUpWithExistingEmail() {
        waitForsignUpNameIsClickable();
        fillInsignUpEmailAddress(BasePage.email);
        fillInsignUpName(randomString.generateRandomNumLettersLongString(5));
        clicksignUpButton();
    }

    // login methods
    public void fillInloginEmailAddress(String Email) {
        logInEmailAddress.sendKeys(Email);
    }

    public void fillInPassword(String Password) {
        password.sendKeys(Password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void logInWithCorrectCredentials() {
        homePage.clickSignUpLogInButton();
        fillInloginEmailAddress(BasePage.email);
        fillInPassword(BasePage.password);
        clickLoginButton();
    }

    public void logInWithIncorrectCredentials() {
        homePage.clickSignUpLogInButton();
        fillInloginEmailAddress("notcorrectemail@gmail.com");
        fillInPassword("notcorrectpassword");
        clickLoginButton();
    }

    // logOut Method

    public void clickLogOutButton() {
        logOutButton.click();
    }

}

