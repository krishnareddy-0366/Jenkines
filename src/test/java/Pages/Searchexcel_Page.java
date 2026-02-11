package Pages;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.BaseClass.DriverFactory;
import Com.BaseClass.Library;
import Com.ReusableFunctions.SeleniumReusable;
import Utilities.excelutility;

public class Searchexcel_Page{
     private WebDriver driver;
	 private excelutility excel;
	 private  SeleniumReusable se;
	
	 public Searchexcel_Page(WebDriver driver) {
		 this.driver=DriverFactory.getDriver();
		 PageFactory.initElements(driver, this);
		 excel = new excelutility();
	     se = new SeleniumReusable(driver);
	 } 
	 
	 @FindBy(xpath = "//input[@name='q']")
	 private WebElement Search;

	 @FindBy(xpath = "//div[@id='container']")
	 private WebElement homepage;

	 public void Searchwithexcel() throws Throwable {
	     for (int i = 1; i <= 6; i++) {

	         se.entervalue(Search, excel.excelread("sheet1", i, 0));
	         Search.sendKeys(Keys.ENTER);
	         se.waits();

	         if (homepage.isDisplayed()) {
	             excel.excelwrite("sheet1", i, 1, "PASS");
	         } else {
	             excel.excelwrite("sheet1", i, 1, "FAIL");
	         }
	         se.navigateback();
	         
	     }
	     
	 }

}
