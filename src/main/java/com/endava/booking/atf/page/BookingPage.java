package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BookingPage extends BasePage {

    public JavascriptExecutor jse;
    public WebDriver driver;

    @FindBy(xpath = "//div[@class='hp-lists-reserve']//button[@id='hp_book_now_button']")
    WebElement reserveButton;

    @FindBy(xpath = "//a[@class='b-button b-button_secondary b-button_small hp_sidebar-similar_button']")
    WebElement showSimilarHotels;

    @FindBy(xpath = "//h2[@id='availability_target']")
    WebElement availabilityTarget;

    @FindBy(xpath = "//div[@class = 'hprt-block']//select[@class = 'hprt-nos-select']")
    List<WebElement> roomQ;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailAddress;

    @FindBy(xpath = "//input[@id='email_confirm']")
    WebElement emailAddressConfirm;

    @FindBy(xpath = "//div[@id='b_tt_holder_3']")
    WebElement nextFinalDetailsButton;

    @FindBy(xpath = "//button[contains(text(), 'reserve')]")
    WebElement illreserveButton;

    @FindBy(xpath = "//li[@class='hp_nav_bar_item']//a[@id='show_reviews_tab']")
    WebElement guestReviewsTab;


    public BookingPage(WebDriver driver) {
        super ( driver );
        jse = (JavascriptExecutor) driver;
        PageFactory.initElements ( driver , this );
        this.driver = driver;
    }

    public void selectRooms(String value) {
        jse.executeScript("arguments[0].scrollIntoView()", availabilityTarget);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(availabilityTarget));
        roomQ.get(0).click();
        Select select = new Select(roomQ.get(0));
        select.selectByValue(value);
    }

    public void doesSlidingWidgetAppear(String string) {
        Boolean isPresent = driver.findElements(By.xpath("//div[@class='sliding-panel-widget-content review_list_block one_col']")).size() > 0;
        if (isPresent == true) System.out.println("The user sees a sliding reviews widget appearing from the side of the page");
        else System.out.println("The user does not see a sliding reviews widget");
    }


    @Override
    public boolean isElementDisplayed() {
        try {
            return driver.getCurrentUrl().contains("https://www.booking.com/hotel");
        } catch (Exception e){
            return false;
        }
    }



}
