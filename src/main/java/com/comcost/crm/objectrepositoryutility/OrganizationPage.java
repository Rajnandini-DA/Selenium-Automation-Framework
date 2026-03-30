package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * OrganizationPage class:
 * Represents the organization page and provides methods to interact with its elements.
 */

public class OrganizationPage {


	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement organizationLink ;

	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	
	public void Clickonorganizationsign() {
		organizationLink.click();
	}
	
	
}
