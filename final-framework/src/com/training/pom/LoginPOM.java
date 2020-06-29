package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[@href='edit.php']/div[@class='wp-menu-name']")
	private WebElement clickposts; 
	
	@FindBy(xpath="//a[@class='wp-first-item current']")
	private WebElement clickallposts; 

	@FindBy(xpath="//a[@aria-label='“Poorvankara Builders” (Edit)']")
	private WebElement hoveronpost; 
	
	@FindBy(xpath="//a[@aria-label='Move “Poorvankara Builders” to the Trash']")
	private WebElement clickontrash; 
	
	@FindBy(xpath="	//a[@href='post-new.php']")
	private WebElement addnewpost; 

	@FindBy(xpath="//input[@id='title']")
	private WebElement addtitle; 
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement addContent; 	
	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement clickpublish;
	
	@FindBy(xpath="//a[@href='edit-tags.php?taxonomy=category']")
	private WebElement clickCategory;	
	
	@FindBy(xpath="//h1[@class='wp-heading-inline']")
	private WebElement categoryTitle;	
	
	@FindBy(xpath="//h2[contains(text(),'Add New Category')]")
	private WebElement addNewCategoryTitle;
	
	@FindBy(xpath="//input[@id='tag-name']")
	private WebElement addCategoryName;
	
	@FindBy(xpath="//input[@id='tag-slug']")
	private WebElement enterSlugName;
	
	@FindBy(xpath="//textarea[@id='tag-description']")
	private WebElement enterDescription;	
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement submitbt;
	
	@FindBy(xpath="//input[@id='tag-search-input']")
	private WebElement searchCat;
	
	@FindBy(xpath="//input[@id='search-submit']")
	private WebElement Searchbtn;
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
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
	public void ClickOnTrash() {
		this.clickontrash.click();
		
	}
	
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
	public void clickCategory() {
		this.clickCategory.click();
				
	}
	public void categoryTitle() {

		String actualTitle = this.categoryTitle.getText();
		String expectedTitle= "Categories";
		assertEquals(actualTitle,expectedTitle);
	
				
	}
	public void addCategoryTitle() {

		String actualTitle = this.addNewCategoryTitle.getText();
		String expectedTitle= "Add New Category";
		assertEquals(actualTitle,expectedTitle);
	
	}
	public void CategoryName(String addCategoryName) {
		this.addCategoryName.sendKeys(addCategoryName);
	}
	
	public void SlugName(String enterSlugName) {
		this.enterSlugName.sendKeys(enterSlugName);
	}

	public void DescriptionName(String enterDescription) {
		this.enterDescription.sendKeys(enterDescription);
	}
	
	public void SubmitButton() throws InterruptedException {
		Actions act= new Actions(driver);
		act.moveToElement(submitbt).build().perform();
		Thread.sleep(3000);
		act.moveToElement(submitbt).click().perform();
		
	}

	public void sendSearchCat(String addNewCategoryName) {
		this.searchCat.clear();
		this.searchCat.sendKeys(addNewCategoryName);
	}
	
	public void clickSeach() {
		this.Searchbtn.click();
		
	}

}



