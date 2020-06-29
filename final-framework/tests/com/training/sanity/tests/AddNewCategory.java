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
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddNewCategory {
 
	private WebDriver driver; 
	private String baseUrl; 
	private LoginPOM loginPOM; 
	
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
	public void addCategory() throws InterruptedException {
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); 
			screenShot.captureScreenShot("First");
			loginPOM.clickPostslink();
			screenShot.captureScreenShot("PostsLink");
			loginPOM.clickCategory();
			screenShot.captureScreenShot("ClickCategory");
			loginPOM.categoryTitle();
			loginPOM.addCategoryTitle();
			screenShot.captureScreenShot("CategoryTitle");
			loginPOM.CategoryName("New Launches - 204");
			loginPOM.SlugName("launch 204");
			loginPOM.DescriptionName("New Launches of Villas, apartments, flats");
			screenShot.captureScreenShot("AddCatogory");
			loginPOM.SubmitButton();
			screenShot.captureScreenShot("AddCatogorybutton");
			Thread.sleep(10000);
			loginPOM.sendSearchCat("New Launches -204");
			loginPOM.clickSeach();
			Thread.sleep(3000);
			screenShot.captureScreenShot("CategoryLabel");
	}

}
