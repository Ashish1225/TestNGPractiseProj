package com.nxtgenai.crossbrowsertesting;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameterDemo {
	
	@Parameters({"i","j"})
	@Test(priority = 1)
	public void add(int a, int b) {
		int result = a+b;
		System.out.println("Result of addition is :"+result);
	}
	
	@Parameters({"i","j"})
	@Test(priority = -1000)
	public void sub(int a, int b) {
		int result = a-b;
		System.out.println("Result of Subtraction is :"+result);
	}
	
	@Parameters({"i","j"})
	@Test(priority =2000)
	public void div(int a, int b) {
		double result = a/b;
		System.out.println("Result of Division is :"+result);
	}

}
