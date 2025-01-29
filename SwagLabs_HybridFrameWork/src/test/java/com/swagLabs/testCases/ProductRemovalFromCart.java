package com.swagLabs.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swagLabs.pageObjects.LogInPage;
import com.swagLabs.pageObjects.ProductPage;
import com.swagLabs.pageObjects.YourCartPage;
import com.swagLabs.testBase.BaseClass;

public class ProductRemovalFromCart extends BaseClass
{
	
	 @Test(priority = 1)
	 public void addItemsToTheCart()  
	 {
		 LogInPage logIn = new LogInPage(driver);
		 logIn.logIn("standard_user", "secret_sauce");
		 ProductPage productPage =new ProductPage(driver);
		 
		 productPage.clickRedTShirtAddtoCart();
		 productPage.clickShoppingCartIcon();
	 }
	 
	 @Test(dependsOnMethods = "addItemsToTheCart")
	 public void removeItemsToTheCart() throws InterruptedException  
	 {
		 YourCartPage youcart = new YourCartPage(driver);
		 
		 youcart.clickOnRemoveRedTShirtFromCart();
		 
		 String getText = youcart.getRedTShirtText();
		 Assert.assertNotEquals(getText, "Test.allTheThings() T-Shirt (Red)");
	 }

}
