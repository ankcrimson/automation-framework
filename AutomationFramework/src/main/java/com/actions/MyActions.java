package com.actions;

import com.business.MyBusiness;
import com.helpers.DriverWrapper;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MyActions {
	DriverWrapper wrapper;
	
	
	public void setup()
	{
		if(wrapper==null)
		wrapper=new DriverWrapper();
	}

	
	@Given("^Browser is (.+)$")
	public void browserSelection(String browser) throws Throwable {
		System.setProperty("browser", browser);
		setup();
	   // throw new PendingException();
	}

	@Given("^Webpage is (.+)$")
	public void openUrl(String url)
	{
		MyBusiness business=new MyBusiness();
		business.openURL(wrapper, url);
	}
	

@Then("^search for selenium$")
public void search_for_selenium() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

}
