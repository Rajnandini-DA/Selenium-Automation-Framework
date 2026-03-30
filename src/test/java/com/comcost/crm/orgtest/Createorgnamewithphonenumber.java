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

public class Createorgnamewithphonenumber {

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
		String phonenumber = eutil.getDatafromExcelFile("org", 7, 4);

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

		// Enter phone number
		driver.findElement(By.id("phone")).sendKeys(phonenumber);

		// Step 6:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// verify phone number
		String Actualphonedata = driver.findElement(By.id("dtlview_Phone")).getText();
		if (Actualphonedata.equals(phonenumber)) {
			System.out.println(phonenumber + " is present");
		} else {
			System.out.println(phonenumber + " is not present");
		}

		// Logout
		WebElement Logout = driver.findElement(By.xpath("//img [@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(Logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();

	}

}
