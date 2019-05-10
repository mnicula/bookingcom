package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetawayDealsPage extends BasePage {

    public JavascriptExecutor jse;
    public WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(),'The Great Getaway Sale')]")
    WebElement greatGetawaySaleHeader;

    @FindBy(xpath = "//h1[contains(text(),'Rome')]")
    WebElement romeCardImage;



    public GetawayDealsPage(WebDriver driver) {
        super ( driver );
        jse = (JavascriptExecutor) driver;
        PageFactory.initElements ( driver , this );
        this.driver = driver;
    }


    @Override
    public boolean isElementDisplayed() {
        try {
            return this.greatGetawaySaleHeader.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }





}
