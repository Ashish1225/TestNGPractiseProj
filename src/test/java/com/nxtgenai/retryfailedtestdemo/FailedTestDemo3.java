package com.nxtgenai.retryfailedtestdemo;

import org.testng.Assert;

import org.testng.annotations.Test;

// using IAnnotationTransformer Listener

public class FailedTestDemo3 {
	
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
	
	@Test
	public void testCase4() {
		Assert.assertTrue(true);
	}

}
