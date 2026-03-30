package com.comcast.crm.Testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DataProvider_Test2 {

	@Test(dataProvider="getData")
	public void createContactTest(String firstName , String lastName ,long phonenumber) {
		
		System.out.println("FirstName :"+ firstName +" , LastName :" + lastName + " ,phonenumber :" + phonenumber);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr = new Object[3][3];
		objArr[0][0]="deepak";
		objArr[0][1]="hr";
		objArr[0][2]=1234567890l;
		
		objArr[1][0]="Sam";
		objArr[1][1]="sh";
		objArr[1][2]=2136547890l;
		
		objArr[2][0]="John";
		objArr[2][1]="smith";
		objArr[2][2]=9876543210l;
		
		return objArr;
		
		
	}
	
	
	
}
