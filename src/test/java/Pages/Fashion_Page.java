package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.BaseClass.Library;
import Com.ReusableFunctions.SeleniumReusable;

public class Fashion_Page extends Library{
	
	WebDriver driver;
	SeleniumReusable se;
	
	public Fashion_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="(//div[@class=\"yQdBY2\"])[3]") private WebElement fashionlink;
	@FindBy(xpath = "//a[text()='Kids']") private WebElement kidslink;
	@FindBy(xpath = "//a[text()='Girls Dresses']") private WebElement girlsdresslink;
	@FindBy(xpath = "//div[text()='Price -- High to Low']") private WebElement pricehightolow;

	
	public void movefashionlink() {
		se=new SeleniumReusable(driver);
		se.highleterelement(fashionlink);
		se.mousehover(fashionlink);
	}
	
	public void movekidslink() {
		se.highleterelement(kidslink);
		se.mousehover(kidslink);
		
	}
	
	public void clickgirlslink() {
		se.highleterelement(girlsdresslink);
		se.moveelement(girlsdresslink);
		
	}
	
	public void clickprice() {
		se.highleterelement(pricehightolow);
		se.click(pricehightolow);
		
	}

}
