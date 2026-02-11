package Com.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Library {
	

    // To store data from config.properties
    public static Properties prop;

    // Logger for logging execution details
    protected static Logger logger;

    // This method launches browser and application
    public void launchapplication() throws IOException {

        // Step 1: Read config.properties file
        FileInputStream fis = new FileInputStream("src/test/resources/Property/config.properties");

        // Step 2: Create Properties object
        prop = new Properties();
        prop.load(fis);

        // Step 3: Initialize logger
        logger = Logger.getLogger(Library.class);

        // Step 4: Configure log4j
        PropertyConfigurator.configure("src/test/resources/Property/log4j.properties");

        // Step 5: Launch browser using DriverFactory
        DriverFactory.initDriver(prop.getProperty("browser"));

        // Step 6: Open application URL
        DriverFactory.getDriver().get(prop.getProperty("url"));

        // Step 7: Log success message
        logger.info("Browser launched and application opened");
    }
}
	
	
	
	
	
	/*
    public static WebDriver driver;
    public static Properties prop;
    protected static Logger logger;
    
    public void launchapplication() throws IOException {
	FileInputStream fis=new FileInputStream("src\\test\\resources\\Property\\config.properties");
    prop = new Properties();
    prop.load(fis);
    logger=Logger.getLogger(Library.class);
    PropertyConfigurator.configure("src\\test\\resources\\Property\\log4j.properties");
    
    try {
    if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
    	driver=new ChromeDriver();
    	logger.info("*********chrome broswer launched**************");
    }  
    else if(prop.getProperty("browser").equalsIgnoreCase("edge")){
    	driver=new EdgeDriver();
    	logger.info("*********edge broswer launched**************");
    }
    
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.get(prop.getProperty("url"));  
    logger.info("*********Application launched**************");
}
    catch(Exception e) {
    	System.out.println("broswer did'nt launch");
      }
    }
    public void teardown() {
    	//driver.quit();
    }
  }*/