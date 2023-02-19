package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGenerator {
	
	public static ExtentReports generateExtent() {
		ExtentReports extent = new ExtentReports();
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\erReportOnFailTest.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extent.attachReporter(sparkReporter);
		return extent;
	}

}
