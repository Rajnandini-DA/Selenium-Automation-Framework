package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/*
 * ContactPage class:
 * Represents the Contact page and provides methods to interact with its elements.
 */
public class ContactPage {

	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement contactlookupimage;

	public WebElement getContactlookupimage() {
		return contactlookupimage;
	}
	
	
	
}
