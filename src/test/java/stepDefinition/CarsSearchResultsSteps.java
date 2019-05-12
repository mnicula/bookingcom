package stepDefinition;


import com.endava.booking.atf.page.CarSearchResultsPage;
import com.endava.booking.atf.page.MailPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testContext.TestContext;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.theInstance;
import static org.junit.Assert.assertThat;


public class CarsSearchResultsSteps extends BaseStep {


    public CarsSearchResultsSteps(TestContext context) {
        super(context);
    }

    @Then("^user is redirected on '(.*)' Page$")
    public void userIsOnCarSearchResultsPage(String pageName) {
        page = utilities.getPageByName(pageName);
        wait.until(ExpectedConditions.urlContains("SearchResults"));
        assertThat("User is on " + pageName + "com/endava/booking/atf/page", page.isElementDisplayed(), is(true));
    }

    @When("^user clicks on orderByPrice$")
    public void sortByPrice() {
        page = utilities.getPageByName("CarSearchResults");
        CarSearchResultsPage carSearchResultsPage = (CarSearchResultsPage) page;
        carSearchResultsPage.sortByPrice();
    }

    @When("^results are ordered ascending by price$")
    public void orderedResults() {
        page = utilities.getPageByName("CarSearchResults");
        CarSearchResultsPage carSearchResultsPage = (CarSearchResultsPage) page;
        assertThat("Search results are ordered by price ascending", carSearchResultsPage.checkSortByPrice(), is(true));
    }

    @When("^user clicks on first chooseCar button$")
    public void clickOnChooseCar() throws InterruptedException {
        page = utilities.getPageByName("CarSearchResults");
        CarSearchResultsPage carSearchResultsPage = (CarSearchResultsPage) page;
        carSearchResultsPage.clickChooseCar(2);
        Thread.sleep(5000);
        utilities.switchTab(2);
    }

    @When("^user clicks on save for later$")
    public void clickSaveForLate(){
        page = utilities.getPageByName("CarSearchResults");
        CarSearchResultsPage carSearchResultsPage= (CarSearchResultsPage) page;
        carSearchResultsPage.clickSaveForLater(2);
    }

    @And("^user completes personalinfo with '(.*)' , '(.*)' , '(.*)', '(.*)' and '(.*)'$")
    public void completePersonalInfo(String title, String firstName, String surname, String email, String phone)  {
        page = utilities.getPageByName("CarSearchResults");
        CarSearchResultsPage carSearchResultsPage = (CarSearchResultsPage) page;
        carSearchResultsPage.completePersonalInfo(title,firstName,surname,email,phone);
    }

    @And("^user clicks on 'emailDetails' link$")
    public void clickOnLink() throws IOException, InterruptedException {
        CarSearchResultsPage carSearchResultsPage = (CarSearchResultsPage) page;
        carSearchResultsPage.clickEmailDetails();
        wait.until(ExpectedConditions.visibilityOf(carSearchResultsPage.driver.findElement(By.xpath("//span[@class='reference-number']"))));
    }



}
