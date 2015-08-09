package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.helpers.DriverWrapper;
import com.helpers.PageElementsHelper;

public class HomePage extends CommonPage {

	public String getPageName()
	{
		String pageName=this.getClass().getSimpleName();
		pageName=System.getProperty("platform")+"_"+pageName;
		return pageName;
	}

	
	public WebElement getElement(DriverWrapper wrapper,String fieldName)
	{
		return PageElementsHelper.getWebElement(wrapper, getPageName(), fieldName);
	}
	
	public List<WebElement> getElements(DriverWrapper wrapper,String fieldName)
	{
		return PageElementsHelper.getWebElements(wrapper, getPageName(), fieldName);
	}
}
