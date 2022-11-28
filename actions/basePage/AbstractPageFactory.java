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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseObject.AddressPageObject;
import baseObject.ChangePasswordPageObject;
import baseObject.CustomerInfoPageObject;
import baseObject.DownloadableProductPageObject;
import baseObject.HomePageObject;
import baseObject.MyAccountObject;
import baseObject.MyProductReviewPageObject;
import baseObject.OrderPageObject;
import baseObject.PageGeneratorManager;
import baseObject.RewardPointPageObject;
import baseObject.SearchPageObject;
import baseObject.SubscriptionPageObject;
import pageUIs.AbstractPageUI;
import pageUIs.HomepageUI;

public class AbstractPageFactory {
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
	private WebElement getElement(WebDriver driver, By element) {
		return driver.findElement(element);
	}
	protected List<WebElement> getElements(WebDriver driver, By element){
		return driver.findElements(element);
	}
	protected void clickToElement(WebDriver driver, By element) {
		getElement(driver, element).click();
	}
	protected void sendKeyToElement(WebDriver driver, By element, String key) {
		getElement(driver, element).clear();
		getElement(driver, element).sendKeys(key);
	}
	protected String getElementText(WebDriver driver, By element) {
		return getElement(driver, element).getText();
	}
	protected int getElementSize(WebDriver driver, By element) {
		return getElements(driver, element).size();
	}
	protected void selectItemDropdown(WebDriver driver, By element, String textItem) {
		Select select=new Select(getElement(driver, element));
		select.selectByValue(textItem);
	}
	protected void selectItemDropdownByText(WebDriver driver, By element, String textItem) {
		Select select=new Select(getElement(driver, element));
		select.selectByVisibleText(textItem);
	}
	protected String getSelectedItemDropdown(WebDriver driver, By element) {
		Select select=new Select(getElement(driver, element));
		return select.getFirstSelectedOption().getText();
	}
	protected boolean isDropDownMultiple(WebDriver driver, By element) {
		Select select=new Select(getElement(driver, element));
		return select.isMultiple();
	}
	protected void selectItemCustomDropdown(WebDriver driver, By parentElement, By childElement, String expectedItem) {
		getElement(driver, parentElement).click();
		sleepInSecond(1);
		WebDriverWait explicityWait=new WebDriverWait(driver, timeOut);
		List<WebElement> allItems=explicityWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(childElement));
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
	protected String getAttributeValue(WebDriver driver, By element, String attribute) {
		return getElement(driver, element).getAttribute(attribute);
	}
	protected String getTextElement(WebDriver driver, By element) {
		return getElement(driver, element).getText();
	}
	protected String getCssValue(WebDriver driver, By element, String cssValue) {
		return getElement(driver, element).getCssValue(cssValue);
	}
	protected String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	protected void checkCheckboxorRadio(WebDriver driver, By element) {
		if (!isControlSelected(driver, element)) {
			clickByJs(driver, element);
		}
	}
	protected void uncheckCheckbox(WebDriver driver, By element) {
		if (isControlSelected(driver, element)) {
			clickByJs(driver, element);
		}
	}
	protected boolean isControlDisplayed(WebDriver driver, By element) {
		return getElement(driver, element).isDisplayed();
	}
	protected boolean isControlSelected(WebDriver driver, By element) {
		return getElement(driver, element).isSelected();
	}
	protected boolean isControlEnabled(WebDriver driver, By element) {
		return getElement(driver, element).isEnabled();
	}
	protected void switchToFrame(WebDriver driver, By element) {
		driver.switchTo().frame(getElement(driver, element));
	}
	protected void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	protected void doubleClick(WebDriver driver, By element) {
		Actions action=new Actions(driver);
		action.doubleClick(getElement(driver, element)).perform();
	}
	protected void hoverMouse(WebDriver driver, By element) {
		Actions action=new Actions(driver);
		action.moveToElement(getElement(driver, element)).perform();
	}
	protected void rightClick(WebDriver driver, By element) {
		Actions action=new Actions(driver);
		action.contextClick(getElement(driver, element)).perform();
	}
	protected void DragandDrop(WebDriver driver, By startElement, By endElement) {
		Actions action= new Actions(driver);
		action.dragAndDrop(getElement(driver, startElement), getElement(driver, endElement)).perform();;
	}
	protected void sendKeyBoardToElement(WebDriver driver, By element, Keys key) {
		Actions action=new Actions(driver);
		action.sendKeys(getElement(driver, element), key).perform();
	}
	protected void uploadFile(WebDriver driver, By element, String fileName) {
		String projectPath=System.getProperty("osName");
		String filePath=projectPath+"\\Uploadfiles\\"+fileName;
		sendKeyToElement(driver,element, filePath);
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
	protected void highlightElement(WebDriver driver, By childElement) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		WebElement element=getElement(driver, childElement);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}
	protected void clickByJs(WebDriver driver, By element) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, element));
	}
	protected void scrollToElement(WebDriver driver, By element) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, element));
	}
	protected void sendKeyByJs(WebDriver driver, By element, String key) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '"+key+"');", getElement(driver, element));
	}
	protected void removeAttributeInDom(WebDriver driver, By element, String attributeRemove) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('"+attributeRemove+"');", getElement(driver, element));
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
	protected String getValidationMessage(WebDriver driver, By element) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, element));
	}
	protected Boolean isImageLoad(WebDriver driver, By element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, element));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	protected void waitForElementVisible(WebDriver driver, By element) {
		WebDriverWait explicityWait=new WebDriverWait(driver, timeOut);
		explicityWait.until(ExpectedConditions.visibilityOf(getElement(driver, element)));
	}
	protected void waitForAllElementVisible(WebDriver driver, By element) {
		WebDriverWait explicityWait=new WebDriverWait(driver, timeOut);
		explicityWait.until(ExpectedConditions.visibilityOfAllElements(getElements(driver, element)));
	}
	protected void waitForElementClickable(WebDriver driver, By element) {
		WebDriverWait explicityWait= new WebDriverWait(driver, timeOut);
		explicityWait.until(ExpectedConditions.elementToBeClickable(getElement(driver, element)));
	}
	protected void waitForElementInvisible(WebDriver driver, By element) {
		WebDriverWait explicityWait=new WebDriverWait(driver, timeOut);
		explicityWait.until(ExpectedConditions.invisibilityOf(getElement(driver, element)));
	}
	protected void waitForAllElementInvisible(WebDriver driver, By element) {
		WebDriverWait explicityWait=new WebDriverWait(driver, timeOut);
		explicityWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, element)));
	}
	protected void waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicityWait=new WebDriverWait(driver, timeOut);
		explicityWait.until(ExpectedConditions.alertIsPresent());
	}
	
	protected int timeOut=30;
	public int getRandomNumber() {
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
