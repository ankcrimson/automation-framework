package com.actions;

import com.business.Home;
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

	
	@Given("^Browser is (.+) on (.+)$")
	public void browserSelection(String browser,String platform) throws Throwable {
		System.setProperty("browser", browser);
		System.setProperty("platform", platform);
		setup();
	   // throw new PendingException();
	}

	@Given("^Webpage is (.+)$")
	public void openUrl(String url)
	{
		Home business=new Home();
		business.openURL(wrapper, url);
	}
	

@Then("^search for (.+)$")
public void searchForText(String text) throws Throwable {
    Home home=new Home();
    home.searchText(wrapper, text);
}

@Then("^click on (\\d+)st link$")
public void clickOnLinkPos(int n) throws Throwable {
    //throw new PendingException();
	Home home=new Home();
    home.clickNthLink(wrapper, n);
}



@Then("^wait for (\\d+) ms$")
public void waitForMillis(int time) throws Throwable {
    int wait=time;
    Thread.sleep(wait);
}


@Then("^close browser$")
public void close_browser() throws Throwable {
	wrapper.close();
}

}
