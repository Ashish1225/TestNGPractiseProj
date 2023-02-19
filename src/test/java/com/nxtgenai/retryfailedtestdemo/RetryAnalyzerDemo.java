package com.nxtgenai.retryfailedtestdemo;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerDemo implements IRetryAnalyzer{
	
	// create counter to track of retry attempts
	int counter=0;
	
	// set max limit for retry failed test
	int setMaxLimit=3;

	@Override
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
			if(counter<setMaxLimit) {
				counter++;
				return true;
			}
			
		}
		
		
		return false;
	}

}
