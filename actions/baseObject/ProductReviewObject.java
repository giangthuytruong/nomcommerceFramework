package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.ProductReviewUI;

public class ProductReviewObject extends AbstractPage{
	private WebDriver driver;
	public ProductReviewObject(WebDriver mappingDriver) {
		driver=mappingDriver;
	}
	public void sendToReviewTitle(String reviewTitle) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(ProductReviewUI.DYNAMIC_ELEMENT, "input","AddProductReview_Title"));
		sendKeyToElement(driver, castRestParameter(ProductReviewUI.DYNAMIC_ELEMENT,"input", "AddProductReview_Title"), reviewTitle);
	}

	public void sendToReviewText(String reviewText) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(ProductReviewUI.DYNAMIC_ELEMENT,"textarea", "AddProductReview_ReviewText"));
		sendKeyToElement(driver, castRestParameter(ProductReviewUI.DYNAMIC_ELEMENT,"textarea", "AddProductReview_ReviewText"), reviewText);
	}

	public void clickRating() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(ProductReviewUI.DYNAMIC_ELEMENT,"input", "addproductrating_3"));
		checkCheckboxorRadio(driver, castRestParameter(ProductReviewUI.DYNAMIC_ELEMENT,"input", "addproductrating_3"));
	}

	public void clickToSubmitButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, ProductReviewUI.SUBMITREVIEW_BUTTON);
		clickToElement(driver, ProductReviewUI.SUBMITREVIEW_BUTTON);
	}
}
