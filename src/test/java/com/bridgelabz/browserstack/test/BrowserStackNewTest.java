package com.bridgelabz.browserstack.test;

import com.bridgelabz.browserstack.pages.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserStackNewTest {
    static Home home;
    public static final String AUTOMATE_USERNAME = "samikshashende_SUKp6E";
    public static final String AUTOMATE_ACCESS_KEY = "HFk9ojAWFYqy1QefNqqq";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "iPhone");
        caps.setCapability("device", "iPhone 11");
        caps.setCapability("realMobile", "true");
        caps.setCapability("os_version", "14.0");
        caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://tpcindia.com/");
        home = new Home(driver);
        home.displayTrackingDetails(driver);
        home.loginIntoAccount(driver);
        home.navigateToPreviousPage(driver);
        driver.quit();
    }
}
