package pageUIs;

public class OrderPageUI {
	public static final String ORDER_INFO="xpath=//div[@class='%s']/strong";
	public static final String METHOD_TEXT="xpath=//li[@class='%s']/span[@class='value']";
	public static final String PRODUCT_INFO="xpath=//td[@class='%s']//a";
	public static final String PRODUCT_ATTRIBUTE="xpath=//div[@class='attributes']";
	public static final String PRODUCT_PRICE="xpath=//span[@class='%s']";
	public static final String GIFTWRAPPING="xpath=//div[@class='selected-checkout-attributes']";
	public static final String TOTAL_PRICE="//label[text()='%s']/parent::td/following-sibling::td/span]";
	public static final String BUTTON="xpath=//button[text()='%s']";
	public static final String DETAIL_LINK="xpath=//button[text()='Details']";
	public static final String ORDER_NUMBER="xpath=//div[@class='section order-item']//strong";
	public static final String BILLINGADDRESS_INFO="xpath=//div[@class='billing-info']//li[@class='%s']";
	public static final String SHIPPINGADDRESS_INFO="xpath=//div[@class='shipping-info']//li[@class='%s']";
	public static final String TOTAL_INFO="xpath=//label[text()='%s']/parent::td/following-sibling::td";
}
