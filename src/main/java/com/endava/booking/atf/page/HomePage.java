package com.endava.booking.atf.page;


import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    public JavascriptExecutor jse;
    public WebDriver driver;

    @FindBy (xpath = "//span[contains(text(),'Airport taxis')]")
    public  WebElement airportTaxiButton;
    @FindBy(xpath = "//div[@id='cross-product-bar']//a[2]")
    WebElement carRentals;
    @FindBy(xpath = "//span[@class='header_name user_firstname ge-no-yellow-bg']")
    public WebElement yourAccountBlock;
    @FindBy(xpath = "//*[@id=\"b2indexPage\"]/div[13]/button")
    public WebElement closeButton;
    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    public WebElement signIn;
    @FindBy(xpath = "//div[contains(@class,'profile-menu__item profile_menu__item--mysettings')]")
    public WebElement settingsOption;
    @FindBy(xpath = "//input[@type='search']")
    WebElement locationField;
    @FindBy(xpath = "//span[contains(text(),'Register')]")
    WebElement registerButton;
    @FindBy(xpath = "//div[@class='xp__dates-inner']")
    WebElement dateSelector;
    @FindBy(xpath = "//div[@class='bui-calendar__wrapper']")
    List < WebElement > dateTables;
    @FindBy(xpath = "//td[@class='bui-calendar__date']")
    List < WebElement > dates;
    @FindBy(xpath = "//div[contains(@class,'sb-searchbox-submit-col -submit-button')]//span[contains(text(),'Search')]")
    private WebElement searchButton;
    @FindBy(xpath="//*[@id=\"footer_links\"]/div[3]/ul/li[5]/a")
    WebElement lnk_TravelCommunity;
   




    public HomePage(WebDriver driver) {
        super ( driver );
        jse = (JavascriptExecutor) driver;
        PageFactory.initElements ( driver , this );
        this.driver = driver;
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return this.searchButton.isDisplayed ();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectDate(String date1,String date2) {
        dateSelector.click ();
        for (int i = 0; i <dates.size() ; i++) {
            if(dates.get(i).getText().contains(date1)){
                dates.get(i).click();
                break;
            }
        }

        for (int i = 0; i <dates.size() ; i++) {
            if(dates.get(i).getText().contains(date2)){
                dates.get(i).click();
                break;
            }
        }
    }

    public boolean checkIfUserIsLoggedIn(WebElement obj) {
        try {
            if (obj.getText () != null) return true;
            else return false;
        } catch (Exception e) {
            return false;
        }
    }

}
