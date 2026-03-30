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
import com.comcost.crm.objectrepositoryutility.ContactInfoPage;
import com.comcost.crm.objectrepositoryutility.ContactPage;
import com.comcost.crm.objectrepositoryutility.CreateContactPage;
import com.comcost.crm.objectrepositoryutility.HomePage;
import com.comcost.crm.objectrepositoryutility.LoginPage;

public class CreateContactTest {

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
		
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTextfield().sendKeys(lastname);
		ccp.getSaveButton().click();
		
		ContactInfoPage cip = new ContactInfoPage(driver);
		String headerinfo = cip.getHeaderElement().getText();
		if(headerinfo.contains(lastname)) {
			System.out.println(lastname + " is created");
		}else {
			System.out.println(lastname+ " not created");
		}
		
		hp.getLogoutEle().click();
		hp.getSignoutLink().click();
		
		driver.quit();
		
		
		
	}

}
