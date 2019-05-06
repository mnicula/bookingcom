package stepDefinition;


import com.endava.booking.atf.page.CarBookingPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import testContext.TestContext;


public class CarBookingSteps extends BaseStep {


    public CarBookingSteps(TestContext context) {
        super ( context );
    }


    @And("^user clicks on goToBook button$")
    public void userClickOnCarRentalsButton() throws InterruptedException {
        page = utilities.getPageByName ( "CarBooking" );
        CarBookingPage carBookingPage = (CarBookingPage) page;
        carBookingPage.clickToBook();

    }
    @And("^user enters personal info$")
    public void enterPersonalInfo()  {
        page = utilities.getPageByName ( "CarBooking" );
        CarBookingPage carBookingPage = (CarBookingPage) page;
        carBookingPage.enterPersonalInfo();
    }
    @And("^user clicks on BookNow button$")
    public void clickBookNow() throws InterruptedException {
        page = utilities.getPageByName ( "CarBooking" );
        CarBookingPage carBookingPage = (CarBookingPage) page;
        carBookingPage.clickBookNow();
    }

    @And("^user enters payment details$")
    public void enterPaymentDetails() throws InterruptedException {
        page = utilities.getPageByName ( "CarBooking" );
        CarBookingPage carBookingPage = (CarBookingPage) page;
        Thread.sleep(8000);
        //carBookingPage.switchFrameToHelp(carBookingPage.paymentMethod);
        carBookingPage.enterPaymentDetails();
    }

}
