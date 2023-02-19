package com.nxtgenai.extentandtestngreports;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportDemo1 {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentSparkReporter("ExtentReportDemo1.html"); 
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		// adding environment details
		
		reports.setSystemInfo("Machine", "Ashish_Machine");
		reports.setSystemInfo("OS", "windows 10");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("User", "Ashish Sahu");
		
		// configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Extent Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
		
	}
	@Test(priority=0)
	public void launchBrowserAndOpenUrl() {
		// create test
		test=reports.createTest("Launch Browser and Open Url");
		Assert.assertTrue(true);	
	}
	
	@Test(priority=1)
	public void verifyTitle() {
		// create test
		test=reports.createTest("Verify Title");
		Assert.assertTrue(false);	
	}
	
	@Test(priority=2)
	public void verifyLogo() {
		// create test
		test=reports.createTest("Logo Verified");
		Assert.assertTrue(true);	
	}
	
	@Test(priority=3)
	public void verifyEmail() {
		// create test
		test=reports.createTest("Email Verify");
		throw new SkipException("Skip this test");	
	}
	
	@Test(priority=4)
	public void verifyUserName() {
		// create test
		test=reports.createTest("Username is Verified");
		Assert.assertTrue(false);	
	}
	
	@AfterMethod
	public void getTestResult(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Fail", ExtentColor.CYAN));
			test.fail(result.getThrowable());
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Pass", ExtentColor.GREEN));
		}
		else if (result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Skipped", ExtentColor.ORANGE));
		}
	}
	
	@AfterTest
	public void tearDown() {
		reports.flush();
	}
	

}
