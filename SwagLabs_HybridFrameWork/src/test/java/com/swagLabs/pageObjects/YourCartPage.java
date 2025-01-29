package com.swagLabs.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage {

    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a[contains(@class,'shopping_cart_link')]")
    private WebElement shoppingCartIcon;

    public void clickShoppingCartIcon() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250)", ""); // Scrolls the page if needed
        js.executeScript("arguments[0].click();", shoppingCartIcon); // Click the cart icon
    }

    @FindBy(xpath = "//button[@id='checkout' or @name='checkout']")
    private WebElement checkOutBtn;

    public void clickOnCheckOutBtn() {
        checkOutBtn.click();
    }

    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continueShoppingBtn;

    public void clickContinueShoppingBtn() {
       
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("window.scrollBy(0, 250)", ""); // Scrolls the page if needed
         js.executeScript("arguments[0].click();", continueShoppingBtn); // Click the cart icon
    	
    	
    }

    @FindBy(xpath = "//*[text()='Sauce Labs Backpack']")
    private WebElement getBackPack;

    public String getBackPackText() {
        try {
            return getBackPack.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @FindBy(xpath = "//button[text()='Remove'][@id='remove-test.allthethings()-t-shirt-(red)']")
    private WebElement removeRedTShirt;

    public void clickOnRemoveRedTShirtFromCart() {
        removeRedTShirt.click();
    }

    @FindBy(xpath = "//div[text()='Test.allTheThings() T-Shirt (Red)']")
    private WebElement getRedTShirtText;

    public String getRedTShirtText() {
        try {
            return getRedTShirtText.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
