package stepDefinition;

import com.endava.booking.atf.page.BookingPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import testContext.TestContext;

public class BookingSteps extends BaseStep {
    public BookingSteps(TestContext context) {
        super(context);
    }


    @And("^user selects '(.*)' room$")
    public void userSelectsFromDropdown(String value) {
        page = utilities.getPageByName("Booking");
        BookingPage bookingPage = (BookingPage) page;
        bookingPage.selectRooms(value);
    }



}
