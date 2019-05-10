# automation-framework
Selenium test automation framework
This is a step by step documentation on how works an automation framework on http://www.booking.com/ as the test site. 



# 1. The pom file
Sort the maven pom file out: start a new maven project that gives the structure.
It is a maven structure not for the automation project. Open the pom.xml file.
Add the dependencies you need. You can get it from here.  https://mvnrepository.com
Examples: cucumber-java,cucumber-junit, junit, selenium etc.


# 2. The basic test framework structure
Important: the feature files go into resource directory and everything else goes into the test dir.
(In this framework there is a java directory under test)
src -> test -> java ->  supporting code
src -> test -> resources -> feature files
(This resources dir where your feature files live needs to be marked as source root.

# 3. Cucumber runner
 Create cucumber runner in the root dir of test/java because Cucumber runs on Junit in java.
The dependencies will be crucial at this point. Luckily there is great documentation on how to set up this class.
Go to:https://cucumber.io/docs/reference/jvm
If you happen to have issues with the dependencies, enable auto import and let magic happen.( don't recommend)


# 4. The BasePage
# 4.1 The webdriver
How to get chrome driver? (Steps are pretty similar for IE browser too)
You can download chromedriver from here: http://chromedriver.chromium.org/downloads

# 4.2 Commonly used methods
If you declare a ‘click’ method on the BasePage the problem is that every page will have a different URL.
You can solve this by extending BasePage. However you must declare this method abstract.

BasePage should contain the methods that are used all over the tests in order to avoid duplications.

# 5. The hooks (before and after)
Hooks allow you to perform actions at various points in the cucumber testcycle.
This is commonly used for driver management. (before, after hooks)
and the information should live in a support class or on a step definition.

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


# 6. Start building features and step def files
Recommended basic structure:
- Feature files
- Step definitions
- Respective page files
- Hooks
- Base Page

#  Abstraction, patterns and framework organisation


The singleton patter is useful because exactly one object is needed to coordinate actions across the system.

  
