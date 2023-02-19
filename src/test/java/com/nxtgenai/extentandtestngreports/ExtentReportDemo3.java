package com.nxtgenai.extentandtestngreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo3 {

	public static void main(String[] args) {
		
		// Generating extent report with test using Spark reporter and open automatically
		
		ExtentReports extent = new ExtentReports();
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\erReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		
		// attach extent report to spark reporter
		
		extent.attachReporter(sparkReporter);
		
		ExtentTest test1 = extent.createTest("Test_One");
		//test1.pass("Test One is Passed");
		test1.log(Status.INFO, "Chrome browser launched");
		test1.log(Status.INFO, "Application successfully Opened");
		test1.log(Status.INFO, "Valid product got searched");
		test1.log(Status.INFO, "Valid product got displayed");
		test1.log(Status.INFO, "Chrome browser Closed");
		
		test1.log(Status.WARNING, "Alignement of button should be correct");
		
		test1.log(Status.FAIL, "Fail");
		
		
		extent.flush();
		
		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
