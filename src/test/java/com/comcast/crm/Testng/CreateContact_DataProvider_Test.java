package com.comcast.crm.Testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DataProvider_Test {

	@Test(dataProvider="getData")
	public void createContactTest(String firstName , String lastName) {
		
		System.out.println("FirstName :"+ firstName +", LastName :" + lastName);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr = new Object[3][2];
		objArr[0][0]="deepak";
		objArr[0][1]="hr";
		
		objArr[1][0]="Sam";
		objArr[1][1]="sh";
		
		objArr[2][0]="John";
		objArr[2][1]="smith";
		
		return objArr;
		
		
	}
	
	
	
}
