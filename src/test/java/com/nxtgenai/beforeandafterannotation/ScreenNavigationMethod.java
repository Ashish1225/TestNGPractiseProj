package com.nxtgenai.beforeandafterannotation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenNavigationMethod {
	
	@BeforeMethod
	public void launchApplication() {
		System.out.println("Application is launched");
	}
	
	
	@Test(priority=1)
	public void navigateToRegisterDemo() {
		System.out.println("Page navigated to register form");
	}
	
	@Test(priority=2)
	public void navigateToAlertPopUp() {
		System.out.println("Page navigated to Alert Pop Up");
	}
	
	@Test(priority=3)
	public void navigateToMultipleWindows() {
		System.out.println("Page navigated to Multipple Windows");
	}
	
	@Test(priority=4)
	public void navigateToWebTable() {
		System.out.println("Page navigated to Web Table");
	}
	
	@AfterMethod
	public void closeApplication() {
		System.out.println("Application is closed");
	}
	

}
