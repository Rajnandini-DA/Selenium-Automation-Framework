package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * Create Product img Page class:
 * Represents  the image icon  of product page and provides methods to interact with its elements.
 */

public class CreateProuctimg {


	WebDriver driver;

	public CreateProuctimg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement productlookupimage;

	public WebElement getproductlookupimage() {
		return productlookupimage;
	}

	
	
}
