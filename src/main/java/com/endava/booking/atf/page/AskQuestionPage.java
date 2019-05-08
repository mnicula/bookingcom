package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AskQuestionPage extends BasePage {
    //   #comm-form-field-select-1-input
    @FindBy(xpath = "//h1[@class='bui-f-font-display_one bui-spacer--large new-post-page__title']")
    public WebElement askQuestionHeader;
    @FindBy(xpath = "//label[contains(text(),'Publish your post in:')]")
    WebElement publishPostInLbl;

    @FindBy(xpath = "//div[@class='input-communities-select__fake-input bui-form__control js-form-fake-input']")
    WebElement chooseTravelCommunityInputBox;
    @FindBy(xpath = "//div[@class='input-communities-select__dropdown-list']")
    WebElement inputCommunitiesSelectDropdownList;
    @FindBy(xpath = "//div[@class='input-communities-select__dropdown js-input-select-dropdown']")
    WebElement selectInputCommunities;
    @FindBy(xpath = "//select[@id='comm-form-field-select-6-input']")
    WebElement selectForm;

    @FindBy(xpath = "//div[@class='js-form-fields-wrapper js-form-fields-wrapper--title-description']" +
            "//label[@class='js-form-field-label'][contains(text(),'Title')]")
    WebElement titleLbl;
    @FindBy(xpath = "//select[@id='comm-form-field-select-1-input']")
    WebElement selectQuestionType;
    @FindBy(xpath = "//input[@id='comm-form-field-text-2-input']")
    WebElement titleInputBox;
    //transport subform
    // @FindBy(id="ss")
    @FindBy(xpath = "//div[1]//div[1]//form[1]//div[5]//div[1]//div[1]//div[1]//div[1]//input[1]")
    WebElement inputDestinationFrom;
    @FindBy(xpath = "//div[1]//div[1]//form[1]//div[5]//div[2]//div[1]//div[1]//div[1]//input[1]")
    WebElement inputDestinationTo;
    @FindBy(xpath = "//select[@id='comm-form-field-select-4-input']")
    WebElement selectTravellersNumber;
    @FindBy(xpath = "//select[@id='comm-form-field-select-5-input']")
    WebElement selectPreferencesBy;
    @FindBy(xpath = "//textarea[@id='comm-form-field-textarea-4-input']")
    WebElement textAreaforQuestion;
    //
    @FindBy(xpath = "//button[[contains(@class,'new-post__submit-btn']")
    WebElement postBtn;
    //driver.findElement(By.id("change-password"));
    //Places to stay
    @FindBy(xpath = "//div[1]//div[1]//form[1]//div[4]//div[1]//div[1]//div[1]//div[1]//input[1]")
    WebElement inputProperty;

    public AskQuestionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return this.askQuestionHeader.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void getListItemsFromTitleInputBox(List<String> l) {
        boolean b = titleInputBox.isEnabled();
    }

    public void completeQuestionType(String typeQuestion) {
        Select dropdown = new Select(selectQuestionType);
        dropdown.selectByVisibleText(typeQuestion);
        //  dropdown.selectByIndex(typeQuestion);
    }

    public void completeTransportSelectFields(String travellersNumber, String preferencesBy) {
        Select dropdown = new Select(selectTravellersNumber);
        dropdown.selectByVisibleText(travellersNumber);
        Select dropdown1 = new Select(selectPreferencesBy);
    }
}


