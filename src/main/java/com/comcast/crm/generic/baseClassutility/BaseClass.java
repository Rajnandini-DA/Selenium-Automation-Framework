package com.comcast.crm.generic.baseClassutility;


/*
 * 
 * BaseClass
 * -----------------------------
 * This class serves as the foundation for all test classes.
 * It contains common setup and teardown logic along with 
 * reusable utilities that can be shared across test scripts.
 *
 */

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcost.crm.generic.databaseutility.DatabaseUtility;
import com.comcost.crm.generic.fileutility.ExcelUtility;
import com.comcost.crm.generic.fileutility.Fileutility;
import com.comcost.crm.generic.webdriverutility.Javautility;
import com.comcost.crm.generic.webdriverutility.UtilityClassObject;
import com.comcost.crm.generic.webdriverutility.WebDriverUtility;
import com.comcost.crm.objectrepositoryutility.HomePage;
import com.comcost.crm.objectrepositoryutility.LoginPage;

public class BaseClass {

	
	/*Create object*/
	public DatabaseUtility dbutil = new DatabaseUtility();
	public Fileutility futil = new Fileutility();
	public ExcelUtility eutil = new ExcelUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public Javautility jutil = new Javautility();
	public WebDriver driver ;
	public static WebDriver sdriver;
	
	
	/*
	 * This method is annotated with @BeforeSuite.
	 * It will run only once before all tests in the entire suite execution.
	 * 
	 * Common setup tasks are usually performed here, such as:
	 *  - Initializing database connections
	 *  - Setting up test reports (Extent Report, Allure, etc.)
	 *  - Loading configuration files / global properties
	 *  - Any one-time setup required before executing test cases
	 * 
	 * Being in the BaseClass ensures all test classes that extend this class
	 * will have the setup executed automatically.
	 */
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS() {
		System.out.println("==Connect to DB , Report Config==");
		dbutil.getDbConnection();
	}
	
	
	/*
	 * This method is annotated with @BeforeClass.
	 * It runs once before the first @Test method of the current class.
	 *
	 * Common uses:
	 *  - Launching browser
	 *  - Navigating to the base URL
	 *  - Logging into the application (if required at class level)
	 *
	 * Scope: Executes once per class, before any @Test method inside it.
	 */
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC() throws IOException {
		System.out.println("==Launch the Browser==");
		String BROWSER = futil.getDatafromPropertiesFile("browser");
		if (BROWSER.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.contains("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.contains("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		driver.get(futil.getDatafromPropertiesFile("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		UtilityClassObject.setDriver(driver);
	}
	
	
	/*
	 * This method is annotated with @BeforeMethod.
	 * It runs before each @Test method in the current class.
	 *
	 * Common uses:
	 *  - Navigating to a specific page before each test
	 *  - Resetting test data/state
	 *  - Setting implicit/explicit waits
	 *  - Creating fresh test preconditions
	 *
	 * Scope: Executes before every single @Test method.
	 */
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws IOException {
		System.out.println("==Login to app==");
		String USERNAME = futil.getDatafromPropertiesFile("username");
		String PASSWORD = futil.getDatafromPropertiesFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp(USERNAME, PASSWORD);
	}
	
	/*
	 * This method is annotated with @AfterMethod.
	 * It runs after each @Test method in the current class.
	 *
	 * Common uses:
	 *  - Logging out of the application (if required per test)
	 *  - Capturing screenshots on test failure
	 *  - Cleaning up test data/state
	 *
	 * Scope: Executes after every single @Test method.
	 */
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void ConfigAM() {
		System.out.println("==Logout from app==");
		HomePage hp = new HomePage(driver);
		hp.Logoutfromapp(driver);
	}
	
	/*
	 * This method is annotated with @AfterClass.
	 * It runs once after all @Test methods in the current class are executed.
	 *
	 * Common uses:
	 *  - Closing the browser window for that test class
	 *  - Releasing class-level resources
	 *
	 * Scope: Executes once per class, after all @Test methods inside it.
	 */
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void ConfigAC() {
		System.out.println("==Close the Browser==");
		driver.quit();
	}
	
	
	/*
	 * This method is annotated with @AfterSuite.
	 * It will run only once after all the tests in the entire suite execution.
	 * 
	 * Common cleanup tasks are usually performed here, such as:
	 *  - Closing database connections
	 *  - Flushing and closing test reports (Extent Report, Allure, etc.)
	 *  - Releasing global resources
	 *  - Sending consolidated execution results (e.g., via email/Slack)
	 * 
	 * Being in the BaseClass ensures all test classes that extend this class
	 * will automatically benefit from this cleanup after the suite execution finishes.
	 */
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void ConfigAS() {
		System.out.println("==Close the db==");
		dbutil.closeConnection();
	}
	
	
}
