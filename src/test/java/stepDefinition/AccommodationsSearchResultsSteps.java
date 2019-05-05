package stepDefinition;

import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebElement;
import testContext.TestContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AccommodationsSearchResultsSteps extends BaseStep {
    public AccommodationsSearchResultsSteps(TestContext context) {
        super(context);
    }


    @And("^user (clicks) on '(.*)' link$")
    public void userClicksOnButton(String action , String element) throws IllegalAccessException, InvocationTargetException {
        Method method = utilities.getClickMethod ( page , action );
        WebElement webElement = utilities.getWebElementByName ( page , element );
        method.invoke ( page , webElement );
        utilities.switchTab(1);

    }























}
