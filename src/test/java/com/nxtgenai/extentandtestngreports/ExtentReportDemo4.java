package com.nxtgenai.extentandtestngreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo4 {

	public static void main(String[] args) {
		
		// Generating extent report with test using Spark reporter and open automatically
		// log text in bold and italic formats into extent report
		
		ExtentReports extent = new ExtentReports();
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		
		// attach extent report to spark reporter
		
		extent.attachReporter(sparkReporter);
		
		ExtentTest test1 = extent.createTest("Test_One");
		test1.pass("Test One is Passed");
		
		ExtentTest test2 = extent.createTest("Test_Two");
		test2.fail("<i>Test One is Failed</i>");
		
		ExtentTest test3 = extent.createTest("Test_Three");
		test3.skip("<b>Test One is Skipped</b>");
		
		// there is a another way to pass, fail and skip the test
		ExtentTest test4 = extent.createTest("Test_Four");
		test4.log(Status.PASS, "<b>Test Fourth is Passed</b>");
		
		
		
		extent.flush();
		
		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
