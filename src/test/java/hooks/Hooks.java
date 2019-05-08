package hooks;

import com.endava.booking.atf.utilities.Log;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import testContext.TestContext;

import java.io.IOException;

public class Hooks {
    TestContext testContext;
    Scenario scenario;


    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        Log.info ( "Scenario name: " + scenario.getName () );
        Log.startLog ( "Test is Starting!" );


    }

    @After
    public void AfterSteps() throws IOException {
        testContext.getWebDriverManager ().closeDriver ();
        Log.endLog ( "Test is ending!" );
    }

}
