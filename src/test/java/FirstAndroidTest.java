import configurationFileReader.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstAndroidTest {

    ConfigReader configReader;

    public FirstAndroidTest() {
        configReader = new ConfigReader();
    }

    //region Appium Driver
    /*#############################################################################################################
    # AppiumDriver : It inherits from the RemoteWebDriver and adds functions that are handy for mobile automation.#
    # It can be used to automate both Android and iOS apps; however, it lacks device family-specific functions.   #
    # The direct subclasses are AndroidDriver , IOSDriver , and WindowsDriver                                     #
    #############################################################################################################*/
    AppiumDriver driver;
    //endregion

    //region Initializer Method
    /*#######################################################################################################################
    # initializer Method : This method is used to define the Desired Capabilities. Desired Capabilities is a class used     #
    # to declare a set of basic requirements such as combinations of browsers, operating systems, browser versions          #
    # Device Platform Name, Platform Version, Device Name etc.                                                              #
    #######################################################################################################################*/

    @BeforeTest
    public void initializer() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", configReader.getPlatformName());
        capabilities.setCapability("platformVersion", configReader.getPlatformVersion());
        capabilities.setCapability("deviceName", configReader.getDeviceName());
        capabilities.setCapability("automationName", configReader.getAutomationName());
        capabilities.setCapability("app", System.getProperty("user.dir") + configReader.getApkPath());
        driver = new AndroidDriver(new URL(configReader.appiumServerEndpointURL()), capabilities);
        System.out.println("Opening Appium Server");
    }
    //endregion

    //region First Sample Test
    @Test
    public void clickAppButton() {
        // Code
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();
    }
    //endregion

    //region TearDown Method
    /*###################################################################################################
    # tearDown blocks registered during a test method's execution are run after that test method ends,  #
    # before the tearDown() instance method is called. tearDown() class method to perform final cleanup #
    # after all test methods complete.                                                                  #
    ###################################################################################################*/
    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
    //endregion
}