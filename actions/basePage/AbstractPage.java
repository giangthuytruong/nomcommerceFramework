package basePage;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AbstractPage {
	
	protected void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	protected String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	protected String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	protected void Back(WebDriver driver) {
		driver.navigate().back();
	}
	protected void Forward(WebDriver driver) {
		driver.navigate().forward();
	}
	protected void Refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	protected Alert waitAlertPresence(WebDriver driver) {
		WebDriverWait explicityWait= new WebDriverWait(driver, timeOut);
		return explicityWait.until(ExpectedConditions.alertIsPresent());
	}
	protected void acceptAlert(WebDriver driver) {
		waitAlertPresence(driver);
		driver.switchTo().alert().accept();
	}
	protected void cancelAlert(WebDriver driver) {
		waitAlertPresence(driver);
		driver.switchTo().alert().dismiss();
	}
	protected String getTextAlert(WebDriver driver) {
		waitAlertPresence(driver);
		return driver.switchTo().alert().getText();
	}
	protected void sendKeyToAlert(WebDriver driver, String alertKey) {
		waitAlertPresence(driver);
		driver.switchTo().alert().sendKeys(alertKey);
	}
	protected void switchWindowByID(WebDriver driver) {
		String currentID=driver.getWindowHandle();
		Set<String> allWindowID=driver.getWindowHandles();
		for (String i: allWindowID) {
			if (!i.equals(currentID)) {
				driver.switchTo().window(i);
			}
		}
	}
	protected void switchWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindowID=driver.getWindowHandles();
		for (String id: allWindowID) {
			driver.switchTo().window(id);
			String actualTitle=driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}
	protected void closeAllWindowWithoutParent(WebDriver driver, String parentID) {
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
	private By getByXpath(String locator) {
		return By.xpath(locator);
	}
	private WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	protected List<WebElement> getElements(WebDriver driver, String locator){
		return driver.findElements(getByXpath(locator));
	}
	protected void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}
	protected void sendKeyToElement(WebDriver driver, String locator, String key) {
		getElement(driver, locator).sendKeys(key);
	}
	protected String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	protected int getElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	protected void selectItemDropdown(WebDriver driver, String locator, String textItem) {
		Select select=new Select(getElement(driver, locator));
		select.selectByValue(textItem);
	}
	protected String getSelectedItemDropdown(WebDriver driver, String locator) {
		Select select=new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	protected boolean isDropDownMultiple(WebDriver driver, String locator) {
		Select select=new Select(getElement(driver, locator));
		return select.isMultiple();
	}
	protected void selectItemCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(1);
		WebDriverWait explicityWait=new WebDriverWait(driver, timeOut);
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
	protected String getAttributeValue(WebDriver driver, String locator, String attribute) {
		return getElement(driver, locator).getAttribute(attribute);
	}
	protected String getTextElement(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	protected String getCssValue(WebDriver driver, String locator, String cssValue) {
		return getElement(driver, locator).getCssValue(cssValue);
	}
	protected String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	protected void checkCheckboxorRadio(WebDriver driver, String locator) {
		if (!isControlSelected(driver, locator)) {
			clickByJs(driver, locator);
		}
	}
	protected void uncheckCheckbox(WebDriver driver, String locator) {
		if (isControlSelected(driver, locator)) {
			clickByJs(driver, locator);
		}
	}
	protected boolean isControlDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}
	protected boolean isControlSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	protected boolean isControlEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}
	protected void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}
	protected void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	protected void doubleClick(WebDriver driver, String locator) {
		Actions action=new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}
	protected void hoverMouse(WebDriver driver, String locator) {
		Actions action=new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}
	protected void rightClick(WebDriver driver, String locator) {
		Actions action=new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}
	protected void DragandDrop(WebDriver driver, String sourceLocator, String endLocator) {
		Actions action= new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, endLocator)).perform();;
	}
	protected void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		Actions action=new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}
	protected void uploadFile(WebDriver driver, String locator, String fileName) {
		String projectPath=System.getProperty("osName");
		String filePath=projectPath+"\\Uploadfiles\\"+fileName;
		sendKeyToElement(driver,locator, filePath);
	}
	protected Object executeJavascriptBrowser(WebDriver driver, String Javascript) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		return jsExecutor.executeScript(Javascript);
	}
	protected String getInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}
	protected boolean areExpectedTextInnerText(WebDriver driver, String expectedText) {
		String actualText=getInnerText(driver);
		return actualText.equals(expectedText);
	}
	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	}
	protected void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		WebElement element=getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}
	protected void clickByJs(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}
	protected void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}
	protected void sendKeyByJs(WebDriver driver, String locator, String key) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '"+key+"');", getElement(driver, locator));
	}
	protected void removeAttributeInDom(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('"+attributeRemove+"');", getElement(driver, locator));
	}
	protected Boolean areJqueryandJsLoadSuccess(WebDriver driver) {
		WebDriverWait explicityWait=new WebDriverWait(driver, timeOut);
		final JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad= new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active")==0);
				} catch (Exception e) {
					return true;
				}
			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicityWait.until(jQueryLoad) && explicityWait.until(jsLoad);
	}
	protected String getValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}
	protected Boolean isImageLoad(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	protected void waitForElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicityWait=new WebDriverWait(driver, timeOut);
		explicityWait.until(ExpectedConditions.visibilityOf(getElement(driver, locator)));
	}
	protected void waitForAllElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicityWait=new WebDriverWait(driver, timeOut);
		explicityWait.until(ExpectedConditions.visibilityOfAllElements(getElements(driver, locator)));
	}
	protected void waitForElementClickable(WebDriver driver, String locator) {
		WebDriverWait explicityWait= new WebDriverWait(driver, timeOut);
		explicityWait.until(ExpectedConditions.elementToBeClickable(getElement(driver, locator)));
	}
	protected void waitForElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicityWait=new WebDriverWait(driver, timeOut);
		explicityWait.until(ExpectedConditions.invisibilityOf(getElement(driver, locator)));
	}
	protected void waitForAllElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicityWait=new WebDriverWait(driver, timeOut);
		explicityWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, locator)));
	}
	protected void waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicityWait=new WebDriverWait(driver, timeOut);
		explicityWait.until(ExpectedConditions.alertIsPresent());
	}
	protected int timeOut=30;
	protected int getRandomNumber() {
		Random rand=new Random();
		return rand.nextInt(9999);
	}
	protected void sleepInSecond(long second) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(second*1000);
		}catch (InterruptedException e) {
		}
	}
}
