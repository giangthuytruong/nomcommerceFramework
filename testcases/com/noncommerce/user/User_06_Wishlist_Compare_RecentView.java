package com.noncommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseObject.CompareProductObject;
import baseObject.HomePageObject;
import baseObject.PageGeneratorManager;
import baseObject.RegisterPageObject;
import baseObject.SearchPageObject;
import baseObject.ShoppingCartObject;
import baseObject.WishlistPageObject;
import basePage.BaseTest;

public class User_06_Wishlist_Compare_RecentView extends BaseTest{
	private WebDriver driver;
	private HomePageObject homepage;
	private RegisterPageObject registerpage;
	private WishlistPageObject wishlistpage;
	private ShoppingCartObject shoppingcartpage;
	private CompareProductObject compareproductpage;
	private String firstName, lastName, name, password, productName, processor, RAM, HDD, OS, software, product1, product2, product3, product4, product5;
	SoftAssert softAssert;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver= getBrowserDriver(browserName);
		firstName= "Steve";
		lastName="Job";
		name=firstName+" "+lastName;
		password="123123";
		productName="Build your own computer";
		processor="2.2 GHz Intel Pentium Dual-Core E2200";
		RAM="2 GB";
		HDD="320 GB";
		OS="Vista Home [+$50.00]";
		software="Microsoft Office [+$50.00]";
		product1="Build your own computer";
		product2="Apple MacBook Pro 13-inch";
		product3="HP Envy 6-1180ca 15.6-Inch Sleekbook";
		product4="HP Spectre XT Pro UltraBook";
		product5="Lenovo Thinkpad X1 Carbon Laptop";
		homepage= PageGeneratorManager.openHomePage(driver);
		registerpage=(RegisterPageObject) homepage.openPageAtHeaderByName(driver, "ico-register");
		registerpage.sendKeyToFirstname(firstName);
		registerpage.sendKeyToLastname(lastName);
		registerpage.sendKeyToEmail(registerpage.email);
		registerpage.sendKeyToPassword(password);
		registerpage.sendKeyToConfirmationPassword(password);
		registerpage.clickToRegisterButton();
		verifyEquals(registerpage.getRegistrationResultMessage(), "Your registration completed test");
		homepage=registerpage.openHomepage(driver);
		homepage.clickToProduct(productName);
	}
	@Test
	public void TC_01_AddToWishlist() {
		homepage.selectProcessor(processor);
		homepage.selectRamByText(RAM);
		homepage.chooseHDDCheckbox(HDD);
		homepage.chooseOSCheckbox(OS);
		homepage.tickSoftware(software);
		homepage.clickToButton("Add to wishlist");
		verifyEquals(homepage.notificationSuccessText(), "The product has been added to your wishlist");
		wishlistpage=homepage.openWishlistPage(driver);
		Assert.assertEquals(wishlistpage.getProductName(), productName);
		Assert.assertTrue(wishlistpage.getProperty().contains(processor));
		Assert.assertTrue(wishlistpage.getProperty().contains(RAM));
		Assert.assertTrue(wishlistpage.getProperty().contains(HDD));
		Assert.assertTrue(wishlistpage.getProperty().contains(OS));
		wishlistpage.wishlistURLForSharing();
		verifyTrue(wishlistpage.getUsername().contains(name));
	}
	@Test
	public void TC_02_AddProductToCart() {
		wishlistpage.clickCheckboxAddToCart();
		shoppingcartpage= wishlistpage.openShoppingCart(driver);
		verifyEquals(shoppingcartpage.getQuantity(driver), "There are 1 item(s) in your cart.");
		wishlistpage=(WishlistPageObject) shoppingcartpage.openPageAtHeaderByName(driver, "ico-wishlist");
	}
	@Test
	public void TC_03_RemoveProductInWishlist() {
		homepage=wishlistpage.openHomepage(driver);
		homepage.clickToProduct(productName);
		homepage.selectProcessor(processor);
		homepage.selectRamByText(RAM);
		homepage.chooseHDDCheckbox(HDD);
		homepage.chooseOSCheckbox(OS);
		homepage.tickSoftware(software);
		homepage.clickToButton("Add to wishlist");
		verifyEquals(homepage.notificationSuccessText(), "The product has been added to your wishlist");
		wishlistpage=homepage.openWishlistPage(driver);
		wishlistpage.clickToRemoveButton();
		verifyEquals(wishlistpage.emptyMessage(),"The wishlist is empty!");
	}
	@Test
	public void TC_04_AddProductToCompare() {
		homepage=wishlistpage.openHomepage(driver);
		homepage.clickToCompareList(product1);
		verifyEquals(homepage.notificationSuccessText(), "The product has been added to your product comparison");
		homepage.closeNotification();
		sleepInSecond(2);
		homepage.clickToCompareList(product2);
		verifyEquals(homepage.notificationSuccessText(), "The product has been added to your product comparison");
		compareproductpage=homepage.openCompareProduct(driver);
		verifyEquals(compareproductpage.getProductName(product1), product1);
		verifyEquals(compareproductpage.getProductName(product2), product2);
		compareproductpage.clickToClearListButton();
		verifyEquals(compareproductpage.getNoDataMessage(), "You have no items to compare.");
	}
	@Test
	public void TC_05_RecentlyViewedProducts() {
		homepage=compareproductpage.openHomepage(driver);
		homepage.clickToProduct(product1);
		homepage.clickToCategoryProduct("Computers ","Notebooks ");
		homepage.clickToProduct(product2);
		homepage.clickToCategoryProduct("Computers ","Notebooks ");
		homepage.clickToProduct(product3);
		homepage.clickToCategoryProduct("Computers ","Notebooks ");
		homepage.clickToProduct(product4);
		homepage.clickToCategoryProduct("Computers ","Notebooks ");
		homepage.clickToProduct(product5);
		homepage.clickToCategoryProduct("Computers ","Notebooks ");
		verifyEquals(homepage.getProductRecentlyViewName("1"), product5);
		verifyEquals(homepage.getProductRecentlyViewName("2"), product4);
		verifyEquals(homepage.getProductRecentlyViewName("3"), product3);
	}
	protected void sleepInSecond(long second) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(second*1000);
		}catch (InterruptedException e) {
		}
	}
}
