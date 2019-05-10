package com.endava.booking.atf.manager;


import com.endava.booking.atf.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;
    private static Browser browser;
    private static final String DRIVER_PATH = com.endava.booking.atf.manager.FileReaderManager.getInstance().getConfigFileReader().getDriverPath();

    public WebDriverManager() {
        browser = com.endava.booking.atf.manager.FileReaderManager.getInstance().getConfigFileReader().getBrowser();
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createLocalDriver();
           return driver;
    }

    private WebDriver createLocalDriver() {
        switch (browser) {
            case CHROME:
                System.setProperty(Browser.CHROME.getDriverProperty(), DRIVER_PATH + "chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("user-data-dir=target/custom/profile");
                driver = new ChromeDriver(options);
                break;
            case INTERNETEXPLORER:
                DesiredCapabilities defaultZoom = DesiredCapabilities.internetExplorer();
                defaultZoom.setCapability("ignoreZoomSetting", true);
                System.setProperty(Browser.INTERNETEXPLORER.getDriverProperty(), DRIVER_PATH + "IEDriverServer.exe");
                driver = new InternetExplorerDriver(defaultZoom);
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
        String language = FileReaderManager.getInstance().getConfigFileReader().getURLLanguage();
        this.driver.navigate().to(homeURL+"/index."+language+".html");
    }

    private void maximizeWindow() {
        if (FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize())
            this.driver.manage().window().maximize();
    }

    private void setImplicitWait() {
        long implicitlyWait = FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait();
        this.driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
    }

    public void closeDriver() throws IOException {
        driver.close();
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}