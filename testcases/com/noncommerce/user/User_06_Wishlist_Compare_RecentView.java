package com.noncommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import baseObject.HomePageObject;
import baseObject.PageGeneratorManager;
import baseObject.RegisterPageObject;
import baseObject.SearchPageObject;
import basePage.BaseTest;

public class User_06_Wishlist_Compare_RecentView extends BaseTest{
	private WebDriver driver;
	private HomePageObject homepage;
	private RegisterPageObject registerpage;
	private String firstName, lastName, password;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver= getBrowserDriver(browserName);
		firstName= "Steve";
		lastName="Job";
		password="123123";
		homepage= PageGeneratorManager.openHomePage(driver);
		registerpage= homepage.clickToRegisterLink();
		registerpage.sendKeyToFirstname(firstName);
		registerpage.sendKeyToLastname(lastName);
		registerpage.sendKeyToEmail(registerpage.email);
		registerpage.sendKeyToPassword(password);
		registerpage.sendKeyToConfirmationPassword(password);
		registerpage.clickToRegisterButton();
		Assert.assertEquals(registerpage.getRegistrationResultMessage(), "Your registration completed");
		
	}
	
}
