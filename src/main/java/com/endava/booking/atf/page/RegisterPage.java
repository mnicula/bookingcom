package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//input[@id='login_name_register']")
    WebElement mailInput;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement getStartedButton;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password1Input;
    @FindBy(xpath = "//input[@id='confirmed_password']")
    WebElement password2Input;
    @FindBy(xpath = "//span[@class='bui-button__text']")
    WebElement createAccountButton;
    @FindBy(xpath = "//*[@id=\"wl252-modal-name\"]/div/h1")
    public WebElement confirmationMsg;
    @FindBy(xpath = "//div[@id='login_name_register-error']")
    public WebElement errorMsgMail;
    @FindBy(xpath = "//div[@id='confirmed_password-error']")
    public WebElement errorMsgPassword;

    public RegisterPage(WebDriver driver) {
        super ( driver );
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return this.getStartedButton.isDisplayed ();
        } catch (Exception e) {
            return false;
        }
    }

    public void typeMail(String email) {
        mailInput.sendKeys ( email );
    }
    public void typePass(String pass) {
        password1Input.sendKeys(pass);
    }

    public void typeConfirmPass(String pass) {
        password2Input.sendKeys(pass);
    }
    public void createEmail( String email) {
        typeMail(email);
    }
    public void clickGetStartedButton() {
        getStartedButton.click();
    }
    public void clickCreateAccountButton() {
        createAccountButton.click();
    }
}
