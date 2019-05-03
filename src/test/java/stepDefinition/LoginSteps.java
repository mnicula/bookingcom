package stepDefinition;


import com.endava.booking.atf.page.HomePage;
import comonSteps.BaseStep;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testContext.TestContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class LoginSteps extends BaseStep {
    public LoginSteps(TestContext context) {
        super ( context );
    }

    @Then("^user is(.*) authenticated and is on home page$")
    public void user_is_authenticated(String arg0) throws InvocationTargetException, IllegalAccessException {
        Method method = utilities.getClickMethod ( page , "clicks" );
        WebElement webElement = wait.until ( ExpectedConditions.elementToBeClickable ( utilities.getWebElementByName ( page , "closeButton" ) ) );
        method.invoke ( page , webElement );
        HomePage homePage = (HomePage) page;
        switch (arg0) {
            case "":
                assertThat ( "User is authenticated " , homePage.checkIfUserIsLoggedIn ( homePage.yourAccountBlock ) , is ( true ) );
                break;
            case "not":
                assertThat ( "User is not authenticated " , homePage.checkIfUserIsLoggedIn ( homePage.yourAccountBlock ) , is ( false ) );
        }
    }
}




