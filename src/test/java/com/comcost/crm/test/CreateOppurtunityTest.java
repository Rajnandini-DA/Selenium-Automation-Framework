package com.comcost.crm.test;

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

public class CreateOppurtunityTest {

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

		String oppurtunityname = eutil.getDatafromExcelFile("opportunity", 1, 2) + jutil.getRandomNumber();

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

		// Click on More link
		driver.findElement(By.linkText("Opportunities")).click();

		// click on projects
		driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();

		driver.findElement(By.name("potentialname")).sendKeys(oppurtunityname);

		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();

		// Switch
		String parentwindow = driver.getWindowHandle();

		wutil.switchToWindowOnURL(driver, "Accounts&action");

		driver.findElement(By.linkText("Qspider")).click();

		driver.switchTo().window(parentwindow);

		driver.findElement(By.xpath("//img[@id='jscal_trigger_closingdate']")).click();

		driver.findElement(By.xpath("//td[text()='30']")).click();

		// Step 6:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify Header msg
		String HeaderInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (HeaderInfo.contains(oppurtunityname)) {
			System.out.println(oppurtunityname + "is passed");
		} else {
			System.out.println(oppurtunityname + "is failed");
		}

		driver.quit();

	}

}
