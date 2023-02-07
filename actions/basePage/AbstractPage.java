package basePage;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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

import baseObject.HomePageObject;
import baseObject.PageGeneratorManager;
import baseObject.SearchPageObject;
import commons.GlobalConstants;
import io.qameta.allure.Step;
import pageUIs.AbstractPageUI;
import pageUIs.uploadFilePageUI;

public class AbstractPage {
	private By getByLocator(String locatorType) {
		By by=null;
		if (locatorType.startsWith("id=")||locatorType.startsWith("ID=")||locatorType.startsWith("Id=")) {
			by=By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=")||locatorType.startsWith("CLASS=")||locatorType.startsWith("Class=")) {
			by=By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=")||locatorType.startsWith("NAME=")||locatorType.startsWith("Name=")) {
			by=By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=")||locatorType.startsWith("CSS=")||locatorType.startsWith("Css=")) {
			by=By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=")|locatorType.startsWith("XPATH=")||locatorType.startsWith("Xpath=")) {
			by=By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("locatorType type is not supported");
		}
		return by;
	}
	private String getDynamicXpath(String locatorType, String...dynamicValues) {
		if (locatorType.startsWith("xpath=")|locatorType.startsWith("XPATH=")||locatorType.startsWith("Xpath=")) {
			locatorType=String.format(locatorType, (Object[]) dynamicValues);
		}
		return locatorType;
		
	}
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
		WebDriverWait explicityWait= new WebDriverWait(driver, longTimeout);
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
	
