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
import com.training.pom.AllPostPOM;
import com.training.pom.LoginPOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddPost {


	private WebDriver driver; 
	private String baseUrl; 
	private LoginPOM loginPOM; 
	private AllPostPOM postPOM;
	private AddPostPOM addpostPOM;
	
	
	private static Properties properties; 
	private ScreenShot screenShot; 
	
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		/*driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		postsPOM= new PostsPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
		*/
	}


	@BeforeMethod
	public void beforeMethod() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		postPOM = new AllPostPOM(driver);
		addpostPOM = new AddPostPOM(driver);
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
	public void NewPost() throws InterruptedException {
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); 
			screenShot.captureScreenShot("First");
			postPOM.clickPostslink();
			screenShot.captureScreenShot("PostsLink");
			addpostPOM.addNewPosts();
			screenShot.captureScreenShot("AddNewPosts");
			addpostPOM.sendaddTitle("New Launches 123456");
			screenShot.captureScreenShot("AddTitle");
			addpostPOM.sendaddContent("New Launch in Home - 123456");
			screenShot.captureScreenShot("AddContent");
			addpostPOM.clickPublish();
			Thread.sleep(3000);
			screenShot.captureScreenShot("Publish button");
			addpostPOM.publishMsg();
			screenShot.captureScreenShot("PublishMessage");
			
	}
	
}
