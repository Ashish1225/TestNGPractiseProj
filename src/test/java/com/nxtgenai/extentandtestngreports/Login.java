package com.nxtgenai.extentandtestngreports;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Attaching screenshots to extent reports only for the failed tests

public class Login {
	
	WebDriver driver; 
	
	@BeforeMethod
	public void launchApplication() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void loginWithValidCred() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		driver.findElement(By.name("email")).sendKeys("ashishpal1@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Edit your account information abcds']")).isDisplayed());
		
	}
	
	@Test(priority = 2)
	public void loginWithInValidCred() {
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		driver.findElement(By.name("email")).sendKeys("ashishpal1"+generateTimeStampForCred()+"@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		
	}
	
	@Test(priority = 3,dependsOnMethods ={"loginWithValidCred"} )
	public void loginWithoutCred() {
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		driver.findElement(By.name("email")).sendKeys("");
		driver.findElement(By.name("password")).sendKeys("");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		
	}
		
	// to generate random timeStamp
	public String generateTimeStampForCred() {
		Date date = new Date();
		
		return date.toString().replace(" ","_").replace(":", "_");
	}

}
