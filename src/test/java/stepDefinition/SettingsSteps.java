package stepDefinition;

import com.endava.booking.atf.page.SettingsPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import testContext.TestContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SettingsSteps extends BaseStep {
    public SettingsSteps(TestContext context) {
        super ( context );
    }

    @And("^user completes card data  with '(.*)' , '(.*)' , '(.*)', '(.*)' and '(.*)'$")
    public void userSelectCardType(String valueToComplete , String expiryMonthValue , String expireYearValue , String creditCardNumber , String creditCardHolder) {
        page = utilities.getPageByName ( "Settings" );
        SettingsPage settingsPage = (SettingsPage) page;
        settingsPage.completeCardData ( valueToComplete , expiryMonthValue , expireYearValue , creditCardNumber , creditCardHolder );
    }

    @Then("^credit card is added$")
    public void userUserIsRegistered() {
        page = utilities.getPageByName ( "Settings" );
        SettingsPage settingsPage = (SettingsPage) page;
        assertThat ( "Credit card is added" , settingsPage.receives ( settingsPage.successfullyAddedCardMsg ) , is ( "Your changes have been saved" ) );
    }

    @Then("^user is warned that saving card is not possible$")
    public void userIsWarnedThatDeliveryIsNotPossible() throws Throwable {
        page = utilities.getPageByName ( "Settings" );
        SettingsPage settingsPage = (SettingsPage) page;
        assertThat ( "User is warned that saving card is not possible " , settingsPage.receives ( settingsPage.warningCardType ) ,
                is ( "This is a required field" ) );
    }


}
