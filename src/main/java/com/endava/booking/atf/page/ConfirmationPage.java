package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends BasePage {

    public JavascriptExecutor jse;
    public WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        super ( driver );
        jse = (JavascriptExecutor) driver;
        PageFactory.initElements ( driver , this );
        this.driver = driver;
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return driver.getCurrentUrl().contains("https://secure.booking.com/confirmation");
        } catch (Exception e){
            return false;
        }
    }


}
