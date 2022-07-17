package testCases;

import base.AppFactory;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ExcelUtils;

import java.net.MalformedURLException;

public class LoginTest {

    private LoginPage loginPage;

    @BeforeTest
    public void setup() throws MalformedURLException {
        ExcelUtils.readExcelFile();
        AppFactory.initializer();
        loginPage = new LoginPage();
    }

    @Test
    @Flaky
    @Epic("Booking.com")
    @Feature("Account Creation")
    @Description("From this Test Case User should able to create a New Account")
    @Story("When user should create a New Account for Login into the application")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyUserCreation() throws InterruptedException {
        loginPage.clickCreateAccountButton();
        Assert.assertTrue(loginPage.pageHeader.isDisplayed());
        System.out.println("Email Address Page is Displayed");
        loginPage.enterValidEmailAddress(ExcelUtils.GetCellValue(1, 0));
        loginPage.clickContinueButton();
        Assert.assertTrue((loginPage.createPasswordHeader.isDisplayed()));
        System.out.println("Password Page is Displayed");
        loginPage.enterPassword(ExcelUtils.GetCellValue(1, 1));
        loginPage.enterConfirmPassword(ExcelUtils.GetCellValue(1, 1));
        loginPage.clickSignInButton();
        System.out.println("Creating New User Account");
        Thread.sleep(1000);
    }
    @Test
    @Epic("Booking.com")
    @Feature("Login")
    @Description("From this Test Case User is able to login")
    @Story("When user should able to login into the application")
    @Severity(SeverityLevel.BLOCKER)
    public void sampleTestOne(){
        System.out.println("This is a Sample Test One");
    }
    @Test
    @Epic("Booking.com")
    @Feature("Forget Password")
    @Description("From this Test Case User should able reset new Password")
    @Story("When user should to reset New Password form application")
    @Severity(SeverityLevel.CRITICAL)
    public void sampleTestTwo(){
        System.out.println("This is a Sample Test Two");
    }
    @Test
    @Epic("Booking.com")
    @Feature("Log Out")
    @Description("From this Test Case User should able to logout")
    @Story("When user should Logout form the application")
    @Severity(SeverityLevel.CRITICAL)
    public void sampleTestThree(){
        System.out.println("This is a Sample Test Three");
    }
    @Test
    @Epic("Booking.com")
    @Feature("Delete User")
    @Description("From this Test Case User should able to Delete Account")
    @Story("When user should delete previous user account form the application")
    @Severity(SeverityLevel.CRITICAL)
    public void sampleTestFour(){
        System.out.println("This is a Sample Test Four");
    }
    @Test
    @Epic("Booking.com")
    @Feature("Push Notification")
    @Description("From this Test Case User should able to see the Push Notification")
    @Story("When user should see the Push Notification after deleting account")
    @Severity(SeverityLevel.MINOR)
    public void sampleTestFive(){
        System.out.println("This is a Sample Test Five");
    }

    @AfterTest
    public void tearDown() {
        AppFactory.quitDriver();
    }
}
