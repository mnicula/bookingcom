package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ConfirmationPostPage extends BasePage {
    public WebDriver driver;

    @FindBy(xpath = "//h3[@class='congrats-message__title']")
    WebElement congratsMessageHeader;
    @FindBy(xpath = "//p[@class='congrats-message__message']")
    WebElement congratsMessageParag;
    @FindBy(xpath = "//a[contains(text(),'Egypt Community')]")
    List<WebElement> egyptCommunityLinks;
    @FindBy(xpath = "//a[contains(text(),'ommunity')]")
    List<WebElement> anyCommunityLinks;
    @FindBy(tagName = "a")
    List<WebElement> allLinks;
    @FindBy(xpath = "//a[@class='js-profile-link post-meta-v2__profile-link']")
    WebElement profileLink;
    @FindBy(xpath="//div[@class='cover-name']") //    France Community</div>")
    WebElement communityCoverName;

    //<a class="js-post-preview-link post-preview__clickable-link" href="https://www.booking.com/communities/p/3c05636a73a611e9aa7c1a81407a1f0f/verona-places-to-stay-as-a-solo-traveller-low-budget?aid=304142;label=gen173nr-1DCAEoggI46AdIM1gEaI4BiAEBmAEJuAEXyAEM2AED6AEBiAIBqAIDuALYntnmBcACAQ;sid=cf5689a13813cb8e02a5f651660bd204;communities_entry_point=www_footer;community_ep_ref=f526;lang=en-gb&amp;utm_campaign=www&amp;utm_medium=footer&amp;utm_source=communities_ep&amp;" data-post-type="question" xpath="1"></a

    //a[contains(text(),'Go back to AnyCommunityPage community')]
    @FindBy(xpath = "//a[contains(text(),'Go back to AnyCommunityPage community')]")
    WebElement linkGoBackToCommunity;

    public ConfirmationPostPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return this.congratsMessageHeader.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public String  getCongratsMessageParagText() {
        String bodyText = congratsMessageParag.getText();
        return bodyText;
    }

    public void hasLinkBackToCommunity(WebDriver driver, String communityName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(anyCommunityLinks));
        for (int i = 0; i < anyCommunityLinks.size() - 1; i++) {
            if (anyCommunityLinks.get(i).getAttribute("href").contains(communityName.toLowerCase())) {
                anyCommunityLinks.get(i).click();
            }
        }
    }

}