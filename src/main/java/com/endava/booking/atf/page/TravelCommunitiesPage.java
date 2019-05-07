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
    @FindBy(xpath = "//a[@class='navbar__link js-communities-tab']//div[@class='navbar__link-content']")
    WebElement communitiesTab;
    @FindBy(xpath = "//a[contains(@class,'navbar__link js-communities-tab']")
    WebElement communitiesTab2;

//    /html/body/div[4]/div[1]/h3
//    <h3 class="congrats-message__title">Your post is live!</h3>
    WebElement congratMessage;

    public TravelCommunitiesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            System.out.println("travelCommunitiesHeader.isDisplayed()");
            return travelCommunitiesHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String validateTravelCommunitiesPageTitle(WebDriver driver){
        return driver.getTitle();
    }
    public String validatePageUrl(WebDriver driver) {
        String pageURL = driver.getCurrentUrl();
        return pageURL;
    }
//    public boolean validateCRMImage(){
//        return crmLogo.isDisplayed();
//    }

}
