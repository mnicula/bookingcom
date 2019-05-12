package stepDefinition;

import com.endava.booking.atf.page.MailPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import testContext.TestContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class MailSteps extends BaseStep {
    public MailSteps(TestContext context) {
        super(context);
    }


    @And("^user navigates to mail$")
    public void navigateToMail() {
        page = utilities.getPageByName("Mail");
        MailPage mailPage = (MailPage) page;
        mailPage.navigateToMail();
        driver.navigate().refresh();
    }

    @And("^user opens recent email$")
    public void openRecentEmail() {
        page = utilities.getPageByName("Mail");
        MailPage mailPage = (MailPage) page;
        mailPage.openRecentMail();
    }

    @Then("^email subject contains the reference number from from CarSearchResultPage$")
    public void containsText() throws InterruptedException {
        page = utilities.getPageByName("Mail");
        MailPage mailPage = (MailPage) page;
        Thread.sleep(5000);
        assertThat("Mail subject contains Reference Number", mailPage.checkEmail(), is(true));
    }


}
