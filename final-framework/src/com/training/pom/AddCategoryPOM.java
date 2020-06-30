package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPOM {
private WebDriver driver; 
	
	public AddCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
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
