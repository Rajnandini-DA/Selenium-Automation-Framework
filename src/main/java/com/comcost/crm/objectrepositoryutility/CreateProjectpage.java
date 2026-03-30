package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



/*
 * CreateProjectPage class:
 * Represents creating Project page and provides methods to interact with its elements.
 */

public class CreateProjectpage {

	WebDriver driver;

	public CreateProjectpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "projectname")
	private WebElement projecttextfield;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public WebElement getProjecttextfield() {
		return projecttextfield;
	}

}
