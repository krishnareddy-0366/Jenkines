package Com.Hooks;

import java.io.IOException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import Com.BaseClass.DriverFactory;
import Com.BaseClass.Library;
import Com.ReusableFunctions.SeleniumReusable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks  {

	  // ThreadLocal to store browser per thread
    private static ThreadLocal<String> threadBrowser = new ThreadLocal<>();

    // Called from runner to set browser for this thread
    public static void setBrowser(String browser) {
        threadBrowser.set(browser);
    }

    @Before
    public void setUp() {

        String browser = threadBrowser.get(); // get browser for this thread
        if (browser == null) browser = "chrome"; // default

        System.out.println("Launching browser: " + browser);
        DriverFactory.initDriver(browser);
   /*
     // ===== Window size & position for parallel execution =====
        if (browser.equalsIgnoreCase("chrome")) {
            DriverFactory.getDriver().manage().window()
                    .setSize(new Dimension(680, 720));   // left window
            DriverFactory.getDriver().manage().window()
                    .setPosition(new Point(0, 0));
        } 
        else if (browser.equalsIgnoreCase("edge")) {
            DriverFactory.getDriver().manage().window()
                    .setSize(new Dimension(680, 720));   // right window
            DriverFactory.getDriver().manage().window()
                    .setPosition(new Point(690, 0));
        }*/
        
     // ===== Add window size & position logic for parallel testing =====
        if (browser.equalsIgnoreCase("chrome")) {
            DriverFactory.getDriver().manage().window().setSize(new Dimension(790,1000));
            DriverFactory.getDriver().manage().window().setPosition(new Point(0, 0)); // left side
        } else if (browser.equalsIgnoreCase("edge")) {
            DriverFactory.getDriver().manage().window().setSize(new Dimension(790, 1000));
            DriverFactory.getDriver().manage().window().setPosition(new Point(790, 0)); // right side
        } 

        DriverFactory.getDriver().get("https://www.flipkart.com");
    }

    @After
    public void cleanup(Scenario scenario) {

        if (DriverFactory.getDriver() != null) {
            new SeleniumReusable(DriverFactory.getDriver())
                    .attachscreenshot(scenario);
            DriverFactory.quitDriver();
        }
    }
}