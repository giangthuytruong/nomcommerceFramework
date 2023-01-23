package baseObject;

import org.openqa.selenium.WebDriver;

import basePage.AbstractPage;
import pageUIs.MyAccountUI;

public class MyAccountObject extends AbstractPage {
	private WebDriver driver;
	
	public MyAccountObject(WebDriver mappingDriver) {
		driver=mappingDriver;
	}

	
	
}
