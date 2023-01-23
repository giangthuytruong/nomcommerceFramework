package baseObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basePage.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.SearchPageUI;

public class SearchPageObject extends AbstractPage {
		private WebDriver driver;
	public SearchPageObject(WebDriver mappingDriver) {
		// TODO Auto-generated constructor stub
		driver=mappingDriver;
	}

	public void clickToSearchButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	public String getValidateMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, SearchPageUI.SEARCH_KEYWORD_VALIDATE_MESSAGE);
		return getTextElement(driver, SearchPageUI.SEARCH_KEYWORD_VALIDATE_MESSAGE);
	}

	public void sendKeyToSearchKeywork(String key) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		sendKeyToElement(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX, key);
	}

	public String getDataNotExistMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, SearchPageUI.SEARCH_KEYWORD_NO_RESULT_MESSAGE);
		return getTextElement(driver, SearchPageUI.SEARCH_KEYWORD_NO_RESULT_MESSAGE);
	}

	public Object getResultSize() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, SearchPageUI.PRODUCT_SEARCH_RESULT);
		return getElementSize(driver, SearchPageUI.PRODUCT_SEARCH_RESULT);
	}

	public Boolean getResultContainKeyWord(String key) {
		// TODO Auto-generated method stub
		Boolean result = null;
		List<WebElement> elements=getElements(driver, SearchPageUI.PRODUCT_SEARCH_RESULT);
		for (WebElement element: elements) {
			System.out.println(element.getText());
			result=element.getText().contains(key);
		}
		return result;
	}

	public void tickCheckboxAdvancedSearch() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, castRestParameter(SearchPageUI.DYNAMIC_CHECKBOX, "advs"));
		checkCheckboxorRadio(driver, castRestParameter(SearchPageUI.DYNAMIC_CHECKBOX, "advs"));
	}

	public void selectCategory(String key) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, castRestParameter(SearchPageUI.DYNAMIC_DROPDOWN, "cid"));
		selectItemDropdownByText(driver, castRestParameter(SearchPageUI.DYNAMIC_DROPDOWN, "cid"), key);
	}

	public void tickCheckboxAutomicallySubCategories() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, castRestParameter(SearchPageUI.DYNAMIC_CHECKBOX, "isc"));
		checkCheckboxorRadio(driver, castRestParameter(SearchPageUI.DYNAMIC_CHECKBOX, "isc"));
	}

	public void selectManufacturer(String key) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, castRestParameter(SearchPageUI.DYNAMIC_DROPDOWN,"mid"));
		selectItemDropdownByText(driver, castRestParameter(SearchPageUI.DYNAMIC_DROPDOWN,"mid"), key);
	}

}
