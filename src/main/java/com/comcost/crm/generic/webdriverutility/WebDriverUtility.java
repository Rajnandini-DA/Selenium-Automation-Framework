package com.comcost.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	
	/**
	 * This Method is used to wait until element is loaded in Webpage
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	/**
	 * This method will wait until the visibility of element provided with driver
	 * and element
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementPresentToLoad(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	/**
	 * this method is used to transfer driver control to window 
	 * provided driver and particular url
	 * @param driver
	 * @param partialurl
	 */
	public void switchToWindowOnURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);

			String actualURL = driver.getCurrentUrl();
			if (actualURL.contains(partialURL)) {
				break;
			}
		}

	}

	/**
	 * this method is used to transfer driver control to window 
	 * provided driver and particular title
	 * @param driver
	 * @param partialtitle
	 */
	public void switchToWindowOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);

			String actualURL = driver.getTitle();
			if (actualURL.contains(partialTitle)) {
				break;
			}
		}

	}

	/**
	 * This method is used to handle Frame with index provides Driver and Element
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to handle Frame with name provides Driver and Element
	 * 
	 * @param driver
	 * @param name
	 */
	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}

	/**
	 * This method is used to handle Frame with WebElements provides Driver and Element
	 * 
	 * @param driver
	 * @param WebElement
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	
	/**
	 * This method is used to Handle Alerthandle popup by using accept provides
	 * wiuth driver
	 * 
	 * @param driver
	 */
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	
	/**
	 * This method is used to Handle Alerthandle popup by using dismiss provides
	 * wiuth driver
	 * 
	 * @param driver
	 */
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * this method is using to handle dropdown using Visible text provided with text
	 * and element
	 * 
	 * @param text
	 * @param element
	 */
	public void selectByWebElement(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	
	/**
	 * this method is used to handle dropdown by using index provide with element
	 * and index
	 * 
	 * @param element
	 * @param index
	 */
	public void selectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * ' this method is used to do mouse hover on element provides with driver and
	 * element
	 * 
	 * @param driver
	 * @param element
	 */

	public void mouseMovementOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	
	/**
	 * ' this method is used to do doubleClick on element provides with driver and
	 * element
	 * 
	 * @param driver
	 * @param element
	 */

	public void doubleClickElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	/**
	 * ' this method is used to do click on element provides with driver and
	 * element
	 * 
	 * @param driver
	 * @param element
	 */

	public void Click(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.click(element).perform();
	}
	
	/**
	 * \ This Method is used to Maximize the browser provided driver
	 * 
	 * @param driver
	 */
	public void maximizethepage(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	

}
