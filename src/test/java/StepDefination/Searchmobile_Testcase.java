package StepDefination;

import java.io.IOException;

import Com.BaseClass.DriverFactory;
import Com.BaseClass.Library;
import Pages.Search_Page;
import io.cucumber.java.en.*;

public class Searchmobile_Testcase{
	private Search_Page sp;
	@Given("Launch the Flipkart aplication")
	public void launch_the_flipkart_aplication() throws IOException {
	   
	}

	@When("Close the popup")
	public void close_the_popup() {
	   System.out.println(DriverFactory.getDriver().getTitle());
	}

	@Then("It should navigates to the home page")
	public void it_should_navigates_to_the_home_page() {
	    sp=new Search_Page(DriverFactory.getDriver());
	    sp.homescreen();
	}

	@Given("user enter the text in the search field")
	public void user_enter_the_text_in_the_search_field() {
	    sp.search("Mobiles");
	}

	@When("Click te search buttion")
	public void click_te_search_buttion() {
	    sp.clciksearch();
	}

	@Then("It should navigates to the search result page and display the relavent details")
	public void it_should_navigates_to_the_search_result_page_and_display_the_relavent_details() {
	    sp.Result();
	}
	
	@Then("Extract the results and print console")
	public void extract_the_results_and_print_console() {
	   sp.printentairesults();
	}

	@Then("Print the third result and keep it vin the console")
	public void print_the_third_result_and_keep_it_vin_the_console() {
		sp.print3searchresults();
	    
	}



}
