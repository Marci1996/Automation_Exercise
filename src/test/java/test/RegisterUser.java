package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.CreateAccountPage;
import page.HomePage;
import page.LoginPage;

public class RegisterUser {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    CreateAccountPage createAccountPage = new CreateAccountPage();

    @Test
    void RegisterUser() {

        String expected = "Automation Exercise";
        String actual = loginPage.getTitle();
        Assertions.assertEquals(expected, actual);

        homePage.clickSignUpLogInButton();

        String expected_ = "New User Signup!";
        String actual_ = loginPage.getNewUserSignUpText();
        Assertions.assertEquals(expected_, actual_);

        loginPage.newUserSignUp();

        createAccountPage.fillEnterAccountInformationPage();

        String expected__ = "ACCOUNT CREATED!";
        String actual__ = createAccountPage.getAccountCreatedText();
        createAccountPage.getAccountCreatedText();
        Assertions.assertEquals(expected__, actual__);

        createAccountPage.clickContinueButton();
        createAccountPage.navigatedBackToTheMainSiteFromMultipleIframe("aswift_1", "ad_iframe");
        createAccountPage.clickInnerFrameCloseButton();

        String expected___ = "Logged in as Jane Doe";
        String actual___ = homePage.getLoggedInAsUsernameText();
        Assertions.assertEquals(expected___, actual___);

        homePage.clickDeleteAccount();

        String expected____ = "ACCOUNT DELETED!";
        String actual____ = homePage.getAccountDeletedText();
        Assertions.assertEquals(expected____, actual____);


    }

}
