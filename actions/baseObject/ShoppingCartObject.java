package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.ShoppingCartUI;

public class ShoppingCartObject extends AbstractPage{
	private WebDriver driver;
	public ShoppingCartObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public void clickToRemoveButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, ShoppingCartUI.REMOVE);
		clickToElement(driver, ShoppingCartUI.REMOVE);
	}
	public String getNoDataMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, ShoppingCartUI.NODATA_MESSAGE);
		return getTextElement(driver, ShoppingCartUI.NODATA_MESSAGE);
	}
	public String getProductAttribute() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, ShoppingCartUI.PRODUCT_ATTRIBUTE);
		return getTextElement(driver, ShoppingCartUI.PRODUCT_ATTRIBUTE);
	}
	public String getProductPrice(String productPrice) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, ShoppingCartUI.PRODUCT_PRICE, productPrice);
		return getTextElement(driver, ShoppingCartUI.PRODUCT_PRICE, productPrice);
	}
	public String getQuantity() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, ShoppingCartUI.PRODUCT_QUANTITY);
		return getCssValue(driver, ShoppingCartUI.PRODUCT_QUANTITY, "value");
	}
	public String getProductTotalPrice(String price) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, ShoppingCartUI.TOTAL_PRICE, price);
		return getTextElement(driver, ShoppingCartUI.TOTAL_PRICE, price);
	}
	public void clickToShoppingCartButton(String buttonName) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, ShoppingCartUI.SHOPPINGCART_BUTTON, buttonName);
		clickToElement(driver, ShoppingCartUI.SHOPPINGCART_BUTTON, buttonName);
	}
	public void inputQuantity(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, ShoppingCartUI.PRODUCT_QUANTITY);
		sendKeyToElement(driver, ShoppingCartUI.PRODUCT_QUANTITY, string);
	}
	public void selectGiftWrapping(String giftWrapping) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, ShoppingCartUI.SELECTGIFTWRAPPING, giftWrapping);
		selectItemDropdownByText(driver, ShoppingCartUI.SELECTGIFTWRAPPING, giftWrapping);
	}
	public void selectAddress(String address, String text) {
		// TODO Auto-generated method stub
		waitForAllElementVisible(driver, ShoppingCartUI.ADDRESS_SELECT, address);
		selectItemDropdownByText(driver, ShoppingCartUI.ADDRESS_SELECT, address, text);
	}
	public void inputZipPostalCode(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, ShoppingCartUI.ZIP_POSTALCODE_TEXTBOX);
		sendKeyToElement(driver, ShoppingCartUI.ZIP_POSTALCODE_TEXTBOX, string);
	}
	public void chooseShippingMethod(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, ShoppingCartUI.SHIPPING_METHOD, string);
		clickToElement(driver, ShoppingCartUI.SHIPPING_METHOD, string);
	}
	public String getShippingPrice(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, ShoppingCartUI.SHIPPING_METHOD_PRICE, string);
		return getTextElement(driver, ShoppingCartUI.SHIPPING_METHOD_PRICE, string);
	}
	public String getSubTotalPrice(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, ShoppingCartUI.TOTAL_PRICE, string);
		return getTextElement(driver, ShoppingCartUI.TOTAL_PRICE, string);
	}
	public String getShippingMethod() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, ShoppingCartUI.SHIPPING_METHOD_TEXT);
		return getTextElement(driver, ShoppingCartUI.SHIPPING_METHOD_TEXT);
	}
	public void aggreeToTermOfService() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, ShoppingCartUI.TERM_OF_SERVICE);
		clickToElement(driver, ShoppingCartUI.TERM_OF_SERVICE);
	}
	public HomePageObject clickToEditButton() {
		waitForElementClickable(driver, ShoppingCartUI.EDIT_LINK);
		clickToElement(driver, ShoppingCartUI.EDIT_LINK);
		return new HomePageObject(driver);		
	}
	public CheckoutPageObject clickToCheckoutButton() {
		waitForElementClickable(driver, ShoppingCartUI.CHECKOUT_BUTTON);
		clickToElement(driver, ShoppingCartUI.CHECKOUT_BUTTON);
		return new CheckoutPageObject(driver);		
	}
}

