package comonSteps;

import com.endava.booking.atf.common.action.BasePage;
import com.endava.booking.atf.utilities.PageObjectUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testContext.TestContext;

public class BaseStep {
    public TestContext context;
    public BasePage page;
    public WebDriver driver;
    public PageObjectUtilities utilities;
    public WebDriverWait wait;



    public BaseStep(TestContext context) {
        this.context = context;
        page = context.getPageObjectUtilities().getPageByName("Home");
        driver = context.getWebDriverManager().getDriver();
        utilities = context.getPageObjectUtilities();
        wait = context.getWait();

    }
}