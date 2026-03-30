package com.comcost.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

/*
 * DriverFactory class:
 * Uses ThreadLocal to provide thread-safe WebDriver instances for parallel test execution.
 */

public class UtilityClassObject {

	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	
	/*
     * Returns the ExtentTest instance for the current thread.
     */
	public static ExtentTest getTest() {
		return test.get();
		}
	
	/*
     * Initializes and sets a new ExtentTest instance for the current thread.
     */
	public static void setTest(ExtentTest actTest) {
		test.set(actTest);
		
	}
	
	/*
     * Returns the WebDriver instance for the current thread.
     */
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	 /*
     * Initializes and sets a new WebDriver instance for the current thread.
     */
	public static void setDriver(WebDriver actdriver) {
		driver.set(actdriver);
		
	}
}
