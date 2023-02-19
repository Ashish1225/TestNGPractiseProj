package com.nxtgenai.retryfailedtestdemo;

import org.testng.Assert;

import org.testng.annotations.Test;

// using retryAnalyzer interface

public class FailedTestDemo2 {
	
	@Test(retryAnalyzer = RetryAnalyzerDemo.class)
	public void testCase1() {
		Assert.assertTrue(false);
	}
	
	@Test
	public void testCase2() {
		Assert.assertTrue(true);
	}
	
	@Test(retryAnalyzer = RetryAnalyzerDemo.class)
	public void testCase3() {
		Assert.assertTrue(false);
	}
	
	@Test
	public void testCase4() {
		Assert.assertTrue(true);
	}

}
