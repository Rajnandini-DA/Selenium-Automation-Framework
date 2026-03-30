package com.comcast.crm.baseClassExecution;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseClassutility.BaseClass;
import com.comcost.crm.objectrepositoryutility.CreateOrgInfoPage;
import com.comcost.crm.objectrepositoryutility.CreateOrgPage;
import com.comcost.crm.objectrepositoryutility.HomePage;
import com.comcost.crm.objectrepositoryutility.OrganizationPage;

public class OrganizationTestWithBaseCLass extends BaseClass {

	@Test(groups = "smokeTest")
	public void CreateOrgsTest() throws IOException {

		// To read date from excel
		String orgName = eutil.getDatafromExcelFile("org", 1, 2) + jutil.getRandomNumber();

		// Navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		// To Click on organization image lookupimg
		OrganizationPage op = new OrganizationPage(driver);
		op.getOrganizationLink().click();

		// Enter all the details and create Organization
		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getOrganizationName().sendKeys(orgName);
		cop.getSavebutton().click();

		// verification
		CreateOrgInfoPage coip = new CreateOrgInfoPage(driver);
		String headerinfo = coip.getHeaderverification().getText();
		System.out.println(headerinfo);
		boolean status = headerinfo.contains(orgName);
		Assert.assertEquals(status, true);

	}

	@Test(groups = "regressionTest")
	public void CreateOrgwithphonenumber() throws IOException {

		// Read filr from Excel with random no
		String orgName = eutil.getDatafromExcelFile("org", 1, 2) + jutil.getRandomNumber();
		String phonenumber = eutil.getDatafromExcelFile("org", 7, 4);

		// Navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		// To Click on organization image lookupimg
		OrganizationPage org = new OrganizationPage(driver);
		org.Clickonorganizationsign();

		// Enter all the details and create Organization
		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getOrganizationName().sendKeys(orgName);
		cop.getPhonenoTextField().sendKeys(phonenumber);
		cop.getSavebutton().click();

		// Verification

		CreateOrgInfoPage coi = new CreateOrgInfoPage(driver);
		coi.phonenumberverification(phonenumber);
		// verification
		CreateOrgInfoPage coip = new CreateOrgInfoPage(driver);
		String headerinfo = coip.getHeaderverification().getText();
		System.out.println(headerinfo);
		boolean status = headerinfo.contains(orgName);
		Assert.assertEquals(status, true);

	}

	@Test(groups = "regressionTest")
	public void CreateOrgswithDropdwon() throws IOException {

		// read data from excel file
		String orgName = eutil.getDatafromExcelFile("org", 1, 2) + jutil.getRandomNumber();
		String industry = eutil.getDatafromExcelFile("org", 4, 4);
		String type = eutil.getDatafromExcelFile("org", 4, 5);

		// Navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		// To Click on organization image lookupimg
		OrganizationPage op = new OrganizationPage(driver);
		op.getOrganizationLink().click();

		// Enter all the details and create Organization
		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getOrganizationName().sendKeys(orgName);

//		WebElement dropdown = cop.getIndustryDropdown();
//		wutil.selectByWebElement(dropdown,industry);

		cop.SelectbyDropdown(industry, type);

		cop.getSavebutton().click();

		// verification of industry dropdown
		CreateOrgInfoPage coip = new CreateOrgInfoPage(driver);
		String headerindustry = coip.getIndustrydpheader().getText();
		boolean status = headerindustry.contains(industry);
		Assert.assertEquals(status, true);


		//verification of type dropdown
		String headertype = coip.getTypedpheader().getText();
		boolean status1 = headertype.contains(type);
		Assert.assertEquals(status1, true);
		

	}

}
