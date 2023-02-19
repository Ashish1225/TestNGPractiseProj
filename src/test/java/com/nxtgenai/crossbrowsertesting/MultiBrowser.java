package com.nxtgenai.crossbrowsertesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class MultiBrowser {

	public WebDriver driver;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void launchApplication(String browser, String url) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\SeleniumTrainingWorkspace\\TestNGFramework\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"D:\\SeleniumTrainingWorkspace\\TestNGFramework\\Driver\\msedgedriver.exe");

			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		Reporter.log("Application is Launched");
	}
	
	@AfterClass
	public void closeApplication() {
		driver.close();
		Reporter.log("Application is Closed");
	}
}
