package com.comcost.crm.test;

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

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Click on More link
		driver.findElement(By.linkText("More")).click();

		// click on projects
		driver.findElement(By.name("Projects")).click();

		// Click on the add button on projects page
		WebElement Projectplussign = driver.findElement(By.xpath("//img[@alt='Create Projects...']"));
		Actions action = new Actions(driver);
		action.moveToElement(Projectplussign).click().perform();

		// Lastname
		driver.findElement(By.name("projectname")).sendKeys(projectname);

		// Step 6:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify Header msg
		String HeaderInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (HeaderInfo.contains(projectname)) {
			System.out.println(projectname + "is passed");
		} else {
			System.out.println(projectname + "is failed");
		}

		driver.quit();
	}

}
