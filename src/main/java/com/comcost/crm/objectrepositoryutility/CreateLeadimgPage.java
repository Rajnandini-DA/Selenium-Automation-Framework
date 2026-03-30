package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * CreateLeadingPage class:
 * Represents the Lead page and provides methods to interact with its elements.
 */

public class CreateLeadimgPage {

	WebDriver driver;

	public CreateLeadimgPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement leadlookupimage;

	public WebElement getLeadlookupimage() {
		return leadlookupimage;
	}

}
