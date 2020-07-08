package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddRegionPOM {
private WebDriver driver; 
	
	public AddRegionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@id='region-add-toggle']")
	private WebElement addnewregion;
	
	@FindBy(xpath= "//input[@id='newregion']")
	private WebElement newregiontxtbx;
	
	@FindBy(xpath= "//select[@id='newregion_parent']")
	private WebElement selectregion;

	@FindBy(xpath= "//input[@id='region-add-submit']")
	private WebElement addregionsbt;
	
	
	//label[contains(text(),' test')]
	
	
	public void clkAddNewRegion() { // method to click on the Add New Region button
		
		Actions act = new Actions(driver);
		act.moveToElement(addnewregion).build().perform();
		act.moveToElement(addnewregion).click().perform();
		
	}
	public void sendNewRegionTxtBx(String newregiontxtbx) { //method to add region name
		this.newregiontxtbx.sendKeys(newregiontxtbx);
		
	}
	public void selectRegion() { // method to select parent region from dropdown
		Select seladdfeature= new Select (selectregion);
		seladdfeature.selectByIndex(1);
		}
	public void clkRegionSubmit() { // method to click on submit button to add region
		this.addregionsbt.click();
	}
	
	public void viewRegionFeature(String newregiontxtbx) { // method to select the newly added region from the regions section
		String beforeXpath="//label[contains (text(),'";
		String afterXpath="')]";
		String selFeatureXpath=beforeXpath+newregiontxtbx+afterXpath;
		driver.findElement(By.xpath(selFeatureXpath)).click();
		}
}

