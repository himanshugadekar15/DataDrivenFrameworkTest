

package com.infy.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;


public class TestBase {

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	
	
	@BeforeSuite
	public void setUp() throws IOException
	{
		if(driver== null)
		{

			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			config.load(fis);
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
			
		if(config.getProperty("browser").equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
			}
		else
			{
				System.setProperty("webdriver.chrome.driver" , "C:\\ChoromeDriver\\chromedriver.exe");
				driver = new FirefoxDriver();
			}
		
		driver.get(config.getProperty("testsiteURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("ImpliciteWait"))));
		
		
		
		}
		
	}		

	public boolean isElementVisible(By by)
	{
		try
		{
		driver.findElement(by);
		return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
	
	
	
	
		@AfterSuite
		public void tearDown()
		{
			if(driver!=null)
			{
			//closing browser
			driver.quit();
			}
		}
}

	
