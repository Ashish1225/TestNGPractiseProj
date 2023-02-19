package com.nxtgenai.grouping;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class InvocationCountTestDemo2 {
	
	// if invocationCount is 0 then it will not execute that test
	
	@Test(invocationCount = 6)
	public void testCase1(ITestContext context) {
		int currentInvocationCount=context.getAllTestMethods()[0].getCurrentInvocationCount();
		System.out.println("Test Case 1 executed: "+currentInvocationCount);
	}
	@Test(invocationCount = 3)
	public void testCase2() {
		System.out.println("Test Case 2 executed");
	}
	
	@Test(invocationCount = 3)
	public void testCase3() {
		System.out.println("Test Case 3 executed");
	}
	@Test(invocationCount = 1)
	public void testCase4(ITestContext context) {
		int currentInvocationCount1=context.getAllTestMethods()[1].getCurrentInvocationCount();
		System.out.println("Test Case 4 executed: "+currentInvocationCount1);
	}

}
