package com.nxtgenai.dataprovidertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProviderDemo {
	WebDriver driver;
	
	@BeforeMethod
	public void launchApplication() throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver",
//				"D:\\SeleniumTrainingWorkspace\\TestNGFramework\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("Application is Open");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	// --- if data provider method is belong to another class
	@Test(dataProvider = "searchCountryMonument",dataProviderClass = DataProviderMethodDemo.class)
	//@Test(dataProvider = "searchCountryMonument")
	public void searchGoogle(String country, String monument) throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));
		
		// enter country and monument keys combination
		searchText.sendKeys(country + " " +monument);
		Thread.sleep(3000);
		driver.findElement(By.name("btnK")).click();
		
	}
	
	/*
	@DataProvider(name="searchCountryMonument")
	public Object[][] dataProvider(){
		Object[][] enterData = new Object[3][2];
		enterData[0][0] = "India";
		enterData[0][1] = "Qutub Minar";
		
		enterData[1][0] = "Agra";
		enterData[1][1] = "Taj Mahal";
		
		enterData[2][0] = "Hyderabad";
		enterData[2][1] = "Char Minar";
		
		return enterData;	
	}
	*/

}
