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

public class ExtentReportDemo5 {

	public static void main(String[] args) {
		
		// Attaching screen shot at test level in extent report
		
		ExtentReports extent = new ExtentReports();
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport1.html");
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
		
		// taking screen shot using output type as file
		TakesScreenshot tss = (TakesScreenshot)driver;
		File srsFile = tss.getScreenshotAs(OutputType.FILE);
		String destFile = "D:\\SeleniumTrainingWorkspace\\TestNGFramework\\Screenshots\\TutorialsNinjaHome.png";
		try {
			Files.copy(srsFile, new File(destFile));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// creating test 
		
		ExtentTest test1 = extent.createTest("Test One");
		test1.log(Status.INFO, "Test execution started");
		test1.log(Status.INFO, "Test execution InProgress");
		
		//and attaching the screenshot at test level
		test1.addScreenCaptureFromPath(destFile,"TutorialsNinja Home Page screen shot");
		
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
