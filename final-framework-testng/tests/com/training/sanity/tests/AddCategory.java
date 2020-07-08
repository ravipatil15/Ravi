// Simple TC RETC_018 - to verify if admin can add category

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
			postPOM.clickPostslink();//click on Posts Link
			screenShot.captureScreenShot("PostsLink");
			addcategoryPOM.clickCategory(); // Click on Add Category link
			screenShot.captureScreenShot("ClickCategory");
			addcategoryPOM.categoryTitle(); // verify the category title page
			addcategoryPOM.addCategoryTitle();// verify the add category title 
			screenShot.captureScreenShot("CategoryTitle");
			addcategoryPOM.CategoryName("New Launches Title- 12"); //add the Title name
			addcategoryPOM.SlugName("Launch Slug - 123456"); // add the slug details
			addcategoryPOM.DescriptionName("New Launches of Villas, apartments, flats - 12345");// add description detials
			screenShot.captureScreenShot("AddCatogory");
			addcategoryPOM.SubmitButton(); // click on submit button
			screenShot.captureScreenShot("AddCatogorybutton");
			driver.navigate().refresh();// refresh the page after adding category
			addcategoryPOM.sendSearchCat("New Launches Title- 12"); // enter the category name in the search box
			addcategoryPOM.clickSeach();// search for the newly added category 
			screenShot.captureScreenShot("CategoryLabel");
			
			 
			
	}

}
