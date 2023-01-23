package com.noncommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseObject.DataGritPageObject;
import baseObject.PageGeneratorManager;
import basePage.BaseTest;

public class DataGrid_Jquery extends BaseTest {
	private WebDriver driver;
	private DataGritPageObject dataGridPage;
	List<String> allCountryValue;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver= getBrowserDriver(browserName);
		dataGridPage= PageGeneratorManager.openDataGridPage(driver);
	}
	@Test
	public void TC_01_Pagination() {
		dataGridPage.paginationByPageNumber("10");
		Assert.assertTrue(dataGridPage.isPageSelected("10"));
		dataGridPage.paginationByPageNumber("20");
		Assert.assertTrue(dataGridPage.isPageSelected("20"));
		
	}
	@Test
	public void TC_02_Delete_Edit_Icon() {
		dataGridPage.refreshPage(driver);
		dataGridPage.clickToIconByCountryName("Argentina", "edit");
		dataGridPage.editRecordByTextboxName("France", "country");
		dataGridPage.sleepInSecond(2);
		dataGridPage.saveEditRecord();
		Assert.assertEquals(dataGridPage.getTextByCountryName("France"), "France");
		dataGridPage.clickToIconByCountryName("France", "remove");
	}
	@Test
	public void TC_03_Total_Country() {
	//Chay qua tung page (for)
	//Get data cell/row/column
		dataGridPage.getValueEachRowAtAllPage();
		allCountryValue=dataGridPage.getValueEachRowByColumnName("Country");
		//Đọc dữ liệu của file country.txt ra
		//Lưu vào 1 list<string>=expected value
		
	}
}
