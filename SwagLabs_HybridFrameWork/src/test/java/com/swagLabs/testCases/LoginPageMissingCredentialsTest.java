package com.swagLabs.testCases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.swagLabs.pageObjects.LogInPage;
import com.swagLabs.testBase.BaseClass;

public class LoginPageMissingCredentialsTest extends BaseClass
{

	
    
	@Test(priority = 1,groups={"Functional","Master"})
	public void verifyLoginWithMissingUsernameAndPassword()
	{
		LogInPage logIn = new LogInPage(driver);
		logIn.logIn("TestDemo", "");
		String msg1 = logIn.getEmptyPasswordErrorMessage();
		AssertJUnit.assertEquals(msg1, "Epic sadface: Password is required");
		
	
	}
	
	
	@Test(priority = 2,groups={"Functional","Master"})
	public void verifyLoginWithMissingPassword() 
	{
		LogInPage logIn = new LogInPage(driver);
		logIn.logIn("", "TestDemo");
        String msg = logIn.getEmptyPasswordErrorMessage();
		AssertJUnit.assertEquals(msg,"Epic sadface: Username is required");
		
		
	}
}
