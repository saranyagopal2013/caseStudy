package com.case_study.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyPolicyPage extends Page{
	
WebDriver driver;
	
	@FindBy(name="startDate")
	private WebElement policyStartDate;
	
	@FindBy(xpath="//input[@type='checkbox']")
	 private WebElement checkBox;
	
	@FindBy(xpath="//input[@value='Submit']")
	 private WebElement submit;
	
	public BuyPolicyPage(WebDriver driver)
	 {
			super(driver);
	 		this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	
	public void buyPolicy(String start)
	{
		this.policyStartDate.sendKeys();
		this.checkBox.click();
		this.submit.click();
		assertTrue("In policy confirmation page",policyConfirm.isDisplayed());
		
	}

}
