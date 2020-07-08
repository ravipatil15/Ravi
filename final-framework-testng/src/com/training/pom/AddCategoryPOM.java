package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	//@FindBy(xpath="//a[@class='row-title']")
	//private WebElement veiwCatTitle;
			
	public void clickCategory() { // method to click on category link
		this.clickCategory.click();
				
	}
	public void categoryTitle() { // method to verify the category page title

		String actualTitle = this.categoryTitle.getText();
		String expectedTitle= "Categories";
		assertEquals(actualTitle,expectedTitle);
	
				
	}
	public void addCategoryTitle() { // method to verify the add new category page title

		String actualTitle = this.addNewCategoryTitle.getText();
		String expectedTitle= "Add New Category";
		assertEquals(actualTitle,expectedTitle);
	
	}
	public void CategoryName(String addCategoryName) { // method to add category name
		this.addCategoryName.sendKeys(addCategoryName);
	}
	
	public void SlugName(String enterSlugName) { // method to add slug name
		this.enterSlugName.sendKeys(enterSlugName);
	}

	public void DescriptionName(String enterDescription) { //method to add description
		this.enterDescription.sendKeys(enterDescription);
	}
	
	public void SubmitButton() throws InterruptedException {// method to click on submit button
		/*
		Actions act= new Actions(driver);
		act.moveToElement(submitbt).build().perform();
		Thread.sleep(3000);// wait added to make sure submit button is enabled
		act.moveToElement(submitbt).click().perform();
		*/
		this.submitbt.click();
	}

	public void sendSearchCat(String addNewCategoryName) { //method to search the category which was added
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-200)", addNewCategoryName);// to scroll up to click on search category field				
		this.searchCat.sendKeys(addNewCategoryName);
	}
	
	public void clickSeach() { //method to click on search button to search the newly added category
		this.Searchbtn.click();
		
	}
	

}
