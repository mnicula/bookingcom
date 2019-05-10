package stepDefinition;

import com.endava.booking.atf.page.SecureBooking2Page;
import com.endava.booking.atf.page.SecureBooking3Page;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import testContext.TestContext;

public class SecureBooking3Steps extends BaseStep {

    public SecureBooking3Steps(TestContext context) {
        super(context);
    }


    @And("^user scrolls down the page and fills in with '(.*)' CVC code field if it appears on the page$")
    public void ScrollDownAndFillInCvc(String cvc) {
        page = utilities.getPageByName ( "SecureBooking3" );
        SecureBooking3Page secureBooking3Page = (SecureBooking3Page) page;
        secureBooking3Page.ScrollDownAndFillInIf(cvc);
    }



    @And("^user scrolls down the page and clicks Complete$")
    public void ScrollDownAndPushButton() {
        page = utilities.getPageByName ( "SecureBooking3" );
        SecureBooking3Page secureBooking3Page = (SecureBooking3Page) page;
        secureBooking3Page.ScrollDownAndPressButton();
    }




}
