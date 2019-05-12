package stepDefinition;

import com.endava.booking.atf.common.action.BasePage;
import com.endava.booking.atf.page.CarRentalsPage;
import com.endava.booking.atf.page.HomePage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebElement;
import testContext.TestContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CarRentalsSteps extends BaseStep {

    public CarRentalsSteps(TestContext context) { super ( context );
    }


    @And("^user is redirected to new tab$")
    public void userIsRedirected(){
        page = utilities.getPageByName ( "CarRentals" );
        CarRentalsPage carRentalsPage = (CarRentalsPage) page;

        carRentalsPage.isElementDisplayed();
    }

    @And("^user (completes) the '(.*)' with '(.*)' value$")
    public void userCompleteTheField(String action , String element , String valueToComplete) throws IllegalAccessException, InvocationTargetException, InterruptedException {
        Method method = utilities.getWriteMethod ( page , action );
        WebElement webElement = utilities.getWebElementByName ( page , element );
        webElement.clear ();
        method.invoke ( page , webElement , valueToComplete );}



}
