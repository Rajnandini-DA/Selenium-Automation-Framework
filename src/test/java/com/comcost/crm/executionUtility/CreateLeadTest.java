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
import com.comcost.crm.objectrepositoryutility.CreateLeadimgPage;
import com.comcost.crm.objectrepositoryutility.CreateLeadsPage;
import com.comcost.crm.objectrepositoryutility.HomePage;
import com.comcost.crm.objectrepositoryutility.LoginPage;

public class CreateLeadTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

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
		// Create lead
		String leadname = eutil.getDatafromExcelFile("lead", 1, 1) + jutil.getRandomNumber();
		String orgname = eutil.getDatafromExcelFile("org", 1, 2) + jutil.getRandomNumber();

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

		// Get the url
		driver.get(URL);
		wutil.maximizethepage(driver);
		wutil.waitForPageLoad(driver);

		LoginPage lp = new LoginPage(driver);
		lp.logintoApp(USERNAME, PASSWORD);

		HomePage hp = new HomePage(driver);
		hp.getLeadslink().click();

		CreateLeadimgPage clp = new CreateLeadimgPage(driver);
		clp.getLeadlookupimage().click();

		CreateLeadsPage page = new CreateLeadsPage(driver);
		page.getLeadnametextfield().sendKeys(leadname);
		page.getCompanyTextfield().sendKeys(orgname);
		page.getSavebutton().click();

		hp.Logoutfromapp(driver);
		
		driver.quit();

	}

}
