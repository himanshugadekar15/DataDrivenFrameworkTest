package com.infy.testCases;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.infy.base.TestBase;


public class LoginTest extends TestBase{

	@Test
	public void loginAsBankManager() throws InterruptedException
	{
		driver.findElement(By.cssSelector("div>div:last-child> .btn.btn-primary.btn-lg")).click();
		Thread.sleep(5000);
	}
	
	
}
