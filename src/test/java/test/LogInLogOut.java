package test;

import base.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.HomePage;
import page.LoginPage;

public class LogInLogOut {

    LoginPage loginPage = new LoginPage();

    HomePage homePage = new HomePage();


    @Test
    void loginUserWithCorrectEmailAndPassword() {

        loginPage.logInWithCorrectCredentials();

        String expected = "Logged in as " + BasePage.name;
        String actual = homePage.getLoggedInAsUsernameText();
        Assertions.assertEquals(expected, actual);

    }


    @Test
    void loginUserWithIncorrectEmailAndPassword() {

        loginPage.logInWithIncorrectCredentials();
        homePage.logInErrorMessageIsDisplayed();
    }

    @Test
    void logOutUser() {

        loginPage.logInWithCorrectCredentials();
        loginPage.clickLogOutButton();
        homePage.signUpLogInButtonIsDisplayed();

    }


    @AfterAll
    static void driverShutDown() {
        BasePage.quit();
    }

}
