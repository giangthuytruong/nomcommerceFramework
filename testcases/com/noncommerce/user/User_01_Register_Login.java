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
	  log.info("Login - Step 01: Open 'HomePage'");
	  homepage=PageGeneratorManager.openHomePage(driver);
	  
	  log.info("Login - Step 02: Open 'Register Page'");
	  registerpage=(RegisterPageObject) homepage.openPageAtHeaderByName(driver, "ico-register");
	  
	  log.info("Login - Step 03: Click to Register button without filling in text fields");
	  registerpage.clickToRegisterButton();
	  
	  log.info("Login - Step 04: Verify firstname validation message displayed");
	  Assert.assertEquals(registerpage.getFirstnameError(), "First name is required.");
	  
	  log.info("Login - Step 04: Verify lastname validation message displayed");
	  Assert.assertEquals(registerpage.getLastnameError(), "Last name is required.");
	  
	  log.info("Login - Step 04: Verify email validation message displayed");
	  Assert.assertEquals(registerpage.getEmailError(), "Email is required.");
	  
	  log.info("Login - Step 05: Verify password validation message displayed");
	  Assert.assertEquals(registerpage.getPasswordError(), "Password is required.");
	  
	  log.info("Login - Step 05: Verify confirm password validation message displayed");
	  Assert.assertEquals(registerpage.getConfirmPasswordError(), "Password is required.");
  }
  @Test
  public void Re_02_InvalidEmail() {
	  log.info("Login - Step 01: Input data to 'Email' textbox: tesst");
	  registerpage.sendKeyToEmail("tesst");
	  
	  log.info("Login - Step 02: Verify email validation message displayed");
	  Assert.assertEquals(registerpage.getEmailError(), "Wrong email");
  }
  @Test
  public void Re_03_ValidData() {
	  log.info("Login - Step 01: Input data to 'Firstname' textbox:"+ firstName);
	  registerpage.sendKeyToFirstname(firstName);
	  
	  log.info("Login - Step 02: Input data to 'Lastname' textbox:"+ lastName);
	  registerpage.sendKeyToLastname(lastName);
	  
	  log.info("Login - Step 03: Input data to 'Email' textbox:"+ registerpage.email);
	  registerpage.sendKeyToEmail(registerpage.email);
	  
	  log.info("Login - Step 04: Input data to 'Password' textbox:"+ password);
	  registerpage.sendKeyToPassword(password);
	  
	  log.info("Login - Step 05: Input data to 'Confirmation password' textbox:"+ password);
	  registerpage.sendKeyToConfirmationPassword(password);
	  
	  log.info("Login - Step 06: Click to Register button");
	  registerpage.clickToRegisterButton();
	  
	  log.info("Login - Step 07: Verify registration success message displayed");
	  Assert.assertEquals(registerpage.getRegistrationResultMessage(), "Your registration completed");
	  
	  log.info("Login - Step 08: Logout");
	  homepage=(HomePageObject) registerpage.openPageAtHeaderByName(driver, "ico-logout");
  }
  @Test
  public void Re_04_PasswordLessThan6() {
	  log.info("Login - Step 01: Open Register page");
	  registerpage=(RegisterPageObject) homepage.openPageAtHeaderByName(driver, "ico-register");
	  
	  log.info("Login - Step 02: Input data to 'Password' textbox: 123");
	  registerpage.sendKeyToPassword("123");
	  
	  log.info("Login - Step 03: Click to register button");
	  registerpage.clickToRegisterButton();
	  
	  log.info("Login - Step 04: Verify password validation error message displayed");
	  Assert.assertTrue(registerpage.getPasswordError().contains("Password must meet the following rules:"));
  }
  @Test
  public void Re_05_ConfirmPasswordInvalid() {
	  log.info("Login - Step 01: Input data to 'Password' textbox: "+ password);
	  registerpage.sendKeyToPassword(password);
	  
	  log.info("Login - Step 02: Input data to 'Confirmation password' textbox: 123567" );
	  registerpage.sendKeyToConfirmationPassword("123567");
	  
	  log.info("Login - Step 03: Click to register button");
	  registerpage.clickToRegisterButton();
	  
	  log.info("Login - Step 04: Verify confirmation password validation error message displayed");
	  Assert.assertEquals(registerpage.getConfirmPasswordError(), "The password and confirmation password do not match.");
  }
  @AfterClass
  public void AfterClass() {
	  driver.quit();
  }
}
