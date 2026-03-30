package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketimgPage {

	/*
     * Constructor initializes all WebElements using PageFactory.
     */

	public TicketimgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Ticket...']")
	private WebElement ticketlookupimage;

	public WebElement getticketlookupimage() {
		return ticketlookupimage;
	}

	

}
