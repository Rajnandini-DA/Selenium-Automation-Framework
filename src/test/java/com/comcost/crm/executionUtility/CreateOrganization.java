package com.comcost.crm.executionUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcost.crm.generic.fileutility.ExcelUtility;
import com.comcost.crm.generic.fileutility.Fileutility;
import com.comcost.crm.generic.webdriverutility.Javautility;
import com.comcost.crm.generic.webdriverutility.WebDriverUtility;
import com.comcost.crm.objectrepositoryutility.CreateOrgInfoPage;
import com.comcost.crm.objectrepositoryutility.CreateOrgPage;
import com.comcost.crm.objectrepositoryutility.HomePage;
import com.comcost.crm.objectrepositoryutility.LoginPage;
import com.comcost.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrganization {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Create object of files needed
		Fileutility futil = new Fileutility();
		ExcelUtility eutil = new ExcelUtility();
		Javautility jutil = new Javautility();
		WebDriverUtility wutil = new WebDriverUtility();

		// Read from propertyfile
		String BROWSER = futil.getDatafromPropertiesFile("browser");
		String URL = futil.getDatafromPropertiesFile("url");
		String USERNAME = futil.getDatafromPropertiesFile("username");
		String PASSWORD = futil.getDatafromPropertiesFile("password");

		// Read filr from Excel with random no
		String orgName = eutil.getDatafromExcelFile("org", 1, 2) + jutil.getRandomNumber();

		// LAunch the browser
		WebDriver driver = null;

		if (BROWSER.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.contains("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.contains("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		// get the url
		driver.get(URL);
		wutil.maximizethepage(driver);
		wutil.waitForPageLoad(driver);
		
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameTextField().sendKeys(USERNAME);
		lp.getPasswordTextField().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getOrganizationLink().click();
		
		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getOrganizationName().sendKeys(orgName);
		cop.getSavebutton().click();
		
		CreateOrgInfoPage coip = new CreateOrgInfoPage(driver);
		String headerinfo = coip.getHeaderverification().getText();
		if(headerinfo.contains(orgName)) {
			System.out.println(orgName + " is created");
		}else {
			System.out.println(orgName + " not created");
		}

		hp.getLogoutEle().click();
		hp.getSignoutLink().click();
		
		driver.quit();

	}

}
