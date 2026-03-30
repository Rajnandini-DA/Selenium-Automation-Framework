package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectInfoPage {

	/*
     * Constructor initializes all WebElements using PageFactory.
     */

	public ProjectInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerElement;

	public WebElement getHeaderElement() {
		return headerElement;
	}
	
	
	
}
