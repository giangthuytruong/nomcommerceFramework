package com.noncommerce.user;

import org.testng.annotations.Test;

import baseObject.HomePageObject;
import baseObject.RegisterPageObject;

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
	  HomePageObject.clickToElement(driver, "//a[@class='ico-register']");
	  RegisterPageObject.areJqueryandJsLoadSuccess(driver);
	  RegisterPageObject.clickToElement(driver, "//button[@id='register-button']");
	  sleepInSecond(2);
	  AssertJUnit.assertEquals(RegisterPageObject.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
	  AssertJUnit.assertEquals(RegisterPageObject.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
	  AssertJUnit.assertEquals(RegisterPageObject.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
	  AssertJUnit.assertEquals(RegisterPageObject.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
	  AssertJUnit.assertEquals(RegisterPageObject.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
  }
  @Test
  public void Re_02_InvalidEmail() {
	  RegisterPageObject.sendKeyToElement(driver, "//input[@id='Email']", "tesst");
	  sleepInSecond(2);
	  AssertJUnit.assertEquals(RegisterPageObject.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
  }
  @Test
  public void Re_03_ValidData() {
	  RegisterPageObject.sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
	  RegisterPageObject.sendKeyToElement(driver, "//input[@id='LastName']", lastName);
	  RegisterPageObject.sendKeyToElement(driver, "//input[@id='Email']", email);
	  RegisterPageObject.sendKeyToElement(driver, "//input[@id='Password']", password);
	  RegisterPageObject.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);
	  RegisterPageObject.clickToElement(driver, "//button[@id='register-button']");
	  RegisterPageObject.waitForAllElementVisible(driver, "//div[@class='result']");
	  AssertJUnit.assertEquals(RegisterPageObject.getElementText(driver, "//div[@class='result']"), "Your registration completed");
	  RegisterPageObject.clickToElement(driver, "//a[@class='ico-logout']");
  }
  @Test
  public void Re_04_PasswordLessThan6() {
	  HomePageObject.clickToElement(driver, "//a[@class='ico-register']");
	  RegisterPageObject.areJqueryandJsLoadSuccess(driver);
	  RegisterPageObject.sendKeyToElement(driver, "//input[@id='Password']", "123");
	  RegisterPageObject.clickToElement(driver, "//button[@id='register-button']");
	  sleepInSecond(1);
	  AssertJUnit.assertTrue(RegisterPageObject.getElementText(driver, "//span[@id='Password-error']").contains("Password must meet the following rules:"));
  }
  @Test
  public void Re_05_ConfirmPasswordInvalid() {
	  RegisterPageObject.sendKeyToElement(driver, "//input[@id='Password']", password);
	  RegisterPageObject.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123567");
	  RegisterPageObject.clickToElement(driver, "//button[@id='register-button']");
	  sleepInSecond(1);
	  AssertJUnit.assertEquals(RegisterPageObject.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
  }
  @AfterClass
  public void AfterClass() {
	  driver.quit();
  }
}
