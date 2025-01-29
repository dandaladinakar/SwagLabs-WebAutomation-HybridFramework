package com.swagLabs.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

    // Constructor to initialize WebDriver
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    // Locate the "Finish" button
    @FindBy(css = "[id=\"finish\"]")
    private WebElement finishBtn;

    // Method to click on the "Finish" button
    public void clickOnFinishButton() {
    //  shoppingCartIcon.click();
   	 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Scroll the element into view
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", finishBtn);
        // Click the element using JavaScript
        jsExecutor.executeScript("arguments[0].click();", finishBtn);
    }

    // Locate the "Cancel" button
    @FindBy(xpath = "//button[@id='cancel']")
    private WebElement cancelBtn;

    // Method to click on the "Cancel" button
    public void clickOnCancelButton() {
        cancelBtn.click();
    }
}
