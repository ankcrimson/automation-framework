package com.business;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.helpers.DriverWrapper;
import com.pages.HomePage;

public class Home extends CommonBusiness {
	
	public void searchText(DriverWrapper wrapper,String text)
	{
		HomePage page=new HomePage();
		WebElement searchBox=page.getElement(wrapper, "searchbar");
		searchBox.sendKeys(text);
		WebElement searchBtn=page.getElement(wrapper, "searchbtn");
		searchBtn.click();
	}

	
	public void clickNthLink(DriverWrapper wrapper,int num)
	{
		HomePage page=new HomePage();
		List<WebElement> links=page.getElements(wrapper, "resultLinks");
		System.out.println(links.size());
		links.get(num-1).click();
	}

}
