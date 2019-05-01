package stepDefinition;

import comonSteps.BaseStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testContext.TestContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class AccommodationsPage extends BaseStep {
    public AccommodationsPage(TestContext context) {
        super(context);
    }

    @Given("^user is on '(.*)' page$")
    public void userIsOnAccommodationsPage(String pageName) {
        page = utilities.getPageByName(pageName);
        assertThat("User is on " + pageName + "com/endava/booking/atf/page", page.isElementDisplayed(), is(true));
    }

    @When("^user enters the (.*) details$")
    public void userEntersSearchDetails(String action, String element) throws InvocationTargetException, IllegalAccessException {
        Method method = utilities.getClickMethod(page, action);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(utilities.getWebElementByName(page, element)));
        method.invoke(page, webElement);
    }
}
