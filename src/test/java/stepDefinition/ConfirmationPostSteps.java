package stepDefinition;

import com.endava.booking.atf.page.ConfirmationPostPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import scenContext.Context;
import testContext.TestContext;

public class ConfirmationPostSteps extends BaseStep {
    public ConfirmationPostSteps(TestContext context) {
        super(context);
    }

    @And("^confirmation has done on '(.*)' Community page$")
    public void userIsOnCorrectCommunityPage(String communityName){
        context.scenarioContext.getContext(Context.COMMUNITY_NAME);
        String s = (String)  context.scenarioContext.getContext(Context.COMMUNITY_NAME);
        System.out.println("context.scenarioContext.getContext(Context.COMMUNITY_NAME) =" + s);
        page = utilities.getPageByName("ConfirmationPost");
        ConfirmationPostPage confirmationPostPage = (ConfirmationPostPage) page;
        confirmationPostPage.prinAllLinks(s);
    }
}
