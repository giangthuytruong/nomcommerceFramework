package pageUIs;

public class ShoppingCartUI {
	public static final String PRODUCT_NAME="xpath=//a[@class='product-name']";
	public static final String PRODUCT_QUANTITY="xpath=//input[@class='qty-input']";
	public static final String REMOVE="xpath=//td[@class='remove-from-cart']";
	public static final String SHOPPINGCART_BUTTON="xpath=//button[text()='%s']";
	public static final String SELECTGIFTWRAPPING="xpath=//select[@id='checkout_attribute_1']";
	public static final String NODATA_MESSAGE="xpath=//div[@class='no-data']";
	public static final String PRODUCT_ATTRIBUTE="xpath=//a[@class='product-name']/following-sibling::div[@class='attributes']";
	public static final String PRODUCT_PRICE="xpath=//span[@class='%s']";
	public static final String TOTAL_PRICE="xpath=//tr[@class='%s']//span[@class='value-summary']";
	public static final String ADDRESS_SELECT="xpath=//select[@id='%s']";
	public static final String ZIP_POSTALCODE_TEXTBOX="xpath=//input[@id='ZipPostalCode']";
	public static final String SHIPPING_METHOD="xpath=//div[text()='%s']/preceding-sibling::div/input";
	public static final String SHIPPING_METHOD_PRICE="xpath=//div[text()='%s']/following-sibling::div[2]";
	public static final String SHIPPING_METHOD_TEXT="xpath=//span[@class='selected-shipping-method']";
	public static final String TERM_OF_SERVICE="xpath=//input[@id='termsofservice']";
	public static final String EDIT_LINK="xpath=//div[@class='edit-item']/a";
	public static final String CHECKOUT_BUTTON="xpath=//button[@id='checkout']";
	
}
