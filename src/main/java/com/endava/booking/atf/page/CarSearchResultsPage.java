package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CarSearchResultsPage extends BasePage {

    public WebDriver driver;
    public JavascriptExecutor jse;
    @FindBy(xpath = "//button[@class='horizontal-search__btn']")
    WebElement searchButton;
    @FindBy(xpath = "//button[@class='proceed-btn gradient a11y-normalise-button']")
    WebElement searchButton2;
    @FindBy(xpath = "//select[@id='resultsOrder']")
    WebElement resultsOrder;
    @FindBy(xpath = "//div[@class='bui-price-display__value bui-f-color-black']")
    List<WebElement> prices;
    @FindBy(xpath = "//a[contains(@class, 'carResultRow')]")
    List<WebElement> chooseButton;
    @FindBy(xpath = "/button[@class='carResultRow_OfferInfo-btn-primary']")
    List<WebElement> chooseButton2;

    public CarSearchResultsPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return driver.getCurrentUrl().contains("cars");
        } catch (Exception e) {
            return false;
        }
    }

    public void sortByPrice() {
        Select resultOrder = new Select(resultsOrder);
        resultOrder.selectByValue("price");
    }

    public boolean checkSortByPrice() {
        ArrayList<String> prices2 = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++) {
            prices2.add(prices.get(i).getText().replace(" €", ""));
        }

        int i = 0;
        boolean flag = true;
        while (i < prices2.size()) {
            if ((prices2.get(i).compareTo(prices2.get(i + 1)) == 0)) {
                i++;
            } else {
                flag = false;
            }
        }
        return flag;
    }

    public void clickChooseCar(int carNr) {
        try { jse.executeScript("arguments[0].click();", chooseButton.get(carNr));
        }
        catch (IndexOutOfBoundsException e) { e.printStackTrace();}


    }
}




