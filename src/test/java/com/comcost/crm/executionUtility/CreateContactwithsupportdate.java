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
import com.comcost.crm.objectrepositoryutility.ContactPage;
import com.comcost.crm.objectrepositoryutility.CreateContactPage;
import com.comcost.crm.objectrepositoryutility.HomePage;
import com.comcost.crm.objectrepositoryutility.LoginPage;

public class CreateContactwithsupportdate {

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

		//String orgName = eutil.getDatafromExcelFile("org", 1, 2) + jutil.getRandomNumber();
		String lastname = eutil.getDatafromExcelFile("contact", 1, 0) + jutil.getRandomNumber();

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
		lp.logintoApp(USERNAME, PASSWORD);

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
		
		hp.Logoutfromapp(driver);
		
		
		
	}

}
