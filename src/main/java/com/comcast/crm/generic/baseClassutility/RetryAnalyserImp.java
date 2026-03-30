package com.comcast.crm.generic.baseClassutility;

/*
 * RetryAnalyzer class:
 * Implements IRetryAnalyzer to re-run failed test cases automatically.
 */
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImp implements IRetryAnalyzer {

	int count = 0; /*Counter to track retry attempts*/
	int limitcount = 5;/*/ Maximum retry attempts allowed*/
	
	@Override
	public boolean retry(ITestResult result) {
		 /*Returns true if test should be retried, false otherwise*/
		if(count<limitcount) {
			count++;
			return true;
		}
		return false;
	}
	
	

}
