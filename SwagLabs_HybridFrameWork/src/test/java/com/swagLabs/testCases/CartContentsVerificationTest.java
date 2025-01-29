package com.swagLabs.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swagLabs.pageObjects.LogInPage;
import com.swagLabs.pageObjects.ProductPage;
import com.swagLabs.pageObjects.YourCartPage;
import com.swagLabs.testBase.BaseClass;

public class CartContentsVerificationTest extends BaseClass

{
	

	 
	 @Test(groups={"Regression","Master"})
	 public void addItemsToTheCart()  
	 {
		 LogInPage logIn = new LogInPage(driver);
		 logIn.logIn("standard_user", "secret_sauce");
		 ProductPage productPage =new ProductPage(driver);
		 productPage.clickBackpackAddtoCart();
		 productPage.clickRedTShirtAddtoCart();
		 productPage.clickShoppingCartIcon();
	     String ordercount = productPage.getOrderCount();
		 Assert.assertEquals(ordercount,"2");
	 }
	 @Test(dependsOnMethods ="addItemsToTheCart",groups={"EndToEnd","Master"})
	 
	 public void testProductsAreDisplayed()
	 {
		 YourCartPage yourCart = new YourCartPage(driver);
		 
		String backPackTextName1 = yourCart.getBackPackText();
		Assert.assertEquals(backPackTextName1,"Sauce Labs Backpack");
	 }
}
