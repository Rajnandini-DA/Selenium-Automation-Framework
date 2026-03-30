package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewWindowToSelectOrganization {

	public NewWindowToSelectOrganization(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(id="search_txt")
	private WebElement Searchbox;

	public WebElement getSearchbox() {
		return Searchbox;
	}
	

	
}
