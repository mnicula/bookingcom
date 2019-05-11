package stepDefinition;

import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testContext.TestContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AirportTaxiSteps extends BaseStep {

    public AirportTaxiSteps(TestContext context) {
        super(context);
    }

    @And("^user (clicks) on '(.*)' taxi button$")
    public void userClickOnAirportTaxiButton(String action, String element) throws IllegalAccessException, InvocationTargetException, InterruptedException {
        //Log.info(MessageFormat.format("User {0} on {1} taxi button", action, element));
        Method method = utilities.getClickMethod(page, action);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(utilities.getWebElementByName(page, element)));
        method.invoke(page, webElement);
        Thread.sleep(5000);
        utilities.switchTab(1);
    }


}
