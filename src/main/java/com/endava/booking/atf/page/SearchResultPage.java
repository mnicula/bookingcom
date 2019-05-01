package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchResultPage extends BasePage {



    @FindBy(xpath="//div[@class='destination-sr-header__col destination-sr-header__content']")
    WebElement searchHeader;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return this.searchHeader.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
}
