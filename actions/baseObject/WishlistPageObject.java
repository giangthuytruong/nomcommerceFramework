package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import pageUIs.WishlistPageUI;

public class WishlistPageObject extends AbstractPage {
	private WebDriver driver;
	public WishlistPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public String getProductName() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, WishlistPageUI.PRODUCT_NAME);
		return getTextElement(driver, WishlistPageUI.PRODUCT_NAME);
	}
	public String getProperty() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, WishlistPageUI.PRODUCT_ATTRIBUTE);
		return getTextElement(driver, WishlistPageUI.PRODUCT_ATTRIBUTE);
	}
	public String getUsername() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, WishlistPageUI.WISHLIST_USERNAME);
		return getTextElement(driver, WishlistPageUI.WISHLIST_USERNAME);
	}
	public void wishlistURLForSharing() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, WishlistPageUI.WISHLIST_LINK_SHARE);
		clickToElement(driver, WishlistPageUI.WISHLIST_LINK_SHARE);
	}
	public void clickCheckboxAddToCart() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, WishlistPageUI.ADDTOCART_CHECKBOX);
		clickToElement(driver, WishlistPageUI.ADDTOCART_CHECKBOX);
	}
	public String emptyMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, WishlistPageUI.NODATA_MESSAGE);
		return getTextElement(driver, WishlistPageUI.NODATA_MESSAGE);
	}
	public void clickToRemoveButton() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, WishlistPageUI.REMOVE_BUTTON);
		clickToElement(driver, WishlistPageUI.REMOVE_BUTTON);
	}
	public ShoppingCartObject openShoppingCart(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, WishlistPageUI.ADDTOCART_BUTTON);
		clickToElement(driver, WishlistPageUI.ADDTOCART_BUTTON);
		return new ShoppingCartObject(driver);
	}

	
}
