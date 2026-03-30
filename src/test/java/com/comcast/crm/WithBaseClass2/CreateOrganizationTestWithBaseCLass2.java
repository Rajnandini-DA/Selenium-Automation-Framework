package com.comcast.crm.WithBaseClass2;

import java.io.IOException;

import org.testng.annotations.Test;

import com.comcast.crm.generic.baseClassutility.BaseClass;
import com.comcast.crm.generic.baseClassutility.BaseClasswithAlwaysrun;
import com.comcost.crm.objectrepositoryutility.CreateOrgInfoPage;
import com.comcost.crm.objectrepositoryutility.CreateOrgPage;
import com.comcost.crm.objectrepositoryutility.HomePage;
import com.comcost.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrganizationTestWithBaseCLass2 extends BaseClasswithAlwaysrun {

	@Test(groups="smokeTest")
	public void CreateOrgsTest() throws IOException {

		String orgName = eutil.getDatafromExcelFile("org", 1, 2) + jutil.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getOrganizationLink().click();

		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getOrganizationName().sendKeys(orgName);
		cop.getSavebutton().click();

		CreateOrgInfoPage coip = new CreateOrgInfoPage(driver);
		String headerinfo = coip.getHeaderverification().getText();
		if (headerinfo.contains(orgName)) {
			System.out.println(orgName + " is created");
		} else {
			System.out.println(orgName + " not created");
		}
	}

	@Test(groups="regressionTest")
	public void CreateOrgwithphonenumber() throws IOException {

		// Read filr from Excel with random no
		String orgName = eutil.getDatafromExcelFile("org", 1, 2) + jutil.getRandomNumber();
		String phonenumber = eutil.getDatafromExcelFile("org", 7, 4);

		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationPage org = new OrganizationPage(driver);
		org.Clickonorganizationsign();

		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getOrganizationName().sendKeys(orgName);
		cop.getPhonenoTextField().sendKeys(phonenumber);
		cop.getSavebutton().click();

		CreateOrgInfoPage coip = new CreateOrgInfoPage(driver);
		coip.phonenumberverification(phonenumber);

	}

	@Test(groups="regressionTest")
	public void CreateOrgswithDropdwon() throws IOException {

		String orgName = eutil.getDatafromExcelFile("org", 1, 2) + jutil.getRandomNumber();
		String industry = eutil.getDatafromExcelFile("org", 4, 4);
		String type = eutil.getDatafromExcelFile("org", 4, 5);

		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getOrganizationLink().click();

		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getOrganizationName().sendKeys(orgName);

//		WebElement dropdown = cop.getIndustryDropdown();
//		wutil.selectByWebElement(dropdown,industry);

		cop.SelectbyDropdown(industry, type);

		cop.getSavebutton().click();

		CreateOrgInfoPage coip = new CreateOrgInfoPage(driver);
		String headerindustry = coip.getIndustrydpheader().getText();
		if (headerindustry.contains(industry)) {
			System.out.println(industry + "is selected");
		} else {
			System.out.println(industry + "is not selected");

		}

		String headertype = coip.getTypedpheader().getText();
		if (headertype.contains(type)) {
			System.out.println(type + "is selected");
		} else {
			System.out.println(type + "is not selected");

		}

	}

}
