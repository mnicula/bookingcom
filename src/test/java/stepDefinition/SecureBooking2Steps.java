package stepDefinition;

import com.endava.booking.atf.page.SecureBooking2Page;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import testContext.TestContext;

public class SecureBooking2Steps extends BaseStep {

    public SecureBooking2Steps(TestContext context) {
        super(context);
    }

    @And("^user scrolls down the page and clicks Next$")
    public void ScrollDownAndPushButton() throws InterruptedException {
        page = utilities.getPageByName ( "SecureBooking2" );
        SecureBooking2Page secureBooking2Page = (SecureBooking2Page) page;
        secureBooking2Page.ScrollDownAndPressButton();
    }





}
