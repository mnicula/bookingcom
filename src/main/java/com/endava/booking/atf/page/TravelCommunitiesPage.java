package com.endava.booking.atf.page;


import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TravelCommunitiesPage extends BasePage {
    @FindBy(xpath = "//h1[@class='index-cover__title']")
    public WebElement travelCommunitiesHeader;
    @FindBy(xpath = "//a[@class='new-post-btn__btn new-post-btn__btn-tip js-new-post-btn-tip']")
    WebElement giveTipBtn;
    @FindBy(xpath = "//a[contains(@class, 'new-post-btn__btn-question')]")
    WebElement askQuestionBtn;
    @FindBy(xpath = "//ul[@class='communities-list__items']")
    WebElement ulCommunity;
    @FindBy(xpath = "//a[contains(@class, 'communities-list__item')]")
    List<WebElement> aCommunity;
    @FindBy(xpath = "//div[@class='cover-name']")
    WebElement communityCoverName;


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

    public void goToCommunity(WebDriver driver, String communityName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(ulCommunity));
        for (WebElement li : aCommunity) {
            System.out.println( li.getText());
            if ( li.getAttribute("href").contains(communityName.toLowerCase())){
                WebDriverWait wait1 = new WebDriverWait(driver, 10);
                wait1.until(ExpectedConditions.elementToBeClickable(li));
                li.click();
                break;
            }
        }
    }


}
