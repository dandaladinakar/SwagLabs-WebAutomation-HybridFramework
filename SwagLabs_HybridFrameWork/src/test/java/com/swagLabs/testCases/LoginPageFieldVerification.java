package com.swagLabs.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.swagLabs.pageObjects.LogInPage;
import com.swagLabs.testBase.BaseClass;

//Verify username field and password field

public class LoginPageFieldVerification extends BaseClass
{

	public static String username;
	public static String password;
	
	@Test(groups={"Functional","Master"})
	public void verifyLoginPageFieldVerification() 
	{
		Faker faker;
		LogInPage logIn;
		faker = new Faker();
		logIn = new LogInPage(driver);
		
		// Generate random username and password using Faker
		username = faker.name().firstName();
		password = faker.name().lastName();
		
       //Username should be entered correctly without issues.
		logIn.setUsername(username);
       //Password should be entered correctly without issues.
		logIn.setPassword(password);
		
		// Trace the values entered into the fields
		
        logger.info("Username entered: " + logIn.getUsernameAttribute());
        logger.info("Username entered: " + logIn.getUsernameAttribute());
        
	}
}
