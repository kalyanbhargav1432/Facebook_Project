package com.facebook.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.BaseClass;
import com.facebook.qa.pages.FriendsPage;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;
import com.facebook.qa.pages.ProfilePage;
import com.facebook.qa.pages.SavedPage;

public class HomePageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	FriendsPage friendsPage;
	SavedPage savedPage;
	ChromeOptions options = new ChromeOptions();

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));

	}

	// To check HomePage Title coming or not

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		options.addArguments("--disable-notifications");
		homePage.verifyHomePageTitle();
	}

	// To check ProfileName is visible or not

	@Test(priority = 2)
	public void verifyProfileNameTest() {
		options.addArguments("--disable-notifications");
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}

	// To check Profile link opening or not

	@Test(priority = 3)
	public void verifyClickOnProfileTest() throws InterruptedException {
		options.addArguments("--disable-notifications");
		profilePage = homePage.clickOnProfile();

	}

	// To check FindFriends link opening or not

	@Test(priority = 4)
	public void verifyFindFriendsPageTest() {
		options.addArguments("--disable-notifications");
		friendsPage = homePage.clickOnFindFriendsLink();
	}

	// To check SavedPage link opening or not

	@Test(priority = 5)
	public void verifySavedPageTest() {
		options.addArguments("--disable-notifications");
		savedPage = homePage.clickOnSavedLink();
	}

	@AfterMethod
	public void AfterMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
