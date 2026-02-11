package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.BaseClass.DriverFactory;
import Com.BaseClass.Library;
import Com.ReusableFunctions.SeleniumReusable;

public class MultipleSearch_Page{
	private WebDriver driver;
	private SeleniumReusable se;
	
public MultipleSearch_Page(WebDriver driver) {
	this.driver = DriverFactory.getDriver();
	PageFactory.initElements(driver, this);
}


@FindBy (xpath ="//input[@name='q']" )private WebElement searchfiled;

public void Entersearch(String searchtext) {
	se=new SeleniumReusable(DriverFactory.getDriver());
	se.entervalue(searchfiled, searchtext);
}

public void clicksearch() {
	searchfiled.sendKeys(Keys.ENTER);
}

}
