package com.swagLabs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage extends BasePage {

    public LogOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Open Menu' or @id='react-burger-menu-btn']")
    private WebElement openMenu;

    public void clickOpenMenuOption() {
        openMenu.click();
    }

    @FindBy(xpath = "//*[@id='logout_sidebar_link' or text()='Logout']")
    private WebElement logOutOption;

    public void clickOnLogOutOption() {
        logOutOption.click();
    }
}
