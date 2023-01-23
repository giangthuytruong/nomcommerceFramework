package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import pageUIs.OrderPageUI;

public class OrderPageObject extends AbstractPage {
	private WebDriver driver;
	public OrderPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public String getOrderInfo(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, OrderPageUI.ORDER_INFO, string);
		return getTextElement(driver, OrderPageUI.ORDER_INFO, string);
	}
	public void clickToDetail(String string) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, OrderPageUI.DETAIL_LINK);
		clickToElement(driver, OrderPageUI.DETAIL_LINK, string);
	}
	public String getOrderNumberInfor() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, OrderPageUI.ORDER_NUMBER);
		return getTextElement(driver, OrderPageUI.ORDER_NUMBER);
	}
	public String getOrderTotalPrice() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, OrderPageUI.TOTAL_PRICE);
		return getTextElement(driver, OrderPageUI.TOTAL_PRICE);
	}
	public String getBillingInfo(String billingName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, OrderPageUI.BILLINGADDRESS_INFO, billingName);
		return getTextElement(driver, OrderPageUI.BILLINGADDRESS_INFO, billingName);
	}
	public String getShippingInfo(String shippingName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, OrderPageUI.SHIPPINGADDRESS_INFO, shippingName);
		return getTextElement(driver, OrderPageUI.SHIPPINGADDRESS_INFO, shippingName);
	}
	
	public String getShippingMethod(String methodName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, OrderPageUI.METHOD_TEXT, methodName);
		return getTextElement(driver, OrderPageUI.METHOD_TEXT, methodName);
	}
	public String getProductInfo(String infoName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, OrderPageUI.PRODUCT_INFO, infoName);
		return getTextElement(driver, OrderPageUI.PRODUCT_INFO, infoName);
	}
	public String getGiftWrapping() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, OrderPageUI.GIFTWRAPPING);
		return getTextElement(driver,  OrderPageUI.GIFTWRAPPING);
	}
	public String getSubTotalPrice(String totalName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, OrderPageUI.TOTAL_INFO, totalName);
		return getTextElement(driver, OrderPageUI.TOTAL_INFO, totalName);
	}
	public ShoppingCartObject clickToReorder(String reOrder) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, OrderPageUI.BUTTON, reOrder);
		clickToElement(driver, OrderPageUI.BUTTON, reOrder);
		return new ShoppingCartObject(driver);
	}

}
