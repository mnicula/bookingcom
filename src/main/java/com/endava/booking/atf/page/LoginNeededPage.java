package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginNeededPage extends BasePage {

    @FindBy(xpath = "//h3[@id='login-needed-modal-title']")
    WebElement pageHeader;
    @FindBy(xpath = "//span[@class='bui-button__text'][contains(text(),'Sign in')]")
    WebElement signInBtn;
    @FindBy(xpath = "//button[@class='bui-button bui-button--secondary']")
    WebElement cancelBtn;
    public LoginNeededPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return this.pageHeader.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
