package base;

import configurationFileReader.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {

    public static AppiumDriver driver;
    public static DesiredCapabilities capabilities;
    public static ConfigReader configReader;

    public static void initializer() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        configReader = new ConfigReader();
        capabilities.setCapability("platformName", configReader.getPlatformName());
        capabilities.setCapability("platformVersion", configReader.getPlatformVersion());
        capabilities.setCapability("deviceName", configReader.getDeviceName());
        capabilities.setCapability("automationName", configReader.getAutomationName());
        capabilities.setCapability("app", System.getProperty("user.dir") + configReader.getApkPath());
        driver = new AndroidDriver(new URL(configReader.appiumServerEndpointURL()), capabilities);
        AppDriver.setDriver(driver);
        System.out.println("Android driver is set");
    }

    public static void quitDriver() {
        if (null != driver) {
            driver.quit();
        }
    }
}
