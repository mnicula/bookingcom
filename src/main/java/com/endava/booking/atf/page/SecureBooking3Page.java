package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.apache.http.HttpHeaders.TIMEOUT;

public class SecureBooking3Page extends BasePage {

    public JavascriptExecutor jse;
    public WebDriver driver;

    @FindBy(xpath = "//input[@id='cc_cvc_2673423401']")
    WebElement cvcCode;

    @FindBy(xpath = "//button[@name='book']//ins[@class='submit_holder_button_text_wrap']")
    WebElement completeBooking;

    @FindBy(xpath = "//span[@id='label_cc_month']")
    WebElement expirationDate;


    public SecureBooking3Page(WebDriver driver) {
        super ( driver );
        jse = (JavascriptExecutor) driver;
        PageFactory.initElements ( driver , this );
        this.driver = driver;
    }

    public void ScrollDownAndFillInIf(String cvc) {
        jse.executeScript("arguments[0].scrollIntoView();", expirationDate);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        Boolean isPresent = driver.findElements(By.xpath("//input[@id='cc_cvc_2673423401']")).size() > 0;
        if (isPresent == true)  cvcCode.sendKeys(cvc);
    }


    public void waitForUrlContains(String expectedString, WebDriver driver, int TIMEOUT) {
        waitForUrlContains(expectedString, driver, TIMEOUT);
    }


    public void ScrollDownAndPressButton() {
        jse.executeScript("arguments[0].scrollIntoView();", completeBooking);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        jse.executeScript("arguments[0].click();", completeBooking);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Override
    public boolean isElementDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (jse).executeScript("return document.readyState").equals("complete");
            }
        });

        try {
            return driver.getCurrentUrl().equals("https://secure.booking.com/book.html");
        } catch (Exception e){
            return false;
        }
    }



}
