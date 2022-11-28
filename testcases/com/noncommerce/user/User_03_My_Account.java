package com.noncommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseObject.AddressPageObject;
import baseObject.ChangePasswordPageObject;
import baseObject.CustomerInfoPageObject;
import baseObject.HomePageObject;
import baseObject.LoginPageObject;
import baseObject.MyAccountObject;
import baseObject.MyProductReviewPageObject;
import baseObject.PageGeneratorManager;
import baseObject.ProductReviewObject;
import baseObject.RegisterPageObject;
import basePage.BaseTest;

public class User_03_My_Account extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, password;
	private HomePageObject homepage;
	private RegisterPageObject registerpage;
	private LoginPageObject loginpage;
	private CustomerInfoPageObject customerpage;
	private ProductReviewObject productReview;
	private AddressPageObject addresspage;
	private ChangePasswordPageObject changePasswordPage;
	private MyAccountObject myaccountpage;
	private MyProductReviewPageObject myProductReviewPage;
	private String firstNameUpdate, lastNameUpdate, emailUpdate, companyName, newPassword, productName;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver= getBrowserDriver(browserName);
		firstName= "Steve";
		lastName="Job";
		password="123123";
		firstNameUpdate="Automation";
		lastNameUpdate="FC";
		emailUpdate="automationfc.vn@gmail.com";
		companyName="Automation FC";
		newPassword="123456";
		productName="Build your own computer";
		homepage= PageGeneratorManager.openHomePage(driver);
		registerpage=(RegisterPageObject) homepage.openPageAtHeaderByName(driver, "ico-register");
		registerpage.sendKeyToFirstname(firstName);
		  registerpage.sendKeyToLastname(lastName);
		  registerpage.sendKeyToEmail(registerpage.email);
		  registerpage.sendKeyToPassword(password);
		  registerpage.sendKeyToConfirmationPassword(password);
		  registerpage.clickToRegisterButton();
		  Assert.assertEquals(registerpage.getRegistrationResultMessage(), "Your registration completed");
		  myaccountpage=(MyAccountObject) registerpage.openPageAtHeaderByName(driver, "ico-account");
	}
	public void My_Acc_01_Update_Success() {
		String dateOfBirth="1";
		String monthOfBirth="1";
		String yearOfBirth="1914";
		customerpage=(CustomerInfoPageObject) myaccountpage.openPageAtMyAccountByName(driver, "customer-info active");
		customerpage.sendKeyToFirstName(firstNameUpdate);
		customerpage.sendKeyToLastName(lastNameUpdate);
		customerpage.selectDay(dateOfBirth);
		customerpage.selectMonth(monthOfBirth);
		customerpage.selectYear(yearOfBirth);
		customerpage.sendKeyToEmail(emailUpdate);
		customerpage.sendKeyToCompanyName(companyName);
		customerpage.clickToSaveButton();
		Assert.assertEquals(customerpage.getFirstNameAttribute("value"), firstNameUpdate);
		Assert.assertEquals(customerpage.getLastNameAttribute("value"), lastNameUpdate);
		Assert.assertEquals(customerpage.getDateAttribute("value"), dateOfBirth);
		Assert.assertEquals(customerpage.getMonthAttribute("value"), monthOfBirth);
		Assert.assertEquals(customerpage.getYearAttribute("value"), yearOfBirth);
		Assert.assertEquals(customerpage.getCompanyNameAttribute("value"), companyName);
	}
	public void My_Acc_02_Add_Address() {
		String country="Viet Nam";
		String city="Hanoi";
		String address1="123 Le Lai";
		String address2="234 Hai Phong";
		String postalCode="550000";
		String phoneNumber="0123456789";
		String faxNumber="0987654321";
		addresspage=(AddressPageObject)customerpage.openPageAtMyAccountByName(driver, "customer-addresses inactive");
		addresspage.clickToAddButton();
		addresspage.sendKeyToFirstName(firstNameUpdate);
		addresspage.sendKeyToLastName(lastNameUpdate);
		addresspage.sendKeyToEmail(emailUpdate);
		addresspage.sendKeyToCompany(companyName);
		addresspage.selectCountry(country);
		addresspage.sendKeyToCity(city);
		addresspage.sendKeyToAddress1(address1);
		addresspage.sendKeyToAddress2(address2);
		addresspage.sendKeyToPostalCode(postalCode);
		addresspage.sendKeyToPhoneNumber(phoneNumber);
		addresspage.sendKeyToFaxNumber(faxNumber);
		addresspage.clickToSaveAddressButton();
		Assert.assertEquals(addresspage.getNameText(), firstNameUpdate+" "+lastNameUpdate);
		Assert.assertTrue(addresspage.getEmailUpdate().contains(emailUpdate));
		Assert.assertTrue(addresspage.getPhoneNumber().contains(phoneNumber));
		Assert.assertTrue(addresspage.getFaxNumber().contains(faxNumber));
		Assert.assertEquals(addresspage.getcompanyName(), companyName);
		Assert.assertEquals(addresspage.getAddress1Update(), address1);
		Assert.assertEquals(addresspage.getAddress2Update(), address2);
		Assert.assertEquals(addresspage.getCityPostalCodeText(), city+", "+postalCode);
		Assert.assertEquals(addresspage.getCountry(), country);
	}
	public void My_Acc_03_Change_Password() {
		changePasswordPage=(ChangePasswordPageObject)addresspage.openPageAtMyAccountByName(driver, "change-password inactive");
		changePasswordPage.sendKeyToOldPassword(password);
		changePasswordPage.sendKeyToNewPassword(newPassword);
		changePasswordPage.sendKeyToConfirmPassword(newPassword);
		changePasswordPage.clickToChangePasswordButton();
		changePasswordPage.closePopup();
		homepage=(HomePageObject) changePasswordPage.openPageAtHeaderByName(driver, "ico-logout");
		loginpage=(LoginPageObject) homepage.openPageAtHeaderByName(driver, "ico-login");
		loginpage.sendKeyToEmail(emailUpdate);
		loginpage.sendKeyToPassword(password);
		loginpage.clickToLoginButton();
		Assert.assertTrue(loginpage.getValidationMessage().contains("The credentials provided are incorrect"));
		loginpage.sendKeyToEmail(emailUpdate);
		loginpage.sendKeyToPassword(newPassword);
		loginpage.clickToLoginButton();
		Assert.assertTrue(homepage.MyAccountLinkDisplayed());
	}
	public void My_Acc_04_My_Product_Review() {
		String reviewTitle="Ok";
		String reviewText="Very Good";
		homepage.clickToProduct(productName);
		productReview=homepage.clickToAddYourReview();
		productReview.sendToReviewTitle(reviewTitle);
		productReview.sendToReviewText(reviewText);
		productReview.clickRating();
		productReview.clickToSubmitButton();
		myaccountpage=(MyAccountObject) productReview.openPageAtHeaderByName(driver, "ico-account");
		myProductReviewPage=(MyProductReviewPageObject)myaccountpage.openPageAtMyAccountByName(driver, "customer-reviews inactive");
		Assert.assertEquals(myProductReviewPage.getReviewTitle(), reviewTitle);
		Assert.assertEquals(myProductReviewPage.getReviewText(), reviewText);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
