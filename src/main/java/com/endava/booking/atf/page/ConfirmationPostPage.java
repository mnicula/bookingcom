package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ConfirmationPostPage extends BasePage {

    @FindBy(xpath = "//h3[@class='congrats-message__title']")
    WebElement congratsMessageHeader;
    @FindBy(xpath = "//p[@class='congrats-message__message']")
    WebElement congratsMessageParag;
    @FindBy(xpath = "//a[contains(text(),'Egypt Community')]")
    List<WebElement> egyptCommunityLinks;
    @FindBy(xpath = "//a[contains(text(),'Community')]")
    List<WebElement> anyCommunityLinks;
    @FindBy(xpath = "//a[@class='js-profile-link post-meta-v2__profile-link']")
    WebElement profileLink;

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

    public void prinAllLinks(String communityName) {
        for (int i = 0; i < anyCommunityLinks.size() - 1; i++) {
            if (anyCommunityLinks.get(i).getAttribute("href").contains(communityName)) {
                System.out.println(anyCommunityLinks.get(i).getText());
            }
            System.out.println(anyCommunityLinks.get(i).getText());
        }
    }
//
//            "<a href=\"https://www.booking.com/communities/c/egypt?aid=304142;label=gen173bo-1DCAEoggI46AdIM1gDaI4BiAEBmAEJuAEXyAEM2AED6AEB-AEDiAIBmAIhqAIDuAKXi8_mBcACAQ;sid=fd6de57ba16c26092dc344946d0354ca;communities_entry_point=www_footer;community_ep_ref=a618;lang=en-gb&amp;" +
//                    "utm_campaign=www&amp;utm_medium=footer&amp;" +
//                    "utm_source=communities_ep&amp;\" " +
//                    "class=\"bui-link bui-link--primary js-breadcrumb-link\" data-breadcrumb-level=\"2\" " +
//                    "xpath=\"1\">\n" +
//            "Egypt Community\n" +
//            "</a>")

}
