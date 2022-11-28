package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.HomepageUI;

public class HomePageObject extends AbstractPage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver mappingDriver) {
		// TODO Auto-generated constructor stub
		driver=mappingDriver;
	}
	public boolean MyAccountLinkDisplayed() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(HomepageUI.MENU_LINK, "ico-account"));
		isControlDisplayed(driver, castRestParameter(HomepageUI.MENU_LINK, "ico-account"));
		return isControlDisplayed(driver, castRestParameter(HomepageUI.MENU_LINK, "ico-account"));
	}


	public void clickToProduct(String productName) {
		// TODO Auto-generated method stub
		scrollToElement(driver, HomepageUI.PRODUCT_LINK, productName);
		clickByJs(driver, HomepageUI.PRODUCT_LINK, productName);
	}


	public ProductReviewObject clickToAddYourReview() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomepageUI.ADDREVIEW_LINK);
		clickToElement(driver, HomepageUI.ADDREVIEW_LINK);
		return new ProductReviewObject(driver);
	}
	public void selectRamByText(String RAM) {
		waitForElementClickable(driver, HomepageUI.SELECTRAM);
		selectItemDropdownByText(driver, HomepageUI.SELECTRAM, RAM);
	}
	public void chooseHDDCheckbox(String HDDvalue) {
		waitForElementClickable(driver, HomepageUI.PRODUCTATTRIBUTE_CHECKBOX, HDDvalue);
		clickToElement(driver, HomepageUI.PRODUCTATTRIBUTE_CHECKBOX, HDDvalue);
	}
	public void clickToButton(String function) {
		waitForElementClickable(driver, HomepageUI.PRODUCTFUNCTION_BUTTON, function);
		clickToElement(driver, HomepageUI.PRODUCTFUNCTION_BUTTON, function);
	}
	public String notificationSuccessText() {
		waitForElementVisible(driver, HomepageUI.SUCCESS_NOTIFICATION);
		return getTextElement(driver, HomepageUI.SUCCESS_NOTIFICATION);
	}
	public WishlistPageObject clickToNotificationLink() {
		waitForElementClickable(driver, HomepageUI.NOTIFICATION_LINK);
		clickToElement(driver, HomepageUI.NOTIFICATION_LINK);
		return new WishlistPageObject(driver);	
	}


	public void selectProcessor(String processor) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomepageUI.SELECTPROCESSOR);
		selectItemDropdownByText(driver, HomepageUI.SELECTPROCESSOR, processor);
	}


	public void chooseOSCheckbox(String OS) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomepageUI.PRODUCTATTRIBUTE_CHECKBOX, OS);
		clickToElement(driver, HomepageUI.PRODUCTATTRIBUTE_CHECKBOX, OS);
	}


	public void tickSoftware(String software) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomepageUI.PRODUCTATTRIBUTE_CHECKBOX, software);
		clickToElement(driver, HomepageUI.PRODUCTATTRIBUTE_CHECKBOX, software);
	}
	public void clickToCompareList(String product) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomepageUI.PRODUCT_BUTTON, product, "Add to compare list");
		clickToElement(driver, HomepageUI.PRODUCT_BUTTON, product, "Add to compare list");
	}
	
	public void clickToCategoryProduct(String menuCategory, String sublistCategory) {
		// TODO Auto-generated method stub
		hoverMouse(driver, HomepageUI.MENU_PRODUCT, menuCategory);
		waitForElementClickable(driver, HomepageUI.SUBLIST_PRODUCT, sublistCategory);
		clickToElement(driver, HomepageUI.SUBLIST_PRODUCT, sublistCategory);
	}
	public String getProductRecentlyViewName(String i) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomepageUI.RECENTLY_VIEW_PRODUCT, i);
		return getElementText(driver, HomepageUI.RECENTLY_VIEW_PRODUCT, i);
	}
	public void closeNotification() {
		waitForElementClickable(driver, HomepageUI.CLOSE_NOTIFICATION);
		clickToElement(driver, HomepageUI.CLOSE_NOTIFICATION);
	}
	public WishlistPageObject openWishlistPage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomepageUI.NOTIFICATION_LINK);
		clickToElement(driver, HomepageUI.NOTIFICATION_LINK);
		return new WishlistPageObject(driver);
	}
	public CompareProductObject openCompareProduct(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomepageUI.NOTIFICATION_LINK);
		clickToElement(driver, HomepageUI.NOTIFICATION_LINK);
		return new CompareProductObject(driver);
	}
	public String getProductPrice() {
		waitForElementVisible(driver, HomepageUI.PRODUCT_PRICE);
		return getTextElement(driver, HomepageUI.PRODUCT_PRICE);
		
	}
	public void inputQuantity(String quantity) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomepageUI.PRODUCT_QUANTITY);
		sendKeyToElement(driver, HomepageUI.PRODUCT_QUANTITY, quantity);
	}
}
