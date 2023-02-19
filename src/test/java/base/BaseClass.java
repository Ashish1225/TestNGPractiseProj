package base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class BaseClass {
	
	public void captureScreenShot(WebDriver driver, String testName) {
		TakesScreenshot tss = (TakesScreenshot)driver;
		File srcFile = tss.getScreenshotAs(OutputType.FILE);
		File destFile = new File("D:\\SeleniumTrainingWorkspace\\TestNGFramework\\Screenshots\\"+testName+"_"+generateTimeStamp()+".png");
		try {
			Files.copy(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// to overcome the problem of overriding  the screen shot every time when test cases got failed.
	// using this code exiting screenshot will not be override rather a new screen shot will be stored with current date and time
	public String generateTimeStamp() {
		Date date = new Date();
		return date.toString().replace(" ","_").replace(":","_");
	}
	

	public static String takeScreenShot(WebDriver driver,String testName) {
		// taking screen shot using output type file

		TakesScreenshot tss = (TakesScreenshot) driver;
		File srcsScreenshot = tss.getScreenshotAs(OutputType.FILE);
		File destScreen = new File(System.getProperty("user.dir") + "\\Screenshots\\"+testName+".png");
		try {
			Files.copy(srcsScreenshot, destScreen);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return destScreen.getAbsolutePath();
		
	}

}
