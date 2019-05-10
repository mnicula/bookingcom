package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GiveTipPage extends BasePage {

    @FindBy(xpath = "//h1[@class='bui-f-font-display_one bui-spacer--large new-post-page__title']")
    public WebElement giveTipHeader;
    @FindBy(xpath = "//h1[contains(@class,'bui-f-font-display_one']")
    public WebElement giveTipHeader1;
    @FindBy(xpath = "//h1[text()='Give a tip']")
    public WebElement giveTipHeader2;
    @FindBy(xpath = "//label[contains(text(),'Publish your post in:')]")
    WebElement publishPostInLbl;
    @FindBy(xpath = "//div[@class='input-communities-select__fake-input bui-form__control js-form-fake-input']")
    WebElement chooseTravelCommunityInputBox;
    @FindBy(xpath = "//div[@class='input-communities-select__dropdown js-input-select-dropdown']")
    WebElement selectInputCommunities;

    @FindBy(xpath="//input[@placeholder='Search all communities...']")
    WebElement searchCommunitiesPlaceHolder;
    @FindBy(xpath = "//input[@id='comm-form-field-text-2-input']")
    WebElement titleInputBox;
    @FindBy(xpath ="//label[contains(text(),'Your tip')]")
    WebElement yourTipLbl;
    @FindBy(xpath ="//textarea[@id='comm-form-field-textarea-2-input']")
    WebElement yourTipTextArea;
    @FindBy(xpath ="//div[@class='post-image-upload__input-wrap js-post-image-upload-large-file-input-wrap']//input[@class='js-post-image-upload-input']")
    WebElement postImgArea;
    //@FindBy(xpath ="//button[[contains(@class,'new-post__submit-btn']")
    @FindBy(xpath ="//button[@class='bui-button bui-button--primary bui-button--wide new-post__submit-btn js-submit-btn']")
    WebElement postBtn;
    @FindBy(xpath ="//div[contains(text(),'France Community']")
    WebElement franceCommunityWebElement;
    //div[@class='input-communities-select__dropdown js-input-select-dropdown']
     //       [contains(@class, 'new-post-btn__btn-question')]
    public GiveTipPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
         try {
             System.out.println("giveTipHeader.isDisplayed()");
            return this.giveTipHeader.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public String validatePageUrl(WebDriver driver) {
        String pageURL = driver.getCurrentUrl();
        return pageURL;
        //Check and verify that the URL loaded remains the same and the correct page is loaded.
        //Assert.assertEquals(expectedUrl,  driver.getCurrentUrl());
    }
    public boolean isListCommunitiesEmpty(WebDriver driver) {
        WebElement roleDropdown = driver.findElement(By.id("name1"));
        roleDropdown.click();
        this.selectInputCommunities.findElements(By.xpath("class='input-communities-select__dropdown js-input-select-dropdown"));

 //       body > div:nth-child(37) > div:nth-child(2) > main > div > div > form > div.js-input-communities-select-wrap > div > div.input-communities-select__dropdown.js-input-select-dropdown > div.input-communities-select__dropdown-list > a:nth-child(14)

        return true;

    }
    public void typeTitle(String title) {
        titleInputBox.sendKeys(title);
    }
    public void typeYourTip(String yourTip) {
        yourTipTextArea.sendKeys(yourTip);
    }

    public void typeCommunities(WebDriver driver, String placeholder){
        searchCommunitiesPlaceHolder.sendKeys(placeholder);
        String s3 ="//div[contains(text(),'France Community')]";
        WebElement france =driver.findElement(By.xpath("//div[contains(text(),'France Community')]"));
        System.out.println("//div[contains(text(),'France Community')]"+france.getText());
        france.click();
    }
}



