package com.noncommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseObject.FacebookPageObject;
import baseObject.PageGeneratorManager;
import basePage.BaseTest;

public class Element_Not_Displayed extends BaseTest{
	private WebDriver driver;
	private FacebookPageObject facebookPage;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver= getBrowserDriver(browserName);
		facebookPage= PageGeneratorManager.openFacebookPage(driver);
	}
	@Test
	public void TC_01_Element_Displayed() {
		facebookPage.clickToCreateNewAccountButton();
		facebookPage.inputDataByTextboxName("test@gmail.com", "Mobile number or email address");
		verifyTrue(facebookPage.reEnterEmailAddressDisplayed());
	}
	@Test
	public void TC_02_Element_Not_Displayed_In_DOM() {
		facebookPage.refreshPage(driver);
		facebookPage.clickToCreateNewAccountButton();
		facebookPage.inputDataByTextboxName("", "Mobile number or email address");
		verifyTrue(facebookPage.reEnterEmailAddressUndisplayed());
	}
	@Test
	public void TC_02_Element_Not_Displayed_Not_In_DOM() {
		facebookPage.refreshPage(driver);
		verifyTrue(facebookPage.reEnterEmailAddressUndisplayed());
	}
}
