package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;


public class MailPage extends BasePage {

    public WebDriver driver;

    @FindBy(xpath = "//td[contains(text(),'Booking.com')]")
    List<WebElement> emails;

    public MailPage(WebDriver driver) {
        super(driver);
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


    public void navigateToMail() {
        driver.get("https://www.mailinator.com/v3/index.jsp?zone=public&query=bookingauto#/#inboxpane");
    }

    public void openRecentMail() {
        emails.get(0).click();
    }

    public boolean checkEmail() {

        try (InputStream input = new FileInputStream("src//test//resources//testdata.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            if (driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText().contains(prop.getProperty("referenceNumber"))) {
                return true;
            } else return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }

    }

}
