//Test case no RETC_046
//Test case to create property details based by selecting feature & regions

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
		//Click on Properties tab
		createpropertyPOM.clickProperties();
		screenShot.captureScreenShot("Properties Link");
		//Verify if the Properties title on the page
		createpropertyPOM.getPropertiesTitle();
		screenShot.captureScreenShot("Properties Title111");
		//click on Add New button under Properties section
		createpropertyPOM.clickAddNew();
		screenShot.captureScreenShot("Add New property");
		//Add the property title in the property title field
		createpropertyPOM.enterAddNewTitle("Prestige Title111");
		//Add the data in the textbox field
		createpropertyPOM.enterTextBox("HomeTown");
		//Click on the feature in the added features checkbox section
		createpropertyPOM.clickFeatureChkBox();
		//Click on the region in the Added Regions section
		createpropertyPOM.clickRegionChkBox();
		screenShot.captureScreenShot("Add New property Details");
		//added wait for Publish button to become clickable
		Thread.sleep(3000);
		//Click on Publish button
		addpostPOM.clickPublish();
		Thread.sleep(3000);
		screenShot.captureScreenShot("Publish button for Property");
		//Verify the publish message is displayed after clicking on publish button 
		addpostPOM.publishMsg();
		screenShot.captureScreenShot("PublishMessage");
		
}
	
	
}
