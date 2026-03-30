package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadInfopage {

	 /*
     * Constructor initializes all WebElements using PageFactory.
     */

	public CreateLeadInfopage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerElement;

	public WebElement getHeaderElement() {
		return headerElement;
	}
	
	@FindBy(id="mouseArea_Company")
	private WebElement companyverification;

	public WebElement getCompanyverification() {
		return companyverification;
	}
	
	
	
}
