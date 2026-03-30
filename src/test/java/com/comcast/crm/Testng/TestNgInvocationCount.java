package com.comcast.crm.Testng;

import org.testng.annotations.Test;

public class TestNgInvocationCount {

	@Test(invocationCount=10)
	public void createOrderTest() {
		System.out.println("Execute createOrderTest==>123");
		}
	
	@Test(enabled=false)
	public void billingandOrderTest() {
		System.out.println("Execute billingandOrderTest ==>123");
		}
	
	
	
}
