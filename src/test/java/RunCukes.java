import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@3"},//scenarios to run
        glue = {"hooks" , "stepDefinition"},
        monochrome = true
//TODO generate cucumber report
)

public class RunCukes {


}
