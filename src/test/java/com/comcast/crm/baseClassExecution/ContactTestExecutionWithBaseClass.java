package com.comcast.crm.baseClassExecution;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseClassutility.BaseClass;
import com.comcast.crm.generic.baseClassutility.ListenerImp;
import com.comcost.crm.objectrepositoryutility.ContactInfoPage;
import com.comcost.crm.objectrepositoryutility.ContactPage;
import com.comcost.crm.objectrepositoryutility.CreateContactPage;
import com.comcost.crm.objectrepositoryutility.CreateOrgPage;
import com.comcost.crm.objectrepositoryutility.HomePage;
import com.comcost.crm.objectrepositoryutility.NewWindowToSelectOrganization;
import com.comcost.crm.objectrepositoryutility.OrganizationPage;

@Listeners(com.comcast.crm.generic.baseClassutility.ListenerImp.class)
public class ContactTestExecutionWithBaseClass extends BaseClass {

	@Test(groups = "smokeTest")
	public void createContactTest() throws IOException {

		ListenerImp.test.log(Status.INFO, "read file from excel");
		String lastName = eutil.getDatafromExcelFile("contact", 1, 0);

		// navigate to contact module
		ListenerImp.test.log(Status.INFO, "navigate to contact page");
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		// Click on create contact
		ListenerImp.test.log(Status.INFO, "create org  contact page");
		ContactPage cp = new ContactPage(driver);
		cp.getContactlookupimage().click();

		// Enter all the details and create contact
		ListenerImp.test.log(Status.INFO, "verify the header");
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTextfield().sendKeys(lastName);
		ccp.getSaveButton().click();

		// verify header
		ContactInfoPage cip = new ContactInfoPage(driver);
		String headerinfo = cip.getHeaderElement().getText();
		System.out.println(headerinfo);
		boolean status = headerinfo.contains(lastName);
		Assert.assertEquals(status, true);

	}

	@Test(groups = "regressionTest")
	public void CreateContactwithOrganizationTest() throws IOException, InterruptedException {

		// Read file from Excel
		ListenerImp.test.log(Status.INFO, "read file from excel");
		String orgName = eutil.getDatafromExcelFile("org", 1, 2) + jutil.getRandomNumber();
		String lastname = eutil.getDatafromExcelFile("contact", 1, 0) + jutil.getRandomNumber();

		// Navigate to organization module
		ListenerImp.test.log(Status.INFO, "navigate to contact page");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		// To Click on organization image lookupimg
		ListenerImp.test.log(Status.INFO, "create org  contact page");
		OrganizationPage org = new OrganizationPage(driver);
		org.Clickonorganizationsign();

		// Enter all the details and create Organization
		ListenerImp.test.log(Status.INFO, "Create orgname");
		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getOrganizationName().sendKeys(orgName);
		cop.getSavebutton().click();

		// wutil.waitForElementPresentToLoad(driver, hp.getContactsLink());

		Thread.sleep(2000);

		// Navigate to contact link
		wutil.doubleClickElement(driver, hp.getContactsLink());

		// To Click on contact image lookupimg
		ContactPage cp = new ContactPage(driver);
		cp.getContactlookupimage().click();

		// to add Organization
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTextfield().sendKeys(lastname);
		ccp.getAddorganizationincontactpageimg().click();

		// to switch to window
		String parentwindow = driver.getWindowHandle();

		wutil.switchToWindowOnURL(driver, "Accounts&action");
		NewWindowToSelectOrganization selectorg = new NewWindowToSelectOrganization(driver);
		selectorg.getSearchbox().sendKeys(orgName);
		driver.findElement(By.partialLinkText("facebook")).click();

		// switch back to parentwindow
		driver.switchTo().window(parentwindow);

		// verify header
		ContactInfoPage cip = new ContactInfoPage(driver);
		String headerinfo = cip.getHeaderElement().getText();
		System.out.println(headerinfo);
		boolean status = headerinfo.contains(lastname);
		Assert.assertEquals(status, true);

		ccp.getSaveButton();

	}

	@Test(groups = "regressionTest")
	public void CreateContactwithSouportDateTest() throws IOException {

		// read data from excel
		String lastname = eutil.getDatafromExcelFile("contact", 1, 0) + jutil.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		// To Click on contact image lookupimg
		ContactPage cp = new ContactPage(driver);
		cp.getContactlookupimage().click();

		// Sourcestart date
		String startdate = jutil.getSystemDateYYYYDDMM();

		// enddate
		String enddate = jutil.getRequiredDateYYYYMMDD(30);

		// To Add supportdate
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTextfield().sendKeys(lastname);
		ccp.togetsupportdate(startdate, enddate);

		// verify header
		ContactInfoPage cip = new ContactInfoPage(driver);
		String headerinfo = cip.getHeaderElement().getText();
		System.out.println(headerinfo);
		boolean status = headerinfo.contains(lastname);
		Assert.assertEquals(status, true);

		ccp.getSaveButton().click();

	}

}
