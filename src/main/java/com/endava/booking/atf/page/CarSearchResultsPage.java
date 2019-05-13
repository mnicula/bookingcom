package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
    @FindBy(xpath = "//a[contains(text(),'later')]")
    List<WebElement> saveForLater;
    @FindBy(xpath = "//select[@id='quote_title']")
    WebElement titleSelect;
    @FindBy(xpath = "//input[@id='f_name_input']")
    WebElement firstNamePopUp;
    @FindBy(xpath = "//input[@id='surname_input']")
    WebElement surnamePopUp;
    @FindBy(xpath = "//input[@id='email_input']")
    WebElement emailPopUp;
    @FindBy(xpath = "//input[@id='phone_input']")
    WebElement phoneNumber;
    @FindBy(xpath = "//a[@class='cta']")
    WebElement emailDetails;
    @FindBy(xpath = "//span[@class='reference-number']")
    WebElement referenceNr;

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
        try {
            jse.executeScript("arguments[0].click();", chooseButton.get(carNr));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void clickSaveForLater(int carNr) {
        try {
            jse.executeScript("arguments[0].click();", saveForLater.get(carNr));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }


    public void clickEmailDetails() throws IOException, InterruptedException {
        emailDetails.click();
        Thread.sleep(5000);
        try (OutputStream output = new FileOutputStream("src//test//resources//datastore.properties")) {
            Properties prop = new Properties();
            prop.setProperty("referenceNumber", referenceNr.getText());
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }

    }


    public void completePersonalInfo(String title, String firstName, String surname, String email, String phone) {
        Select select = new Select(titleSelect);
        select.selectByValue(title);
        firstNamePopUp.sendKeys(firstName);
        surnamePopUp.sendKeys(surname);
        emailPopUp.sendKeys(email);
        phoneNumber.sendKeys(phone);
    }


}




