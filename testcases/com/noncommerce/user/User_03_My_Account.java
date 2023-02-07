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
import commons.Common_01_RegisterToSystem;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
@Epic("Regression Tests")
@Feature("My Account Tests")
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
		homepage=PageGeneratorManager.openHomePage(driver);
		
		log.info("Login - Step 01: Navigate to Login page");
		loginpage=(LoginPageObject) homepage.openPageAtHeaderByName(driver, "ico-login");
		
		log.info("Login - Step 02: Set cookie and reload page");
		loginpage.setCookies(driver, Common_01_RegisterToSystem.loggedCookie);
		loginpage.refreshPage(driver);
		
		log.info("Login - Step 03: Open My Account page");
		myaccountpage=(MyAccountObject) registerpage.openPageAtHeaderByName(driver, "ico-account");
	}
	@Description("Update account with valid data")
	@Severity(SeverityLevel.CRITICAL)
	@Test
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
		verifyEquals(customerpage.getFirstNameAttribute("value"), firstNameUpdate);
		verifyEquals(customerpage.getLastNameAttribute("value"), lastNameUpdate);
		verifyEquals(customerpage.getDateAttribute("value"), dateOfBirth);
		verifyEquals(customerpage.getMonthAttribute("value"), monthOfBirth);
		verifyEquals(customerpage.getYearAttribute("value"), yearOfBirth);
		verifyEquals(customerpage.getCompanyNameAttribute("value"), companyName);
	}
	@Description("Add address success")
	@Severity(SeverityLevel.CRITICAL)
	@Test
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
		verifyEquals(addresspage.getNameText(), firstNameUpdate+" "+lastNameUpdate);
		verifyTrue(addresspage.getEmailUpdate().contains(emailUpdate));
		verifyTrue(addresspage.getPhoneNumber().contains(phoneNumber));
		verifyTrue(addresspage.getFaxNumber().contains(faxNumber));
		verifyEquals(addresspage.getcompanyName(), companyName);
		verifyEquals(addresspage.getAddress1Update(), address1);
		verifyEquals(addresspage.getAddress2Update(), address2);
		verifyEquals(addresspage.getCityPostalCodeText(), city+", "+postalCode);
		verifyEquals(addresspage.getCountry(), country);
	}
	@Description("Change password success")
	@Severity(SeverityLevel.CRITICAL)
	@Test
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
		verifyTrue(loginpage.getValidationMessage().contains("The credentials provided are incorrect"));
		loginpage.sendKeyToEmail(emailUpdate);
		loginpage.sendKeyToPassword(newPassword);
		loginpage.clickToLoginButton();
		verifyTrue(homepage.MyAccountLinkDisplayed());
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
		verifyEquals(myProductReviewPage.getReviewTitle(), reviewTitle);
		verifyEquals(myProductReviewPage.getReviewText(), reviewText);
	}
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
