package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import pageUIs.CompareProductUI;

public class CompareProductObject extends AbstractPage{
	private WebDriver driver;

	public CompareProductObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public String getProductName(String productName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, CompareProductUI.PRODUCT_NAME, productName);
		return getTextElement(driver, CompareProductUI.PRODUCT_NAME, productName);
	}

	public void clickToClearListButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, CompareProductUI.CLEARLIST_BUTTON);
		clickToElement(driver, CompareProductUI.CLEARLIST_BUTTON);
	}

	public String getNoDataMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, CompareProductUI.NODATA_MESSAGE);
		return getTextElement(driver, CompareProductUI.NODATA_MESSAGE);
	}

	public boolean productIsNotDisplayed(String productName) {
		// TODO Auto-generated method stub
		waitForElementInvisible(driver, CompareProductUI.PRODUCT_NAME, productName);
		return isControlDisplayed(driver, CompareProductUI.PRODUCT_NAME, productName);
	}

}
