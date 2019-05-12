package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class AskQuestionPage extends BasePage {
    public WebDriver driver;
    public JavascriptExecutor jse;

    @FindBy(xpath = "//h1[@class='bui-f-font-display_one bui-spacer--large new-post-page__title']")
    public WebElement askQuestionHeader;
    @FindBy(xpath = "//div[@class='input-communities-select__fake-input bui-form__control js-form-fake-input']")
    WebElement chooseTravelCommunityInputBox;
    @FindBy(xpath = "//div[@class='input-communities-select__dropdown-list']")
    WebElement inputCommunitiesSelectDropdownList;
    @FindBy(xpath = "//a[contains(@class, 'input-communities-select__dropdown-item')]")
    List<WebElement> allCommunities;
    @FindBy(xpath = "//select[@id='comm-form-field-select-6-input']")
    WebElement selectForm;
    @FindBy(xpath = "//select[@id='comm-form-field-select-1-input']")
    WebElement selectQuestionType;
    @FindBy(xpath = "//input[@id='comm-form-field-text-2-input']")
    WebElement titleInputBox;
    @FindBy(xpath = "//button[@class='bui-button bui-button--primary bui-button--wide new-post__submit-btn js-submit-btn']")
    WebElement postBtn;
    //transport subform
    @FindBy(xpath = "//div[1]//div[1]//form[1]//div[5]//div[1]//div[1]//div[1]//div[1]//input[1]")
    WebElement inputDestinationFrom;
    @FindBy(xpath = "//ul[@class='c-autocomplete__list sb-autocomplete__list sb-autocomplete__list-with_photos -visible']")
    WebElement ulDestinationFrom;
    @FindBy(xpath = "//div[1]//div[1]//form[1]//div[5]//div[2]//div[1]//div[1]//div[1]//input[1]")
    WebElement inputDestinationTo;
    @FindBy(xpath = "//select[@id='comm-form-field-select-4-input']")
    WebElement selectTravellersNumber;
    @FindBy(xpath = "//select[@id='comm-form-field-select-5-input']")
    WebElement selectPreferencesBy;
    @FindBy(xpath = "//textarea[@id='comm-form-field-textarea-4-input']")
    WebElement textAreaforTransportQuestion;
    //Places to stay subform
    @FindBy(xpath = "//div[1]//div[1]//form[1]//div[4]//div[1]//div[1]//div[1]//div[1]//input[1]")
    WebElement inputProperty;
    @FindBy(xpath = "//li[contains(@class, 'c-autocomplete__item')]")
    List<WebElement> liPlacesToStay;
    @FindBy(xpath = "//ul[contains(@class,'c-autocomplete__list']")
    WebElement ulPlacesToStay;
    @FindBy(xpath = "//select[@id='comm-form-field-select-2-input']")
    WebElement selectTravellingAs;
    @FindBy(xpath = "//select[@id='comm-form-field-select-3-input']")
    WebElement selectBudget;
    @FindBy(xpath = "//textarea[@id='comm-form-field-textarea-3-input']")
    WebElement textAreaforplacesToStayQuestion;
    //warning messages
    @FindBy(xpath = "//div[@id='comm-form-field-select-6-error']")
    WebElement messageFieldselect6Error6; //"Choose the community you want to publish your post in"
    @FindBy(xpath = "//div[@id='comm-form-field-select-1-error']")
    WebElement messageFieldselect1Error1;//Select question type
    @FindBy(xpath = "//div[@id='comm-form-field-destination-1-error']")
    WebElement messageDestination1Error;//Sorry, we don't recognise that name. //for places
    @FindBy(xpath = "//div[@id='comm-form-field-textarea-3-error']")
    WebElement messageFieldTextarea3error;//Please specify – what kind of advice are you looking for?
    @FindBy(xpath = "//div[@id='comm-form-field-destination-2-error']")
    WebElement messageFieldDestination2Error;//Sorry, we don't recognise that name. for transport
    @FindBy(xpath = "//div[@id='comm-form-field-destination-3-error']")
    WebElement messageErrorFieldDestination3Error;////Sorry, we don't recognise that name. for transport
    @FindBy(xpath = "//div[@id='comm-form-field-textarea-4-error']")
    WebElement messageError; //Please specify – what kind of advice are you looking for? (for transport)

    public AskQuestionPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return this.askQuestionHeader.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

     public void completeQuestionType(String typeQuestion) {
        Select dropdown = new Select(selectQuestionType);
        dropdown.selectByVisibleText(typeQuestion);
    }

    public void chooseRandomValueByIndex(WebElement webElement) {
        Select dropdown = new Select(webElement);
        List<WebElement> listOptions = dropdown.getOptions();
        int num = listOptions.size() ;
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(num);
        dropdown.selectByIndex(randomInt);
    }

    public void selectCommunity(WebDriver driver, String communityName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(allCommunities));
        for (int i = 0; i < allCommunities.size() - 1; i++)
            if (allCommunities.get(i).getAttribute("data-title").contains(communityName)) {
                try {
                    jse.executeScript("arguments[0].click();", allCommunities.get(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
    }

    public void chooseRandomPlacesToStay(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(ulPlacesToStay));
        int nnn = liPlacesToStay.size();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(nnn);
        WebDriverWait wait1 = new WebDriverWait(driver, 5);
        wait1.until(ExpectedConditions.elementToBeClickable(liPlacesToStay.get(randomInt)));
        liPlacesToStay.get(randomInt).click();
    }
    public void choosePlacesToStay(WebDriver driver, String cityName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(ulDestinationFrom));
        for (WebElement li : liPlacesToStay) {
            if (li.getText().contains(cityName)) {
                WebDriverWait wait1 = new WebDriverWait(driver, 10);
                wait1.until(ExpectedConditions.elementToBeClickable(li));
                li.click();
                break;
            }
        }
    }

}
