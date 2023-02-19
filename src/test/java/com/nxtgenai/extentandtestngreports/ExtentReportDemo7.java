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

public class ExtentReportDemo7 {
	
	static WebDriver driver;

	public static void main(String[] args) {

		// Attaching screen shot at test level in extent report

		ExtentReports extent = new ExtentReports();
		File file = new File(System.getProperty("user.dir") + "\\ExtentReports\\eReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

		// attach extent report to spark reporter

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		// creating test

		ExtentTest test1 = extent.createTest("Test One");
		test1.log(Status.INFO, "Test execution started");
		test1.log(Status.INFO, "Test execution InProgress");

		// and attaching the screenshot at test level using add screen shot 
		
		test1.addScreenCaptureFromPath(takeScreenShot("homePageScreenShot"));

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

	public static String takeScreenShot(String fileName) {
		// taking screen shot using output type file

		TakesScreenshot tss = (TakesScreenshot) driver;
		File srcsScreenshot = tss.getScreenshotAs(OutputType.FILE);
		File destScreen = new File(System.getProperty("user.dir") + "\\Screenshots\\"+fileName+".png");
		try {
			Files.copy(srcsScreenshot, destScreen);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return destScreen.getAbsolutePath();
		
	}

}
