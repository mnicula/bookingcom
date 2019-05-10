package com.endava.booking.atf.page;


import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelCommunitiesPage extends BasePage {
    @FindBy(xpath = "//h1[@class='index-cover__title']")
    public WebElement travelCommunitiesHeader;
    @FindBy(xpath = "//a[@class='new-post-btn__btn new-post-btn__btn-tip js-new-post-btn-tip']")
    WebElement giveTipBtn;
    @FindBy(xpath = "//a[contains(@class, 'new-post-btn__btn-question')]")
    WebElement askQuestionBtn;

    public TravelCommunitiesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return travelCommunitiesHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String validatePageUrl(WebDriver driver) {
        String pageURL = driver.getCurrentUrl();
        return pageURL;
    }

}
