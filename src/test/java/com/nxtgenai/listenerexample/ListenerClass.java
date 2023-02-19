package com.nxtgenai.listenerexample;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseClass;

public class ListenerClass extends BaseClass implements ITestListener {
//public class ListenerClass implements ITestListener {
	
	WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		// retrieving test tag name along with test name
		// it will be used with tstng.xml file test tag
		String testName = result.getTestContext().getName()+"-"+result.getName();
		System.out.println("Name of the test method Started :"+testName);	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of the test method successfully executed :"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getTestContext().getName()+"-"+result.getName();
		System.out.println("Test method is failed :" + testName);
		
		// taking screen shot on test fail
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		
		// we will move this code to the base class where screen shot will be captured
		// calling the method from base class
		captureScreenShot(driver, testName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test method is skipped :" + result.getName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Name of the onTestFailedWithTimeout :"+result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart method is invoked");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinished method is executed");
	}

//	public void onStart(ITestContext Result) {
//		System.out.println("onStart method is invoked");
//	}
//
//	public void onFinish(ITestContext Result) {
//		System.out.println("onFinished method is executed");
//	}
//
//	public void onTestFailure(ITestContext Result) {
//		System.out.println("Test method is failed :" + Result.getName());
//	}
//
//	public void onTestSkipped(ITestContext Result) {
//		System.out.println("Test method is skipped :" + Result.getName());
//	}
//	
//	public void onTestStart(ITestContext Result) {
//		System.out.println("Name of the test method Started :"+Result.getName());
//
//	}
//	public void onTestSuccess(ITestContext Result) {
//		System.out.println("Name of the test method successfully executed :"+Result.getName());
//	}
//	public void onTestFailedButWithinSuccessPercentage(ITestContext Result) {
//	}

}
