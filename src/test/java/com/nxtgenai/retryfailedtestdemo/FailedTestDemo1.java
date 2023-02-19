package com.nxtgenai.retryfailedtestdemo;

import org.testng.Assert;
import org.testng.annotations.Test;

// using testng-failed.xml

public class FailedTestDemo1 {
	
	@Test
	public void testCase1() {
		Assert.assertTrue(false);
	}
	
	@Test
	public void testCase2() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void testCase3() {
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods = "testCase3")
	public void testCase4() {
		Assert.assertTrue(true);
	}

}
