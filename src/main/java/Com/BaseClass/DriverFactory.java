package Com.BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DriverFactory {

    // ThreadLocal variable to store WebDriver for each thread
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // This method initializes the browser
    public static void initDriver(String browser) {

        // If browser name is chrome
        if (browser.equalsIgnoreCase("chrome")) {

            // Setup ChromeDriver automatically
            WebDriverManager.chromedriver().setup();

            // Create ChromeOptions object
            ChromeOptions options = new ChromeOptions();

            // Start browser in maximized mode
            options.addArguments("--start-maximized");

            // Fix for Chrome remote origin issue
            options.addArguments("--remote-allow-origins=*");

            // Create ChromeDriver and store in ThreadLocal
            tlDriver.set(new ChromeDriver(options));

        }
        // If browser name is edge
        else if (browser.equalsIgnoreCase("edge")) {

            // Setup EdgeDriver automatically
            WebDriverManager.edgedriver().setup();

            // Create EdgeDriver and store in ThreadLocal
            tlDriver.set(new EdgeDriver());
        }

        // Apply implicit wait of 20 seconds
        getDriver().manage().timeouts()
                   .implicitlyWait(Duration.ofSeconds(20));
    }

    // This method returns the WebDriver of current thread
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    // This method quits the browser safely
    public static void quitDriver() {

        // Check if driver is not null
        if (tlDriver.get() != null) {
            try {
                // Quit the browser
                tlDriver.get().quit();
            } catch (Exception e) {
                // Print error if browser does not close
                System.out.println("Error quitting driver: " + e.getMessage());
            } finally {
                // Remove driver from ThreadLocal to avoid memory leak
                tlDriver.remove();
            }
        }
    }
}