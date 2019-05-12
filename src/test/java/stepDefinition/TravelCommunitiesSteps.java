package stepDefinition;

import com.endava.booking.atf.page.AnyCommunityPage;
import com.endava.booking.atf.page.TravelCommunitiesPage;
//import com.sun.java.util.jar.pack.Package;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import testContext.TestContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TravelCommunitiesSteps extends BaseStep {

    public TravelCommunitiesSteps(TestContext context) {

        super(context);
    }

    @Then("^user is on TravelCommunities page$")
    public void userIsOnTravelCommunitiesPage() {
       page = utilities.getPageByName ( "TravelCommunities" );
       TravelCommunitiesPage travelCommunitiesPage = (TravelCommunitiesPage) page;
       assertThat ( "User is on page  " + page.getClass() ,
                page.isElementDisplayed () , is ( true ) );
       String expectedUrl = travelCommunitiesPage.validatePageUrl(driver);
       Assert.assertEquals("url's have to be equal",expectedUrl,driver.getCurrentUrl());
    }

    @And("^user (clicks) on '(.*)' on '(.*)' page$")
    public void userClicksOnButton(String action , String element, String pageName) throws IllegalAccessException, InvocationTargetException {
        page = utilities.getPageByName ( pageName );
        Method method = utilities.getClickMethod(page, action);
        WebElement webElement = utilities.getWebElementByName(page, element);
        method.invoke(page, webElement);
      //  Reporter.log("Button " + element + " Clicked");
    }

    @And("^user (completes) the '(.*)' field with '(.*)' value on '(.*)' page$")
    public void userCompleteTheField(String action , String element , String valueToComplete, String pageName) throws IllegalAccessException, InvocationTargetException, InterruptedException {
        page = utilities.getPageByName ( pageName );
        Method method = utilities.getWriteMethod ( page , action );
        WebElement webElement = utilities.getWebElementByName ( page , element );
        webElement.clear ();
        method.invoke ( page , webElement , valueToComplete );
    }

//    @And("^user put in the searchCommunitiesPlaceHolder K$")
//    public void K()  {
//        page = utilities.getPageByName ("GiveTip" );
//        GiveTipPage giveTipPage = (GiveTipPage) page;
//        giveTipPage.typeCommunities(driver,"Fr");
//    }
    @And("^user sleep for '(.*)' milliseconds$")
    public void sleep(Long longValue) throws InterruptedException {
        Thread.sleep(longValue);
    }

    @And("^covername is correct on page '(.*)'$")
    public  void coverNameIsCorrect(String pageName){
        page = utilities.getPageByName ( pageName );
        AnyCommunityPage anyCommunityPage = (AnyCommunityPage) page;
        String it = anyCommunityPage.getCoverNameText();
        System.out.println(it);
    }
    @And("^user chooses community by name '(.*)'$")
    public void userChoosesCommunity(String communityName){
        page = utilities.getPageByName ( "TravelCommunities" );
        TravelCommunitiesPage travelCommunitiesPage = (TravelCommunitiesPage) page;
        travelCommunitiesPage.goToCommunity(driver, communityName);
    }

}
