package testCases;

import base.AppFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.net.MalformedURLException;

public class LoginTest {

    private LoginPage loginPage;

    @BeforeTest
    public void setup() throws MalformedURLException {
        AppFactory.initializer();
        loginPage = new LoginPage();
    }

    @Test
    public void verifyUserCreation() throws InterruptedException {
        loginPage.clickCreateAccountButton();
        Assert.assertTrue(loginPage.pageHeader.isDisplayed());
        System.out.println("Email Address Page is Displayed");
        loginPage.enterValidEmailAddress();
        loginPage.clickContinueButton();
        Assert.assertTrue((loginPage.createPasswordHeader.isDisplayed()));
        System.out.println("Password Page is Displayed");
        loginPage.enterPassword();
        loginPage.enterConfirmPassword();
        loginPage.clickSignInButton();
        System.out.println("Creating New User Account");
        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        AppFactory.quitDriver();
    }
}
