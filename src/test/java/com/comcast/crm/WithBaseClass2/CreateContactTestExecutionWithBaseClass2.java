package com.comcast.crm.WithBaseClass2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseClassutility.BaseClass;
import com.comcast.crm.generic.baseClassutility.BaseClasswithAlwaysrun;
import com.comcost.crm.objectrepositoryutility.ContactInfoPage;
import com.comcost.crm.objectrepositoryutility.ContactPage;
import com.comcost.crm.objectrepositoryutility.CreateContactPage;
import com.comcost.crm.objectrepositoryutility.CreateOrgPage;
import com.comcost.crm.objectrepositoryutility.HomePage;
import com.comcost.crm.objectrepositoryutility.NewWindowToSelectOrganization;
import com.comcost.crm.objectrepositoryutility.OrganizationPage;

public class CreateContactTestExecutionWithBaseClass2 extends BaseClasswithAlwaysrun {

	@Test(groups="smokeTest")
	public void createContactTest() throws IOException {
		String lastName = eutil.getDatafromExcelFile("contact", 1, 0);

		// navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		// Click on create contact
		ContactPage cp = new ContactPage(driver);
		cp.getContactlookupimage().click();

		// Enter all the details and create contact
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTextfield().sendKeys(lastName);

		// verify header
		ContactInfoPage cip = new ContactInfoPage(driver);
		String headerinfo = cip.getHeaderElement().getText();
		System.out.println(headerinfo);
		boolean status = headerinfo.contains(lastName);
		Assert.assertTrue(status);

	}

	@Test(groups="regressionTest")
	public void CreateContactwithOrganizationTest() throws IOException, InterruptedException {

		String orgName = eutil.getDatafromExcelFile("org", 1, 2) + jutil.getRandomNumber();
		String lastname = eutil.getDatafromExcelFile("contact", 1, 0) + jutil.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationPage org = new OrganizationPage(driver);
		org.Clickonorganizationsign();

		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getOrganizationName().sendKeys(orgName);
		cop.getSavebutton().click();

		// wutil.waitForElementPresentToLoad(driver, hp.getContactsLink());

		Thread.sleep(2000);

		wutil.doubleClickElement(driver, hp.getContactsLink());

		ContactPage cp = new ContactPage(driver);
		cp.getContactlookupimage().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTextfield().sendKeys(lastname);
		ccp.getAddorganizationincontactpageimg().click();

		String parentwindow = driver.getWindowHandle();

		wutil.switchToWindowOnURL(driver, "Accounts&action");
		NewWindowToSelectOrganization selectorg = new NewWindowToSelectOrganization(driver);
		selectorg.getSearchbox().sendKeys(orgName);
		driver.findElement(By.partialLinkText("facebook")).click();

		driver.switchTo().window(parentwindow);

		ccp.getSaveButton();

	}

	@Test(groups="regressionTest")
	public void CreateContactwithSouportDateTest() throws IOException {

		String lastname = eutil.getDatafromExcelFile("contact", 1, 0) + jutil.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getContactlookupimage().click();

		// Sourcestart date
		String startdate = jutil.getSystemDateYYYYDDMM();

		// enddate
		String enddate = jutil.getRequiredDateYYYYMMDD(30);

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTextfield().sendKeys(lastname);
		ccp.togetsupportdate(startdate, enddate);

		ccp.getSaveButton().click();

	}

}
