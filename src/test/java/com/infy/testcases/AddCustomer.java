package com.infy.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.infy.base.TestBase;



public class AddCustomer extends TestBase{
	
	
	@Test(dataProvider="getdata")
	public void addCustomer(String firstname,String lastname,String postcode,String alerttext) throws InterruptedException 
	{
		driver.findElement(By.xpath(OR.getProperty("AddCust"))).click();
		driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(firstname);
		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(lastname);
		driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postcode);
		driver.findElement(By.xpath(OR.getProperty("addingAll"))).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alerttext);
		System.out.println(alert.getText());
		Assert.assertTrue(alert.getText().contains(alerttext));
		Thread.sleep(4);
		alert.accept();
		
	}
	
	@DataProvider(name = "getdata")
	public Object[][] getdata() throws InvalidFormatException, IOException
	{
		String sheetName = "AddCustomer";
		System.out.println(excel.getRowCount(sheetName));
		System.out.println(excel.getColumnCount(sheetName));
		
		
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows-1][cols];
		
		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				
			}

		}
		return data;	
	}
	
}	
	

