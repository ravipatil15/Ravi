package com.training.pom;

import static org.testng.Assert.assertEquals;

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
	
	public void addNewPosts() {
		this.addnewpost.click();
		
	}
	
	public void sendaddTitle(String addTitle) {
		this.addtitle.clear();
		this.addtitle.sendKeys(addTitle);
	
	}
	public void sendaddContent(String addContent) {
		this.addContent.clear();
		this.addContent.sendKeys(addContent);
	}
	public void clickPublish() throws InterruptedException {
		Actions act= new Actions(driver);
		act.moveToElement(clickpublish).build().perform();
		Thread.sleep(5000);
		act.moveToElement(clickpublish).click().perform();
		
		//this.clickpublish.click();
		
	}
	public void publishMsg() {
		this.publishmsg.getText();
		String actualTitle=this.publishmsg.getText();
		String expectedTitle="Post published. View post";
		assertEquals(actualTitle,expectedTitle);
		
		
	}
	
}
