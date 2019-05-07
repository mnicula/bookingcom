package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SettingsPage extends BasePage {

    @FindBy(xpath = "//div[@id='about-you']//div[contains(@class,'settings-head')]//div[1]")
    public WebElement aboutYou;
    @FindBy(xpath = "//span[contains(text(),'Credit cards')]")
    public WebElement creditCardsForm;
    @FindBy(xpath = "//div[@id='credit-cards']//button[1]")
    public WebElement addCreditCardButton;
    @FindBy(xpath = "//div[@class='static-notification__body static-notification__body--success']")
    public WebElement successfullyAddedCardMsg;
    @FindBy(xpath = "//select[@id='cardtype']")
    WebElement cardTypeDropDown;
    @FindBy(xpath = "//select[@name='b_cc_expire_year']")
    WebElement expiryYear;
    @FindBy(id = "cardmonth")
    WebElement expiryMonth;
    @FindBy(xpath = "//button[contains(text(),'Save change')]")
    WebElement saveCreditChangesButton;
    @FindBy(id = "cardnumber")
    WebElement cardNumber;
    @FindBy(id = "cardholder")
    WebElement cardHolder;
    @FindBy(xpath = "//div[contains(text(),'This is a required field')]")
    public WebElement warningCardType;


    public SettingsPage(WebDriver driver) {
        super ( driver );
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return this.aboutYou.isDisplayed ();
        } catch (Exception e) {
            return false;
        }
    }

    public void completeCardData(String valueToComplete , String expiryMonthValue , String expireYearValue ,
                                 String creditCardNumber , String creditCardHolder) {
        Select dropdown = new Select ( cardTypeDropDown );
        dropdown.selectByVisibleText ( valueToComplete );
        Select dropdown1 = new Select ( expiryMonth );
        dropdown1.selectByVisibleText ( expiryMonthValue );
        Select dropdown2 = new Select ( expiryYear );
        dropdown2.selectByVisibleText ( expireYearValue );
        cardNumber.sendKeys ( creditCardNumber );
        cardHolder.sendKeys ( creditCardHolder );
    }


}
