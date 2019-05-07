package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mnicula
 * Date: 5/3/2019
 * Time: 1:11 PM
 */
public class CarRentalsPage extends BasePage {


    @FindBy (xpath = "//div[@id='bodyconstraint']//h1[1]")
    WebElement pageHeader;
    @FindBy (xpath = "//input[@id='ss_origin']")
    WebElement locationField;

    public CarRentalsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return this.pageHeader.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
}
