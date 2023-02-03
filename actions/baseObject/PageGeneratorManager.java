package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import io.qameta.allure.Step;
import pageUIs.AbstractPageUI;


public class PageGeneratorManager {

	public static CustomerInfoPageObject getToCustomerInfoLink(WebDriver driver) {
		// TODO Auto-generated method stub
		return new CustomerInfoPageObject(driver);
	}

	public static AddressPageObject getToAddressLink(WebDriver driver) {
		// TODO Auto-generated method stub
		return new AddressPageObject(driver);
	}

	public static OrderPageObject getToOrderLink(WebDriver driver) {
		// TODO Auto-generated method stub
		return new OrderPageObject(driver);
	}

	public static DownloadableProductPageObject getToDownloadableLink(WebDriver driver) {
		// TODO Auto-generated method stub
		return new DownloadableProductPageObject(driver);
	}

	public static SubscriptionPageObject getToSubscriptionLink(WebDriver driver) {
		// TODO Auto-generated method stub
		return new SubscriptionPageObject(driver);
	}

	public static RewardPointPageObject getToRewardLink(WebDriver driver) {
		// TODO Auto-generated method stub
		return new RewardPointPageObject(driver);
	}

	public static ChangePasswordPageObject getToChangePasswordLink(WebDriver driver) {
		// TODO Auto-generated method stub
		return new ChangePasswordPageObject(driver);
	}

	public static MyProductReviewPageObject getToMyProductReviewLink(WebDriver driver) {
		// TODO Auto-generated method stub
		return new MyProductReviewPageObject(driver);
	}
	@Step ("Open Homepage")
	public static HomePageObject openHomePage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new HomePageObject(driver);
	}

	public static HomePageObject getToLogoutLink(WebDriver driver) {
		// TODO Auto-generated method stub
		return new HomePageObject(driver);
	}

	public static SearchPageObject getToSearchLink(WebDriver driver) {
		// TODO Auto-generated method stub
		return new SearchPageObject(driver);
	}
	public static HomePageObject getToHomePageLink(WebDriver driver) {
		return new HomePageObject(driver);
		
	}

	public static AbstractPage openRegisterPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new RegisterPageObject(driver);
	}

	public static AbstractPage openLoginPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new LoginPageObject(driver);
	}

	public static AbstractPage openWishlistPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new WishlistPageObject(driver);
	}

	public static AbstractPage openShoppingCartPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new ShoppingCartObject(driver);
	}

	public static AbstractPage openMyAccountPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new MyAccountObject(driver);
	}

	public static DataGritPageObject openDataGridPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new DataGritPageObject(driver);
	}
	public static uploadFilePageObject uploadFilePage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new uploadFilePageObject(driver);
	}

	public static FacebookPageObject openFacebookPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new FacebookPageObject(driver);
	}
}
