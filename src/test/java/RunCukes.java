import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(

        tags = {"@1"},//scenarios to run
        glue = {"hooks" , "stepDefinition"},
        plugin = { "html:target/cucumber-reports",
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/test-output/HtmlReport/cucumbareport.html" }


)

public class RunCukes {


}
