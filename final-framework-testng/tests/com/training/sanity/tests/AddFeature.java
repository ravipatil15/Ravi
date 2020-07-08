//Test case no RETC_047
//Test case to add new features while creating a new properties page


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
import com.training.pom.AddFeaturePOM;
import com.training.pom.AddPostPOM;
import com.training.pom.CreatePropertyPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddFeature {
	private WebDriver driver;
	private String baseUrl; 
	private LoginPOM loginPOM;
	private AddPostPOM addpostPOM;
	private CreatePropertyPOM createpropertyPOM;
	private AddFeaturePOM addfeaturePOM;
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
		addfeaturePOM= new AddFeaturePOM(driver);
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
	public void AddFeaturetest() throws InterruptedException{
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		//Click on properties tab
		createpropertyPOM.clickProperties();
		screenShot.captureScreenShot("Properties Link");
		//Verify the properties title
		createpropertyPOM.getPropertiesTitle();
		screenShot.captureScreenShot("Properties Title");
		//Click on the Add New Button
		createpropertyPOM.clickAddNew();
		screenShot.captureScreenShot("Add New property Title");
		//Click on the Add New Feature button in the features section
		addfeaturePOM.clkAddNewFeature();
		screenShot.captureScreenShot("Add New Feature checkbox");
		//Add a Feature Title
		addfeaturePOM.sendNewFeaturetxtbx("Testing 556");
		//Select a Feature value from the Parent Feature dropdown
		addfeaturePOM.selectFeature();
		screenShot.captureScreenShot("Add New Feature details");
		//click on add new feature button
		addfeaturePOM.clkAddSubmit();
		Thread.sleep(3000);
		//Refresh the page
		driver.navigate().refresh();
		screenShot.captureScreenShot("checkFeature details");
		//Enter properties title
		createpropertyPOM.enterAddNewTitle("Prestige Title- to test feature 156");
		//Enter value in textbox field
		createpropertyPOM.enterTextBox("HomeTown - to test feature 156");
		//Select a feature value
		//verify if the newly added feature is shown
		addfeaturePOM.viewSelectFeature("Testing 556");
		screenShot.captureScreenShot("Add New Feature checkbox selected");
		//Select a region value
		createpropertyPOM.clickRegionChkBox();
		screenShot.captureScreenShot("Add New property Details");
		//Wait added for Publish button become clickable
		Thread.sleep(3000);
		//Click on Publish button
		addpostPOM.clickPublish();
		Thread.sleep(3000);
		screenShot.captureScreenShot("Publish button for Property");
		//Verifying the publish message
		addpostPOM.publishMsg();
		screenShot.captureScreenShot("PublishMessage");
		
}
	

}
