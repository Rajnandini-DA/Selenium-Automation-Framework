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
import com.comcost.crm.objectrepositoryutility.CreateProjectimg;
import com.comcost.crm.objectrepositoryutility.CreateProjectpage;
import com.comcost.crm.objectrepositoryutility.HomePage;
import com.comcost.crm.objectrepositoryutility.LoginPage;

public class CreateProjectTest {

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

		String projectname = eutil.getDatafromExcelFile("projects", 1, 2) + jutil.getRandomNumber();

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
		hp.getMoreLink().click();
		hp.getProjectsLinks().click();
		hp.getProjectsLinks().click();
		
		CreateProjectimg cpi = new CreateProjectimg(driver);
		cpi.getprojectlookupimage().click();
		
		CreateProjectpage cpp = new CreateProjectpage(driver);
		cpp.getProjecttextfield().sendKeys(projectname);
		cpp.getSaveButton().click();
		
		hp.getLogoutEle();
		
		driver.quit();
				
		
		
		
	}

}
