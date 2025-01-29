package com.swagLabs.pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement txtUsername;

    @FindBy(xpath = "//input[@id='password' or name='password']")
    private WebElement txtPassword;

    @FindBy(xpath = "//input[@id='login-button' or name='login-button']")
    private WebElement logInbtn;

    @FindBy(xpath = "//h3[text()='Epic sadface: Sorry, this user has been locked out.']")
    private WebElement errorMsg;

    @FindBy(xpath = "//h3[text()='Epic sadface: Username is required']")
    private WebElement emptyUsernameAndPassword;

    @FindBy(xpath = "//h3[text()='Epic sadface: Password is required']")
    private WebElement emptyPassword;

    @FindBy(xpath = "//h3[text()='Epic sadface: Username is required']")
    private WebElement emptyUsername;

    public void logIn(String uname, String pwd) {
        txtUsername.sendKeys(uname);
        txtPassword.sendKeys(pwd);
        logInbtn.click();
    }

    public void setUsername(String uname) {
    	txtUsername.sendKeys(uname);
    }

    public String getUsernameAttribute() {
        return txtUsername.getAttribute("value");
    }

    public boolean usernameFieldIsDisplayed() {
        return txtUsername.isDisplayed();
    }

    public void clearUsernameData() {
        txtUsername.clear();
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void clearPasswordData() {
        txtPassword.clear();
    }

    public String getPasswordAttribute() {
        return txtPassword.getAttribute("value");
    }

    public boolean passwordFieldIsDisplayed() {
        return txtPassword.isDisplayed();
    }

    public void clickLogInButton() {
        logInbtn.click();
    }

    public boolean loginButtonIsDisplayed() {
        return logInbtn.isDisplayed();
    }

    public String getInvalidCredentialsErrorMessage() {
        try {
            return errorMsg.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getEmptyUsernameAndPasswordErrorMessage() {
        try {
            return emptyUsernameAndPassword.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getEmptyPasswordErrorMessage() {
        try {
            return emptyPassword.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getEmptyUsernameErrorMessage() {
        try {
            return emptyUsername.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getHomePageUrl() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public boolean isLoginSuccessful() {
        try {
            // Check for an element that confirms the user is logged in, like a profile icon
            return driver.findElement(By.id("logoutButton")).isDisplayed();
        } catch (NoSuchElementException e) {
            // If the element isn't found, the login failed
            return false;
        }
    }
}
