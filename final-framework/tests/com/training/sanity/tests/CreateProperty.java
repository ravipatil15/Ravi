package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddPostPOM;
import com.training.pom.CreatePropertyPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CreateProperty {
	private WebDriver driver;
	private String baseUrl; 
	private LoginPOM loginPOM;
	private AddPostPOM addpostPOM;
	private CreatePropertyPOM createpropertyPOM;
	private static Properties properties; 
	private ScreenShot screenShot; 
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	
	}
 
	@BeforeMethod
	public void beforeMethod() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		addpostPOM = new AddPostPOM(driver);
		createpropertyPOM= new CreatePropertyPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	@Test
	public void CreatePropertyName() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		createpropertyPOM.clickProperties();
		screenShot.captureScreenShot("Properties Link");
		createpropertyPOM.getPropertiesTitle();
		screenShot.captureScreenShot("Properties Title");
		createpropertyPOM.clickAddNew();
		screenShot.captureScreenShot("Add New property");
		createpropertyPOM.enterAddNewTitle("Prestige Title");
		createpropertyPOM.enterTextBox("HomeTown");
		createpropertyPOM.clickFeatureChkBox();
		createpropertyPOM.clickRegionChkBox();
		screenShot.captureScreenShot("Add New property Details");
		Thread.sleep(3000);
		addpostPOM.clickPublish();
		Thread.sleep(3000);
		screenShot.captureScreenShot("Publish button for Property");
		addpostPOM.publishMsg();
		screenShot.captureScreenShot("PublishMessage");
		
}
	
	
}
