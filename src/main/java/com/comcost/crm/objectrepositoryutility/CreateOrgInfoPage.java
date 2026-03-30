package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * CreateOrginfo class:
 * Represents the Organization page and provides methods to interact with its elements.
 */

public class CreateOrgInfoPage {

	public CreateOrgInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerverification;

	@FindBy(id = "dtlview_Industry")
	private WebElement industrydpheader;

	@FindBy(id = "dtlview_Type")
	private WebElement typedpheader;

	@FindBy(id = "dtlview_Phone")
	private WebElement phoneheader;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationheaderinfo;

	public WebElement getOrganizationheaderinfo() {
		return organizationheaderinfo;
	}

	public WebElement getPhoneheader() {
		return phoneheader;
	}

	public WebElement getIndustrydpheader() {
		return industrydpheader;
	}

	public WebElement getTypedpheader() {
		return typedpheader;
	}

	public WebElement getHeaderverification() {
		return headerverification;
	}

	public void phonenumberverification(String value) {
		String phonenoheader = phoneheader.getText();
		if (phonenoheader.contains(value)) {
			System.out.println(value + " is created");
		} else {
			System.out.println(value + " is not created");

		}
	}

}
