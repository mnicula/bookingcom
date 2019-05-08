package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AirportTaxiPage extends BasePage {

    @FindBy(xpath = "//input[@id='pickupLocation']")
    public WebElement pickUpLocationTaxi;
    @FindBy(xpath = "//input[@id='dropoffLocation']")
    public WebElement dropOffLocationTaxi;
    @FindBy(xpath = "//button[@name='searchButton']")
    public WebElement searchTaxiButton;
    @FindBy(xpath = "//span[@class='sb-searchbox__title-text']")
    public WebElement taxiPageHeader;
    @FindBy(xpath = "//*[@id=\"pickupLocation-items\"]/li[2]")
    WebElement pickUpTaxiLocation;
    @FindBy(xpath = "//*[@id=\"dropoffLocation-items\"]/li[2]")
    WebElement dropOffTaxiLocation;
    @FindBy(xpath = "//div[@id='rwVerticalSearch']")
    WebElement changeSearchResults;
    @FindBy(xpath = "//body[contains(@class,'rw-ft-remove-branding@on')]/div[contains(@class,'rw-page')]/div[contains(@class,'rw-container__results rw-booking-flow--search-results rw-p-standard')]/div[contains(@class,'rw-container rw-booking-flow')]/div[contains(@class,'rw-booking-flow__right')]/div[contains(@class,'rw-component')]/div[contains(@class,'rw-search-results')]/div/div[1]/div[2]/a[1]/span[1]")
    WebElement firstButtonTaxiSearch;
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

