package com.case_study.pages;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverageDetailsPage 
{
	WebDriver driver;
	 
	@FindBy(id="addinfo")
	private WebElement additionalInfoLink;

	@FindBy(xpath="//input[@value='Proceed to Buy']")
	private WebElement buyButton;
	
	public CoverageDetailsPage(WebDriver driver)
	 {
	 		this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	
	public void coverageDetails()
	{ 
		additionalInfoLink.click();
		
		driver.navigate().back();
	
	   this.buyButton.click();
	}
		
		
		
	

}
