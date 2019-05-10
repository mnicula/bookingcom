package stepDefinition;

import com.endava.booking.atf.page.AccommodationsSearchResultsPage;
import com.endava.booking.atf.page.GetawayDealsSearchResultsPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.When;
import testContext.TestContext;

import java.lang.reflect.InvocationTargetException;

public class AccommodationsSearchResultsSteps extends BaseStep {
    public AccommodationsSearchResultsSteps(TestContext context) {
        super(context);
    }


    @When("^user (clicks) on first '(.*)' link$")
    public void userClicksOnButton(String action , String element) throws IllegalAccessException, InvocationTargetException {
        page = utilities.getPageByName ( "AccommodationsSearchResults" );
        AccommodationsSearchResultsPage accommodationsSearchResultsPage = (AccommodationsSearchResultsPage) page;
        accommodationsSearchResultsPage.getHotelName ( 0 );
        utilities.switchTab(1);
    }

    @When("^user filters the deals by clicking a button in the search table$")
    public void ScrollDownAndPushButton() throws InterruptedException {
        page = utilities.getPageByName ( "AccommodationsSearchResults" );
        AccommodationsSearchResultsPage accommodationsSearchResultsPage = (AccommodationsSearchResultsPage) page;
        accommodationsSearchResultsPage.FilterDealsByPressingButton();

    }





}
