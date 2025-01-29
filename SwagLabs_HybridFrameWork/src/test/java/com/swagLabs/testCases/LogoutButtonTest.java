package com.swagLabs.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.swagLabs.pageObjects.LogInPage;
import com.swagLabs.pageObjects.LogOutPage;
import com.swagLabs.testBase.BaseClass;

public class LogoutButtonTest extends BaseClass {

    // Test case for logging in
    @Test(priority = 1)
    public void logInFunction() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.logIn("standard_user", "secret_sauce");
    }

    // Test case for logging out functionality
    @Test(dependsOnMethods = "logInFunction")
    public void testLogOutFunctionality() {
        LogOutPage logOutPage = new LogOutPage(driver);
        
        // Click on the menu option
        logOutPage.clickOpenMenuOption();
        
        // Click on the LogOut option
        logOutPage.clickOnLogOutOption();
        
        // Create a LogInPage object to verify if the user is on the login page after logout
        LogInPage logInPage = new LogInPage(driver);
        
        // Get the current URL and verify if it's the login page
        String currentUrl = logInPage.getHomePageUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/");
    }
}
