package com.comcast.crm.listener;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvoiceTEst1 {

	@Test(retryAnalyzer = com.comcast.crm.generic.baseClassutility.RetryAnalyserImp.class)
	public void activatesim() {
		System.out.println("execute activatesim");
		Assert.assertEquals(" ", "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
		
	}
	
}
