package com.business;

import com.helpers.DriverWrapper;

public class MyBusiness extends CommonBusiness {
	
	public void openURL(DriverWrapper wrapper,String url)
	{
		wrapper.getDriver().get(url);
	}
	
}
