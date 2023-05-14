package page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[@href='/login']")
    WebElement SignUpLogInButton;


  //  @FindBy(xpath = "//div[contains(@class, shop-menu)]/ul/[10]")
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
    WebElement loggedInAsUsername;


    //div[contains(@class, shop-menu)]/ul/[5]
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
    WebElement deleteAccount;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    WebElement accountDeletedText;


    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/p")
    WebElement logInErrorMessage;


    public void clickSignUpLogInButton() {
        SignUpLogInButton.click();
    }

    public void clickDeleteAccount() {
        deleteAccount.click();
    }

    public String getLoggedInAsUsernameText() {
        return loggedInAsUsername.getText();
    }

    public String getAccountDeletedText() {
        return accountDeletedText.getText();
    }

    public void logInErrorMessageIsDisplayed() {
        logInErrorMessage.isDisplayed();
    }
}
