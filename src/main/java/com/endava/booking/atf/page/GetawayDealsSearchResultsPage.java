package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GetawayDealsSearchResultsPage extends BasePage {

    public JavascriptExecutor jse;
    public WebDriver driver;

    @FindBy(xpath = "//div[@id='search_results_table']")
    WebElement searchTable;

    @FindBy(xpath = "//span[@class='filter_label'][contains(text(),'Breakfast')]")
    WebElement breakfastIncluded;

    @FindBy(xpath = "//span[contains(text(),'Only show available properties')]")
    WebElement showOnlyAvailableProperties;

    @FindBy(xpath = "//sup[@class='sr_room_reinforcement'][contains(text(),'Breakfast')]")
    List<WebElement> breakfastReinforcementMessage;


    public GetawayDealsSearchResultsPage(WebDriver driver) {
        super ( driver );
        jse = (JavascriptExecutor) driver;
        PageFactory.initElements ( driver , this );
        this.driver = driver;
    }

    public void SelectFilterCriteria() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(breakfastIncluded));
        jse.executeScript("arguments[0].scrollIntoView();", breakfastIncluded);
        jse.executeScript("arguments[0].click();", breakfastIncluded);

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(showOnlyAvailableProperties));
        jse.executeScript("arguments[0].scrollIntoView();", showOnlyAvailableProperties);
        jse.executeScript("arguments[0].click();", showOnlyAvailableProperties);
        wait.until(ExpectedConditions.visibilityOf(searchTable));
    }


    public void doesFilterWorkOK() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
//        wait.until(new ExpectedCondition<Boolean>()
//            {
//            public Boolean apply(WebDriver driver)
//            { return (jse).executeScript("return document.readyState").equals("complete"); }
//            });

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//sup[@class='sr_room_reinforcement'][contains(text(),'Breakfast')]")));
        Thread.sleep(5000);
        if (breakfastReinforcementMessage.size() >= 10) System.out.println("Filter works OK");
        else System.out.println("Getaway deals list is not filtered properly");
    }


    @Override
    public boolean isElementDisplayed() {
        try {
            return this.searchTable.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }


}
