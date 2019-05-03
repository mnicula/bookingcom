package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//h4[@class='bui_font_display_two bui_font_heading--bold bui-spacer--medium nw-step-header']")
    public WebElement signInHeader;
    @FindBy(xpath = "//button[@class='bui-button bui-button--primary bui-button--large bui-button--wide']")
    WebElement nextSignInButton;
    @FindBy(xpath = "//input[@id='username']")
    WebElement emailSignIn;
    @FindBy(xpath = "//input[@id='username']")
    WebElement passwordSignIn;
    @FindBy(xpath = "//span[@class='bui-button__text']")
    WebElement signInButton;


    public LoginPage(WebDriver driver) {
        super ( driver );
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return this.signInHeader.isDisplayed ();
        } catch (Exception e) {
            return false;
        }
    }
}
