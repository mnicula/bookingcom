package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TaxiBookingPage extends BasePage {

    public WebDriver driver;
    @FindBy(xpath = "//div[@class='rw-prompt__content']")
    public WebElement warningBookingTaxiMsg;
    @FindBy(xpath = "//select[@id='title']")
    WebElement title;
    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='lastname']")
    WebElement surname;
    @FindBy(xpath = "//input[@id='emailaddress']")
    WebElement email;
    @FindBy(xpath = "//input[@id='verifyemailaddress']")
    WebElement verifyemail;
    @FindBy(xpath = "//input[@id='contactNumber']")
    WebElement phone;
    @FindBy(xpath = "//div[@class='rw-benefits rw-box']")
    WebElement bookingBenefitsTable;
    @FindBy(xpath = "//span[@class='gb-o-btn__content']")
    WebElement continueToBookTaxi;
    @FindBy(xpath = "//div[@id='card-number']")
    WebElement cardNumberLabel;
    @FindBy(xpath = "//input[@id='credit-card-number']")
    WebElement cardNumber;
    @FindBy(xpath = "//input[@id='expiration']")
    WebElement expiryDate;
    @FindBy(xpath = "//input[@id='cvv']")
    WebElement cardCVV;
    @FindBy(xpath = "//span[contains(@class,'gb-o-btn__content')]")
    WebElement bookNowTaxi;

    public TaxiBookingPage(WebDriver driver) {
        super ( driver );
        this.driver = driver;
    }


    @Override
    public boolean isElementDisplayed() {
        try {
            return this.bookingBenefitsTable.isDisplayed ();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterPersonalInfo() {
        Select select = new Select ( title );
        select.selectByValue ( "Mr" );
        firstName.sendKeys ( "TEST" );
        surname.sendKeys ( "AUTOMATION" );
        email.sendKeys ( "test@booking.com" );
        verifyemail.sendKeys ( "test@booking.com" );
        phone.clear ();
        phone.sendKeys ( "+37369691234" );
    }

    public void enterPaymentDetailsForTaxi() {
        driver.switchTo ().frame ( "braintree-hosted-field-number" );
        cardNumber.sendKeys ( "4111111111111111" );
        driver.switchTo ().defaultContent ();
        driver.switchTo ().frame ( "braintree-hosted-field-expirationDate" );
        expiryDate.sendKeys ( "02/20" );
        driver.switchTo ().defaultContent ();
        driver.switchTo ().frame ( "braintree-hosted-field-cvv" );
        cardCVV.sendKeys ( "123" );
        driver.switchTo ().defaultContent ();


    }
}
