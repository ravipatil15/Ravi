//Test case no RETC_048
//Test case to add new region while creating a new properties page


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
import com.training.pom.AddRegionPOM;
import com.training.pom.CreatePropertyPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddRegion {
	private WebDriver driver;
	private String baseUrl; 
	private LoginPOM loginPOM;
	private AddPostPOM addpostPOM;
	private CreatePropertyPOM createpropertyPOM;
	private AddRegionPOM addregionPOM;
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
		addregionPOM= new AddRegionPOM(driver);
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
	public void AddRegiontest() throws InterruptedException{
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
		//Click on the Add New Region button in the Region's section
		addregionPOM.clkAddNewRegion();
		screenShot.captureScreenShot("Add New Region checkbox");
		//Add a Region Title
		addregionPOM.sendNewRegionTxtBx("New City - 123");
		//Select a Region value from the Parent Region dropdown
		addregionPOM.selectRegion();
		screenShot.captureScreenShot("Add New Region details");
		//click on add new region button
		addregionPOM.clkRegionSubmit();
		Thread.sleep(3000);
		//Refresh the page
		driver.navigate().refresh();
		screenShot.captureScreenShot("checkRegion details");
		//Enter properties title
		createpropertyPOM.enterAddNewTitle("Prestige Title- To test region 02");
		//Enter value in textbox field
		createpropertyPOM.enterTextBox("HomeTown - to test Region 02");
		//Select a feature value
		//verify if the newly added feature is shown
		addregionPOM.viewRegionFeature("New City - 123");
		screenShot.captureScreenShot("Add New region checkbox selected");
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
