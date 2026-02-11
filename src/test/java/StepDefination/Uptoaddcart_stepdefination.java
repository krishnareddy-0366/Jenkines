package StepDefination;

import Com.BaseClass.DriverFactory;
import Com.BaseClass.Library;
import Com.ReusableFunctions.SeleniumReusable;
import Pages.Uptoaddcart_Page;
import io.cucumber.java.en.*;

public class Uptoaddcart_stepdefination extends Library {
	SeleniumReusable re;
	Uptoaddcart_Page up;
	
	@Given("User can move to the login link")
	public void user_can_move_to_the_login_link() throws Throwable {
	    up=new Uptoaddcart_Page(DriverFactory.getDriver());
	    re=new SeleniumReusable(DriverFactory.getDriver());
	    up.MovetoLogin();
		re.waits();
		System.out.println("parentwindow title");
		re.gettitle();
	}
	
	@When("User can click the flipkart pluse zone")
	public void user_can_click_the_flipkart_pluse_zone() throws Throwable {
		up.MovetoFlipkartzone();
		re.waits();
	    	}

	@When("Mouse move to the Home&Furniture link")
	public void mouse_move_to_the_home_furniture_link() throws Throwable {
		up.MousetoHome_Furniture();
		re.waits();

	    
	}

	@When("going to click the wall lamp")
	public void going_to_click_the_wall_lamp() throws Throwable {
		up.MovetoWall_lamp();
		re.waits();
	    
	}

	@When("scroll down the page and click one particular result")
	public void scroll_down_the_page_and_click_one_particular_result() throws Throwable {
		up.ClickOnresult();
		re.waits();
	}

	@When("Enter delivery pincode and click the check link")
	public void enter_delivery_pincode_and_click_the_check_link() throws Throwable {
		up.CkickOnPincode();
		re.waits();
	}

	@Then("Pincode should be checked and display and verify the titles")
	public void pincode_should_be_checked_and_display_and_verify_the_titles() {
		up.Clickchecklink();
		System.out.println("Childwindow title");
		re.gettitle();
		re.screenshot("C:\\Users\\G\\eclipse-workspace\\Y_End_To_End_FlipkartProject\\src\\test\\resources\\Screenshot\\lamp.png");
		
	    
	}


}
