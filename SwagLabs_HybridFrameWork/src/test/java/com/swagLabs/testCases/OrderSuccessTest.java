package com.swagLabs.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.swagLabs.pageObjects.CheckoutCompletePage;
import com.swagLabs.pageObjects.CheckoutOverviewPage;
import com.swagLabs.pageObjects.CheckoutPage;
import com.swagLabs.pageObjects.LogInPage;
import com.swagLabs.pageObjects.ProductPage;
import com.swagLabs.pageObjects.YourCartPage;
import com.swagLabs.testBase.BaseClass;

public class OrderSuccessTest extends BaseClass {

    @Test(priority = 1)
    public void addItemsToCart() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.logIn("standard_user", "secret_sauce");
        
        ProductPage productPage = new ProductPage(driver);
        productPage.clickRedTShirtAddtoCart();
        productPage.clickShoppingCartIcon();
    }

    @Test(dependsOnMethods = "addItemsToCart")
    public void proceedToCheckout() {
        YourCartPage cartPage = new YourCartPage(driver);
        cartPage.clickOnCheckOutBtn();
    }

    @Test(dependsOnMethods = "proceedToCheckout")
    public void enterValidDetailsInCheckout() {
        Faker faker = new Faker();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        
        checkoutPage.setFirstName(faker.name().firstName());
        checkoutPage.setLastName(faker.name().lastName());
        checkoutPage.setPostalCode(faker.address().zipCode());
        checkoutPage.clickOnContinueBtn();
    }

    @Test(dependsOnMethods = "enterValidDetailsInCheckout")
    public void completeCheckoutOverview() {
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
        overviewPage.clickOnFinishButton();
    }

    @Test(dependsOnMethods = "completeCheckoutOverview")
    public void verifyOrderSuccessMessage() {
        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        String successMessage = completePage.getOrderSuccessMessage();
        
        Assert.assertEquals(successMessage, "Thank you for your order!");
        completePage.clickOnBackToHome();
    }
}