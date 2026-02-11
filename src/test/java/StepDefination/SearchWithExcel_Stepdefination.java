package StepDefination;


import Com.BaseClass.DriverFactory;
import Com.BaseClass.Library;
import Com.ReusableFunctions.SeleniumReusable;
import Pages.Searchexcel_Page;
import io.cucumber.java.en.*;

public class SearchWithExcel_Stepdefination extends Library {
	
	Searchexcel_Page sp;
	SeleniumReusable re;

	@Given("Enter search Test in the search Field")
	public void enter_search_test_in_the_search_field() throws Throwable {
	    
		 sp= new Searchexcel_Page(DriverFactory.getDriver());
		 sp.Searchwithexcel();
	}

	@When("click search Icon")
	public void click_search_icon() {
	    re = new SeleniumReusable(DriverFactory.getDriver());
	    re.screenshot("src/test/resources/Screenshot/searchexcel_"+System.currentTimeMillis()+".png");
	}

	@Then("It should display the Relevent result")
	public void it_should_display_the_relevent_result() {
	   re.gettitle();
	}


}
