package StepDefination;

import org.openqa.selenium.By;

import Com.BaseClass.DriverFactory;
import Com.BaseClass.Library;
import Com.ReusableFunctions.SeleniumReusable;
import Pages.Titleprice_Page;
import io.cucumber.java.en.*;

public class Titleprice_Stepdefination extends Library{
	Titleprice_Page tp;
	SeleniumReusable se;
	
	@Given("Enter the search text in the text field")
	public void enter_the_search_text_in_the_text_field() {
		tp=new Titleprice_Page(DriverFactory.getDriver());
		tp.entersearch("Shirts");
	}

	@When("Click the search icon")
	public void click_the_search_icon() {
	   tp.clciksearchicon();
	}

	@Then("It should the search result and get the title")
	public void it_should_the_search_result_and_get_the_title() {
		se=new SeleniumReusable(DriverFactory.getDriver());
		se.MultipleGettext(DriverFactory.getDriver().findElements(By.xpath("//div[@class='p0C73x']")));
		

	}	
}
