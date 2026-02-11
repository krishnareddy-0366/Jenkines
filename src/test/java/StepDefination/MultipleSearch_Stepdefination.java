package StepDefination;

import Com.BaseClass.DriverFactory;
import Com.BaseClass.Library;
import Com.ReusableFunctions.SeleniumReusable;
import Pages.MultipleSearch_Page;
import io.cucumber.java.en.*;

public class MultipleSearch_Stepdefination {
	
	MultipleSearch_Page ms;
	  SeleniumReusable sr;
	@Given("user enter the {string} in the search field")
	public void user_enter_the_in_the_search_field(String searchtext) {
		ms=new MultipleSearch_Page(DriverFactory.getDriver());
		ms.Entersearch(searchtext);
	  
	}

	@When("click the search button")
	public void click_the_search_button() {
		ms.clicksearch(); 
	  
	}

	@Then("en it should navigates to the text page and display the correspding page")
	public void en_it_should_navigates_to_the_text_page_and_display_the_correspding_page() {
	   sr= new SeleniumReusable(DriverFactory.getDriver());
	   sr.gettitle();
	   System.out.println("*******************************************");
	   sr.screenshot("C:\\Users\\G\\eclipse-workspace\\Y_End_To_End_FlipkartProject\\src\\test\\resources\\Screenshot\\Multiplesearch"+System.currentTimeMillis()+".png");
	}


}
