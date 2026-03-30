package com.comcost.crm.contacttest;

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

public class CreateContactwithsupportDate {

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

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Step 3:Navigate to contact link
		driver.findElement(By.linkText("Contacts")).click();

		// Step 4:Click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Create a contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(lastname);

		// Sourcestart date
		String startdate = jutil.getSystemDateYYYYDDMM();

		// enddate
		String enddate = jutil.getRequiredDateYYYYMMDD(30);

		// Enter source start date
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startdate);

		// Enter source end date
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(enddate);

		// save and verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String Lastnameheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (Lastnameheader.contains(lastname)) {
			System.out.println(lastname + "---passed");
		} else {
			System.out.println(lastname + "----failed");
		}

		// verify the source date
		String actualsourcedate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actualsourcedate.contains(startdate)) {
			System.out.println(startdate + "---passed");
		} else {
			System.out.println(startdate + "----failed");
		}

		String actualsourceenddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actualsourceenddate.contains(enddate)) {
			System.out.println(enddate + "---passed");
		} else {
			System.out.println(enddate + "----failed");
		}

		// Logout of Application
		WebElement Logout = driver.findElement(By.xpath("//img [@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(Logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		// Close Browser
		driver.quit();

	}

}
