package com.nxtgenai.testngannotation;

import org.testng.annotations.Test;

public class BankingApplicationOrder {

	@Test(priority = 0)
	public void launchApplication() {
		System.out.println("Application is launched successfully");
	}

	@Test(priority = 1)
	public void loginUser() {
		System.out.println("Successfull login");
	}

	@Test(priority = 2)
	public void checkSavingAccountBalance() {
		System.out.println("Saving account balance is displayed");
	}

	@Test(priority = 3)
	public void checkCurrentAccountBalance() {
		System.out.println("Current account balance is displayed");
	}

	@Test(priority = 4)
	public void logout() {
		System.out.println("logout successfully");
	}

	@Test(priority = 5)
	public void closeApplication() {
		System.out.println("Application is closed");
	}
}
