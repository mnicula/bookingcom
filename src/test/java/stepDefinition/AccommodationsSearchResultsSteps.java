package stepDefinition;

import com.endava.booking.atf.page.AccommodationsSearchResultsPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.When;
import testContext.TestContext;

public class AccommodationsSearchResultsSteps extends BaseStep {
    public AccommodationsSearchResultsSteps(TestContext context) {
        super(context);
    }


    @When("^user (clicks) on first '(.*)' link$")
    public void userClicksOnButton(String action, String element) {
        page = utilities.getPageByName("AccommodationsSearchResults");
        AccommodationsSearchResultsPage accommodationsSearchResultsPage = (AccommodationsSearchResultsPage) page;
        accommodationsSearchResultsPage.getHotelName(0);
        utilities.switchTab(1);

    }


}
