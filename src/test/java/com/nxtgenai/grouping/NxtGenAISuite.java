package com.nxtgenai.grouping;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public  class NxtGenAISuite {
	
	// -- reference test case mapping excel for group annotation

	@BeforeSuite(groups = {"smoke","sanity","regression"})
	public void launchApplication() {
		System.out.println("Application is launched");
	}

	@AfterSuite(groups = {"smoke","sanity","regression"})
	public void closeApplication() {
		System.out.println("Application is closed");
	}
	
	@Test(groups = {"smoke","sanity","regression"}, priority=1)
	public void navigateToRegisterForm() {
		System.out.println("Registration Form is displayed");
	}
	
	@Test(groups = {"smoke","sanity","regression"}, priority=2)
	public void registerDemo() {
		System.out.println("User is registered");
	}
	
	@Test(groups = {"smoke","sanity","regression"}, priority=3)
	public void navigateToPythonForDataScience() {
		System.out.println("Python For DataScience is displayed");
	}
	
	@Test(groups = {"sanity","regression"}, priority=4)
	public void navigateToAutomationWindow() {
		System.out.println("Automation Window is displayed");
	}
	
	@Test(groups = {"sanity","regression"},priority=5)
	public void handleNewBrowserWindow() {
		System.out.println("New Browser Window is handled");
	}
	
	@Test(groups = {"regression"},priority=6)
	public void handleNewMessageWindow() {
		System.out.println("New Message Window is handled");
	}
	
	@Test(groups = {"regression"},priority=7)
	public void handleNewTab() {
		System.out.println("New Tab is handled");
	}
	
	@Test(groups = {"sanity","regression"},priority=8)
	public void navigateToAutomationAlertPopUp() {
		System.out.println("Automation Alert PopUp is displayed");
	}
	
	@Test(groups = {"sanity","regression"},priority=9)
	public void handleConfirmAlertPopUp() {
		System.out.println("Confirm Alert PopUp is handled");
	}
	
	@Test(groups = {"regression"}, priority=10)
	public void handleAlertPopUp() {
		System.out.println("Alert PopUp is handled");
	}
	
	@Test(groups = {"regression"}, priority=11)
	public void handlePromptPopUp() {
		System.out.println("Prompt PopUp is handled");
	}
	
	@Test(groups = {"sanity","regression"},priority=12)
	public void NavigateToAutomationTable() {
		System.out.println("Automation Table is displayed");
	}
	
	@Test(groups = {"sanity","regression"},priority=13)
	public void extractsEmployeeDetails() {
		System.out.println("Employee Details are extracted");
	}
}
