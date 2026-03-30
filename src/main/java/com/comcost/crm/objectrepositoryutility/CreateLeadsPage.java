package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * CreateLeadPage class:
 * Represents the Lead page and provides methods to interact with its elements.
 */

public class CreateLeadsPage {

	WebDriver driver;

	public CreateLeadsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement leadnametextfield;
	
	@FindBy(name="company")
	private WebElement companyTextfield;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	public WebElement getLeadnametextfield() {
		return leadnametextfield;
	}

	public WebElement getCompanyTextfield() {
		return companyTextfield;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
}
