package stepDefinition;



import com.endava.booking.atf.page.CarSearchResultsPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testContext.TestContext;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class CarsSearchResultsSteps extends BaseStep {


    public CarsSearchResultsSteps(TestContext context) {
        super(context);
    }

    @Then("^user is redirected on '(.*)' Page$")
    public void userIsOnCarSearchResultsPage(String pageName) {
        page = utilities.getPageByName ( pageName );
        wait.until(ExpectedConditions.urlContains("SearchResults"));
        assertThat ( "User is on " + pageName + "com/endava/booking/atf/page" , page.isElementDisplayed () , is (true) );
    }

    @When("^user clicks on orderByPrice$")
    public void sortByPrice() {
        page = utilities.getPageByName ( "CarSearchResults" );
        CarSearchResultsPage carSearchResultsPage = (CarSearchResultsPage) page;
        carSearchResultsPage.sortByPrice();
    }
    @When("^results are ordered ascending by price$")
    public void orderedResults() {
        page = utilities.getPageByName ( "CarSearchResults" );
        CarSearchResultsPage carSearchResultsPage = (CarSearchResultsPage) page;
        assertThat("Search results are ordered by price ascending",carSearchResultsPage.checkSortByPrice(),is(true));
    }

    @When("^user clicks on first chooseCar button$")
    public void clickOnChooseCar() throws InterruptedException {
        page = utilities.getPageByName ( "CarSearchResults" );
        CarSearchResultsPage carSearchResultsPage = (CarSearchResultsPage) page;
        carSearchResultsPage.clickChooseCar(2);
        Thread.sleep(5000);
        utilities.switchTab(2);
    }


}
