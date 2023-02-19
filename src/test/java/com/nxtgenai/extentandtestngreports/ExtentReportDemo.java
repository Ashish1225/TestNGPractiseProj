package com.nxtgenai.extentandtestngreports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	public static void main(String[] args) {
		
		// Generating extent report without any test using Spark reporter
		
		ExtentReports extent = new ExtentReports();
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\erReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		
		// attach extent report to spark reporter
		
		extent.attachReporter(sparkReporter);
		
		extent.flush();

	}

}
