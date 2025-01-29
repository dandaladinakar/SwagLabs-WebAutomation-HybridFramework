package com.swagLabs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement txtFirstName;

    public void setFirstName(String fName) {
        txtFirstName.sendKeys(fName);
    }

    @FindBy(xpath = "//input[@id='last-name' or name='last-name']")
    private WebElement txtLastName;

    public void setLastName(String lName) {
        txtLastName.sendKeys(lName);
    }

    @FindBy(xpath = "//input[@id='postal-code' or name='postal-code']")
    private WebElement txtPostalCode;

    public void setPostalCode(String postalCode) {
        txtPostalCode.sendKeys(postalCode);
    }

    @FindBy(xpath = "//input[@id='continue' or name='continue']")
    private WebElement continueBtn;

    public void clickOnContinueBtn() {
        continueBtn.click();
    }

    @FindBy(xpath = "//button[@id='cancel' or name='cancel']")
    private WebElement cancelBtn;

    public void clickOnCancelBtn() {
        cancelBtn.click();
    }
    
   
}
