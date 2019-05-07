package stepDefinition;

import com.endava.booking.atf.page.AskQuestionPage;
import com.endava.booking.atf.page.GiveTipPage;
import com.endava.booking.atf.page.TravelCommunitiesPage;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.Reporter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testContext.TestContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TravelCommunitiesSteps extends BaseStep {

    public TravelCommunitiesSteps(TestContext context) {
        super(context);
    }

    @Then("^My user is on '(.*)' page$")
    public void userIsOnPage(String pageName) {
        page = utilities.getPageByName ( pageName );  //(BasePage)
        System.out.println("(page.getClass() = " +page.getClass());
        System.out.println("%%%%%%%%%%%%TravelCommunitiesStep%%%%%%%%%%%%%%%");
        assertThat ( "User is on " + pageName + "com/endava/booking/atf/page" , page.isElementDisplayed () , is ( true ) );
    }
    public void userIsOnTravelCommunitiesPage(String pageName) {
       page = utilities.getPageByName ( pageName );
       TravelCommunitiesPage travelCommunitiesPage = (TravelCommunitiesPage) page;
       assertThat ( "User is on " + pageName + "com/endava/booking/atf/page" ,
                page.isElementDisplayed () , is ( true ) );
       String expectedUrl = travelCommunitiesPage.validatePageUrl(driver);
       System.out.println("expectedUrl =" + expectedUrl);
       Assert.assertEquals(expectedUrl,  driver.getCurrentUrl());
    }

    @And("^My user (clicks) on '(.*)'$")
    public void userClicksOnButton(String action , String element) throws IllegalAccessException, InvocationTargetException {
        Method method = utilities.getClickMethod(page, action);
        WebElement webElement = utilities.getWebElementByName(page, element);
        System.out.println("%%%%%%%%%%%%TravelCommunitiesStep%%%%%%%%%%%%%%%");
        System.out.println("page        " + page.getClass());
        System.out.println("method      " + method.getName());
        System.out.println("webElement  " + webElement.getText());
        method.invoke(page, webElement);
      //  Reporter.log("Button " + element + " Clicked");
    }
    @And("^user (clicks) on '(.*)' on (TravelCommunities) page$")
    public void userClicksOnButton(String action , String element, String pageName) throws IllegalAccessException, InvocationTargetException {
        page = utilities.getPageByName ( pageName );
        TravelCommunitiesPage travelCommunitiesPage = (TravelCommunitiesPage) page;
        Method method = utilities.getClickMethod ( travelCommunitiesPage , action );
        WebElement webElement = utilities.getWebElementByName ( travelCommunitiesPage , element );
        System.out.println("^user (clicks) on '(.*)'$" + travelCommunitiesPage.getClass());
        System.out.println("^user (clicks) on '(.*)'$" + webElement.getText());
        method.invoke ( travelCommunitiesPage , webElement );
    }
    @And("^My user (completes) the '(.*)' field with '(.*)' value$")
    public void userCompleteTheField(String action , String element , String valueToComplete) throws IllegalAccessException, InvocationTargetException, InterruptedException {
        Method method = utilities.getWriteMethod ( page , action );
        WebElement webElement = utilities.getWebElementByName ( page , element );
        webElement.clear ();
        method.invoke ( page , webElement , valueToComplete );
    }

    @And("^user selects the '(.*)' value from question type dropdown$")
    public void userSelectsValueFromQuestionTypeDropdown(String typeQuestion){
        AskQuestionPage a = new AskQuestionPage(driver);
        a.completeQuestionType(typeQuestion);
    }


    //completeTransportSelectFields


    @And("^user fill explicitly Communities$")
    public void userFillCommunities()  {
        WebElement v =
                driver.findElement(By.xpath("//div[@class='input-communities-select__fake-input bui-form__control js-form-fake-input']")) ;
        v.click();
        String s2 ="//input[@placeholder='Search all communities...']";
        WebElement webElement = driver.findElement(By.xpath(s2));
        webElement.sendKeys("Fr");
        String s3 ="//div[contains(text(),'France Community')]";
        WebElement france =driver.findElement(By.xpath("//div[contains(text(),'France Community')]"));
        System.out.println("//div[contains(text(),'France Community')]"+france.getText());

        String sourceLocation = france.getAttribute("href");
        System.out.println("sourceLocation:" + sourceLocation);

        france.click();
//        WebElement nnn =
//                driver.findElement(By.xpath("//input[@id='comm-form-field-text-2-input']"));
//        nnn.sendKeys("Paris ????????");


//        page = utilities.getPageByName ("GiveTip" );
//        GiveTipPage giveTipPage = (GiveTipPage) page;
// //      WebElement webElement = utilities.getWebElementByName ( giveTipPage , element );
//        System.out.println("^user put in the searchCommunitiesPlaceHolder " + giveTipPage.getClass());
//        System.out.println("^user put in the searchCommunitiesPlaceHolder " + webElement.getText());
//        method.invoke ( giveTipPage , webElement );

    }
    @And("^user put in the searchCommunitiesPlaceHolder K$")
    public void K()  {
        page = utilities.getPageByName ("GiveTip" );
        GiveTipPage giveTipPage = (GiveTipPage) page;
        giveTipPage.typeCommunities(driver,"Fr");

    }
//    @And("^user (clicks) on selector '(.*)'  and chooses value by string '(.*)'$")
//    public void userClicksOnDateSelector(String action , String element, String valueToSelect) throws IllegalAccessException, InvocationTargetException {
//        Method method = utilities.getClickMethod ( page , action );
//        WebElement webElement = utilities.getWebElementByName ( page , element );
//        method.invoke ( page , webElement );
//        Select dropdown = new Select(webElement);
//        dropdown.selectByVisibleText(valueToSelect);
//
//    }
    @And("^user from selector '(.*)' chooses value ByVisibleText '(.*)'$")
    public void userDateSelector( String element, String valueToSelect){
        AskQuestionPage askQuestionPage = new AskQuestionPage(driver);
        WebElement webElement = utilities.getWebElementByName ( askQuestionPage , element );
        Select dropdown = new Select(webElement);
        dropdown.selectByVisibleText(valueToSelect);
    }
    @And("^user (clicks) on selector '(.*)' and  chooses data ByVisibleText '(.*)'$")
    public void userChoosesDataByVisibleText( String action,String element, String valueToSelect) throws InvocationTargetException, IllegalAccessException {
        System.out.println("page.getClass()   " +page.getClass());
        Method method = utilities.getClickMethod ( page, action );
        WebElement webElement = utilities.getWebElementByName ( page , element );
        method.invoke(page, webElement);
//        AskQuestionPage askQuestionPage = new AskQuestionPage(driver);
//        WebElement webElement = utilities.getWebElementByName ( askQuestionPage , element );
        Select dropdown = new Select(webElement);
        dropdown.selectByVisibleText(valueToSelect);
    }
   @Then("^The new window is displayed and it is not possible to (clicks) '(.*)' now$")
    public void postResult(String action , String element){
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        // Now check again for the post button.
// If post button is displayed it means that the form posted
// is not successful and you have returned to the same page.
// We are using a try catch block here because if the element is not found
// ie. if form posted is successful NoSuchElementException would be thrown.
       try {
           // Element has to be found again else StaleElementReferenceException
           // might be thrown because of page reload.
           Method method = utilities.getClickMethod(page, action);
           WebElement webElement = utilities.getWebElementByName(page, element);
           method.invoke(page, webElement);
         // if post button is found again, this means form post is not successful
          System.out.println("Form was not posted");
       } catch (Exception e) {
           // Login button is not found. Form is submitted
           System.out.println("Form was posted successfully");
       }

   }

}
