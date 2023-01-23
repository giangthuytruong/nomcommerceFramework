package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	private WebDriver driver;
	public String email="steve"+getRandomNumber()+"@gmail.com";
	public LoginPageObject(WebDriver mappingDriver) {
		driver=mappingDriver;
	}

	public void clickToLoginButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String getEmailValidation() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR);
		return getTextElement(driver, LoginPageUI.EMAIL_ERROR);
	}

	public void sendKeyToEmail(String emailAddress) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(LoginPageUI.DYNAMIC_TEXTBOX, "Email"));
		sendKeyToElement(driver, castRestParameter(LoginPageUI.DYNAMIC_TEXTBOX, "Email"), emailAddress);
	}

	public String getValidationMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.INVALIDATTION_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.INVALIDATTION_ERROR_MESSAGE);
	}
	
	public void sendKeyToPassword(String password) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(LoginPageUI.DYNAMIC_TEXTBOX, "Password"));
		sendKeyToElement(driver, castRestParameter(LoginPageUI.DYNAMIC_TEXTBOX, "Password"), password);
	}
}
