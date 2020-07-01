package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	public void clkAddNewFeature() {
		Actions act = new Actions(driver);
		act.moveToElement(addnewfeature).build().perform();
		act.moveToElement(addnewfeature).click().perform();
	}
	public void sendNewFeaturetxtbx(String newfeaturetxtbx) {
		this.newfeaturetxtbx.sendKeys(newfeaturetxtbx);
		
	}
	
}
