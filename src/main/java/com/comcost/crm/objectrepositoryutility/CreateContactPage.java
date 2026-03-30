package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * CreateContactPage class:
 * Represents the Contact page and provides methods to interact with its elements.
 */

public class CreateContactPage {

	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement LastnameTextfield;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement addorganizationincontactpageimg;
	
	@FindBy(name="support_start_date")
	private WebElement supportstartdate;
	
	@FindBy(name="support_end_date")
	private WebElement supportenddate;
	

	public WebElement getAddorganizationincontactpageimg() {
		return addorganizationincontactpageimg;
	}

	public WebElement getLastnameTextfield() {
		return LastnameTextfield;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	public void togetsupportdate(String value , String value1) {
		supportstartdate.clear();
		supportstartdate.sendKeys(value);
		supportenddate.clear();
		supportenddate.sendKeys(value1);
	}
	
	
	
	
	

}
