package com.energy.masterPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MasterPage {
	public WebDriver driver;
	public Properties config;
	public Properties or;
	
	public MasterPage() throws IOException
	{
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\energy\\properties\\config.properties");
		config = new Properties();
		config.load(fs);
		
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\energy\\properties\\ObjectRepository.properties");
		or = new Properties();
		or.load(fi);
		 
		
		if(config.getProperty("browser").equals("firefox"))
		{
			driver = new FirefoxDriver();				
		}
		
		else if(config.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else{
			//open IE 
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://apps.alsoenergy.com/Account/Login");
		
	}

	public void sendData(String xpathKey, String userData)
	{
		driver.findElement(By.xpath(or.getProperty(xpathKey))).sendKeys(userData);
	}
	
	public void click(String xapthKey)
	{
		driver.findElement(By.xpath(or.getProperty(xapthKey))).click();
	}
	
	public boolean isLinkPresent(String xapthKey)
	{
		try{
		driver.findElement(By.xpath(or.getProperty(xapthKey)));
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("could not locate the xpath");
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}