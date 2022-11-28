package pageUIs;

public class HomepageUI {
	public static final String MENU_LINK="xpath=//a[@class='%s']";
	//public static final String REGISTER_LINK="xpath=//a[@class='ico-register']";
	//public static final String LOGIN_LINK="xpath=//a[@class='ico-login']";
	//public static final String MY_ACCOUNT_LINK="xpath=//a[@class='ico-account']";
	public static final String PRODUCT_LINK="xpath=//h2[@class='product-title']/a[text()='%s']";
	public static final String ADDREVIEW_LINK="xpath=//a[text()='Add your review']";
	public static final String PRODUCTFUNCTION_BUTTON="xpath=//button[text()='%s']";
	public static final String SELECTPROCESSOR="xpath=//select[@id='product_attribute_1']";
	public static final String SELECTRAM="xpath=//select[@id='product_attribute_2']";
	public static final String PRODUCTATTRIBUTE_CHECKBOX="xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String CHECKBOX="xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String SUCCESS_NOTIFICATION="xpath=//p[@class='content']";
	public static final String NOTIFICATION_LINK="xpath=//p[@class='content']/a";
	public static final String PRODUCT_BUTTON="xpath=//a[text()='%s']/ancestor::div[@class='product-item']//button[@title='%s']";
	public static final String CLOSE_NOTIFICATION="xpath=//span[@class='close']";
	public static final String MENU_PRODUCT="xpath=//ul[@class='top-menu notmobile']//a[text()='%s']";
	public static final String SUBLIST_PRODUCT="xpath=//ul[@class='sublist first-level']//a[text()='%s']";
	public static final String RECENTLY_VIEW_PRODUCT="xpath=//div[@class='block block-recently-viewed-products']//li[%s]/a[@class='product-name']";
	public static final String PRODUCT_PRICE="xpath=//span[@id='price-value-1']";
	public static final String PRODUCT_QUANTITY="xpath=//input[@class='qty-input']";
}
