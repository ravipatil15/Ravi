package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPostPOM {
private WebDriver driver; 
	
	public AddPostPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="	//a[@href='post-new.php']")
	private WebElement addnewpost; 

	@FindBy(xpath="//input[@id='title']")
	private WebElement addtitle; 
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement addContent; 	
	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement clickpublish;
	
	@FindBy(xpath="//div[@id='message']/p[contains(text(),'Post published.')]")
	private WebElement publishmsg;
	
	public void addNewPosts() { // method for clicking on Add Post Links
		this.addnewpost.click();
		
	}
	
	public void sendaddTitle(String addTitle) { // method for writing title name
		this.addtitle.clear();
		this.addtitle.sendKeys(addTitle);
	
	}
	public void sendaddContent(String addContent) { // method for writing data in the content field
		this.addContent.clear();
		this.addContent.sendKeys(addContent);
	}
	public void clickPublish() throws InterruptedException { // method to click on publish button and to scroll up
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-200)", clickpublish);// to scroll up for Add Feature TC
		Thread.sleep(2000);
		
		Actions act= new Actions(driver);
		act.moveToElement(clickpublish).click().perform();
				
	}
	public void publishMsg() throws InterruptedException { //method for verifying the publish message
		
		this.publishmsg.getText();
		String actualTitle=this.publishmsg.getText();
		String expectedTitle="Post published. View post";
		assertEquals(actualTitle,expectedTitle);
		
		
	}
	
}
