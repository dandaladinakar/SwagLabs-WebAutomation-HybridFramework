package com.swagLabs.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swagLabs.pageObjects.LogInPage;
import com.swagLabs.testBase.BaseClass;

//Verify login with valid credentials
//Verify login button functionality
public class LoginPageTest extends BaseClass
{
    @Test()
	public void verifyLoginWithValidCredentials()
	{
		LogInPage logIn = new LogInPage(driver);
		//User should be successfully logged in and redirected to the inventory page.
		logIn.setUsername("standard_user");
		logIn.setPassword("secret_sauce");
		//Login button should redirect to the inventory page after clicking.
		logIn.clickLogInButton();
		String url = logIn.getHomePageUrl();
		Assert.assertEquals(url,"https://www.saucedemo.com/inventory.html");
	}
}
