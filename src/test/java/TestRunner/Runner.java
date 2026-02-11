package TestRunner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import Com.Hooks.hooks;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"StepDefination", "Com.Hooks"},
    tags = "@Parallelsafe",
    plugin = {
        "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setBrowser(String browser) {
        hooks.setBrowser(browser);
        System.out.println("Browser set to:" + browser);
    }

    @Override
    @DataProvider(parallel = false) // parallel scenarios
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