	protected WebElement getElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}
	protected List<WebElement> getElements(WebDriver driver, String locatorType, String...dynamicValues){
		return driver.findElements(getByLocator(locatorType));
	}
	protected void clickToElement(WebDriver driver, String locatorType, String...dynamicValues) {
		getElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
	}
	protected void sendKeyToElement(WebDriver driver, String locatorType, String key, String...dynamicValues) {
		getElement(driver, getDynamicXpath(locatorType, dynamicValues)).clear();
		getElement(driver, getDynamicXpath(locatorType, dynamicValues)).sendKeys(key);
	}
	protected String getElementText(WebDriver driver, String locatorType, String...dynamicValues) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
	}
	protected int getElementSize(WebDriver driver, String locatorType, String...dynamicValues) {
		return getElements(driver, getDynamicXpath(locatorType, dynamicValues)).size();
	}
	protected void selectItemDropdown(WebDriver driver, String locatorType, String textItem, String...dynamicValues) {
		Select select=new Select(getElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByValue(textItem);
	}
	protected void selectItemDropdownByText(WebDriver driver, String locatorType, String textItem, String...dynamicValues) {
		Select select=new Select(getElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);
	}
	protected String getSelectedItemDropdown(WebDriver driver, String locatorType, String...dynamicValues) {
		Select select=new Select(getElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return select.getFirstSelectedOption().getText();
	}
	protected boolean isDropDownMultiple(WebDriver driver, String locatorType, String...dynamicValues) {
		Select select=new Select(getElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return select.isMultiple();
	}
	protected void selectItemCustomDropdown(WebDriver driver, String parentlocatorType, String childlocatorType, String expectedItem, String...dynamicValues) {
		getElement(driver, getDynamicXpath(parentlocatorType, dynamicValues)).click();
		sleepInSecond(1);
		WebDriverWait explicityWait=new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems=explicityWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(getDynamicXpath(childlocatorType, dynamicValues))));
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
	protected String getAttributeValue(WebDriver driver, String locatorType, String attribute,String...dynamicValues) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicValues)).getAttribute(attribute);
	}
	protected String getTextElement(WebDriver driver, String locatorType, String...dynamicValues) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
	}
	protected String getCssValue(WebDriver driver, String locatorType, String cssValue, String...dynamicValues) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicValues)).getCssValue(cssValue);
	}
	protected String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	protected void checkCheckboxorRadio(WebDriver driver, String locatorType, String...dynamicValues) {
		if (!isControlSelected(driver, getDynamicXpath(locatorType, dynamicValues))) {
			clickByJs(driver, getDynamicXpath(locatorType, dynamicValues));
		}
	}
	protected void uncheckCheckbox(WebDriver driver, String locatorType, String...dynamicValues) {
		if (isControlSelected(driver, getDynamicXpath(locatorType, dynamicValues))) {
			clickByJs(driver, getDynamicXpath(locatorType, dynamicValues));
		}
	}
	protected boolean isControlDisplayed(WebDriver driver, String locatorType, String...dynamicValues) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}
	protected boolean isControlSelected(WebDriver driver, String locatorType, String...dynamicValues) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicValues)).isSelected();
	}
	protected boolean isControlEnabled(WebDriver driver, String locatorType, String...dynamicValues) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicValues)).isEnabled();
	}
	protected void switchToFrame(WebDriver driver, String locatorType, String...dynamicValues) {
		driver.switchTo().frame(getElement(driver, getDynamicXpath(locatorType, dynamicValues)));
	}
	protected void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	protected void doubleClick(WebDriver driver, String locatorType, String...dynamicValues) {
		Actions action=new Actions(driver);
		action.doubleClick(getElement(driver, getDynamicXpath(locatorType, dynamicValues))).perform();
	}
	protected void hoverMouse(WebDriver driver, String locatorType, String...dynamicValues) {
		Actions action=new Actions(driver);
		action.moveToElement(getElement(driver, getDynamicXpath(locatorType, dynamicValues))).perform();
	}
	protected void rightClick(WebDriver driver, String locatorType, String...dynamicValues) {
		Actions action=new Actions(driver);
		action.contextClick(getElement(driver, getDynamicXpath(locatorType, dynamicValues))).perform();
	}
	protected void DragandDrop(WebDriver driver, String sourcelocatorType, String endlocatorType, String...dynamicValues) {
		Actions action= new Actions(driver);
		action.dragAndDrop(getElement(driver, getDynamicXpath(sourcelocatorType, dynamicValues)), getElement(driver, getDynamicXpath(endlocatorType, dynamicValues))).perform();;
	}
	protected void sendKeyBoardToElement(WebDriver driver, String locatorType, Keys key, String...dynamicValues) {
		Actions action=new Actions(driver);
		action.sendKeys(getElement(driver, getDynamicXpath(locatorType, dynamicValues)), key).perform();
	}
	protected void uploadFile(WebDriver driver, String locatorType, String fileName, String...dynamicValues) {
		String projectPath=System.getProperty("user.dir");
		String filePath=projectPath+"\\Uploadfiles\\"+fileName;
		sendKeyToElement(driver,getDynamicXpath(locatorType, dynamicValues), filePath);
	}
	public void uploadMultipleFiles(WebDriver driver, String...fileNames) {
		String projectPath=GlobalConstants.UPLOAD_FILE+File.separator;
		String fullFileName="";
		for (String file: fileNames) {
			fullFileName=fullFileName+projectPath+file+"\n";
		}
		fullFileName=fullFileName.trim();
		sendKeyToElement(driver, uploadFilePageUI.UPLOAD_FILES, fullFileName);
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
	protected void highlightElement(WebDriver driver, String locatorType, String...dynamicValues) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		WebElement element=getElement(driver, getDynamicXpath(locatorType, dynamicValues));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}
	protected void clickByJs(WebDriver driver, String locatorType, String...dynamicValues) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, getDynamicXpath(locatorType, dynamicValues)));
	}
	protected void scrollToElement(WebDriver driver, String locatorType, String...dynamicValues) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, getDynamicXpath(locatorType, dynamicValues)));
	}
	protected void sendKeyByJs(WebDriver driver, String locatorType, String key, String...dynamicValues) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '"+key+"');", getElement(driver, getDynamicXpath(locatorType, dynamicValues)));
	}
	protected void removeAttributeInDom(WebDriver driver, String locatorType, String attributeRemove, String...dynamicValues) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('"+attributeRemove+"');", getElement(driver, getDynamicXpath(locatorType, dynamicValues)));
	}
	protected Boolean areJqueryandJsLoadSuccess(WebDriver driver) {
		WebDriverWait explicityWait=new WebDriverWait(driver, longTimeout);
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
	protected String getValidationMessage(WebDriver driver, String locatorType, String...dynamicValues) {
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, getDynamicXpath(locatorType, dynamicValues)));
	}
	protected Boolean isImageLoad(WebDriver driver, String locatorType, String...dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	protected void waitForElementVisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicityWait=new WebDriverWait(driver, longTimeout);
		explicityWait.until(ExpectedConditions.visibilityOf(getElement(driver, getDynamicXpath(locatorType, dynamicValues))));
	}
	protected void waitForAllElementVisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicityWait=new WebDriverWait(driver, longTimeout);
		explicityWait.until(ExpectedConditions.visibilityOfAllElements(getElements(driver, getDynamicXpath(locatorType, dynamicValues))));
	}
	protected void waitForElementClickable(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicityWait= new WebDriverWait(driver, longTimeout);
		explicityWait.until(ExpectedConditions.elementToBeClickable(getElement(driver, getDynamicXpath(locatorType, dynamicValues))));
	}
	protected void waitForElementInvisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicityWait=new WebDriverWait(driver, longTimeout);
		explicityWait.until(ExpectedConditions.invisibilityOf(getElement(driver, getDynamicXpath(locatorType, dynamicValues))));
	}
	protected void waitForAllElementInvisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicityWait=new WebDriverWait(driver, longTimeout);
		explicityWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, getDynamicXpath(locatorType, dynamicValues))));
	}
	protected void waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicityWait=new WebDriverWait(driver, longTimeout);
		explicityWait.until(ExpectedConditions.alertIsPresent());
	}
	public AbstractPage openPageAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, AbstractPageUI.SIDEBAR_LINK, pageName);
		clickToElement(driver, AbstractPageUI.SIDEBAR_LINK, pageName);
		switch(pageName) {
		case "customer-info active":
			return PageGeneratorManager.getToCustomerInfoLink(driver);
		case "customer-addresses inactive":
			return PageGeneratorManager.getToAddressLink(driver);
		case "customer-orders inactive":
			return PageGeneratorManager.getToOrderLink(driver);
		case "downloadable-products inactive":
			return PageGeneratorManager.getToDownloadableLink(driver);
		case "back-in-stock-subscriptions inactive":
			return PageGeneratorManager.getToSubscriptionLink(driver);
		case "reward-points inactive":
			return PageGeneratorManager.getToRewardLink(driver);
		case "change-password inactive":
			return PageGeneratorManager.getToChangePasswordLink(driver);
		case "customer-reviews inactive":
			return PageGeneratorManager.getToMyProductReviewLink(driver);
		default:
			throw new RuntimeException("Invalid page name at My account area.");
		}
	}
	@Step ("Open register page at header by name:{driver} {pagename}")
	public AbstractPage openPageAtHeaderByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, AbstractPageUI.HEADER_LINK, pageName);
		clickToElement(driver, AbstractPageUI.HEADER_LINK, pageName);
		switch(pageName) {
		case "ico-register":
			return PageGeneratorManager.openRegisterPage(driver);
		case "ico-login":
			return PageGeneratorManager.openLoginPage(driver);
		case "ico-wishlist":
			return PageGeneratorManager.openWishlistPage(driver);
		case "ico-cart":
			return PageGeneratorManager.openShoppingCartPage(driver);
		case "ico-logout":
			return PageGeneratorManager.getToLogoutLink(driver);
		case "ico-account":
			return PageGeneratorManager.openMyAccountPage(driver);
		default:
			throw new RuntimeException("Invalid page name at My account area.");
		}
	}
	public HomePageObject openHomepage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.HOMEPAGE_LINK);
		clickToElement(driver, AbstractPageUI.HOMEPAGE_LINK);
		return PageGeneratorManager.getToHomePageLink(driver);
		
	}
	public SearchPageObject clickToSearchLink(WebDriver driver) {
	// TODO Auto-generated method stub
		waitForElementClickable(driver, AbstractPageUI.SEARCH_LINK);
		clickToElement(driver, AbstractPageUI.SEARCH_LINK);
		return PageGeneratorManager.getToSearchLink(driver);
	}
	public String castRestParameter(String locator, String...values) {
		locator=String.format(locator, (Object[])values);
		return locator;	
	}
	public String getQuantity(WebDriver driver) {
		// TODO Auto-generated method stub
		hoverMouse(driver, AbstractPageUI.HEADER_LINK, "ico-cart");
		return getTextElement(driver, AbstractPageUI.PRODUCT_QUANTITY);
	}
	public String getProductShoppingCart(WebDriver driver) {
		// TODO Auto-generated method stub
		hoverMouse(driver, AbstractPageUI.HEADER_LINK, "ico-cart");
		return getTextElement(driver, AbstractPageUI.PRODUCT_NAME);
	}
	public String getProductTotalPrice(WebDriver driver) {
		hoverMouse(driver, AbstractPageUI.HEADER_LINK, "ico-cart");
		return getTextElement(driver, AbstractPageUI.PRODUCT_PRICE);
	}
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	public void waitToElementInvisible(WebDriver driver, String locator, String...dynamicValues) {
		By byLocator=By.xpath(getDynamicXpath(locator, dynamicValues));
		WebDriverWait explicityWait=new WebDriverWait(driver, shortTimeout);
		overrideGlobalTimeout(driver, shortTimeout);
		explicityWait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
		overrideGlobalTimeout(driver, longTimeout);
	}
	public boolean isElementUndisplayed(WebDriver driver, String locator, String...dynamicValues) {
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements=getElements(driver, locator, dynamicValues);
		overrideGlobalTimeout(driver, longTimeout);
		if (elements.size()==0) {
			return true;
		} else if (elements.size()>0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
		
	}
	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}
	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie: cookies) {
			driver.manage().addCookie(cookie);
		}
	}
	public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	protected int longTimeout=30;
	protected int shortTimeout=10;
	public static int getRandomNumber() {
		Random rand=new Random();
		return rand.nextInt(9999);
	}
	public void sleepInSecond(long second) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(second*1000);
		}catch (InterruptedException e) {
		}
	}
}
