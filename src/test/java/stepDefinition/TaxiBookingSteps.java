package stepDefinition;

import com.endava.booking.atf.page.CarBookingPage;
import com.endava.booking.atf.page.TaxiBookingPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import testContext.TestContext;

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
        Thread.sleep(4000);
        taxiBookingPage.enterPaymentDetailsForTaxi ();
    }
}
