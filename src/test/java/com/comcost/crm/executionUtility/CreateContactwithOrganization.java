package com.comcost.crm.executionUtility;

import java.io.IOException;

import org.openqa.selenium.By;
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
import com.comcost.crm.objectrepositoryutility.CreateOrgPage;
import com.comcost.crm.objectrepositoryutility.HomePage;
import com.comcost.crm.objectrepositoryutility.LoginPage;
import com.comcost.crm.objectrepositoryutility.NewWindowToSelectOrganization;
import com.comcost.crm.objectrepositoryutility.OrganizationPage;

public class CreateContactwithOrganization {

	public static void main(String[] args) throws IOException, InterruptedException {
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

		String orgName = eutil.getDatafromExcelFile("org", 1, 2) + jutil.getRandomNumber();
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

		// get the url
		driver.get(URL);
		wutil.maximizethepage(driver);
		wutil.waitForPageLoad(driver);

		LoginPage lp = new LoginPage(driver);
		lp.logintoApp(USERNAME, PASSWORD);

		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationPage org = new OrganizationPage(driver);
		org.Clickonorganizationsign();

		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getOrganizationName().sendKeys(orgName);
		cop.getSavebutton().click();
		
		//wutil.waitForElementPresentToLoad(driver, hp.getContactsLink());

		Thread.sleep(2000);
		
		wutil.doubleClickElement(driver,hp.getContactsLink());
		

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
		
		hp.Logoutfromapp(driver);
		
		driver.quit();

	}

}
