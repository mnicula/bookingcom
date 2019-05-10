package stepDefinition;

import com.endava.booking.atf.page.RegisterPage;
import com.endava.booking.atf.utilities.Log;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testContext.TestContext;

import java.text.MessageFormat;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterSteps extends BaseStep {
    public RegisterSteps(TestContext context) {
        super(context);
    }


    @Then("^user is registered$")
    public void userUserIsRegistered() {
        page = utilities.getPageByName("Register");
        RegisterPage registerPage = (RegisterPage) page;

        assertThat ( "User is registered" , registerPage.receives ( registerPage.confirmationMsg ) , is ( "Welcome to Booking.com" ) );

    }

    @And("^user fills in duplicate account mail$")
    public void userFillsInExistingAccount() {
        page = utilities.getPageByName("Register");
        RegisterPage registerPage = (RegisterPage) page;
        registerPage.createEmail("testATF01@test.com");

    }

    @Then("^user is warned about duplicate mail$")
    public void userIsWarnedAboutDuplicate() {
        page = utilities.getPageByName("Register");
        RegisterPage registerPage = (RegisterPage) page;
        assertThat ( "User is warned about duplicate" , registerPage.receives ( registerPage.errorMsgMail ) , is ( "You already have a Booking.com account registered to this email: testATF01@test.com. You can sign in directly." ) );
        Log.info ( MessageFormat.format ( "User is warned about dublicate mail: {0}" , registerPage.errorMsgMail ) );

       

    }

    @When("^user fills in different passwords$")
    public void userFillsInDifferentPasswords() {
        page = utilities.getPageByName("Register");
        RegisterPage registerPage = (RegisterPage) page;
        registerPage.typePass("123456789");
        registerPage.typeConfirmPass("987654321");
        registerPage.clickCreateAccountButton();
    }

    @Then("^user is warned about password mismatch$")
    public void userIsWarnedAboutPasswordMismatch() {
        page = utilities.getPageByName("Register");
        RegisterPage registerPage = (RegisterPage) page;
        assertThat ( "User is warned about password mismatch" , registerPage.receives ( registerPage.errorMsgPassword ) , is ( "The passwords you entered did not match, please try again" ) );
    }
}
