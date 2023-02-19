package com.nxtgenai.testngannotation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BankingApplicationSoftDependency {

	@Test
	public void launchApplication() {
		System.out.println("Application is launched successfully");
		Assert.assertEquals("Page Title", "Page Title");
	}

	@Test(dependsOnMethods = {"launchApplication"})
	public void loginUser() {
		System.out.println("Successfull login");
		Assert.assertEquals("Login", "Login");
	}

	@Test(dependsOnMethods = {"loginUser"})
	public void checkSavingAccountBalance() {
		System.out.println("Saving account balance is displayed");
		Assert.assertEquals("Saving Account", "Saving Account");
	}

	@Test(dependsOnMethods = {"checkSavingAccountBalance"})
	public void checkCurrentAccountBalance() {
		System.out.println("Current account balance is displayed");
		Assert.assertEquals("Current Account", "Current Account");
	}

	@Test(dependsOnMethods = {"checkCurrentAccountBalance"})
	public void logout() {
		System.out.println("logout successfully");
		Assert.assertEquals("Logout", "Logout");
	}

	// soft dependency- alwaysRun=true
	@Test(dependsOnMethods = {"logout"},alwaysRun = true)
	public void closeApplication() {
		System.out.println("Application is closed");
		Assert.assertEquals("Closed", "Closed");
	}
}
