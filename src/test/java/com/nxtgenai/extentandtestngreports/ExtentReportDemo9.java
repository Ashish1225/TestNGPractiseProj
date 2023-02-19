package com.nxtgenai.extentandtestngreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo9 {

	public static void main(String[] args) {
		
		// assignAuthor(), assignCategory() and assignDevice() 
		
		ExtentReports extent = new ExtentReports();
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\erReportNew.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		
		// attach extent report to spark reporter
		
		extent.attachReporter(sparkReporter);
		
		ExtentTest test = extent.createTest("Test One","This is test one description");
		test.log(Status.INFO, "Test One got started");
		test.log(Status.PASS, "Test One got Successfully executed");
		// assign author
		test.assignAuthor("Ashish Sahu");
		test.assignCategory("Smoke");
		test.assignDevice("Windows 10 Chrome Browser");
		
		ExtentTest test1 = extent.createTest("Test Two","This is test two description");
		test1.log(Status.INFO, "Test Two got started");
		test1.log(Status.FAIL, "Test Two got Failed");
		// assign author
		test1.assignAuthor("Bhupendra");
		test1.assignCategory("Sanity");
		test1.assignDevice("Windows 10 Chrome Browser");
		
		extent.flush();
		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
