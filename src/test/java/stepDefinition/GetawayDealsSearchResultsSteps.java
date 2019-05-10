package stepDefinition;

import com.endava.booking.atf.page.GetawayDealsSearchResultsPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import testContext.TestContext;


public class GetawayDealsSearchResultsSteps extends BaseStep {

    public GetawayDealsSearchResultsSteps(TestContext context) {
        super(context);
    }

    @When("^user filters the deals with checkboxes in the filter section$")
    public void ScrollDownAndFilterDeals() {
        page = utilities.getPageByName("GetawayDealsSearchResults");
        GetawayDealsSearchResultsPage getawayDealsSearchResultsPage = (GetawayDealsSearchResultsPage) page;
        getawayDealsSearchResultsPage.SelectFilterCriteria();

    }


    @Then("^user can check if the filter works OK$")
    public void userSeesFilteredDeals() {
        GetawayDealsSearchResultsPage getawayDealsSearchResultsPage = (GetawayDealsSearchResultsPage) page;
        getawayDealsSearchResultsPage.doesFilterWorkOK( );
    }

}
