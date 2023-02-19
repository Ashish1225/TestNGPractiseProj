package com.nxtgenai.listenerexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.nxtgenai.listenerexample.ListenerClass.class)
public class ListnerDemo1 {
	
	/*
	 * launch browser
	 * login in the application
	 * verify the title
	 * Listener is an interface
	 * based on the result we have to take post action - listener
	 * 
	 */
	
	WebDriver driver;
	
	@BeforeClass
	public void lauchBrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		System.out.println("Application is launched");
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void loginApplication() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[norm alize-space()='Login']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test(priority=2)
	public void testFail() {
		System.out.println("Fail test case");
		Assert.assertTrue(false);
	}
	
	@Test(priority=3)
	public void testSkip() {
		System.out.println("Skip test case");
		throw new SkipException("Skip Exception thrown...");
	}
	
	@Test(priority=4, timeOut = 1000)
	public void testTimeOutFailure() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("time out test method");
		
	}
}
