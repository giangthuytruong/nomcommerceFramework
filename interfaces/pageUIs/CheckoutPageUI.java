package pageUIs;

public class CheckoutPageUI {
	public static final String TEXTBOX_NAME="xpath=//input[@id='%s']";
	public static final String SELECT_NAME="xpath=//select[@id='%s']";
	public static final String CONTINUE_BUTTON="xpath=//div[@id='%s']/button[text()='Continue']";
	public static final String CHOOSE_METHOD="xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String PAYMENT_INFO="xpath=//div[@class='info']";
	public static final String INFO_TEXT="xpath=//div[@class='%s']//li[@class='%s']";
	public static final String METHOD_TEXT="xpath=//li[@class='%s']/span[@class='value']";
	public static final String PRODUCT_NAME="xpath=//a[@class='product-name']";
	public static final String PRODUCT_PRICE="xpath=//span[@class='%s']";
	public static final String TOTAL_PRICE="//tr[@class='%s']//span";
	public static final String SHIPPING_METHOD_TEXT="xpath=//span[@class='selected-shipping-method']";
	public static final String CONFIRM_BUTTON="xpath=//button[text()='Confirm']";
	public static final String SUCCESSFUL_MESSAGE="xpath=//div[@class='section order-completed']/div[@class='title']/strong";
	public static final String ORDER_NUMBER="xpath=//div[@class='order-number']/strong";
	public static final String DETAIL_LINK="xpath=//div[@class='details-link']/a";
	public static final String GIFTWRAPPING="xpath=//div[@class='selected-checkout-attributes']";
}
