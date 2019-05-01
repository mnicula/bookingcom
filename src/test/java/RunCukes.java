import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@mnicula"},//scenarios to run
        glue = {"hooks","stepDefinition"},
        monochrome = true

)

public class RunCukes {



}
