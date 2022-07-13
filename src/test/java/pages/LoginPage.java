package pages;

import base.AppDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.Button")
    public WebElement createAccountButton;

    @FindBy(id = "com.booking:id/identity_header_title")
    public WebElement pageHeader;

    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public WebElement emailAddress;

    @FindBy(id = "com.booking:id/identity_landing_social_button_text")
    public WebElement continueButton;

    @FindBy(id = "com.booking:id/identity_header_title")
    public WebElement createPasswordHeader;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
    public WebElement password;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
    public WebElement confirmPassword;

    @FindBy(id = "com.booking:id/identity_landing_social_button_text")
    public WebElement signInButton;

    By by_createAccountButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.Button");
    By by_pageHeader = By.id("com.booking:id/identity_header_title");
    By by_confirmPasswordField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");

    public void clickCreateAccountButton() {
        new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(by_createAccountButton));
        createAccountButton.click();
    }

    public void enterValidEmailAddress() {
        new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(by_pageHeader));
        emailAddress.sendKeys("appiumDemoTest002@mailinator.com");
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void enterPassword() {
        new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(by_confirmPasswordField));
        password.sendKeys("Thunder27$");
    }

    public void enterConfirmPassword() {
        confirmPassword.sendKeys("Thunder27$");
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
