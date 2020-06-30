package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllPostPOM {
private WebDriver driver; 
	
	public AllPostPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='edit.php']/div[@class='wp-menu-name']")
	private WebElement clickposts; 
	
	@FindBy(xpath="//a[@class='wp-first-item current']")
	private WebElement clickallposts; 

	@FindBy(xpath="//input[@id='cb-select-9935']")
	private WebElement checkbox;
	
	@FindBy(xpath="//a[@aria-label='“New Launches 123” (Edit)']")
	private WebElement hoveronpost; 
	
	@FindBy(xpath="//a[@aria-label='Move “New Launches 123” to the Trash']")
	private WebElement clickontrash; 
	
	@FindBy(xpath="//div[@id='message']/p[contains(text(),'1 post moved to the Trash.')]")
	private WebElement delmessage;
	
		
	public void clickPostslink() throws InterruptedException {
		Actions act= new Actions(driver);
		//act.moveToElement(clickposts).build().perform();
		//Thread.sleep(2000);
		act.moveToElement(clickposts).click().perform();
	}
	
	public void clickAllPosts() {
		this.clickallposts.click();
				
	}
	
	public void hoverOnPosts() {
		Actions act1= new Actions(driver);
		act1.moveToElement(hoveronpost).build().perform();
		
	}
	public void clickOnTrash() {
		this.clickontrash.click();
		
	}
	
	public void delMessage() {
		this.delmessage.getText();
		String actualTitle=this.delmessage.getText();
		String expectedTitle="1 post moved to the Trash. Undo";
		assertEquals(actualTitle,expectedTitle);
		
		
	}

	
}
