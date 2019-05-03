package stepDefinition;

import com.endava.booking.atf.page.SettingsPage;
import com.endava.booking.atf.pojo.CardDetailsPojo;
import comonSteps.BaseStep;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import testContext.TestContext;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SettingsSteps extends BaseStep {
    public SettingsSteps(TestContext context) {
        super ( context );
    }

    @And("^user sets cardtype with '(.*)'and expiry month '(.*)' and year '(.*)'$")
    public void userSelectCardType(String valueToComplete , String expiryMonthValue , String expireYearValue) {
        page = utilities.getPageByName ( "Settings" );
        SettingsPage settingsPage = (SettingsPage) page;
        settingsPage.selectCardType ( valueToComplete , expiryMonthValue , expireYearValue );
    }

    @And("^user completes the '(.*)' form with following data$")
    public void userCompletesTheCheckoutFormWithFollowingData(String pageName , DataTable details) {
        List < CardDetailsPojo > cardDetails = details.asList ( CardDetailsPojo.class );
        page = utilities.getPageByName ( pageName );
        SettingsPage settingsPage = (SettingsPage) page;
        settingsPage.completeFields ( cardDetails.get ( 0 ) );
    }

    @Then("^credit card is added$")
    public void userUserIsRegistered() {
        page = utilities.getPageByName ( "Settings" );
        SettingsPage settingsPage = (SettingsPage) page;

        assertThat ( "User is registered" , settingsPage.receives ( settingsPage.successfullyAddedCardMsg ) , is ( "Your changes have been saved" ) );
    }
}
