package com.infy.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

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
		FileInputStream fis = new FileInputStream("C:\\Users\\himan\\eclipse-workspace\\DataDrivenFramework\\src\\test\\resources\\properties\\config.properties");
		FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		config.load(fis);
		OR.load(fis2);
		
		System.out.println(config.getProperty("browser"));
		System.out.println(OR.getProperty("customerLogin_btn"));
		
		
		
		
		
		}
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.close();
		
	}
}
