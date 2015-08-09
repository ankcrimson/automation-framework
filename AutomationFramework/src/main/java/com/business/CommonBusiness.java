package com.business;

import com.helpers.DriverWrapper;

/*
 * to contain common business methods
 */
public class CommonBusiness {
	public void openURL(DriverWrapper wrapper,String url)
	{
		wrapper.getDriver().get(url);
	}
}
