package com.comcast.crm.baseClassExecution;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseClassutility.BaseClass;
import com.comcost.crm.objectrepositoryutility.CreateLeadInfopage;
import com.comcost.crm.objectrepositoryutility.CreateLeadimgPage;
import com.comcost.crm.objectrepositoryutility.CreateLeadsPage;
import com.comcost.crm.objectrepositoryutility.CreateProductPage;
import com.comcost.crm.objectrepositoryutility.CreateProjectimg;
import com.comcost.crm.objectrepositoryutility.CreateProjectpage;
import com.comcost.crm.objectrepositoryutility.CreateProuctimg;
import com.comcost.crm.objectrepositoryutility.CreateTicketPage;
import com.comcost.crm.objectrepositoryutility.HomePage;
import com.comcost.crm.objectrepositoryutility.ProductInfopage;
import com.comcost.crm.objectrepositoryutility.ProjectInfoPage;
import com.comcost.crm.objectrepositoryutility.TicketimgPage;




public class AssignmentTestwithBaseClass extends BaseClass {

	
	@Test(groups="smokeTest")
	public void CreateLeadsTest() throws IOException {

		//read file from excel data
		String leadname = eutil.getDatafromExcelFile("lead", 1, 1) + jutil.getRandomNumber();
		String orgname = eutil.getDatafromExcelFile("org", 1, 2) + jutil.getRandomNumber();
		
		//Navigate to lead page
		HomePage hp = new HomePage(driver);
		hp.getLeadslink().click();

		//To Click on Lead image lookupimg
		CreateLeadimgPage clp = new CreateLeadimgPage(driver);
		clp.getLeadlookupimage().click();

		//Enter all the details and create Lead
		CreateLeadsPage page = new CreateLeadsPage(driver);
		page.getLeadnametextfield().sendKeys(leadname);
		page.getCompanyTextfield().sendKeys(orgname);
		page.getSavebutton().click();
		
		CreateLeadInfopage clip = new CreateLeadInfopage(driver);
		String headerinfo = clip.getHeaderElement().getText();
		boolean status = headerinfo.contains(leadname);
		Assert.assertEquals(status, true);
		
		String companyverification = clip.getCompanyverification().getText();
		boolean status1 = companyverification.contains(orgname);
		Assert.assertEquals(status1, true);
		

	}

	@Test(groups="smokeTest")
	public void CreateProductsTest() throws IOException {
		
		//read file from excel data
		String productname = eutil.getDatafromExcelFile("product",1, 2)+jutil.getRandomNumber();
		
		//Navigate to product page
		HomePage hp = new HomePage(driver);
		hp.getProductslink().click();
		
		//To Click on product image lookupimg
		CreateProuctimg cpi = new CreateProuctimg(driver);
		cpi.getproductlookupimage().click();
		
		//Enter all the details and create product
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.getProductTextfield().sendKeys(productname);
		cpp.getSaveButton().click();
		
		ProductInfopage pip = new ProductInfopage(driver);
		String headerinfo = pip.getHeaderElement().getText();
		System.out.println(headerinfo);
		boolean status = headerinfo.contains(productname);
		Assert.assertEquals(status, true);
		
		
	}
	
	
	@Test(groups="regressionTest")
	public void CreateProjectsTest() throws IOException {

		//read file from excel data
		String projectname = eutil.getDatafromExcelFile("projects", 1, 2) + jutil.getRandomNumber();

		//Navigate to product page
		HomePage hp = new HomePage(driver);
		hp.getMoreLink().click();
		hp.getProjectsLinks().click();
		hp.getProjectsLinks().click();

		//To Click on product image lookupimg
		CreateProjectimg cpi = new CreateProjectimg(driver);
		cpi.getprojectlookupimage().click();

		//Enter all the details and create product
		CreateProjectpage cpp = new CreateProjectpage(driver);
		cpp.getProjecttextfield().sendKeys(projectname);
		cpp.getSaveButton().click();
		
		ProjectInfoPage pip = new ProjectInfoPage(driver);
		String headerinfo = pip.getHeaderElement().getText();
		System.out.println(headerinfo);
		System.out.println(headerinfo);
		boolean status = headerinfo.contains(projectname);
		Assert.assertEquals(status, true);
		

	}
	
	@Test(groups = "RegressionTest")
	public void TroubleTicketTest() throws IOException {
		
		//read file from excel data
		String tickettilte = eutil.getDatafromExcelFile("Tickets", 1,1) + jutil.getRandomNumber();
		
		//Navigate to product page
		HomePage hp = new HomePage(driver);
		hp.getTicketlink().click();
		
		//To Click on product image lookupimg
		TicketimgPage tp = new TicketimgPage(driver);
		tp.getticketlookupimage().click();
		
		//Enter all the details and create product
		CreateTicketPage ctp = new CreateTicketPage(driver);
		ctp.getTitleTextFiled().sendKeys(tickettilte);
		ctp.getSaveButton().click();
		
		
	}
	
}
