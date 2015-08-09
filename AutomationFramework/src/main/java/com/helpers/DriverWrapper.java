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
		if(props.get("os.name").toString().equalsIgnoreCase("linux"))
			if(props.get("os.arch").toString().equals("amd64"))
				System.setProperty("webdriver.chrome.driver", "src/main/resources/execs/chromedriver_l64");
			else
				System.setProperty("webdriver.chrome.driver", "src/main/resources/execs/chromedriver_l32");
		else
			System.setProperty("webdriver.chrome.driver", "src/main/resources/execs/chromedriver.exe");
		driver=new ChromeDriver();
	}
	else
	{
		driver=new FirefoxDriver();
	}
	
	
	return driver;
}
public void close()
{
if(driver!=null)
{
	driver.close();
}
}
}
