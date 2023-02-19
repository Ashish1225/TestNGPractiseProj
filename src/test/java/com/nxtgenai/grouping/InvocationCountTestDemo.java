package com.nxtgenai.grouping;

import org.testng.annotations.Test;

public class InvocationCountTestDemo {
	
	// if invocationCount is 0 then it will not execute that test
	
	@Test(invocationCount = 2)
	public void testCase1() {
		System.out.println("Test Case 1 executed");
	}
	@Test(invocationCount = 3)
	public void testCase2() {
		System.out.println("Test Case 2 executed");
	}

}
