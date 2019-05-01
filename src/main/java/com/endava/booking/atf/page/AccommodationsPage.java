package com.endava.booking.atf.page;


import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccommodationsPage extends BasePage {


    @FindBy (xpath = "//button[@data-sb-id='main']")
    private WebElement searchButton;


    public AccommodationsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isElementDisplayed(){
        try {
            return this.searchButton.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

}
