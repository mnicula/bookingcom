package testContext;

import com.endava.booking.atf.manager.WebDriverManager;
import com.endava.booking.atf.utilities.PageObjectUtilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectUtilities pageObjectUtilities;
    private WebDriverWait wait;
    private boolean flag;

    public TestContext() {
        webDriverManager = new WebDriverManager();
        pageObjectUtilities = new PageObjectUtilities(webDriverManager.getDriver());
        wait = new WebDriverWait(webDriverManager.getDriver(), 20);
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