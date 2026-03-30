package com.comcast.crm.WithBaseClass2;

import java.io.IOException;

import org.testng.annotations.Test;

import com.comcast.crm.generic.baseClassutility.BaseClasswithAlwaysrun;
import com.comcost.crm.objectrepositoryutility.CreateLeadimgPage;
import com.comcost.crm.objectrepositoryutility.CreateLeadsPage;
import com.comcost.crm.objectrepositoryutility.CreateProductPage;
import com.comcost.crm.objectrepositoryutility.CreateProjectimg;
import com.comcost.crm.objectrepositoryutility.CreateProjectpage;
import com.comcost.crm.objectrepositoryutility.CreateProuctimg;
import com.comcost.crm.objectrepositoryutility.HomePage;

public class CreateAssignmentTestwithBaseClass2 extends BaseClasswithAlwaysrun {

	
	@Test(groups="smokeTest")
	public void CreateLeadsTest() throws IOException {

		// Create lead
		String leadname = eutil.getDatafromExcelFile("lead", 1, 1) + jutil.getRandomNumber();
		String orgname = eutil.getDatafromExcelFile("org", 1, 2) + jutil.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getLeadslink().click();

		CreateLeadimgPage clp = new CreateLeadimgPage(driver);
		clp.getLeadlookupimage().click();

		CreateLeadsPage page = new CreateLeadsPage(driver);
		page.getLeadnametextfield().sendKeys(leadname);
		page.getCompanyTextfield().sendKeys(orgname);
		page.getSavebutton().click();

	}

	@Test(groups="smokeTest")
	public void CreateProductsTest() throws IOException {
		
		String productname = eutil.getDatafromExcelFile("product",1, 2)+jutil.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getProductslink().click();
		
		CreateProuctimg cpi = new CreateProuctimg(driver);
		cpi.getproductlookupimage().click();
		
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.getProductTextfield().sendKeys(productname);
		cpp.getSaveButton().click();
		
		
		
		
	}
	
	
	@Test(groups="regressionTest")
	public void CreateProjectsTest() throws IOException {

		String projectname = eutil.getDatafromExcelFile("projects", 1, 2) + jutil.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getMoreLink().click();
		hp.getProjectsLinks().click();
		hp.getProjectsLinks().click();

		CreateProjectimg cpi = new CreateProjectimg(driver);
		cpi.getprojectlookupimage().click();

		CreateProjectpage cpp = new CreateProjectpage(driver);
		cpp.getProjecttextfield().sendKeys(projectname);
		cpp.getSaveButton().click();

	}
	
}
