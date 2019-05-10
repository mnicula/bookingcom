package stepDefinition;


import com.endava.booking.atf.page.CarBookingPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import testContext.TestContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class CarBookingSteps extends BaseStep {


    public CarBookingSteps(TestContext context) {
        super(context);
    }


    @And("^user clicks on goToBook button$")
    public void userClickOnCarRentalsButton() throws InterruptedException {
        page = utilities.getPageByName("CarBooking");
        CarBookingPage carBookingPage = (CarBookingPage) page;
        carBookingPage.clickToBook();

    }

    @And("^user enters personal info$")
    public void enterPersonalInfo() {
        page = utilities.getPageByName("CarBooking");
        CarBookingPage carBookingPage = (CarBookingPage) page;
        carBookingPage.enterPersonalInfo();
    }

    @And("^user clicks on BookNow button$")
    public void clickBookNow() throws InterruptedException {
        page = utilities.getPageByName("CarBooking");
        CarBookingPage carBookingPage = (CarBookingPage) page;
        carBookingPage.clickBookNow();
    }

    @And("^user enters payment details$")
    public void enterPaymentDetails() throws InterruptedException {
        page = utilities.getPageByName("CarBooking");
        CarBookingPage carBookingPage = (CarBookingPage) page;
        Thread.sleep(8000);
        carBookingPage.enterPaymentDetails();
    }

    @Then("^user is warned that payment was not processed$")
    public void userIsWarned() throws InterruptedException {
        page = utilities.getPageByName("CarBooking");
        CarBookingPage carBookingPage = (CarBookingPage) page;
        assertThat("User is warned that payment was not processed ",carBookingPage.receives(carBookingPage.errorMessage),is("Sorry but we have been unable to process your payment."));

    }



}
