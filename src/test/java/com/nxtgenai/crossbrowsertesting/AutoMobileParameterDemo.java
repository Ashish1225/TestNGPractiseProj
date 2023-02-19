package com.nxtgenai.crossbrowsertesting;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AutoMobileParameterDemo {
	
	@Parameters({"automobilename"})
	@Test
	public void testCase1(String name) {
		System.out.println(name);
	}

}
