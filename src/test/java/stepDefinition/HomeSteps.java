package stepDefinition;

import com.endava.booking.atf.page.HomePage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import testContext.TestContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class HomeSteps extends BaseStep {
    public HomeSteps(TestContext context) {
        super ( context );
    }

    @Then("^user is on '(.*)' page$")
    public void userIsOnAccommodationsPage(String pageName) {
        page = utilities.getPageByName ( pageName );
        assertThat ( "User is on " + pageName + "com/endava/booking/atf/page" , page.isElementDisplayed () , is ( true ) );
    }

    @And("^user (completes) the '(.*)' field with '(.*)' value$")
    public void userCompleteTheField(String action , String element , String valueToComplete) throws IllegalAccessException, InvocationTargetException, InterruptedException {
        Method method = utilities.getWriteMethod ( page , action );

        WebElement webElement = utilities.getWebElementByName ( page , element );
        webElement.clear ();
        method.invoke ( page , webElement , valueToComplete );

    }

    @And("^user (clicks) on '(.*)'$")
    public void userClicksOnButton(String action , String element) throws IllegalAccessException, InvocationTargetException {
        Method method = utilities.getClickMethod ( page , action );
        WebElement webElement = utilities.getWebElementByName ( page , element );
        method.invoke ( page , webElement );
    }

    @And("^user (clicks) on '(.*)' selector$")
    public void userClicksOnDateSelector(String action , String element) throws IllegalAccessException, InvocationTargetException {
        Method method = utilities.getClickMethod ( page , action );
        WebElement webElement = utilities.getWebElementByName ( page , element );
        method.invoke ( page , webElement );
    }

    @And("^user sets dates$")
    public void userSelectsDates() {
        page = utilities.getPageByName ( "Home" );
        HomePage homePage = (HomePage) page;
        homePage.selectCheckInOutDate ();
    }

}
