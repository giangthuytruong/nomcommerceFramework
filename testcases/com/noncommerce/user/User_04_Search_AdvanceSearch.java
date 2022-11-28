package com.noncommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseObject.HomePageObject;
import baseObject.PageGeneratorManager;
import baseObject.RegisterPageObject;
import baseObject.SearchPageObject;
import basePage.BaseTest;

public class User_04_Search_AdvanceSearch extends BaseTest {
	private WebDriver driver;
	private HomePageObject homepage;
	private RegisterPageObject registerpage;
	private SearchPageObject searchpage;
	private String firstName, lastName, password;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver= getBrowserDriver(browserName);
		firstName= "Steve";
		lastName="Job";
		password="123123";
		homepage= PageGeneratorManager.openHomePage(driver);
		registerpage=(RegisterPageObject) homepage.openPageAtHeaderByName(driver, "ico-register");
		registerpage.sendKeyToFirstname(firstName);
		registerpage.sendKeyToLastname(lastName);
		registerpage.sendKeyToEmail(registerpage.email);
		registerpage.sendKeyToPassword(password);
		registerpage.sendKeyToConfirmationPassword(password);
		registerpage.clickToRegisterButton();
		Assert.assertEquals(registerpage.getRegistrationResultMessage(), "Your registration completed");
		searchpage=registerpage.clickToSearchLink(driver);
	}
	@Test
	public void Search_01_Empty_Data() {
		searchpage.clickToSearchButton();
		Assert.assertEquals(searchpage.getValidateMessage(), "Search term minimum length is 3 characters");
	}
	@Test
	public void Search_02_Data_Not_Exist() {
		searchpage.sendKeyToSearchKeywork("test new");
		searchpage.clickToSearchButton();
		Assert.assertEquals(searchpage.getDataNotExistMessage(), "No products were found that matched your criteria.");
	}
	@Test
	public void Search_03_Search_Product_Name() {
		searchpage.sendKeyToSearchKeywork("lenovo");
		searchpage.clickToSearchButton();
		Assert.assertEquals(searchpage.getResultSize(), 2);
		Assert.assertTrue(searchpage.getResultContainKeyWord("Lenovo"));
	}
	@Test
	public void Search_04_Search_Product_Name_Exactly() {
		searchpage.sendKeyToSearchKeywork("ThinkPad X1 Carbon");
		searchpage.clickToSearchButton();
		Assert.assertEquals(searchpage.getResultSize(), 1);
		Assert.assertTrue(searchpage.getResultContainKeyWord("Thinkpad X1 Carbon"));
	}
	@Test
	public void Search_05_Advanced_Parent_Categories() {
		searchpage.sendKeyToSearchKeywork("Apple Macbook Pro");
		searchpage.tickCheckboxAdvancedSearch();
		searchpage.selectCategory("Computers");
		searchpage.clickToSearchButton();
		Assert.assertEquals(searchpage.getDataNotExistMessage(), "No products were found that matched your criteria.");
	}
	@Test
	public void Search_06_Advanced_Sub_Categories() {
		searchpage.sendKeyToSearchKeywork("Apple Macbook Pro");
		searchpage.tickCheckboxAdvancedSearch();
		searchpage.selectCategory("Computers");
		searchpage.tickCheckboxAutomicallySubCategories();
		searchpage.clickToSearchButton();
		Assert.assertEquals(searchpage.getResultSize(), 1);
		Assert.assertTrue(searchpage.getResultContainKeyWord("Apple MacBook Pro"));
	}
	@Test
	public void Search_07_Advanced_Incorrect_Manufacturer() {
		searchpage.sendKeyToSearchKeywork("Apple Macbook Pro");
		searchpage.tickCheckboxAdvancedSearch();
		searchpage.selectCategory("Computers");
		searchpage.tickCheckboxAutomicallySubCategories();
		searchpage.selectManufacturer("HP");
		searchpage.clickToSearchButton();
		Assert.assertEquals(searchpage.getDataNotExistMessage(), "No products were found that matched your criteria.");
	}
	@Test
	public void Search_08_Advanced_Correct_Manufacturer() {
		searchpage.sendKeyToSearchKeywork("Apple Macbook Pro");
		searchpage.tickCheckboxAdvancedSearch();
		searchpage.selectCategory("Computers");
		searchpage.tickCheckboxAutomicallySubCategories();
		searchpage.selectManufacturer("Apple");
		searchpage.clickToSearchButton();
		Assert.assertEquals(searchpage.getResultSize(), 1);
		Assert.assertTrue(searchpage.getResultContainKeyWord("Apple MacBook Pro"));
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
