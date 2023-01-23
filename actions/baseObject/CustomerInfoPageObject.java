package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import pageUIs.AddressPageUI;
import pageUIs.CustomerInfoUI;


public class CustomerInfoPageObject extends AbstractPage {
	private WebDriver driver;
	public CustomerInfoPageObject(WebDriver mappingDriver) {
		// TODO Auto-generated constructor stub
		 driver = mappingDriver;
	}
	public void sendKeyToFirstName(String firstname) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(CustomerInfoUI.DYNAMIC_TEXTBOX, "FirstName"));
		sendKeyToElement(driver, castRestParameter(CustomerInfoUI.DYNAMIC_TEXTBOX, "FirstName"), firstname);
	}

	public void sendKeyToLastName(String lastNameUpdate) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(CustomerInfoUI.DYNAMIC_TEXTBOX, "LastName"));
		sendKeyToElement(driver, castRestParameter(CustomerInfoUI.DYNAMIC_TEXTBOX, "LastName"), lastNameUpdate);
	}

	public void selectDay(String dateOfBirth) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(CustomerInfoUI.DYNAMIC_DROPDOWN, "DateOfBirthDay"));
		selectItemDropdown(driver, castRestParameter(CustomerInfoUI.DYNAMIC_DROPDOWN, "DateOfBirthDay") , dateOfBirth);
	}

	public void selectMonth(String monthOfBirth) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,castRestParameter(CustomerInfoUI.DYNAMIC_DROPDOWN, "DateOfBirthMonth"));
		selectItemDropdown(driver, castRestParameter(CustomerInfoUI.DYNAMIC_DROPDOWN, "DateOfBirthMonth") , monthOfBirth);
	}

	public void selectYear(String yearOfBirth) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(CustomerInfoUI.DYNAMIC_DROPDOWN, "DateOfBirthYear"));
		selectItemDropdownByText(driver,  castRestParameter(CustomerInfoUI.DYNAMIC_DROPDOWN, "DateOfBirthYear") , yearOfBirth);
	}

	public void sendKeyToEmail(String emailUpdate) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(CustomerInfoUI.DYNAMIC_TEXTBOX, "Email"));
		sendKeyToElement(driver, castRestParameter(CustomerInfoUI.DYNAMIC_TEXTBOX, "Email"), emailUpdate);
	}

	public void sendKeyToCompanyName(String companyName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(CustomerInfoUI.DYNAMIC_TEXTBOX, "Company"));
		sendKeyToElement(driver, castRestParameter(CustomerInfoUI.DYNAMIC_TEXTBOX, "Company"), companyName);
	}

	public void clickToSaveButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, CustomerInfoUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInfoUI.SAVE_BUTTON);
	}

	public String getFirstNameAttribute(String value) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(CustomerInfoUI.DYNAMIC_TEXTBOX, "FirstName"));
		return getAttributeValue(driver, castRestParameter(CustomerInfoUI.DYNAMIC_TEXTBOX, "FirstName"), value);
	}

	public String getLastNameAttribute(String value) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(CustomerInfoUI.DYNAMIC_TEXTBOX, "LastName"));
		return getAttributeValue(driver, castRestParameter(CustomerInfoUI.DYNAMIC_TEXTBOX, "LastName"), value);
	}

	public String getDateAttribute(String value) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(CustomerInfoUI.DYNAMIC_DROPDOWN, "DateOfBirthDay"));
		return getAttributeValue(driver,castRestParameter(CustomerInfoUI.DYNAMIC_DROPDOWN, "DateOfBirthDay"), value);
	}

	public String getMonthAttribute(String textContent) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(CustomerInfoUI.DYNAMIC_DROPDOWN, "DateOfBirthMonth"));
		return getAttributeValue(driver,  castRestParameter(CustomerInfoUI.DYNAMIC_DROPDOWN, "DateOfBirthMonth"), textContent);
	}

	public String getYearAttribute(String value) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(CustomerInfoUI.DYNAMIC_DROPDOWN, "DateOfBirthYear"));
		return getAttributeValue(driver,  castRestParameter(CustomerInfoUI.DYNAMIC_DROPDOWN, "DateOfBirthYear"), value);
	}

	public String getCompanyNameAttribute(String value) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(CustomerInfoUI.DYNAMIC_TEXTBOX, "Company"));
		return getAttributeValue(driver,  castRestParameter(CustomerInfoUI.DYNAMIC_TEXTBOX, "Company"), value);
	}

	
}
