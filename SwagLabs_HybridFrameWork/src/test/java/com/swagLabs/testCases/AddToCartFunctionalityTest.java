package com.swagLabs.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swagLabs.pageObjects.LogInPage;
import com.swagLabs.pageObjects.ProductPage;
import com.swagLabs.testBase.BaseClass;

public class AddToCartFunctionalityTest extends BaseClass {

   // This test case checks if items are added to the cart correctly
	
    @Test(groups = {"Regression", "Master"})
    public void addItemsToTheCart() {
        
 	
    	LogInPage logIn = new LogInPage(driver);
    	
    	logIn.logIn("standard_user", "secret_sauce");
    	
		// Create an object of the ProductPage class to access its methods
        ProductPage productPage = new ProductPage(driver);
        
        // Adding Backpack and Red T-shirt to the cart
        productPage.clickBackpackAddtoCart();
        productPage.clickRedTShirtAddtoCart();

        // Navigate to the shopping cart
        productPage.clickShoppingCartIcon();

        // Get the current order count in the cart and verify if it's 2
        String orderCount = productPage.getOrderCount();
        Assert.assertEquals(orderCount, "2", "Order count does not match the expected value!");
    }
}
