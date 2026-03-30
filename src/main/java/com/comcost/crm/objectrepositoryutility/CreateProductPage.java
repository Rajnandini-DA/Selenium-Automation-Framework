package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/*
 * CreateProductPage class:
 * Represents creating product page and provides methods to interact with its elements.
 */

public class CreateProductPage {

	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "productname")
	private WebElement productTextfield;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public WebElement getProductTextfield() {
		return productTextfield;
	}
	
	
	
}
