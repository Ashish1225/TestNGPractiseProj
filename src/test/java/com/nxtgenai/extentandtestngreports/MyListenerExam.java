package com.nxtgenai.extentandtestngreports;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import utilities.ExtentReportGenerator;

public class MyListenerExam extends BaseClass implements ITestListener{
	
	// call the extent report function using class
	ExtentReports extentReport = ExtentReportGenerator.generateExtent();
	ExtentTest test;
	WebDriver driver;
	

	@Override
	public void onTestStart(ITestResult result) {
		String testName= result.getName();
		
		test = extentReport.createTest(testName);
		test.log(Status.INFO, testName+" has started..");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName= result.getName();
		test.log(Status.PASS, testName+" has successfully passed..");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName= result.getName();
		test.log(Status.FAIL, testName+" has Failed");
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		// taking screen shot and adding into extent report
		test.addScreenCaptureFromPath(takeScreenShot(driver,testName));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName= result.getName();
		test.log(Status.SKIP, testName+" has Skipped..");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}
