package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarRentalsPage extends BasePage {

    public WebDriver driver;
    public JavascriptExecutor js;
    @FindBy(xpath = "//span[@class='sb-searchbox__title-text']")
    WebElement pageHeader;
    @FindBy(xpath = "//input[@id='ss_origin']")
    WebElement pickUpLocation;
    @FindBy(xpath = "//table[@class='c2-month-table']")
    List<WebElement> monthDateTable;
    @FindBy(xpath = "//div[@class='xp__input-group xp__date-time']//div//div//button")
    List<WebElement> calendarTable;
    @FindBy(xpath = "//div[@class='xp__dates-inner']")
    WebElement dateSelector;
    @FindBy(xpath = "//div[@class='bui-calendar__wrapper']")
    List<WebElement> dateTables;
    @FindBy(xpath = "//span[contains(@class,'c2-day')]")
    List<WebElement> dates;
    @FindBy(xpath = "//div[contains(@class,'sb-searchbox-submit-col -submit-button')]//button")
    WebElement searchButton;
    @FindBy(xpath = "//ul[@class='c-autocomplete__list sb-autocomplete__list -visible']//li[@data-i='0']")
    WebElement firstResult;

    public CarRentalsPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            String header = "Car hire";
            return pageHeader.getText().contains(header);
        } catch (Exception e) {
            return false;
        }
    }

}
