package com.facebook.qa.testcases;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.BaseClass;
import com.facebook.qa.pages.FriendsPage;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;

public class FindFriendsPageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	FriendsPage friendsPage;
	ChromeOptions options = new ChromeOptions();

	public FindFriendsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		friendsPage = homePage.clickOnFindFriendsLink();
	}
	// To check Friends page title is showing or not

	@Test(priority = 1)
	public void verifyFriendsPageTitleTest() {
		options.addArguments("--disable-notifications");
		friendsPage.verifyFriendsPageTitle();
	}

	// To check FriendRequest link opening or not

	@Test(priority = 2)
	public void ClickOnFriendRequestLinkTest() {
		options.addArguments("--disable-notifications");
		friendsPage.clickOnFriendRequestLink();
	}

	// To check Suggestions link opening or not

	@Test(priority = 3)
	public void ClickOnSuggestionsLinkTest() {
		options.addArguments("--disable-notifications");
		friendsPage.clickOnSuggestionsLink();
	}
	// To check Birthday link opening or not

	@Test(priority = 4)
	public void ClickOnBirthdayLinkTest() {
		options.addArguments("--disable-notifications");
		friendsPage.clickOnBirthdayLink();
	}
	// To check CustomLists link opening or not

	@Test(priority = 5)
	public void ClickOnCustomListsLinkTest() {
		options.addArguments("--disable-notifications");
		friendsPage.clickCustomListsLink();
	}

	@AfterMethod
	public void AfterMethod() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
