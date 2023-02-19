package com.nxtgenai.listenerexample;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(ListenerClass.class)
public class Login {
	
	WebDriver driver;
	
	@BeforeMethod
	public void launchApplicaion() {
		driver = new ChromeDriver();
		driver.get("http://www.tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void closeApplication() {
		
		driver.quit();
	}
	
	@Test(priority=0)
	public void loginWithValidCred() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("ashishpal1@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		try {
			Thread.sleep(3000);
			Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Edit your account information']")).isDisplayed());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	
	@Test(priority=1)
	public void loginWithInvalidCred() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("ashishpal12@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		try {
			Thread.sleep(3000);
			Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Edit your account information']")).isDisplayed());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	
	@Test(priority=2)
	public void loginWithValidUserInvalidPass() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("ashishpal1@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		try {
			Thread.sleep(3000);
			Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Edit your account information']")).isDisplayed());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}
