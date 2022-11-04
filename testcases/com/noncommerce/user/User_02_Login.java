package com.noncommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseObject.HomePageObject;
import baseObject.LoginPageObject;
import baseObject.PageGeneratorManager;
import baseObject.RegisterPageObject;
import basePage.BaseTest;

public class User_02_Login extends BaseTest{
	private WebDriver driver;
	private HomePageObject homepage;
	private LoginPageObject loginpage;
	private RegisterPageObject registerpage;
	private String firstName, lastName, password, email;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver= getBrowserDriver(browserName);
		firstName= "Steve";
		lastName="Job";
		password="123123";
		homepage= PageGeneratorManager.openHomePage(driver);
		email="automationfc"+homepage.getRandomNumber()+"@gmail.com";
		registerpage=homepage.clickToRegisterLink();
		registerpage= new RegisterPageObject(driver);
		registerpage.sendKeyToFirstname(firstName);
		  registerpage.sendKeyToLastname(lastName);
		  registerpage.sendKeyToEmail(email);
		  registerpage.sendKeyToPassword(password);
		  registerpage.sendKeyToConfirmationPassword(password);
		  registerpage.clickToRegisterButton();
		  Assert.assertEquals(registerpage.getRegistrationResultMessage(), "Your registration completed");
		  homepage=registerpage.clickToLogoutLink(driver);
	}
	@Test
	public void Log_01_Empty_Data() {
		loginpage=homepage.clickToLoginLink();
		loginpage.clickToLoginButton();
		Assert.assertEquals(loginpage.getEmailValidation(), "Please enter your email");
	}
	@Test
	public void Log_02_Invalid_Email() {
		loginpage.sendKeyToEmail("testyyyy");
		loginpage.clickToLoginButton();
		Assert.assertEquals(loginpage.getEmailValidation(), "Wrong email");
	}
	@Test
	public void Log_03_Unregistered_Email(){
		loginpage.sendKeyToEmail("uuuu@gmail.com");
		loginpage.clickToLoginButton();
		Assert.assertTrue(loginpage.getValidationMessage().contains("No customer account found"));
	}
	@Test
	public void Log_04_Registered_Email_Empty_Password() {
		loginpage.sendKeyToEmail(email);
		loginpage.clickToLoginButton();
		Assert.assertTrue(loginpage.getValidationMessage().contains("The credentials provided are incorrect"));
	}
	@Test
	public void Log_05_Registerred_Email_Invalid_Password() {
		loginpage.sendKeyToEmail(email);
		loginpage.sendKeyToPassword("4588795");
		loginpage.clickToLoginButton();
		Assert.assertTrue(loginpage.getValidationMessage().contains("The credentials provided are incorrect"));
	}
	@Test
	public void Log_06_Login_Successful() {
		loginpage.sendKeyToEmail(email);
		loginpage.sendKeyToPassword(password);
		loginpage.clickToLoginButton();
		Assert.assertTrue(homepage.MyAccountLinkDisplayed());
	}
	 @AfterClass
	  public void AfterClass() {
		  driver.quit();
	  }
}
