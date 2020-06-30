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
import com.training.pom.AddCategoryPOM;
import com.training.pom.AllPostPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCategory {
 
	private WebDriver driver; 
	private String baseUrl; 
	private LoginPOM loginPOM;
	private AllPostPOM postPOM;
	private AddCategoryPOM addcategoryPOM;
	
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
		postPOM = new AllPostPOM(driver);
		addcategoryPOM = new AddCategoryPOM(driver);
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
			postPOM.clickPostslink();
			screenShot.captureScreenShot("PostsLink");
			addcategoryPOM.clickCategory();
			screenShot.captureScreenShot("ClickCategory");
			addcategoryPOM.categoryTitle();
			addcategoryPOM.addCategoryTitle();
			screenShot.captureScreenShot("CategoryTitle");
			addcategoryPOM.CategoryName("New Launches - 111222");
			addcategoryPOM.SlugName("Launch Slug - 123456");
			addcategoryPOM.DescriptionName("New Launches of Villas, apartments, flats - 12345");
			screenShot.captureScreenShot("AddCatogory");
			addcategoryPOM.SubmitButton();
			screenShot.captureScreenShot("AddCatogorybutton");
			addcategoryPOM.sendSearchCat("New Launches - 111222");
			driver.navigate().refresh();
			addcategoryPOM.sendSearchCat("New Launches - 111222");
			addcategoryPOM.clickSeach();
			screenShot.captureScreenShot("CategoryLabel");
	}

}
