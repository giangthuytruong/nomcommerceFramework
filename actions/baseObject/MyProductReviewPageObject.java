package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.MyProductReviewUI;

public class MyProductReviewPageObject extends AbstractPage{
private WebDriver driver;
	public MyProductReviewPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public String getReviewTitle() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(MyProductReviewUI.DYNAMIC_TEXT, "review-title"));
		return getElementText(driver, castRestParameter(MyProductReviewUI.DYNAMIC_TEXT, "review-title"));
	}

	public String getReviewText() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(MyProductReviewUI.DYNAMIC_TEXT, "review-text"));
		return getElementText(driver, castRestParameter(MyProductReviewUI.DYNAMIC_TEXT, "review-text"));
	}
}
