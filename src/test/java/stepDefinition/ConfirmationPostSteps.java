package stepDefinition;

import com.endava.booking.atf.page.ConfirmationPostPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import org.junit.Assert;
import scenContext.Context;
import testContext.TestContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConfirmationPostSteps extends BaseStep {
    public ConfirmationPostSteps(TestContext context) {
        super(context);
    }

    @And("^confirmation has done on corresponding Community page$")
    public void userIsOnCorrectCommunityPage(){
        context.scenarioContext.getContext(Context.COMMUNITY_NAME);
        String commName = (String)  context.scenarioContext.getContext(Context.COMMUNITY_NAME);
        page = utilities.getPageByName("ConfirmationPost");
        ConfirmationPostPage confirmationPostPage = (ConfirmationPostPage) page;
        String actual = confirmationPostPage.getCongratsMessageParagText();
        Assert.assertTrue("Text with community name was not found!", actual.contains(commName));
    }
}
