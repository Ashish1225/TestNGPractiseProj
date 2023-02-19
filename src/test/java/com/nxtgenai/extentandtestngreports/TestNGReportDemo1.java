package com.nxtgenai.extentandtestngreports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGReportDemo1 {
	
	// log report using Reporter class
	
	WebDriver driver;
	
	@Test(priority = 1)
	public void search() throws InterruptedException {
		driver = new ChromeDriver();
		Reporter.log("Chrome Browser launched");
		Reporter.log("Browser launched", true);
		driver.get("https://www.google.com/");
		Reporter.log("Url is opened");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Taj Mahal",Keys.ENTER);
		Reporter.log("Search keyword and hi enter key");
		Reporter.log("Search Taj mahal and hit entered", 5);
		Thread.sleep(2000);
		driver.quit();
		Reporter.log("closing he browser");
	
	}

}
