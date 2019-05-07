package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CarBookingPage extends BasePage {


    @FindBy(xpath="//a[@id='bookCta']")
    WebElement goToBook;
    @FindBy(xpath="//select[@id='title']")
    WebElement title;
    @FindBy(xpath="//input[@id='f_name_input']")
    WebElement firstName;
    @FindBy(xpath="//input[@id='surname_input']")
    WebElement surname;
    @FindBy(xpath="//input[@id='booking-form-email']")
    WebElement email;
    @FindBy(xpath="//input[@id='phone_input']")
    WebElement phone;
    @FindBy(xpath="//a[@id='btn-submit-dd']")
    WebElement bookNow;
    @FindBy(xpath="//input[@id='cardName_input']")
    WebElement nameOnCard;
    @FindBy(xpath="//input[@id='cardNumber_input']")
    WebElement cardNumber;
    @FindBy(xpath="//input[@id='cardCCV_input']")
    WebElement cardCVV;
    @FindBy(xpath="//input[@id='cardCCV']")
    WebElement cardCVV2;
    @FindBy(xpath="//a[@id='pa-iframe']")
    WebElement BookNow;

    public JavascriptExecutor jse;
    public WebDriver driver;
    public CarBookingPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
        this.driver = driver; }


    @Override
    public boolean isElementDisplayed() {
        try {
            String header = "Car hire";
            return goToBook.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


   private void scrollToFind(WebElement element) throws InterruptedException {
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickToBook() throws InterruptedException {
        scrollToFind(goToBook);
        goToBook.click();
    }
    public void clickBookNow() throws InterruptedException {
        scrollToFind(bookNow);
        bookNow.click();
    }

    public void enterPersonalInfo(){
        Select select = new Select(title);
        select.selectByValue("Mr");
        firstName.sendKeys("TEST");
        surname.sendKeys("AUTOMATION");
        email.sendKeys("test@booking.com");
        phone.sendKeys("+37369691234");
    }

    public void enterPaymentDetails(){
        if(driver.getCurrentUrl().contains("error")){
          driver.navigate().refresh(); }
        else {
        driver.switchTo().frame(0);
        Select paymentMethod = new Select(driver.findElement(By.xpath("//select[@id='cardType_input']")));
        paymentMethod.selectByValue("1");}
        nameOnCard.sendKeys("TEST AUTOMATION");
        nameOnCard.sendKeys(Keys.TAB);
        cardNumber.sendKeys("4444444444444448");
        Select month = new Select(driver.findElement(By.xpath("//select[@id='cardExpiryMonth']")));
        month.selectByValue("06");
        Select year = new Select(driver.findElement(By.xpath("//select[@id='cardExpiryYear']")));
        year.selectByValue("2020");
        cardCVV.click();
        cardCVV2.sendKeys("123");
        cardCVV2.sendKeys(Keys.TAB);
        driver.switchTo().defaultContent();
    }
}

