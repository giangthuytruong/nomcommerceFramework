package baseObject;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import pageUIs.CheckoutPageUI;

public class CheckoutPageObject extends AbstractPage {
	private WebDriver driver;
	public CheckoutPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public String getTextboxValue(String name) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, CheckoutPageUI.TEXTBOX_NAME, name);
		return getAttributeValue(driver, CheckoutPageUI.TEXTBOX_NAME, name, "value");
	}

	public void selectDropDown(String name, String text) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, CheckoutPageUI.SELECT_NAME, name);
		selectItemDropdownByText(driver, CheckoutPageUI.SELECT_NAME, name, text);
	}

	public void clickToContinueButton(String string) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON, string);
		clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON, string);
	}

	public void chooseMethod(String string) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, CheckoutPageUI.CHOOSE_METHOD, string);
		clickToElement(driver, CheckoutPageUI.CHOOSE_METHOD, string);
	}
	public String getPaymentInfor() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, CheckoutPageUI.PAYMENT_INFO);
		return getTextElement(driver, CheckoutPageUI.PAYMENT_INFO);
	}

	public String getInfoText(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, CheckoutPageUI.INFO_TEXT, string);
		return getTextElement(driver, CheckoutPageUI.INFO_TEXT, string);
	}

	public String getMethodText(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, CheckoutPageUI.METHOD_TEXT, string);
		return getTextElement(driver, CheckoutPageUI.METHOD_TEXT, string);
	}

	public String getProductName() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, CheckoutPageUI.PRODUCT_NAME);
		return getTextElement(driver, CheckoutPageUI.PRODUCT_NAME);
	}

	public String getTotalPrice(String name) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, CheckoutPageUI.TOTAL_PRICE, name);
		return getTextElement(driver, CheckoutPageUI.TOTAL_PRICE, name);
	}

	public String getGiftWrapping() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, CheckoutPageUI.GIFTWRAPPING);
		return getTextElement(driver, CheckoutPageUI.GIFTWRAPPING);
	}

	public String getSuccessfulMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, CheckoutPageUI.SUCCESSFUL_MESSAGE);
		return getTextElement(driver, CheckoutPageUI.SUCCESSFUL_MESSAGE);
	}

	public String getOrderNumber() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, CheckoutPageUI.ORDER_NUMBER);
		return getTextElement(driver, CheckoutPageUI.ORDER_NUMBER);
	}

	public HomePageObject clickToContinueCompleteOrder() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, CheckoutPageUI.CONFIRM_BUTTON);
		clickToElement(driver, CheckoutPageUI.CONFIRM_BUTTON);
		return new HomePageObject(driver);
	}

	public String getShippingName() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, CheckoutPageUI.SHIPPING_METHOD_TEXT);
		return getTextElement(driver, CheckoutPageUI.SHIPPING_METHOD_TEXT);
	}


	public void selectBillingAddress(String string, String name) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, CheckoutPageUI.SELECT_NAME, string, name);
		selectItemDropdownByText(driver, CheckoutPageUI.SELECT_NAME, string, name);
	}

	public void inputTextbox(String name) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, CheckoutPageUI.TEXTBOX_NAME);
		sendKeyToElement(driver, CheckoutPageUI.TEXTBOX_NAME, name);
	}

}
