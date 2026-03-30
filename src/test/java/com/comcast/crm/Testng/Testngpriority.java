package com.comcast.crm.Testng;

import org.testng.annotations.Test;

public class Testngpriority {

	@Test(priority=1)
	public void CreateContact() {
		System.out.println("Execute create contact");
	}

	@Test(priority=2)
	public void Modifycontact() {
		System.out.println("Execute Modify contact");

	}

	@Test(priority=3)
	public void DeleteContact() {
		System.out.println("Execute Delete contact");

	}

}
