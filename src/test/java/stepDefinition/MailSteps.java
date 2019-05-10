package stepDefinition;

import com.endava.booking.atf.page.CarSearchResultsPage;
import com.endava.booking.atf.page.MailPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testContext.TestContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class MailSteps extends BaseStep {
    public MailSteps(TestContext context) {
        super(context);
    }


    @And("^user navigates to mail$")
    public void navigateToMail()  {
        page = utilities.getPageByName("Mail");
        MailPage mailPage = (MailPage) page;
        mailPage.navigateToMail();
        driver.navigate().refresh();
    }

    @And("^user opens recent email$")
    public void openRecentEmail()  {
        page = utilities.getPageByName("Mail");
        MailPage mailPage = (MailPage) page;
        mailPage.openRecentMail();
    }




}
