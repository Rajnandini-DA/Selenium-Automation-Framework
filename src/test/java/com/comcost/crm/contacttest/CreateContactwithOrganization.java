package com.comcost.crm.contacttest;

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

public class CreateContactwithOrganization {

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
		
		String orgName = eutil.getDatafromExcelFile("org", 1, 2)+jutil.getRandomNumber();
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

		/// Click on organization link
		driver.findElement(By.linkText("Organizations")).click();

		// Click on the add button on organization page
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Step 5:Create a contact with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(orgName);

		// Step 6:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

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
		
		

		// Step 3:Navigate to contact link
		driver.findElement(By.linkText("Contacts")).click();

		// Step 4:Click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Create a contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(lastname);

		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		String parentwindow = driver.getWindowHandle();
		
		wutil.switchToWindowOnURL(driver,"Accounts&action");
		
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.id("search_txt")).click();
		driver.findElement(By.partialLinkText("facebook")).click();
		
		driver.switchTo().window(parentwindow);
		
		

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify Header msg
		String HeaderInfo1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (HeaderInfo1.contains(lastname)) {
			System.out.println(lastname + "is passed");
		} else {
			System.out.println(lastname+ "is failed");
		}
		
		//logout
		driver.quit();

	}

}
