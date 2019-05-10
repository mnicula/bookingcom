import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@accommodations1"},//scenarios to run
        glue = {"hooks" , "stepDefinition"},
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber-reports" } //cucumber report: /target/cucumber-reports

)

public class RunCukes {


}
