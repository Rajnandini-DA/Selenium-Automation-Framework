package com.comcast.crm.Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChekoutPage {

	WebDriver driver;

	public ChekoutPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement country;

	@FindBy(id = "BillingNewAddress_City")
	private WebElement city;

	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement address1;

	@FindBy(id = "BillingNewAddress_Address2")
	private WebElement address2;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement zipcode;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phoneno;

	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	private WebElement Billingbtn;

	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	private WebElement shippingbtn;

	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
	private WebElement shippingMethodbtn;

	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
	private WebElement paymentbtn;

	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
	private WebElement paymentinfobtn;

	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")
	private WebElement confirmbtn;

	public WebElement getBillingbtn() {
		return Billingbtn;
	}

	public WebElement getShippingbtn() {
		return shippingbtn;
	}

	public WebElement getShippingMethodbtn() {
		return shippingMethodbtn;
	}

	public WebElement getPaymentbtn() {
		return paymentbtn;
	}

	public WebElement getPaymentinfobtn() {
		return paymentinfobtn;
	}

	public WebElement getConfirmbtn() {
		return confirmbtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getAddress1() {
		return address1;
	}

	public WebElement getAddress2() {
		return address2;
	}

	public WebElement getZipcode() {
		return zipcode;
	}

	public WebElement getPhoneno() {
		return phoneno;
	}

	public void Selectcountry() {
		Select sel = new Select(country);
		sel.deselectByValue("India");

	}
	
	public void Continue(String cityn , String address , String zipcodee , String phonenum) {
		city.sendKeys(cityn);
		address1.sendKeys(address);
		zipcode.sendKeys(zipcodee);
		phoneno.sendKeys(phonenum);
		Billingbtn.click();
		shippingbtn.click();
		shippingMethodbtn.click();
		paymentbtn.click();
		paymentinfobtn.click();
		
	}

}
