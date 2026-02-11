package StepDefination;

import Com.BaseClass.DriverFactory;
import Com.BaseClass.Library;
import Com.ReusableFunctions.SeleniumReusable;
import Pages.Fashion_Page;
import io.cucumber.java.en.*;

public class Fashion_StepDefination extends Library {
	private SeleniumReusable se;
	private Fashion_Page fp;
	
	
	@Given("user to move the fashion link")
	public void user_to_move_the_fashion_link() throws Throwable {
		se=new SeleniumReusable(DriverFactory.getDriver());
		se.gettitle();
		se.waits();
		fp=new Fashion_Page(DriverFactory.getDriver());
		fp.movefashionlink();
		se.waits();	    
	}

	@When("curser to move to the kids link")
	public void curser_to_move_to_the_kids_link() throws Throwable {
	    fp.movekidslink();
	    se.waits();
	}

	@When("move to girls dress and click")
	public void move_to_girls_dress_and_click() {
	   fp.clickgirlslink();
	}

	@When("click the price high to low link")
	public void click_the_price_high_to_low_link() {
	  fp.clickprice();
	}

	@Then("it should display therelevant details and get the title")
	public void it_should_display_therelevant_details_and_get_the_title() {
	    System.out.println("After clicking fashion link price");
	    se.gettitle();
	}
}
