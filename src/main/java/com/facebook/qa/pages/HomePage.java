package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//span[contains(text(),'Kalyan Tanniru')]")
	WebElement userProfileLabel;
	@FindBy(xpath = "//span[contains(text(),'Kalyan Tanniru')]")
	WebElement userProfileLink;

	@FindBy(xpath = "//span[contains(text(),'Find friends')]")
	WebElement findFriendsLink;

	@FindBy(xpath = "//span[contains(text(),'Saved')]")
	WebElement savedLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	
	public ProfilePage clickOnProfile() {
		userProfileLink.click();
		return new ProfilePage();
	}

	public FriendsPage clickOnFindFriendsLink() {
		findFriendsLink.click();
		return new FriendsPage();
	}

	public SavedPage clickOnSavedLink() {
		savedLink.click();
		return new SavedPage();
	}

	public boolean verifyCorrectUserName() {
		return userProfileLabel.isDisplayed();
		
	}

}
