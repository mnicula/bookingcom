package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class AccommodationsSearchResultsPage extends BasePage {

    @FindBy(id = "hotellist_inner")
    WebElement searchTable;

    @FindBy(xpath="//a[@class = 'hotel_name_link url']")
    List <WebElement> HotelName;


    public AccommodationsSearchResultsPage(WebDriver driver) {
        super(driver);
    }


    public void getHotelName(int i) {
        HotelName.get(i).click();
    }


    @Override
    public boolean isElementDisplayed() {
        try {
            return this.searchTable.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }







}


