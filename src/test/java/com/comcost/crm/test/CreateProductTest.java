package com.comcost.crm.test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcost.crm.generic.fileutility.ExcelUtility;
import com.comcost.crm.generic.fileutility.Fileutility;
import com.comcost.crm.generic.webdriverutility.Javautility;

public class CreateProductTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		Fileutility futil = new Fileutility();
		ExcelUtility eutil = new ExcelUtility();
		Javautility jutil = new Javautility();
		//WebDriverUtility wutil = new WebDriverUtility();

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

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Click on organization link
		driver.findElement(By.linkText("Products")).click();

		// Click on the add button on organization page
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

		// Lastname
		driver.findElement(By.name("productname")).sendKeys(productname);


		// Step 6:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify Header msg
		String HeaderInfo = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if (HeaderInfo.contains(productname)) {
			System.out.println(productname + "is passed");
		} else {
			System.out.println(productname + "is failed");
		}

		driver.quit();
		
	}

}
