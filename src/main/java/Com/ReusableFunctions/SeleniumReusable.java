package Com.ReusableFunctions;

import java.awt.Desktop.Action;
import java.io.File;
import java.lang.annotation.ElementType;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import Com.BaseClass.Library;
import io.cucumber.java.Scenario;

public class SeleniumReusable  {
	Logger logger;
	private WebDriver driver;
	private Actions act;
	
	
	
	public SeleniumReusable(WebDriver driver) {
		this.driver=Com.BaseClass.DriverFactory.getDriver();		
	}
	
	
	
	public void entervalue(WebElement element, String text) {
	  try {
			element.sendKeys(text);
			logger.info("*********enter value**************");
		    }catch(Exception e) {
			System.out.println("No surch Element Exception");
		  }
	 }

	
	 public void click(WebElement element) {
		try {
			element.click();
			logger.info("*********clicked button**************");
		}catch(Exception e) {
			System.out.println("No surch Element Exception");
		}
	 }
	
	
	 public void gettitle() {
		 try {
			    System.out.println(driver.getTitle());
		       }catch (Exception e) {
			    System.out.println("could'nt get the title");
		    }
     }
	
	public void screenshot(String path) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(path));
		}catch (Exception e) {
			System.out.println("screenshot not found");
		}
	}
	
	public void MultipleGettext(List<WebElement> element) {
		List<WebElement> text=element;
		System.out.println(text.size());
		
		for(WebElement textcount:text) {
			String totallist = textcount.getText();
			System.out.println("****************************");
			System.out.println(totallist);
		}
	}
	
	
	public void getvalue(WebElement element){
		String Text = element.getText();
		System.out.println(Text);
	}


    public void dropdown(WebElement element, String text) {
	
	Select drp= new Select(element);
	drp.selectByContainsVisibleText(text);
}

   public void scrolldown(WebElement element) {
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("arguments[0].click();",element );
	}

   public void waits() throws Throwable {
	   Thread.sleep(3000);
   }

   public void mousehover(WebElement element) {
	   act=new Actions(driver);
	   act.moveToElement(element).perform();	
  }

       public void moveelement(WebElement element) {
    	   act.moveToElement(element).click().perform();
  }

       
   public void highleterelement(WebElement element) {
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("arguments[0].style.border='yellow'", element);
   }
   
   
   public void windowhandling(WebElement element) {
		String parentwindow = driver.getWindowHandle();
		System.out.println(parentwindow);
		
		Set<String> allwindow=driver.getWindowHandles();
		System.out.println(allwindow.size());
		for(String childwindow:allwindow) {
			driver.switchTo().window(childwindow);
			System.out.println(childwindow);
			}
   }
   
   public void attachscreenshot(Scenario cucumberscenario) {
	   final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	   cucumberscenario.attach(screenshot, "image/png", "flipkartAutomation");  
	   }
   
   public void closeapp() {
	   driver.quit();
	   System.out.println("broswer closed");
   }
   
   
   public void navigateback() {
	   driver.navigate().back();
   }
}
