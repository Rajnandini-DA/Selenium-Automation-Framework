package com.comcost.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * RegisterPage class:
 * Represents the Registerpage and provides methods to interact with its elements.
 */

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//label[text()='Male']")
	private WebElement malebtn;

	@FindBy(xpath = "//label[text()='Female']")
	private WebElement femalebtn;

	@FindBy(id = "FirstName")
	private WebElement firstname;

	@FindBy(id = "LastName")
	private WebElement Lastname;

	@FindBy(id = "Email")
	private WebElement email;

	@FindBy(id = "Password")
	private WebElement password;

	@FindBy(id = "ConfirmPassword")
	private WebElement confirmpassword;

	@FindBy(id = "register-button")
	private WebElement registerbtn;

	public WebElement getMalebtn() {
		return malebtn;
	}

	public WebElement getFemalebtn() {
		return femalebtn;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return Lastname;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmpassword() {
		return confirmpassword;
	}

	public WebElement getRegisterbtn() {
		return registerbtn;
	}

	public void toRegister(String firstn, String lastn, String emailid) {
		
		femalebtn.click();
		firstname.sendKeys(firstn);
		Lastname.sendKeys(lastn);
		email.sendKeys(emailid);
		password.sendKeys("123456");
		confirmpassword.sendKeys("123456");
		registerbtn.click();

	}

}
