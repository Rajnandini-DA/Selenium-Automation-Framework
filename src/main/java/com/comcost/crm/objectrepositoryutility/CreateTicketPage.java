package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTicketPage {


    /*
     * Constructor initializes all WebElements using PageFactory.
     */

	public CreateTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="ticket_title")
	private WebElement titleTextFiled;

	public WebElement getTitleTextFiled() {
		return titleTextFiled;
	}
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;

	public WebElement getSaveButton() {
		return SaveButton;
	}

	
	
	
	
}
