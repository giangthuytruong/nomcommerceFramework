package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import io.qameta.allure.Step;
import pageUIs.AbstractPageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	private WebDriver driver;
	public String email="steve"+getRandomNumber()+"@gmail.com";
	public RegisterPageObject(WebDriver mappingDriver) {
		// TODO Auto-generated constructor stub
		driver=mappingDriver;
	}
	@Step("Click to register button")
	public void clickToRegisterButton() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	@Step("Get firstname error message")
	public String getFirstnameError() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "FirstName-error"));
		return getElementText(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "FirstName-error"));
	
	
}
	@Step("Get lastname error message")
	public String getLastnameError() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "LastName-error"));
		return getElementText(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "LastName-error"));
	}

	@Step("Get email error message")
	public String getEmailError() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "Email-error"));
		return getElementText(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "Email-error"));
	}

	@Step("Get password error message")
	public String getPasswordError() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "Password-error"));
		return getElementText(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "Password-error"));
	}

	@Step("Get confirm password error message")
	public String getConfirmPasswordError() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "ConfirmPassword-error"));
		return getElementText(driver, castRestParameter(RegisterPageUI.DYNAMIC_ERROR, "ConfirmPassword-error"));
	}

	@Step("Input to email textbox with value: {tesst}")
	public void sendKeyToEmail( String invalidEmail) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "Email"));
		sendKeyToElement(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "Email"), invalidEmail);
	}

	@Step("Input to firstname textbox with value: {Steve}")
	public void sendKeyToFirstname(String firstName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "FirstName"));
		sendKeyToElement(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "FirstName"), firstName);
	}

	@Step("Input to lastname textbox with value: {Job}")
	public void sendKeyToLastname(String lastName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "LastName"));
		sendKeyToElement(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "LastName"), lastName);
	}

	@Step("Input to password textbox with value: {123123}")
	public void sendKeyToPassword(String password) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "Password"));
		sendKeyToElement(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "Password"), password);
	}
	@Step("Input to confirmation password textbox with value: {123123}")
	public void sendKeyToConfirmationPassword(String password) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "ConfirmPassword"));
		sendKeyToElement(driver, castRestParameter(RegisterPageUI.DYNAMIC_TEXTBOX, "ConfirmPassword"), password);
	}

	@Step("Get registration result success message")
	public String getRegistrationResultMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.REGISTRATION_RESULT);
		return getElementText(driver, RegisterPageUI.REGISTRATION_RESULT);
	}

}