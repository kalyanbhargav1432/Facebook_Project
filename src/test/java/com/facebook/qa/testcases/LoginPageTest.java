package com.facebook.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.BaseClass;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	Logger log = Logger.getLogger(LoginPageTest.class);

	@BeforeMethod
	public void setUp() {
		initialization();

	}
	// To check Page title is showing correct or not

	@Test(priority = 1)
	public void loginPageTitleTest() {
		loginPage = new LoginPage();
		String loginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up", loginPageTitle);
		log.info("Login facebook page");
	}

	// To check login page working or not

	@Test(priority = 2)
	public void loginTest() {
		loginPage = new LoginPage();
		homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
	}

	@AfterMethod
	public void AfterMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
