package com.comcast.crm.listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseClassutility.BaseClass;
import com.comcast.crm.generic.baseClassutility.ListenerImp;

@Listeners(ListenerImp.class)
public class InvoiceTest extends BaseClass{
	
	@Test
	public void CreateInvoiceTest() {
		System.out.println("Execute CreateInvoiceTest");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}

	@Test
	public void createInvoiceWithContactTest() {
		System.out.println("Execute CreateInvoicewithContactTest");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
	
}
