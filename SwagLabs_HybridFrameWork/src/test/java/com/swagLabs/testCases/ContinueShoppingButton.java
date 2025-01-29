package com.swagLabs.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swagLabs.pageObjects.LogInPage;
import com.swagLabs.pageObjects.ProductPage;
import com.swagLabs.pageObjects.YourCartPage;
import com.swagLabs.testBase.BaseClass;

public class ContinueShoppingButton extends BaseClass {

    // This test case adds items to the cart
    @Test(priority = 1)
    public void addItemsToTheCart() {
       
    	 LogInPage logIn = new LogInPage(driver);
		 logIn.logIn("standard_user", "secret_sauce");
    	
    	ProductPage productPage = new ProductPage(driver);

        // Add items to the cart (Backpack and Red T-shirt)
        productPage.clickBackpackAddtoCart();
        productPage.clickRedTShirtAddtoCart();

        // Navigate to the shopping cart
        productPage.clickShoppingCartIcon();
    }

    // This test case verifies that clicking "Continue Shopping" redirects to the products page
    @Test(dependsOnMethods = "addItemsToTheCart")
    public void testContinueShoppingButton() {
        // Access the YourCartPage object
        YourCartPage yourCart = new YourCartPage(driver);

        // Click the continue shopping button
        yourCart.clickContinueShoppingBtn();

        // Verify if the user is redirected to the product page
        ProductPage page = new ProductPage(driver);
        String url = page.verifyRedirectionToProductPage();

        // Assert that the user is on the correct page
        Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html", "User is not redirected to the correct page");
    }
}
