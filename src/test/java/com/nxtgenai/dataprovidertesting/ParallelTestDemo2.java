package com.nxtgenai.dataprovidertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTestDemo2 {
	
	WebDriver driver ;
	
	@BeforeClass
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		System.out.println("Application is launched");
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
	@Test(priority=1)
	void verifyTitle() {
		System.out.println(driver.getTitle());
		Assert.assertEquals("Swag Labs", driver.getTitle());
	}
	
	@Test(priority=2)
	public void verifyLogo() {
		WebElement logo = driver.findElement(By.xpath("//div[@class='login_logo']"));
		System.out.println("Logo is present in class 2");
		Assert.assertTrue(logo.isDisplayed());
	}

}
