package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.BaseClass;

public class LoginPage extends BaseClass {

	// Page Factory
	@FindBy(id = "email")
	WebElement username;

	@FindBy(xpath = "//input[@id='pass']")
	WebElement password;

	@FindBy(name = "login")
	WebElement loginButton;
	
	
	// initializing the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		loginButton.click();
		return new HomePage();
	}
	
}