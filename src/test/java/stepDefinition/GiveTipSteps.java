package stepDefinition;

import com.endava.booking.atf.page.GiveTipPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import scenContext.Context;
import testContext.TestContext;

public class GiveTipSteps extends BaseStep {
    public GiveTipSteps(TestContext context) {
        super(context);
        page = utilities.getPageByName("GiveTip");
    }

    @And("^user select community by name '(.*)' on GiveTip page$")
    public void selectCommunityByName(String communityName)throws InterruptedException{
        page = utilities.getPageByName ( "GiveTip" );
        GiveTipPage giveTipPage = (GiveTipPage) page;
        giveTipPage.selectCommunity(driver, communityName);
        context.scenarioContext.setContext(Context.COMMUNITY_NAME, communityName);
    }

}
