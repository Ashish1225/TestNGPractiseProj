package com.nxtgenai.grouping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InvocationCountTestDemo3 {
	
	// if invocationCount is 0 then it will not execute that test
	
	@Test(invocationCount = 4,threadPoolSize = 3)
	public void testCase1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://randomuser.me/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@data-label='name']")).click();
		String userName = driver.findElement(By.xpath("//p[@id='user_value']")).getText();
		System.out.println("UserName is :"+userName);
		
		driver.findElement(By.xpath("//li[@data-label='email']")).click();
		String userEmail = driver.findElement(By.xpath("//p[@id='user_value']")).getText();
		System.out.println("UserName is :"+userEmail);
		
		driver.quit();
		
	}

}
