package stepDefinition;

import com.endava.booking.atf.page.BookingPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
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

    @Then("^'(.*)' slides from the side of the page$")
    public void checkIfSlidingWidgetAppears(String string) {
        page = utilities.getPageByName("Booking");
        BookingPage bookingPage = (BookingPage) page;
        bookingPage.doesSlidingWidgetAppear(string);
    }

}
