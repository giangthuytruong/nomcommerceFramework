package baseObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basePage.AbstractPage;
import pageUIs.uploadFilePageUI;

public class uploadFilePageObject extends AbstractPage{
	private WebDriver driver;
	public uploadFilePageObject(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isFileLoadedByName(String fileName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, uploadFilePageUI.FILENAME_LOADED, fileName);
		return isControlDisplayed(driver, uploadFilePageUI.FILENAME_LOADED, fileName);
	}
	public void clickToStartButton() {
		// TODO Auto-generated method stub
		List<WebElement> startButtons=getElements(driver, uploadFilePageUI.START_BUTTON);
		for (WebElement startButton: startButtons) {
			startButton.click();
			sleepInSecond(1);
		}
	}
	public boolean isFileUploadedByName(String fileName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, uploadFilePageUI.FILENAME_UPLOADED, fileName);
		return isControlDisplayed(driver, uploadFilePageUI.FILENAME_UPLOADED, fileName);
	}
	public boolean isImageLoaded(String fileName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, uploadFilePageUI.IMAGE, fileName);
		return isImageLoad(driver, uploadFilePageUI.IMAGE, fileName);
	}
}
