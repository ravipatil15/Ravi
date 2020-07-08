package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddFeaturePOM {
	
	private WebDriver driver; 
	
	public AddFeaturePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@id='property_feature-add-toggle']")
	private WebElement addnewfeature;
	
	@FindBy(xpath= "//input[@id='newproperty_feature']")
	private WebElement newfeaturetxtbx;
	
	@FindBy(xpath= "//select[@id='newproperty_feature_parent']")
	private WebElement selectfeature;

	@FindBy(xpath= "//input[@id='property_feature-add-submit']")
	private WebElement clkaddsubmit;
	
	
	//label[contains (text(),' Test Feature-135')]
	
	
	public void clkAddNewFeature() { // method to click on add new feature 
		Actions act = new Actions(driver);
		act.moveToElement(addnewfeature).build().perform();
		act.moveToElement(addnewfeature).click().perform();
	}
	public void sendNewFeaturetxtbx(String newfeaturetxtbx) { // method to add new feature name
		this.newfeaturetxtbx.sendKeys(newfeaturetxtbx);
		
	}
	public void selectFeature() { // method to select feature name from drop down
		Select seladdfeature= new Select (selectfeature);
		seladdfeature.selectByIndex(1);
		}
	public void clkAddSubmit() { // method to click on submit to add the feature
		this.clkaddsubmit.click();
	}
	
	public void viewSelectFeature(String newfeaturetxtbx) { // method to select the newly added feature
		String beforeXpath="//label[contains (text(),'";
		String afterXpath="')]";
		String selFeatureXpath=beforeXpath+newfeaturetxtbx+afterXpath;
		driver.findElement(By.xpath(selFeatureXpath)).click();
		////label[contains(text(),'testing')]
				}
}
