package com.nxtgenai.extentandtestngreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo2 {

	public static void main(String[] args) {
		
		// Generating extent report with test using Spark reporter and open automatically
		
		ExtentReports extent = new ExtentReports();
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\erReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		
		// attach extent report to spark reporter
		
		extent.attachReporter(sparkReporter);
		
		ExtentTest test1 = extent.createTest("Test_One");
		test1.pass("Test One is Passed");
		
		ExtentTest test2 = extent.createTest("Test_Two");
		test2.fail("Test One is Failed");
		
		ExtentTest test3 = extent.createTest("Test_Three");
		test3.skip("Test One is Skipped");
		
		// there is a another way to pass, fail and skip the test
		ExtentTest test4 = extent.createTest("Test_Four");
		test4.log(Status.PASS, "Test Fourth is Passed");
		
		extent.flush();
		
		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
