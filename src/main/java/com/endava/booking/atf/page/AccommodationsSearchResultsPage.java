package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class AccommodationsSearchResultsPage extends BasePage {

    public JavascriptExecutor jse;
    public WebDriver driver;

    @FindBy(id = "hotellist_inner")
    WebElement searchTable;

    @FindBy(xpath = "//a[@class = 'hotel_name_link url']")
    List <WebElement> AccommodationName;

    @FindBy(xpath = "//button[@id='bh_banner_filter']")
    WebElement showVacationRentals;


    public AccommodationsSearchResultsPage(WebDriver driver) {
        super ( driver );
        jse = (JavascriptExecutor) driver;
        PageFactory.initElements ( driver , this );
        this.driver = driver;
    }


    public void getHotelName(int i) {
        AccommodationName.get(i).click();
    }


    public void FilterDealsByPressingButton() throws InterruptedException {
        jse.executeScript("arguments[0].scrollIntoView();", showVacationRentals);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        jse.executeScript("arguments[0].click();", showVacationRentals);
        //wait.until(ExpectedConditions.elementToBeClickable(AccommodationName.get(0)));
        Thread.sleep(6000);
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


