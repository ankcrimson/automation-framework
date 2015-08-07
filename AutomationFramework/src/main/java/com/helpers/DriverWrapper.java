package com.helpers;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * To act like a Driver Wrapper responsible for managing the web/appium driver
 */
public class DriverWrapper {
	private WebDriver driver;
public WebDriver getDriver()
{
	if(driver!=null)
		return driver;
	Properties props=System.getProperties();
	String browser="firefox";
	if(props.containsKey("browser"))
	{
	browser=props.getProperty("browser").trim().toLowerCase();	
	//System.out.println(browser);
	}
	//System.out.println(props);
	if(browser.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver=new ChromeDriver();
	}
	else
	{
		driver=new FirefoxDriver();
	}
	
	
	return driver;
}
}
