package com.nxtgenai.extentandtestngreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class ExtentReportDemo6 {

	public static void main(String[] args) {
		
		// Attaching screen shot at test level in extent report
		
		ExtentReports extent = new ExtentReports();
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		
		// attach extent report to spark reporter
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		// taking screen shot using output type as Base64 
		
		TakesScreenshot tss= (TakesScreenshot)driver;
		String base64Screenshot = tss.getScreenshotAs(OutputType.BASE64);
		// creating test 
		
		ExtentTest test1 = extent.createTest("Test One");
		test1.log(Status.INFO, "Test execution started");
		test1.log(Status.INFO, "Test execution InProgress");
		
		//and attaching the screenshot at test level using add screen shot base64
		// it will not store screen shot at project , it will store in the extent report only
		test1.addScreenCaptureFromBase64String(base64Screenshot);
		
		test1.log(Status.INFO, "Test execution Ended");
		
		extent.attachReporter(sparkReporter);
			
		extent.flush();
		driver.quit();
		
		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
