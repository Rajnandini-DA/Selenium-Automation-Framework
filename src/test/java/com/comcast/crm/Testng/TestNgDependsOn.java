package com.comcast.crm.Testng;

import org.testng.annotations.Test;

public class TestNgDependsOn {

	@Test
	public void CreateContact() {
		System.out.println("Execute create contact");
	}

	@Test(dependsOnMethods="CreateContact")
	public void Modifycontact() {
		System.out.println("Execute Modify contact");

	}

	@Test(dependsOnMethods="Modifycontact")
	public void DeleteContact() {
		System.out.println("Execute Delete contact");

	}
}
