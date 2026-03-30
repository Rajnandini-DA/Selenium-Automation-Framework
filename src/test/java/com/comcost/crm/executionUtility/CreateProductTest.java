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
import com.comcost.crm.objectrepositoryutility.CreateProductPage;
import com.comcost.crm.objectrepositoryutility.CreateProuctimg;
import com.comcost.crm.objectrepositoryutility.HomePage;
import com.comcost.crm.objectrepositoryutility.LoginPage;

public class CreateProductTest {

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

		//Create lead
		String productname = eutil.getDatafromExcelFile("product",1, 2)+jutil.getRandomNumber();
		

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
		hp.getProductslink().click();
		
		CreateProuctimg cpi = new CreateProuctimg(driver);
		cpi.getproductlookupimage().click();
		
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.getProductTextfield().sendKeys(productname);
		cpp.getSaveButton().click();
		hp.Logoutfromapp(driver);
		
		driver.quit();

		
		
		
		
	}

}
