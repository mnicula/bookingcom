package stepDefinition;

import com.endava.booking.atf.page.TaxiBookingPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import testContext.TestContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TaxiBookingSteps extends BaseStep {

    public TaxiBookingSteps(TestContext context) {
        super ( context );
    }
    @And("^user enters personal info for taxi booking$")
    public void enterPersonalInfoTaxiBooking()  {
        page = utilities.getPageByName ( "TaxiBooking" );
        TaxiBookingPage taxiBookingPage = (TaxiBookingPage) page;
        taxiBookingPage.enterPersonalInfo();
    }
    @And("^user enters payment details for taxi booking$")
    public void enterPaymentDetailsForTaxi() throws InterruptedException {
        page = utilities.getPageByName ( "TaxiBooking" );
        TaxiBookingPage taxiBookingPage = (TaxiBookingPage) page;
        Thread.sleep(2000);
        taxiBookingPage.enterPaymentDetailsForTaxi ();
    }
    @Then("^user is warned that booking taxi with invalid card is not possible$")
    public void userIsWarnedThatBookingTaxiIsNotPossible(String arg0) throws Throwable {
        page = utilities.getPageByName ( "TaxiBooking" );
        TaxiBookingPage taxiBookingPage = (TaxiBookingPage) page;
        assertThat ( "is warned that booking taxi with invalid card is not possible" , taxiBookingPage.receives ( taxiBookingPage.warningBookingTaxiMsg ) ,
                is ( "Sorry but we were unable to take your payment" ) );
    }
}
