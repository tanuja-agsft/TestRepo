package com.agileEnergy.TestCases;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListingSites {
	
	public static void main(String args[]) {
		
	System.setProperty("webdriver.chrome.driver", "/home/agsuser/Downloads/chromedriver/");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://apps.alsoenergy.com/Account/Login");
	
	driver.findElement(By.id("Username")).sendKeys("agilesoftguest");
	driver.findElement(By.id("Password")).sendKeys("changeme");
	driver.findElement(By.xpath("//input[@value='Log in']")).click();
	
	// count the number of sites
	
	int sitesCount=driver.findElements(By.xpath("//*[@id='app']//div[contains(@class,'fixedDataTableRowLayout_rowWrapper')]//img[@src='/Content/images/ui/bldg.png']")).size();
	System.out.println("sitescount="+sitesCount);
	
	//Fetch the sites which are mentioned in dashboard footer
	String totalSiteText = driver.findElement(By.xpath("//div[@title='Total Sites']/div")).getText();
	System.out.println("totalSiteText="+totalSiteText);
	
	//Fetch only the numbers
	int value = Integer.parseInt(totalSiteText.replaceAll("[^0-9]", ""));
	System.out.println("value"+value);
	
	//Compare the listed sites with sites mentioned on dashboard footer
	if(sitesCount==value)
	{
		System.out.println("Total site count is same as number of listes sites");
	}

	//Click on site and count the number of devices
	driver.findElement(By.xpath(".//div[text()='Solar Production']")).click();
		
	int deviceCount = driver.findElements(By.xpath("//img[contains(@src,'https://www.alsoenergy.com/pub/Images/Device')]")).size();
	System.out.println("deviceCount"+deviceCount);
	
	
}

}
