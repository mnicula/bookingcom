package stepDefinition;

import com.endava.booking.atf.page.AskQuestionPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import scenContext.Context;
import testContext.TestContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AskQuestionsSteps extends BaseStep {
    public AskQuestionsSteps(TestContext context) {
        super(context);
    //    page = utilities.getPageByName("AskQuestion");
    }

    @And("^user selects the '(.*)' value from question type dropdown$")
    public void userSelectsValueFromQuestionTypeDropdown(String typeQuestion){
        page = utilities.getPageByName("AskQuestion");
        AskQuestionPage askQuestionPage = (AskQuestionPage) page;
        askQuestionPage.completeQuestionType(typeQuestion);
    }

    @And("^user selects data '(.*)' from '(.*)' field on '(.*)' page$")
    public void userSelectsDataByVisibleText(String valueToSelect, String element, String myPage)
            throws InvocationTargetException, IllegalAccessException {
        page = utilities.getPageByName(myPage);
        WebElement webElement = utilities.getWebElementByName(page, element);
        Select dropdown = new Select(webElement);
        dropdown.selectByVisibleText(valueToSelect);
    }

    @And("^user select community by name '(.*)' on AskQuestion page$")
    public void selectCommunityByName(String communityName){
        page = utilities.getPageByName ( "AskQuestion" );
        AskQuestionPage askQuestionPage = (AskQuestionPage) page;
        askQuestionPage.selectCommunity(driver, communityName);
        context.scenarioContext.setContext(Context.COMMUNITY_NAME, communityName);
    }
    @And("^user selects any data from '(.*)' field on AskQuestionPage$")
    public void userSelectsAnyDataByIndex( String element)
            throws InvocationTargetException, IllegalAccessException {
        page = utilities.getPageByName("AskQuestion");
        AskQuestionPage askQuestionPage = (AskQuestionPage) page;
        WebElement webElement = utilities.getWebElementByName(page, element);
        askQuestionPage.chooseRandomValueByIndex(webElement);
    }

    @And("^user selects any places to stay$")
    public void userSelectsAnyPlacesToStay(){
        page = utilities.getPageByName("AskQuestion");
        AskQuestionPage askQuestionPage = (AskQuestionPage) page;
        askQuestionPage.chooseRandomPlacesToStay(driver);
    }

    @And("^user selects city from list begining at '(.*)'$")
    public void userSelectsCityTravellingFrom(String cityFirstLetters){
        page = utilities.getPageByName("AskQuestion");
        AskQuestionPage askQuestionPage = (AskQuestionPage) page;
        askQuestionPage.choosePlacesToStay(driver,cityFirstLetters);

    }

//        try {
//            method.invoke(page, webElement);
//
//        } catch (InvocationTargetException e) {
//            // Answer:
//            System.out.println("My ERROR");
//            e.getCause().printStackTrace();
//        } catch (Exception e) {
//            // generic exception handling
//            e.printStackTrace();
//        }

}

