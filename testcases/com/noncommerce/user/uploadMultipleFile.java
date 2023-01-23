package com.noncommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseObject.DataGritPageObject;
import baseObject.PageGeneratorManager;
import baseObject.uploadFilePageObject;
import basePage.BaseTest;

public class uploadMultipleFile extends BaseTest{
	private WebDriver driver;
	private uploadFilePageObject uploadFile;
	String fileName1="Screenshot_30.png";
	String fileName2="Screenshot_31.png";
	String fileName3="Screenshot_32.png";
	String fileName4="Screenshot_33.png";
	String fileName5="Screenshot_38.png";
	String[] multipleFileName= {fileName1, fileName2, fileName3, fileName4, fileName5};
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver= getBrowserDriver(browserName);
		uploadFile=PageGeneratorManager.uploadFilePage(driver);
	}
	@Test
	public void TC_01_Upload_One_File_Per_Time() {
		uploadFile.uploadMultipleFiles(driver, fileName1);
		Assert.assertTrue(uploadFile.isFileLoadedByName(fileName1));
		uploadFile.clickToStartButton();
		Assert.assertTrue(uploadFile.isFileUploadedByName(fileName1));
		Assert.assertTrue(uploadFile.isImageLoaded(fileName1));
}
	@Test
	public void TC_01_Upload_Multiple_File_Per_Time() {
		uploadFile.refreshPage(driver);
		uploadFile.uploadMultipleFiles(driver, multipleFileName);
		Assert.assertTrue(uploadFile.isFileLoadedByName(fileName1));
		Assert.assertTrue(uploadFile.isFileLoadedByName(fileName2));
		Assert.assertTrue(uploadFile.isFileLoadedByName(fileName3));
		Assert.assertTrue(uploadFile.isFileLoadedByName(fileName4));
		Assert.assertTrue(uploadFile.isFileLoadedByName(fileName5));
		uploadFile.clickToStartButton();
		Assert.assertTrue(uploadFile.isFileUploadedByName(fileName1));
		Assert.assertTrue(uploadFile.isFileUploadedByName(fileName2));
		Assert.assertTrue(uploadFile.isFileUploadedByName(fileName3));
		Assert.assertTrue(uploadFile.isFileUploadedByName(fileName4));
		Assert.assertTrue(uploadFile.isFileUploadedByName(fileName5));
	}
}