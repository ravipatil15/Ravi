// TC RETC_016 - to check if admin can add post to trash from All posts link

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
import com.training.pom.AllPostPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AllPost {
	private WebDriver driver; 
	private String baseUrl; 
	private LoginPOM loginPOM; 
	private AllPostPOM postPOM;
	
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
	public void loginPassTest() throws InterruptedException {
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); 
			screenShot.captureScreenShot("First");
			postPOM.clickPostslink(); // click on Posts link
			screenShot.captureScreenShot("PostsLink");
			postPOM.clickAllPosts(); // click on All Posts Link
			screenShot.captureScreenShot("AllPostsLink");
			postPOM.hoverOnPosts(); // Hover on the post displayed in the All Posts section
			Thread.sleep(3000); // to check if the trash option is displayed
			screenShot.captureScreenShot("HoverOnPost");
			postPOM.clickOnTrash(); // click on trash link to move the post to trash
			screenShot.captureScreenShot("ClickOnTrash");
			postPOM.delMessage(); // to verify the message for the moving the post to trash
			screenShot.captureScreenShot("Delete Message");
			
	}
	

}
