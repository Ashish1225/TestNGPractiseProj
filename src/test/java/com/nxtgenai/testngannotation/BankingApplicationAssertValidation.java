package com.nxtgenai.testngannotation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BankingApplicationAssertValidation {

	@Test(priority = 0)
	public void launchApplication() {
		System.out.println("Application is launched successfully");
		
		Assert.assertEquals("Page Title", "Page Title");
	}

	@Test(priority = 1)
	public void loginUser() {
		System.out.println("Successfull login");
		Assert.assertEquals("Login", "Login");
	}

	@Test(priority = 2,enabled = false)
	public void checkSavingAccountBalance() {
		System.out.println("Saving account balance is displayed");
		Assert.assertEquals("Not Saving Account", "Saving Account");
	}

	@Test(priority = 3)
	public void checkCurrentAccountBalance() {
		System.out.println("Current account balance is displayed");
		Assert.assertEquals("Current Account", "Current Account");
	}

	@Test(priority = 4)
	public void logout() {
		System.out.println("logout successfully");
		Assert.assertEquals("Logout", "Logout");
	}

	@Test(priority = 5)
	public void closeApplication() {
		System.out.println("Application is closed");
		Assert.assertEquals("Closed", "Closed");
	}
}
