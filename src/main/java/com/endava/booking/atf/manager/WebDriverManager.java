package com.endava.booking.atf.manager;


import com.endava.booking.atf.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;
    private static Browser browser;
    private static final String DRIVER_PATH = com.endava.booking.atf.manager.FileReaderManager.getInstance().getConfigFileReader().getDriverPath();

    public WebDriverManager() {
        browser = com.endava.booking.atf.manager.FileReaderManager.getInstance().getConfigFileReader().getBrower();
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createLocalDriver();
           return driver;
    }

    private WebDriver createLocalDriver() {
        switch (browser) {
            case CHROME:
                System.setProperty(Browser.CHROME.getDriverProperty(), DRIVER_PATH + "chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        goToHomePage();
        maximizeWindow();
        setImplicitWait();

        driver.manage().deleteAllCookies();
        return driver;
    }

    public void goToHomePage() {
        String homeURL = FileReaderManager.getInstance().getConfigFileReader().getApplicationHomeURL();
        //String language = FileReaderManager.getInstance().getConfigFileReader().getURLLanguage();
        this.driver.navigate().to(homeURL);
    }

    private void maximizeWindow() {
        if (FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize())
            this.driver.manage().window().maximize();
    }

    private void setImplicitWait() {
        long implicityWait = FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait();
        this.driver.manage().timeouts().implicitlyWait(implicityWait, TimeUnit.SECONDS);
    }

    public void closeDriver() throws IOException {
        driver.close();
        try {
            driver.quit();
        } catch (Exception e) {
            Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
            Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");

        }
    }

}