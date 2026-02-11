package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Com.BaseClass.DriverFactory;
import Com.BaseClass.Library;
import Com.ReusableFunctions.SeleniumReusable;
import Pages.Filter_Page;
import io.cucumber.java.en.Then;

public class Filter_Stepdefination extends Library{
	Filter_Page fp;
	SeleniumReusable se;
	
	@Then("Select Minimum and Maximum amount")
	public void select_minimum_and_maximum_amount() throws Throwable {
		fp=new Filter_Page(DriverFactory.getDriver());
		String beforefilter = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='col col-7-12'])[1]")).getText();
		System.out.println("before filter:"+beforefilter);
		fp.min();
		se=new SeleniumReusable(DriverFactory.getDriver());
		se.waits();
		fp.max();
		se.waits();
		
	    
	}

	@Then("Select the Brand")
	public void select_the_brand() throws Throwable {
	    fp.brand();
	    se.waits();
	}

	@Then("Select the Ram")
	public void select_the_ram() throws Throwable {
	   fp.ram();
	   se.waits();
	}

	@Then("Select Battery Capacity")
	public void select_battery_capacity() throws Throwable {
	  fp.clcikbattery();
	  se.waits();
	}

	@Then("It should display the Relevant result")
	public void it_should_display_the_relevant_result() {
	    System.out.println("**********************************************");
	    String afterfilter = DriverFactory.getDriver().findElement(By.xpath("//div[text()='vivo Y93 (Nebula Purple, 32 GB)']")).getText();
	    System.out.println("afterfilter :"+afterfilter);
	}



}
