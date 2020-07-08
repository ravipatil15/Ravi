package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePropertyPOM {
	
private WebDriver driver; 
	
	public CreatePropertyPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='wp-has-submenu wp-not-current-submenu menu-top menu-icon-property']/div[@class='wp-menu-name']")
	private WebElement properties;
	
	@FindBy(xpath="//h1")
	private WebElement propertiestitle;
	
	@FindBy(xpath="//a[@class='page-title-action']")
	private WebElement addnew;
	
	@FindBy(xpath="//h1[@class='wp-heading-inline']")
	private WebElement addnewtitle;	

	@FindBy(xpath="//input[@id='title']")
	private WebElement enternewtitle;	
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement entertextbox;		
	
	@FindBy(xpath="//input[@id='in-property_feature-1371']")
	private WebElement featurechkbox;
	
	@FindBy(xpath="//input[@id='in-region-1348']")
	private WebElement regionchkbox;
	
	public void clickProperties() {
		this.properties.click();
	}
	public void getPropertiesTitle() {
		this.propertiestitle.getText();
		String actualTitle= this.propertiestitle.getText();
		String expectedTitle = "Properties";
		assertEquals(actualTitle,expectedTitle);
		
	}
	public void clickAddNew() {
		this.addnew.click();
	}
	public void getAddNewTitle() {
		this.addnewtitle.getText();
		String actualtitle= this.addnewtitle.getText();
		String expectedtitle= "Add Property";
		assertEquals(actualtitle,expectedtitle);
	}
	public void enterAddNewTitle(String EnterTitle) {
		
		this.enternewtitle.sendKeys(EnterTitle);
		//this.enternewtitle.sendKeys(Keys.TAB);
		//this.enternewtitle.sendKeys(EnterTitle);
	}
	public void enterTextBox(String EnterTextBox) {
		
		this.entertextbox.sendKeys(EnterTextBox);
	}
	public void clickFeatureChkBox() {
		this.featurechkbox.click();
	}
	public void clickRegionChkBox() {
		this.regionchkbox.click();
	}
	
	
}
