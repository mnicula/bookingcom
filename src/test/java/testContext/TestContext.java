package testContext;

import com.endava.booking.atf.manager.WebDriverManager;
import com.endava.booking.atf.utilities.PageObjectUtilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import scenContext.ScenarioContext;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectUtilities pageObjectUtilities;
    private WebDriverWait wait;


    public ScenarioContext scenarioContext;

    public TestContext() {
        webDriverManager = new WebDriverManager();
        pageObjectUtilities = new PageObjectUtilities(webDriverManager.getDriver());
        wait = new WebDriverWait(webDriverManager.getDriver(), 20);
        scenarioContext = new ScenarioContext();
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectUtilities getPageObjectUtilities() {
        return pageObjectUtilities;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    }