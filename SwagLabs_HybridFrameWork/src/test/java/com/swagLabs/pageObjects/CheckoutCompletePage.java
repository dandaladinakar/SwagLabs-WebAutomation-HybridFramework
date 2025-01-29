package com.swagLabs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    // Constructor to initialize WebDriver
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    // Locate the "Back to Home" button
    @FindBy(xpath = "//button[@id='back-to-products' or name='back-to-products']")
    WebElement backToHomeBtn;

    // Method to click on the "Back to Home" button
    public void clickOnBackToHome() {
        backToHomeBtn.click();
    }

    // Locate the success message element
    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    WebElement getSuccessMess;

    // Method to get the order success message
    public String getOrderSuccessMessage() {
        try {
            return getSuccessMess.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
