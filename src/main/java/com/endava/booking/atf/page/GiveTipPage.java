package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

public class GiveTipPage extends BasePage {

    public WebDriver driver;
    public JavascriptExecutor jse;

    @FindBy(xpath = "//h1[@class='bui-f-font-display_one bui-spacer--large new-post-page__title']")
    public WebElement giveTipHeader;
    @FindBy(xpath = "//h1[contains(@class,'bui-f-font-display_one']")
    public WebElement giveTipHeader1;
    @FindBy(xpath = "//h1[text()='Give a tip']")
    public WebElement giveTipHeader2;
    @FindBy(xpath = "//div[@class='input-communities-select__fake-input bui-form__control js-form-fake-input']")
    WebElement chooseTravelCommunityInputBox;
    @FindBy(xpath = "//div[@class='input-communities-select__dropdown-backdrop']")
    WebElement selectDropdownBackdrop;
    @FindBy(xpath = "//div[@class='input-communities-select__dropdown js-input-select-dropdown']")
    WebElement selectInputCommunities;
    @FindBy(xpath="//input[@placeholder='Search all communities...']")
    WebElement searchCommunitiesPlaceHolder;
    @FindBy(xpath = "//a[contains(@class, 'input-communities-select__dropdown-item')]")
    List<WebElement> allCommunities;
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

    public GiveTipPage(WebDriver driver) {
        super(driver);
        jse =(JavascriptExecutor)driver;
    }

    @Override
    public boolean isElementDisplayed() {
         try {
             return this.giveTipHeader.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public String validatePageUrl(WebDriver driver) {
        String pageURL = driver.getCurrentUrl();
        return pageURL;
    }

    public void typeTitle(String title) {
        titleInputBox.sendKeys(title);
    }
    public void typeYourTip(String yourTip) {
        yourTipTextArea.sendKeys(yourTip);
    }

//    public void typeCommunities(WebDriver driver, String placeholder){
//        searchCommunitiesPlaceHolder.sendKeys(placeholder);
//        String s3 ="//div[contains(text(),'France Community')]";
//        WebElement france =driver.findElement(By.xpath("//div[contains(text(),'France Community')]"));
//        france.click();
//    }
//    public void selectCommunity1(WebDriver driver){
//        WebElement v =
//                driver.findElement(By.xpath("//div[@class='input-communities-select__fake-input bui-form__control js-form-fake-input']")) ;
//        v.click();
////        selectInputCommunities.click();
//        searchCommunitiesPlaceHolder.sendKeys("Fr");
//        String s3 ="//div[contains(text(),'France Community')]";
//        WebElement france =driver.findElement(By.xpath("//div[contains(text(),'France Community')]"));
//        String sourceLocation = france.getAttribute("href");
//        System.out.println("sourceLocation:" + sourceLocation);
//        france.click();
//
//    }

    public void selectCommunity(WebDriver driver, String communityName) {
//      Iterator<WebElement> i =  allCommunities.iterator();  Egypt Community
//      while (i.hasNext()){
//        selectDropdownBackdrop.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(allCommunities));
        for (int i=0; i<allCommunities.size()-1; i++)
          if (allCommunities.get(i).getAttribute("data-title").contains(communityName)){
              try {
                  jse.executeScript("arguments[0].click();", allCommunities.get(i));
              }
                  catch(Exception e){e.printStackTrace();}
              break;
        }
    }

}

