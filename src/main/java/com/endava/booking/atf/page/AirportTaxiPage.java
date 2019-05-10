package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AirportTaxiPage extends BasePage {

    @FindBy(xpath = "//input[@id='pickupLocation']")
    WebElement pickUpLocationTaxi;
    @FindBy(xpath = "//input[@id='dropoffLocation']")
    WebElement dropOffLocationTaxi;
    @FindBy(xpath = "//button[@name='searchButton']")
    WebElement searchTaxiButton;
    @FindBy(xpath = "//span[@class='sb-searchbox__title-text']")
    public WebElement taxiPageHeader;
    @FindBy(xpath = "//*[@id=\"pickupLocation-items\"]/li[2]")
    WebElement firstPickUpTaxiLocation;
    @FindBy(xpath = "//*[@id=\"dropoffLocation-items\"]/li[2]")
    WebElement firstDropOffTaxiLocation;
    @FindBy(xpath = "//div[contains(@class,'rw-search-results')]//div[1]//div[2]//a[1]")
    WebElement bookTaxiButton;


    public AirportTaxiPage(WebDriver driver) {
        super ( driver );
    }


    @Override
    public boolean isElementDisplayed() {
        try {
            return this.taxiPageHeader.isDisplayed ();
        } catch (Exception e) {
            return false;
        }
    }


}

