package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * HomePage class:
 * Represents the Home page and provides methods to interact with its elements.
 */

public class HomePage {

	WebDriver driver ;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement Campaignslink;
	
	@FindBy(linkText="Projects")
	private WebElement ProjectsLinks;
	
	@FindBy(id="qccombo")
	private WebElement quickcreatedropdown;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutEle;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadslink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitieslink;
	
	@FindBy(linkText="Products")
	private WebElement productslink;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement ticketlink;

	public WebElement getTicketlink() {
		return ticketlink;
	}

	public WebElement getQuickcreatedropdown() {
		return quickcreatedropdown;
	}

	public WebElement getLeadslink() {
		return leadslink;
	}

	public WebElement getOpportunitieslink() {
		return opportunitieslink;
	}

	public WebElement getProductslink() {
		return productslink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getLogoutEle() {
		return logoutEle;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignslink() {
		return Campaignslink;
	}

	public WebElement getProjectsLinks() {
		return ProjectsLinks;
	}
	
	public void Logoutfromapp(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(logoutEle).perform();
		signoutLink.click();
		
	}
	
	
	
	
	
	
	
	
}
