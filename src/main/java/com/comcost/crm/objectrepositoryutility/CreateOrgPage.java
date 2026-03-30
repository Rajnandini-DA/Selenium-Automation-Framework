package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcost.crm.generic.webdriverutility.WebDriverUtility;

/*
 * CreateOrgPage class:
 * Represents creating organization page and provides methods to interact with its elements.
 */

public class CreateOrgPage {

	public CreateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement organizationName;

	@FindBy(name = "industry")
	private WebElement industryDropdown;

	@FindBy(name = "accounttype")
	private WebElement typeDropdown;

	@FindBy(id = "phone")
	private WebElement phonenoTextField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getPhonenoTextField() {
		return phonenoTextField;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	WebDriverUtility wbu = new WebDriverUtility();

	public void SelectbyDropdown(String industryvalue, String typevalue) {
		wbu.selectByWebElement(industryDropdown, industryvalue);
		wbu.selectByWebElement(typeDropdown, typevalue);
	}

}
