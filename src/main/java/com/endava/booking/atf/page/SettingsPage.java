package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
//import com.endava.booking.atf.pojo.CardDetailsPojo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.security.PublicKey;

public class SettingsPage extends BasePage {

    @FindBy(xpath = "//div[@id='about-you']//div[contains(@class,'settings-head')]//div[1]")
    public WebElement aboutYou;
    @FindBy(xpath = "//span[contains(text(),'Credit cards')]")
    public WebElement creditCardsForm;
    @FindBy(xpath = "//div[@id='credit-cards']//button[1]")
    public WebElement addCreditCardButton;
    @FindBy(xpath = "//select[@id='cardtype']")
    WebElement cardTypeDropDown;
    @FindBy(xpath = "//select[@name='b_cc_expire_year']")
    WebElement expiryYear;
    @FindBy(id = "cardmonth")
    WebElement expiryMonth;
    @FindBy(xpath = "//button[contains(text(),'Save change')]")
    WebElement saveCreditChangesButton;
    @FindBy(xpath = "//div[@class='static-notification__body static-notification__body--success']")
    public WebElement successfullyAddedCardMsg;

    @FindBy(id = "cardnumber")
    WebElement cardNumber;
    @FindBy(id = "cardholder")
    WebElement cardHolder;


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

    public void selectCardType(String valueToComplete , String expiryMonthValue , String expireYearValue) {
        Select dropdown = new Select ( cardTypeDropDown );
        dropdown.selectByVisibleText ( valueToComplete );
        Select dropdown1 = new Select ( expiryMonth );
        dropdown1.selectByVisibleText ( expiryMonthValue );
        Select dropdown2 = new Select ( expiryYear );
        dropdown2.selectByVisibleText ( expireYearValue );
    }

//    public void completeFields(CardDetailsPojo details) {
//        cardNumber.sendKeys ( details.getCardNumber () );
//        cardHolder.sendKeys ( details.getCardHolder () );
//    }
}
