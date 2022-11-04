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

	
	public RegisterPageObject clickToRegisterLink() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, castRestParameter(HomepageUI.MENU_LINK, "ico-register"));
		clickToElement(driver, castRestParameter(HomepageUI.MENU_LINK, "ico-register"));
		return new RegisterPageObject(driver);
	}


	public LoginPageObject clickToLoginLink() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, castRestParameter(HomepageUI.MENU_LINK, "ico-login"));
		clickToElement(driver, castRestParameter(HomepageUI.MENU_LINK, "ico-login"));
		return new LoginPageObject(driver);
	}
	public boolean MyAccountLinkDisplayed() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(HomepageUI.MENU_LINK, "ico-account"));
		isControlDisplayed(driver, castRestParameter(HomepageUI.MENU_LINK, "ico-account"));
		return isControlDisplayed(driver, castRestParameter(HomepageUI.MENU_LINK, "ico-account"));
	}


	public void clickToProduct() {
		// TODO Auto-generated method stub
		scrollToElement(driver, HomepageUI.PRODUCT_LINK);
		clickByJs(driver, HomepageUI.PRODUCT_LINK);
	}


	public ProductReviewObject clickToAddYourReview() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomepageUI.ADDREVIEW_LINK);
		clickToElement(driver, HomepageUI.ADDREVIEW_LINK);
		return new ProductReviewObject(driver);
	}


	public MyAccountObject clickToMyAccountLink() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, castRestParameter(HomepageUI.MENU_LINK, "ico-account"));
		clickToElement(driver, castRestParameter(HomepageUI.MENU_LINK, "ico-account"));
		return new MyAccountObject(driver);
	}

}
