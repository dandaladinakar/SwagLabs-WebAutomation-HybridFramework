package com.swagLabs.testCases;

import org.testng.annotations.Test;

import com.swagLabs.pageObjects.LogInPage;
import com.swagLabs.pageObjects.LogOutPage;
import com.swagLabs.pageObjects.ProductPage;
import com.swagLabs.testBase.BaseClass;

public class ProductDetailsVerificationTest extends BaseClass

{
	
	
	
@Test(dependsOnMethods="verifyLoginWithValidCredentials")
	public void applyAllSortingFilters() 
	{
	 LogInPage logIn = new LogInPage(driver);
	 logIn.logIn("standard_user", "secret_sauce");
		ProductPage productPage = new ProductPage(driver);
		
		productPage.selectNameZtoAFilter();
		productPage.selectNameAtoZFilter();
		productPage.selectHighToLowFilter();
		productPage.selectLowtoHighFilter();
		
		LogOutPage logout = new LogOutPage(driver);
		logout.clickOpenMenuOption();
		logout.clickOnLogOutOption();
	}
}
