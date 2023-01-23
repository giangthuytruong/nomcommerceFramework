package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import pageUIs.FacebookPageUI;

public class FacebookPageObject extends AbstractPage{
	private WebDriver driver;
	public FacebookPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public void clickToCreateNewAccountButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, FacebookPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, FacebookPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}
	public void inputDataByTextboxName(String value, String textboxName) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, FacebookPageUI.ELEMENT_TEXTBOX, textboxName);
		sendKeyToElement(driver, FacebookPageUI.ELEMENT_TEXTBOX, value, textboxName);
	}
	public boolean reEnterEmailAddressDisplayed() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, FacebookPageUI.ELEMENT_TEXTBOX, "Re-enter email address");
		return isControlDisplayed(driver, FacebookPageUI.ELEMENT_TEXTBOX, "Re-enter email address");
	}
	public boolean reEnterEmailAddressUndisplayed() {
		// TODO Auto-generated method stub
		waitToElementInvisible(driver, FacebookPageUI.ELEMENT_TEXTBOX, "Re-enter email address");
		return isElementUndisplayed(driver, FacebookPageUI.ELEMENT_TEXTBOX, "Re-enter email address");
	}
	
}
