package com.nxtgenai.crossbrowsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameterGoogleSearch {
	public WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumTrainingWorkspace\\TestNGFramework\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println("Application is Open");
		
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
	@Parameters({"searchKey"})
	@Test
	public void googleSearch(String key) {
		WebElement searchInput = driver.findElement(By.name("q"));
		searchInput.sendKeys(key);
		System.out.println(searchInput.getAttribute("value"));
		Assert.assertEquals(searchInput.getAttribute("value"), key);
		
	}

}
