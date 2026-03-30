package com.comcost.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcost.crm.generic.fileutility.ExcelUtility;
import com.comcost.crm.generic.fileutility.Fileutility;
import com.comcost.crm.generic.webdriverutility.Javautility;
import com.comcost.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrgWithIndustryandType {

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
		String industry = eutil.getDatafromExcelFile("org", 4, 4);
		String type = eutil.getDatafromExcelFile("org", 4, 5);

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

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Click on organization link
		driver.findElement(By.linkText("Organizations")).click();

		// Click on the add button on organization page
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Step 5:Create a contact with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(orgName);

		// industry dropdown
		WebElement Industrydp = driver.findElement(By.name("industry"));
		wutil.selectByWebElement(Industrydp, industry);

		WebElement accounttype = driver.findElement(By.name("accounttype"));
		wutil.selectByWebElement(accounttype, type);

		// Step 6:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify industry selected from actual data
		String actualindustryname = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actualindustryname.equals(industry)) {
			System.out.println(industry + "is selected");
		} else {
			System.out.println(industry + "is not selected");
		}

		// Verify Type dropdown
		String actualtypedata = driver.findElement(By.id("dtlview_Type")).getText();
		if (actualtypedata.equals(type)) {
			System.out.println(type + "is selected");
		} else {
			System.out.println(type + "is not selected");
		}

		// Verify Header msg
		String HeaderInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (HeaderInfo.contains(orgName)) {
			System.out.println(orgName + "is passed");
		} else {
			System.out.println(orgName + "is failed");
		}

		// Verify orgname in Organization name info
		String Actualresult = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (Actualresult.equals(orgName)) {
			System.out.println(orgName + " is created successfully");
		} else {
			System.out.println(orgName + " is not created");
		}

		// Logout
		WebElement Logout = driver.findElement(By.xpath("//img [@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(Logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();

	}

}
