package hooks;

import com.endava.booking.atf.utilities.Log;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import testContext.TestContext;

public class Hooks {
    TestContext testContext;
    Scenario scenario;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;

    }

//    @After
//    public void AfterSteps() throws IOException {
//        testContext.getWebDriverManager().closeDriver();
//    }


}
