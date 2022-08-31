package basePage;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	public void Back(WebDriver driver) {
		driver.navigate().back();
	}
	public void Forward(WebDriver driver) {
		driver.navigate().forward();
	}
	public void Refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	public Alert waitAlertPresence(WebDriver driver) {
		WebDriverWait explicityWait= new WebDriverWait(driver, 30);
		return explicityWait.until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		waitAlertPresence(driver);
		driver.switchTo().alert().accept();
	}
	public void cancelAlert(WebDriver driver) {
		waitAlertPresence(driver);
		driver.switchTo().alert().dismiss();
	}
	public String getTextAlert(WebDriver driver) {
		waitAlertPresence(driver);
		return driver.switchTo().alert().getText();
	}
	public void sendKeyToAlert(WebDriver driver, String alertKey) {
		waitAlertPresence(driver);
		driver.switchTo().alert().sendKeys(alertKey);
	}
	public void switchWindowByID(WebDriver driver) {
		String currentID=driver.getWindowHandle();
		Set<String> allWindowID=driver.getWindowHandles();
		for (String i: allWindowID) {
			if (!i.equals(currentID)) {
				driver.switchTo().window(i);
			}
		}
	}
	public void switchWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindowID=driver.getWindowHandles();
		for (String id: allWindowID) {
			driver.switchTo().window(id);
			String actualTitle=driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}
	public void closeAllWindowWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowID= driver.getWindowHandles();
		for (String id: allWindowID) {
			driver.switchTo().window(id);
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	public List<WebElement> getElements(WebDriver driver, String locator){
		return driver.findElements(getByXpath(locator));
	}
	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}
	public void sendKeyToElement(WebDriver driver, String locator, String key) {
		getElement(driver, locator).sendKeys(key);
	}
	public void selectItemDropdown(WebDriver driver, String locator, String textItem) {
		Select select=new Select(getElement(driver, locator));
		select.selectByValue(textItem);
	}
	public String getSelectedItemDropdown(WebDriver driver, String locator) {
		Select select=new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	public boolean isDropDownMultiple(WebDriver driver, String locator) {
		Select select=new Select(getElement(driver, locator));
		return select.isMultiple();
	}
	public void selectItemCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(1);
		WebDriverWait explicityWait=new WebDriverWait(driver, 30);
		List<WebElement> allItems=explicityWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));
		for (WebElement item: allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExecutor=(JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	public String getAttributeValue(WebDriver driver, String locator, String attribute) {
		return getElement(driver, locator).getAttribute(attribute);
	}
	public String getTextElement(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	public String getCssValue(WebDriver driver, String locator, String cssValue) {
		return getElement(driver, locator).getCssValue(cssValue);
	}
	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	public void checkCheckboxorRadio(WebDriver driver, String locator) {
		
	}
	public void sleepInSecond(long second) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(second*1000);
		}catch (InterruptedException e) {
		}
	}
}
