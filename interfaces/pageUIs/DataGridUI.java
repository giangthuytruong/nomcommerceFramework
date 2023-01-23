package pageUIs;

public class DataGridUI {
	public static final String TOTAL_PAGINATION="xpath=//li[@class='qgrd-pagination-page']/a";
	public static final String	PAGINATION_PAGE_BY_INDEX="xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String ALL_ROW_EACH_PAGE="xpath=//tr/td[@data-key]";
	public static final String BUTTON_ACTION="xpath=//td[text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
	public static final String ALL_ROW_EACH_COLUMN_NAME="xpath=//tr/td[@data-key='%s']";
	public static final String INPUT_NAME="xpath=//input[@name='%s']";
	public static final String SAVE_BUTTON="xpath=//input[@type='submit']";
	public static final String COUNTRY_NAME="xpath=//td[@data-key='country' and text()='%s']";
	public static final String PAGE_SELECTED="xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
}
