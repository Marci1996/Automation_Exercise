package page;

import base.BasePage;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import test.RegisterUser;


public class CreateAccountPage extends BasePage {



    HomePage homePage = new HomePage();
    @FindBy(css = "input[data-qa='password']")
    WebElement password;
    @FindBy(css = "input[data-qa='first_name']")
    WebElement firstName;

    @FindBy(css = "input[data-qa='last_name']")
    WebElement lastName;

    @FindBy(css = "input[data-qa='address']")
    WebElement address;

    @FindBy(css = "button[data-qa='create-account']")
    WebElement createButton;

    @FindBy(css = "select[data-qa='country']")
    WebElement selectCountry;

    @FindBy(css = "input[data-qa='state']")
    WebElement state;

    @FindBy(css = "input[data-qa='city']")
    WebElement city;

    @FindBy(css = "input[data-qa='zipcode']")
    WebElement zipcode;

    @FindBy(css = "input[data-qa='mobile_number']")
    WebElement mobileNumber;


    @FindBy(css = "h2[data-qa='account-created']")
    WebElement accountCreatedText;

    @FindBy(css = "a[data-qa='continue-button']")
    WebElement continueButton;

    @FindBy(id = "dismiss-button")
    WebElement innerFrameCloseButton;


    public void waitForFirstNameFieldIsClickable() {
        firstName = wait.until(ExpectedConditions.elementToBeClickable(firstName));
    }

    public void fillPasswordField(String Password) {
        password.sendKeys(Password);
    }

    public void fillFirstNameField(String FirstName) {
        firstName.sendKeys(FirstName);
    }

    public void fillLastNameField(String LastName) {
        lastName.sendKeys(LastName);
    }

    public void fillAddressField(String Address) {
        address.sendKeys(Address);
    }

    public void selectCountry(String country) {
        Select dropdown = new Select(selectCountry);
        dropdown.selectByVisibleText(country);
    }

    public void fillState(String State) {
        state.sendKeys(State);
    }

    public void fillCity(String City) {
        city.sendKeys(City);
    }

    public void fillZipcode(String zipCode) {
        zipcode.sendKeys(zipCode);
    }

    public void fillMobileNumber(String MobileNumber) {
        mobileNumber.sendKeys(MobileNumber);
    }

    public void clickCreateButton() {
        createButton.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickContinueButtonAndNavigatedBackToTheMainSiteFromMultipleIframe(String ParentFrame, String ChildFrame) {

        clickContinueButton();

        try {
            driver.switchTo().frame(ParentFrame).switchTo().frame(ChildFrame);
            System.out.println("Navigated to innerframe with id " + ChildFrame
                    + "which is present on frame with id" + ParentFrame);
        } catch (NoSuchFrameException e) {
            System.out.println("Unable to locate frame with id " + ParentFrame
                    + " or " + ChildFrame + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to navigate to innerframe with id "
                    + ChildFrame + "which is present on frame with id"
                    + ParentFrame + e.getStackTrace());
        }

        clickInnerFrameCloseButton();
    }

    public void clickInnerFrameCloseButton() {
        innerFrameCloseButton.click();
    }


    public void fillEnterAccountInformationPage() {
        waitForFirstNameFieldIsClickable();
        fillPasswordField("password");
        fillFirstNameField("Jane");
        fillLastNameField("Doe");
        fillAddressField("dasdmas");
        selectCountry("Canada");
        fillState("fsdf");
        fillCity("Quebec");
        fillZipcode("312453387");
        fillMobileNumber("06809136677");
        clickCreateButton();
    }


    public String getAccountCreatedText() {
        return accountCreatedText.getText();
    }



}
