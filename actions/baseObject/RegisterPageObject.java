package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	private WebDriver driver;
	public String email="steve"+getRandomNumber()+"@gmail.com";
	public RegisterPageObject(WebDriver mappingDriver) {
		// TODO Auto-generated constructor stub
		driver=mappingDriver;
	}

	public void clickToRegisterButton() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getFirstnameError() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "FirstName-error"));
		return getElementText(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "FirstName-error"));
	
	
}

	public String getLastnameError() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "LastName-error"));
		return getElementText(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "LastName-error"));
	}


	public String getEmailError() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "Email-error"));
		return getElementText(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "Email-error"));
	}


	public String getPasswordError() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "Password-error"));
		return getElementText(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "Password-error"));
	}


	public String getConfirmPasswordError() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "ConfirmPassword-error"));
		return getElementText(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "ConfirmPassword-error"));
	}


	public void sendKeyToEmail( String invalidEmail) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "Email"));
		sendKeyToElement(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "Email"), invalidEmail);
	}


	public void sendKeyToFirstname(String firstName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "FirstName"));
		sendKeyToElement(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "FirstName"), firstName);
	}


	public void sendKeyToLastname(String lastName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "LastName"));
		sendKeyToElement(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "LastName"), lastName);
	}


	public void sendKeyToPassword(String password) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "Password"));
		sendKeyToElement(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "Password"), password);
	}

	public void sendKeyToConfirmationPassword(String password) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "ConfirmPassword"));
		sendKeyToElement(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "ConfirmPassword"), password);
	}


	public String getRegistrationResultMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.REGISTRATION_RESULT);
		return getElementText(driver, RegisterPageUI.REGISTRATION_RESULT);
	}

}