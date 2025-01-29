package com.swagLabs.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swagLabs.pageObjects.LogInPage;
import com.swagLabs.testBase.BaseClass;

public class LoginPageElementVerification extends BaseClass
{
	
	//Verify login page elements[All elements (Username, Password, Login button) should be visible on the page.]
	@Test(groups={"Functional","Master"})
	public void verifyLoginPageElements()
	{
		LogInPage logIn = new LogInPage(driver);
		boolean username = logIn.usernameFieldIsDisplayed();
		boolean password =logIn.passwordFieldIsDisplayed();
		boolean loginButton = logIn.loginButtonIsDisplayed();
		Assert.assertTrue(username,"Username field is not visible.");
		Assert.assertTrue(password,"Password field is not visible.");
		Assert.assertTrue(loginButton,"Login button is not visible.");
	}
}
