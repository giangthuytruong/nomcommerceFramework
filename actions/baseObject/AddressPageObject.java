package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import pageUIs.AddressPageUI;

public class AddressPageObject extends AbstractPage {
	private WebDriver driver;
	public AddressPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public void clickToAddButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, AddressPageUI.ADDADDRESS_BUTTON);
		clickToElement(driver, AddressPageUI.ADDADDRESS_BUTTON);
	}
	public void sendKeyToFirstName(String firstname) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT,"input", "Address_FirstName"));
		sendKeyToElement(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT,"input", "Address_FirstName"), firstname);
	}

	public void sendKeyToLastName(String lastNameUpdate) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_LastName"));
		sendKeyToElement(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_LastName"), lastNameUpdate);
	}
	public void sendKeyToEmail(String emailUpdate) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_Email"));
		sendKeyToElement(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT,"input", "Address_Email"), emailUpdate);
	}
	public void sendKeyToCompany(String company) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_Company"));
		sendKeyToElement(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_Company"), company);
	}
	public void selectCountry(String country) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "select","Address_CountryId"));
		selectItemDropdownByText(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "select","Address_CountryId") , country);
	}

	public void selectProvince(String province) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "select","Address_StateProvinceId"));
		selectItemDropdownByText(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "select","Address_StateProvinceId") , province);
	}

	public void sendKeyToCity(String city) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_City"));
		sendKeyToElement(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_City"), city);
	}

	public void sendKeyToAddress1(String address1) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_Address1"));
		sendKeyToElement(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_Address1"), address1 );
	}

	public void sendKeyToAddress2(String address2) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_Address2"));
		sendKeyToElement(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_Address2"), address2);
	}

	public void sendKeyToPostalCode(String postalCode) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_ZipPostalCode"));
		sendKeyToElement(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_ZipPostalCode"), postalCode);
	}

	public void sendKeyToPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_PhoneNumber"));
		sendKeyToElement(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_PhoneNumber"), phoneNumber);
	}

	public void sendKeyToFaxNumber(String faxNumber) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_FaxNumber"));
		sendKeyToElement(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_ELEMENT, "input","Address_FaxNumber"), faxNumber);
	}


	public String getEmailUpdate() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "email"));
		return getElementText(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "email"));
	}

	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "phone"));
		return getElementText(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "phone"));
	}

	public String getFaxNumber() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "fax"));
		return getElementText(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "fax"));
	}

	public String getcompanyName() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "company"));
		return getElementText(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "company"));
	}

	public String getAddress1Update() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "address1"));
		return getElementText(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "address1"));
	}

	public String getAddress2Update() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,  castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "address2"));
		return getElementText(driver,castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "address2"));
	}

	public String getCityPostalCodeText() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "city-state-zip"));
		return getElementText(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "city-state-zip"));
	}

	public String getCountry() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "country"));
		return getElementText(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "country"));
	}
	public void clickToSaveAddressButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, AddressPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, AddressPageUI.SAVE_ADDRESS_BUTTON);
	}
	public String getNameText() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "name"));
		return getElementText(driver, castRestParameter(AddressPageUI.ADDRESS_DYNAMIC_TEXT, "name"));
	}
}
