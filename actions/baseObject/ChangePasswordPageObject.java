package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.ChangePasswordUI;

public class ChangePasswordPageObject extends AbstractPage {
	private WebDriver driver;
	public ChangePasswordPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public void sendKeyToOldPassword(String password) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(ChangePasswordUI.DYNAMIC_TEXTBOX, "OldPassword"));
		sendKeyToElement(driver, castRestParameter(ChangePasswordUI.DYNAMIC_TEXTBOX, "OldPassword"), password);
	}

	public void sendKeyToNewPassword(String newPassword) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(ChangePasswordUI.DYNAMIC_TEXTBOX, "NewPassword"));
		sendKeyToElement(driver, castRestParameter(ChangePasswordUI.DYNAMIC_TEXTBOX, "NewPassword"), newPassword);
	}
	public void sendKeyToConfirmPassword(String newPassword) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(ChangePasswordUI.DYNAMIC_TEXTBOX, "ConfirmNewPassword"));
		sendKeyToElement(driver, castRestParameter(ChangePasswordUI.DYNAMIC_TEXTBOX, "ConfirmNewPassword"), newPassword);
	}
	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, ChangePasswordUI.SAVE_CHANGEPASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordUI.SAVE_CHANGEPASSWORD_BUTTON);
	}
	public void closePopup() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, ChangePasswordUI.ICON_CLOSE);
		clickToElement(driver, ChangePasswordUI.ICON_CLOSE);
	}
	
}
