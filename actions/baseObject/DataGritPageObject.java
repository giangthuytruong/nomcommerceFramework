package baseObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePage.AbstractPage;
import pageUIs.DataGridUI;

public class DataGritPageObject extends AbstractPage{
	private WebDriver driver;
	public DataGritPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public List<String> getValueEachRowAtAllPage() {
		// TODO Auto-generated method stub
		int totalPage=getElementSize(driver, DataGridUI.TOTAL_PAGINATION);
		List<String> allRowValue=new ArrayList<String>();
		//Duyệt qua tất cả
		//Thay list= set thì khi add vào chỉ lấy 1 giá trị nếu trung
		
		for (int i=1; i<=totalPage; i++) {
			clickToElement(driver,DataGridUI.PAGINATION_PAGE_BY_INDEX , String.valueOf(i));
			sleepInSecond(1);
			List<WebElement> allRowEachPage=getElements(driver, DataGridUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow: allRowEachPage) {
				allRowValue.add(eachRow.getText());
			}
		}
		return allRowValue;
	}
	public List<String> getValueEachRowByColumnName(String columnName) {
		// TODO Auto-generated method stub
		int totalPage=getElementSize(driver, DataGridUI.TOTAL_PAGINATION);
		List<String> allRowValue=new ArrayList<String>();
		//Duyệt qua tất cả
		//Thay list= set thì khi add vào chỉ lấy 1 giá trị nếu trung
		
		for (int i=1; i<=totalPage; i++) {
			clickToElement(driver,DataGridUI.PAGINATION_PAGE_BY_INDEX , String.valueOf(i));
			sleepInSecond(1);
			List<WebElement> allRowEachPage=getElements(driver, DataGridUI.ALL_ROW_EACH_PAGE, columnName);
			for (WebElement eachRow: allRowEachPage) {
				allRowValue.add(eachRow.getText());
			}
		}
		for (String value: allRowValue) {
			System.out.println(value);
		}
		return allRowValue;
	}

	public void clickToIconByCountryName(String countryName, String buttonName) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, DataGridUI.BUTTON_ACTION, countryName, buttonName);
		clickToElement(driver, DataGridUI.BUTTON_ACTION, countryName, buttonName);
	}
	public void editRecordByTextboxName(String countryName, String country) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, DataGridUI.INPUT_NAME, country);
		sendKeyToElement(driver, DataGridUI.INPUT_NAME, countryName, country);
	}
	public void saveEditRecord() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, DataGridUI.SAVE_BUTTON);
		clickToElement(driver, DataGridUI.SAVE_BUTTON);
	}
	public String getTextByCountryName(String countryName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, DataGridUI.COUNTRY_NAME, countryName);
		return getTextElement(driver, DataGridUI.COUNTRY_NAME, countryName);
	}
	public void paginationByPageNumber(String pageNumber) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, DataGridUI.PAGINATION_PAGE_BY_INDEX, pageNumber);
		clickToElement(driver, DataGridUI.PAGINATION_PAGE_BY_INDEX, pageNumber);
	}
	public boolean isPageSelected(String pageNumber) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, DataGridUI.PAGE_SELECTED, pageNumber);
		return isControlDisplayed(driver, DataGridUI.PAGE_SELECTED, pageNumber);
	}
}
