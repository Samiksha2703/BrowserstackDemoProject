package com.bridgelabz.browserstack.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class Base {
    public static WebDriver driver = null;
    public static final String AUTOMATE_USERNAME = "samikshashende_SUKp6E";
    public static final String AUTOMATE_ACCESS_KEY = "HFk9ojAWFYqy1QefNqqq";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    static Logger logger = Logger.getLogger(Base.class.getName());
    //method to launch browser
    @BeforeTest
    public static WebDriver setUp() throws MalformedURLException, InterruptedException {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "iPhone");
            caps.setCapability("device", "iPhone 11");
            caps.setCapability("realMobile", "true");
            caps.setCapability("os_version", "14.0");
            caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
            caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
        int retryAttempt = 0;
        int retryCount = 5;
        while(retryAttempt<=retryCount){
            retryAttempt++;
            try{
                driver = new RemoteWebDriver(new URL(URL), caps);
                return driver;
            }
            catch(UnreachableBrowserException e){
                Thread.sleep(10000);
                if(retryAttempt>retryCount){
                    logger.info("Remote Web Driver cannot be reached at this moment");
                }
            }
        }
        // launch application
        driver.get("https://tpcindia.com/");
        return driver;
    }

    //method to close the session open by driver
    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
