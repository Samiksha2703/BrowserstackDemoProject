package com.bridgelabz.browserstack.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    @FindBy(xpath = "//input[@placeholder='Enter tracking number']")
    WebElement trackingNumberBox;

    @FindBy(xpath = "//button[text()='SEARCH']")
    WebElement searchButton;

    @FindBy(xpath = "//a[@href='Admin/signin.aspx']")
    WebElement loginButton;

    @FindBy(id = "btnLogin")
    WebElement signInButton;


    public Home(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void displayTrackingDetails(WebDriver driver) throws InterruptedException {
        searchButton.click();
        Thread.sleep(300);
        driver.switchTo().alert().accept();
        trackingNumberBox.sendKeys("454654654545");
        searchButton.click();
    }

    public void loginIntoAccount(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", loginButton);
        signInButton.click();
        driver.switchTo().alert().accept();
    }

    public void navigateToPreviousPage(WebDriver driver){
        driver.navigate().back();
    }
    }
