package com.helpers;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageElementsHelper{

	private WebDriver driver;
	
	private static final int SHORT_TO = 5;
	private static final String PAGEOBJECT_PATH = "./src/main/resources/com/properties/";
	private static HashMap<String,HashMap<String,HashMap<String,String>>> allProps;//All Propertiy files within pageobject_path
	private static ArrayList<String> priorityList; 
	
	static{//static block to initialize
		try{
		setAllProps();
		}catch(Exception e){System.out.println("Error Reading Properties");}
		//System.out.println("Properties loaded"+getAllProps());
		try{
			loadPriority();
		}catch(Exception e){System.out.println("Error Reading Priority");}
		System.out.println("Priorities loaded"+getPriorityList());
		
	}
	/*
	public static By getBy(String pageName,String fieldName)
	{
		//dt_CartPage,txt_Promo_Code_Loc
		int pageNameStart=pageName.lastIndexOf(".");
		pageName=pageName.substring(pageNameStart+1);
		//System.out.println("PageName="+pageName+",FieldName="+fieldName);
		HashMap<String,String> elementPathMap=allProps.get(pageName).get(fieldName);
		//WebElement we=null;
		By by=null;
		String selector=null;
		String pathValue=null;
		for(String plItem:priorityList)
		{
			if(elementPathMap.containsKey(plItem))
			{
				selector=plItem;
				pathValue=elementPathMap.get(plItem);
				break;
			}
		}
		if(selector==null||pathValue==null)
		{
			System.out.println("Selector Name is invalid or not found");
		}
		
		if (selector.equalsIgnoreCase("CLASS"))by= By.className(pathValue);
		else if (selector.equalsIgnoreCase("CSS"))by= By.cssSelector(pathValue);
		else if (selector.equalsIgnoreCase("ID")) by= By.id(pathValue);
		else if (selector.equalsIgnoreCase("LINKTEXT"))by= By.linkText(pathValue);
		else if (selector.equalsIgnoreCase("NAME"))by= By.name(pathValue);
		else if (selector.equalsIgnoreCase("PARTIALLINKTEXT"))by= By.partialLinkText(pathValue);
		else if (selector.equalsIgnoreCase("TAG"))by= By.tagName(pathValue);
		else if (selector.equalsIgnoreCase("XPATH"))by= By.xpath(pathValue);

		
		return by;
	}
	
	*/

	public static WebElement getWebElement(DriverWrapper se,String pageName,String fieldName)
	{
		WebDriver driver=se.getDriver();
		//dt_CartPage,txt_Promo_Code_Loc
		int pageNameStart=pageName.lastIndexOf(".");
		HashMap<String,String> elementPathMap=null;
		pageName=pageName.substring(pageNameStart+1);
		//System.out.println("PageName="+pageName+",FieldName="+fieldName);
		try{
		elementPathMap=allProps.get(pageName).get(fieldName);
		}catch(Exception e){System.out.println("Error for:\nPageName="+pageName+",FieldName="+fieldName);e.printStackTrace();return null;}
		WebElement we=null;
		//By by=null;
		String selector=null;
		String pathValue=null;
		for(String plItem:priorityList)
		{
			try{
			if(elementPathMap.containsKey(plItem))
			{
				selector=plItem;
				pathValue=elementPathMap.get(plItem);
				By by=null;
				if (selector.equalsIgnoreCase("CLASS"))by= By.className(pathValue);
				else if (selector.equalsIgnoreCase("CSS"))by= By.cssSelector(pathValue);
				else if (selector.equalsIgnoreCase("ID")) by= By.id(pathValue);
				else if (selector.equalsIgnoreCase("LINKTEXT"))by= By.linkText(pathValue);
				else if (selector.equalsIgnoreCase("NAME"))by= By.name(pathValue);
				else if (selector.equalsIgnoreCase("PARTIALLINKTEXT"))by= By.partialLinkText(pathValue);
				else if (selector.equalsIgnoreCase("TAG"))by= By.tagName(pathValue);
				else if (selector.equalsIgnoreCase("XPATH"))by= By.xpath(pathValue);
				//break;
			if(by!=null)
			{
				//WebDriverWait waiter = new WebDriverWait(driver, 5000);
				//waiter.until( ExpectedConditions.presenceOfElementLocated(by) );
				//driver.FindElement(by);
				try{
				we=(new WebDriverWait(driver, 2)).until(ExpectedConditions.presenceOfElementLocated(by));
				}catch(Throwable th){System.out.println("Problem with selector:"+selector+", in page:"+pageName+"having value"+pathValue);continue;}
			}if(we!=null)
			break;
			}
			}catch(Exception e)
			{e.printStackTrace();System.out.println("Problem with selector:"+selector+", in page:"+pageName+"having value"+pathValue);}
		}
		if(selector==null||pathValue==null)
		{
			System.out.println("Selector Name is invalid or not found");
		}
	if(we==null)
	{System.out.println("WebElement is null");}
		return we;
	}
	
	public static List<WebElement> getWebElements(DriverWrapper se,String pageName,String fieldName)
	{
		WebDriver driver=se.getDriver();
		//dt_CartPage,txt_Promo_Code_Loc
		int pageNameStart=pageName.lastIndexOf(".");
		pageName=pageName.substring(pageNameStart+1);
		//System.out.println("PageName="+pageName+",FieldName="+fieldName);
		HashMap<String,String> elementPathMap=allProps.get(pageName).get(fieldName);
		List<WebElement> we=null;
		//By by=null;
		String selector=null;
		String pathValue=null;
		for(String plItem:priorityList)
		{
			try{
			if(elementPathMap.containsKey(plItem))
			{
				selector=plItem;
				pathValue=elementPathMap.get(plItem);
				By by=null;
				if (selector.equalsIgnoreCase("CLASS"))by= By.className(pathValue);
				else if (selector.equalsIgnoreCase("CSS"))by= By.cssSelector(pathValue);
				else if (selector.equalsIgnoreCase("ID")) by= By.id(pathValue);
				else if (selector.equalsIgnoreCase("LINKTEXT"))by= By.linkText(pathValue);
				else if (selector.equalsIgnoreCase("NAME"))by= By.name(pathValue);
				else if (selector.equalsIgnoreCase("PARTIALLINKTEXT"))by= By.partialLinkText(pathValue);
				else if (selector.equalsIgnoreCase("TAG"))by= By.tagName(pathValue);
				else if (selector.equalsIgnoreCase("XPATH"))by= By.xpath(pathValue);
				//break;
				if(by!=null)
				{
					//WebDriverWait waiter = new WebDriverWait(driver, 5000);
					//waiter.until( ExpectedConditions.presenceOfElementLocated(by) );
					//driver.FindElement(by);
					try{
					we=(new WebDriverWait(driver, 2)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
					}catch(Throwable th){System.out.println("Problem with selector:"+selector+", in page:"+pageName+"having value"+pathValue);continue;}
				}if(we!=null&&we.size()>0)
				break;
				}
				}catch(Exception e)
			{e.printStackTrace();System.out.println("Problem with selector:"+selector+", in page:"+pageName+"having value"+pathValue);}
		}
		if(selector==null||pathValue==null)
		{
			System.out.println("Selector Name is invalid or not found");
		}
	
		return we;
	}
	
	public static ArrayList<String> getPriorityList() {
		return priorityList;
	}
	public static void loadPriority() {
	if(priorityList==null)
		priorityList=new ArrayList<String>();
	try{
	FileReader fr=new FileReader(PAGEOBJECT_PATH + "priority.list");
	BufferedReader br=new BufferedReader(fr);
	String line="";
	while((line=br.readLine())!=null)
	{
		line=line.trim();
		if(line.startsWith("#")|| line.length()==0)
			continue;
		priorityList.add(line.toUpperCase());
		
	}
	br.close();
	fr.close();
	}catch(Exception e){System.out.println("Error in priority file");}
	}
	
	public static HashMap<String, HashMap<String, HashMap<String, String>>> getAllProps() {
		return allProps;
	}
	
	
	private static HashMap<String,HashMap<String,HashMap<String,String>>> setAllProps(){
		File dir=new File(PAGEOBJECT_PATH);
		String[] files=dir.list();
		
		//HashMap<String,HashMap<String,HashMap<String,String>>> allProps=new HashMap<String,HashMap<String,HashMap<String,String>>>();
		if(allProps==null)
			allProps=new HashMap<String,HashMap<String,HashMap<String,String>>>();
		
		try{
			for(String filename:files)
			{
				
				
				if(filename.endsWith("properties"))
				{
					
					HashMap<String,HashMap<String,String>> pageProps=null;
					int dotIndex=filename.indexOf(".");
					String pageObjectName=filename.substring(0,dotIndex);
					if(allProps.containsKey(pageObjectName))
						{
						pageProps=allProps.get(pageObjectName);
						}
					else
						{
						pageProps=new HashMap<String,HashMap<String,String>>();
						}
					
					
					
					//reading property file non traditionally
					FileReader fr=new FileReader(PAGEOBJECT_PATH + filename);
					BufferedReader br=new BufferedReader(fr);
					String line="";
					while((line=br.readLine())!=null)
					{
						line=line.trim();
						//System.out.println(filename+" <=> "+line);
						if(line.startsWith("#")|| line.length()==0)
							continue;
						int fieldNameEnd=line.indexOf("=");
						String field=line.substring(0,fieldNameEnd);
						int typeEnd=line.indexOf(",");
						String type=line.substring(fieldNameEnd+1, typeEnd).toUpperCase();
						String selector=line.substring(typeEnd+1);
						
						HashMap<String,String> fieldProps=null;
						if(pageProps.containsKey(field))
						{
							fieldProps=pageProps.get(field);
						}
						else
						{
							fieldProps=new HashMap<String,String>();
						}
						fieldProps.put(type, selector);
						pageProps.put(field, fieldProps);
					}
					//end reading
					br.close();
					fr.close();
					allProps.put(pageObjectName, pageProps);
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//allProps=allProps;
		return allProps;
	}

}

