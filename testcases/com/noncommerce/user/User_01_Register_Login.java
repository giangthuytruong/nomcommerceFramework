package com.noncommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import basePage.AbstractPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Register_Login extends AbstractPage{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstName="Steve";
	String lastName="Job";
	String email="stevejob12@gmail.com";
	String password="123123";
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browers\\geckodriver.exe");
		driver = new FirefoxDriver();
		openUrl(driver,"https://demo.nopcommerce.com/");
	}
  @Test
  public void Re_01_EmptyData() {
	  clickToElement(driver, "//a[@class='ico-register']");
	  areJqueryandJsLoadSuccess(driver);
	  clickToElement(driver, "//button[@id='register-button']");
	  sleepInSecond(2);
	  AssertJUnit.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
	  AssertJUnit.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
	  AssertJUnit.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
	  AssertJUnit.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
	  AssertJUnit.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
  }
  @Test
  public void Re_02_InvalidEmail() {
	  sendKeyToElement(driver, "//input[@id='Email']", "tesst");
	  sleepInSecond(2);
	  AssertJUnit.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
  }
  @Test
  public void Re_03_ValidData() {
	  sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
	  sendKeyToElement(driver, "//input[@id='LastName']", lastName);
	  sendKeyToElement(driver, "//input[@id='Email']", email);
	  sendKeyToElement(driver, "//input[@id='Password']", password);
	  sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);
	  clickToElement(driver, "//button[@id='register-button']");
	  waitForAllElementVisible(driver, "//div[@class='result']");
	  AssertJUnit.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
	  clickToElement(driver, "//a[@class='ico-logout']");
  }
  @Test
  public void Re_04_PasswordLessThan6() {
	  clickToElement(driver, "//a[@class='ico-register']");
	  areJqueryandJsLoadSuccess(driver);
	  sendKeyToElement(driver, "//input[@id='Password']", "123");
	  clickToElement(driver, "//button[@id='register-button']");
	  sleepInSecond(1);
	  AssertJUnit.assertTrue(getElementText(driver, "//span[@id='Password-error']").contains("Password must meet the following rules:"));
  }
  @Test
  public void Re_05_ConfirmPasswordInvalid() {
	  sendKeyToElement(driver, "//input[@id='Password']", password);
	  sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123567");
	  clickToElement(driver, "//button[@id='register-button']");
	  sleepInSecond(1);
	  AssertJUnit.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
  }
  @AfterClass
  public void AfterClass() {
	  driver.quit();
  }
}
