package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.BaseClass.DriverFactory;
import Com.BaseClass.Library;
import Com.ReusableFunctions.SeleniumReusable;

public class Titleprice_Page{
	private WebDriver driver;
	private SeleniumReusable se;
	
public 	Titleprice_Page(WebDriver driver){
		this.driver=DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		se=new SeleniumReusable(driver);
	}
	
	@FindBy(xpath="//input[@name='q']") private WebElement Search;
	@FindBy(xpath ="//button[@type='submit']") private WebElement searchicon;

	public void entersearch(String text) {
			se.entervalue(Search, text);
	}
	public void clciksearchicon() {
		se.click(searchicon);
	}
}
