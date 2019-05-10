package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecureBooking2Page extends BasePage {

    public JavascriptExecutor jse;
    public WebDriver driver;


    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastName;

    @FindBy(xpath = "//button[@name='book']")
    WebElement nextFinalDetailsButton;



    public SecureBooking2Page(WebDriver driver) {
        super ( driver );
        jse = (JavascriptExecutor) driver;
        PageFactory.initElements ( driver , this );
        this.driver = driver;
    }

    public void ScrollDownAndPressButton() {
        jse.executeScript("arguments[0].scrollIntoView();", nextFinalDetailsButton);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        jse.executeScript("arguments[0].click();", nextFinalDetailsButton);
    }




    @Override
    public boolean isElementDisplayed() {
        try {
            return driver.getCurrentUrl().contains("https://secure.booking.com/book.html?hotel_id");
        } catch (Exception e){
            return false;
        }
    }



}
