package com.infy.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


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
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"src\\test\\resources\\properties\\config.properties");
		FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		config.load(fis);
		OR.load(fis2);
		
		System.out.println(config.getProperty("browser"));
		System.out.println(OR.getProperty("customerLogin_btn"));
		
		
		if(config.getProperty("browser").equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver",System.getProperty("path");
			System.setProperty("webdriver.chrome.driver", "C:\\selenium-java-4.18.1\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		
		driver.get(config.getProperty("testsiteURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("ImpliciteWait"))));
		
		
		
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
