package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.BaseClass.DriverFactory;
import Com.BaseClass.Library;
import Com.ReusableFunctions.SeleniumReusable;

public class Filter_Page {
	private WebDriver driver;
	private SeleniumReusable se;
	
	public Filter_Page(WebDriver driver) {
		this.driver=DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//select[@class='hbnjE2'][1])")private WebElement  ManimumAmount;
	@FindBy(xpath = "(//select[@class='hbnjE2'])[2]") private WebElement  MaximumAmount;
	@FindBy(xpath = "//div[text()='vivo']") private WebElement  Brand;
	@FindBy(xpath = "//div[text()='4 GB']") private WebElement  Ram;
	@FindBy(xpath = "//div[text()='Battery Capacity']") private WebElement  BatteryRow;
	@FindBy(xpath = "//div[text()='4000 - 4999 mAh']") private WebElement  BatteryCapacity;
	
	
	
	public void min() {
		se=new SeleniumReusable(driver);
		se.dropdown(ManimumAmount, "10000");
	}
	
	public void max() {
		se=new SeleniumReusable(driver);
		se.dropdown(MaximumAmount, "20000");				
	}
	
	public void brand() {
		se=new SeleniumReusable(driver);
		se.click(Brand);
	}
	
	public void ram() {
		se=new SeleniumReusable(driver);
		se.scrolldown(Ram);
		se.click(Ram);
	}
	
	public void clcikbattery() {
		se=new SeleniumReusable(driver);
		se.scrolldown(BatteryRow);
		se.scrolldown(BatteryCapacity);
	}
}
