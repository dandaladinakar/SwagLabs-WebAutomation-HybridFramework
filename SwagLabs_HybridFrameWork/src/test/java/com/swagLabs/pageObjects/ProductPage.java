package com.swagLabs.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement backpackAddtoCart;

    public void clickBackpackAddtoCart() {
        backpackAddtoCart.click();
    }

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    private WebElement backpackText;

    public String getBagDetails() {
        try {
            return backpackText.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
    private WebElement redshirtAddtoCart;

    public void clickRedTShirtAddtoCart() {
        redshirtAddtoCart.click();
    }

    @FindBy(css = "[data-test='shopping-cart-link']")
    private WebElement shoppingCartIcon;

    public void clickShoppingCartIcon() {
      //  shoppingCartIcon.click();
    	 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
         // Scroll the element into view
         jsExecutor.executeScript("arguments[0].scrollIntoView(true);", shoppingCartIcon);
         // Click the element using JavaScript
         jsExecutor.executeScript("arguments[0].click();", shoppingCartIcon);
    }

    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continueShoppingBtn;

    public void clickContinueShoppingBtn() {
        continueShoppingBtn.click();
    }

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement selectingFilterDropdown;

    public void selectNameAtoZFilter() {
        selectFilter("Name (A to Z)");
    }

    public void selectNameZtoAFilter() {
        selectFilter("Name (Z to A)");
    }

    public void selectLowtoHighFilter() {
        selectFilter("Price (low to high)");
    }

    public void selectHighToLowFilter() {
        selectFilter("Price (high to low)");
    }

    private void selectFilter(String filter) {
        selectingFilterDropdown.click();
        Select select = new Select(selectingFilterDropdown);
        select.selectByVisibleText(filter);
    }

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement orderCount;

    public String getOrderCount() {
        try {
            return orderCount.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // Method to verify that the user is redirected to the product page
    public String verifyRedirectionToProductPage() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
