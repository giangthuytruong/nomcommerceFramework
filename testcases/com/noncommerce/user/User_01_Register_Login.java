package com.noncommerce.user;

import org.testng.annotations.Test;


import baseObject.HomePageObject;
import baseObject.PageGeneratorManager;
import baseObject.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.AssertJUnit;

import basePage.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_01_Register_Login extends BaseTest{
	private WebDriver driver;
	private HomePageObject homepage;
	private RegisterPageObject registerpage;
	private String firstName="Steve";
	private String lastName="Job";
	private String password="123123";
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver=getBrowserDriver(browserName);
	}
  @Test
  public void Re_01_EmptyData() {
	  homepage=PageGeneratorManager.openHomePage(driver);
	  registerpage=(RegisterPageObject) homepage.openPageAtHeaderByName(driver, "ico-register");
	  registerpage.clickToRegisterButton();
	  Assert.assertEquals(registerpage.getFirstnameError(), "First name is required.");
	  Assert.assertEquals(registerpage.getLastnameError(), "Last name is required.");
	  Assert.assertEquals(registerpage.getEmailError(), "Email is required.");
	  Assert.assertEquals(registerpage.getPasswordError(), "Password is required.");
	  Assert.assertEquals(registerpage.getConfirmPasswordError(), "Password is required.");
  }
  @Test
  public void Re_02_InvalidEmail() {
	  registerpage.sendKeyToEmail("tesst");
	  Assert.assertEquals(registerpage.getEmailError(), "Wrong email");
  }
  @Test
  public void Re_03_ValidData() {
	  registerpage.sendKeyToFirstname(firstName);
	  registerpage.sendKeyToLastname(lastName);
	  registerpage.sendKeyToEmail(registerpage.email);
	  registerpage.sendKeyToPassword(password);
	  registerpage.sendKeyToConfirmationPassword(password);
	  registerpage.clickToRegisterButton();
	  Assert.assertEquals(registerpage.getRegistrationResultMessage(), "Your registration completed");
	  homepage=(HomePageObject) registerpage.openPageAtHeaderByName(driver, "ico-logout");
  }
  @Test
  public void Re_04_PasswordLessThan6() {
	  registerpage=(RegisterPageObject) homepage.openPageAtHeaderByName(driver, "ico-register");
	  registerpage.sendKeyToPassword("123");
	  registerpage.clickToRegisterButton();
	  Assert.assertTrue(registerpage.getPasswordError().contains("Password must meet the following rules:"));
  }
  @Test
  public void Re_05_ConfirmPasswordInvalid() {
	  registerpage.sendKeyToPassword(password);
	  registerpage.sendKeyToConfirmationPassword("123567");
	  registerpage.clickToRegisterButton();
	  Assert.assertEquals(registerpage.getConfirmPasswordError(), "The password and confirmation password do not match.");
  }
  @AfterClass
  public void AfterClass() {
	  driver.quit();
  }
}
