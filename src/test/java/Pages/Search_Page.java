package Pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.BaseClass.DriverFactory;
import Com.BaseClass.Library;
import Com.ReusableFunctions.SeleniumReusable;

public class Search_Page extends Library{
	private WebDriver driver;
	private SeleniumReusable se;
	
	public Search_Page(WebDriver driver) {
		this.driver= DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='q']") private WebElement Searchtext;
	@FindBy(xpath = "//html[@lang='en-IN']") private WebElement Homepage;
	@FindBy(xpath = "//html[@lang='en']") private WebElement searchresult;
	@FindBy(xpath = "//div[@class='col col-7-12']") private List<WebElement> Entireresult;
	@FindBy(xpath = "(//div[@class='col col-7-12'])[3]") private WebElement thirdsearchresult;
	
	
	
	public void search(String text) {
		se = new SeleniumReusable(driver);
		se.entervalue(Searchtext, text);
	}

	public void clciksearch() {
		Searchtext.sendKeys(Keys.ENTER);
	}

	public void homescreen() {
		// System.out.println(Homepage.isDisplayed());
	}

	public void Result() {
		System.out.println(searchresult.isDisplayed());
		System.out.println(driver.getTitle());
	}

	public void printentairesults() {
		se.MultipleGettext(Entireresult);
	}

	public void print3searchresults() {
		System.out.println("#########################");
		se.getvalue(thirdsearchresult);
	}
}

