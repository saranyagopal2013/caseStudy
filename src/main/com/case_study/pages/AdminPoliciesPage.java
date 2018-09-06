package com.case_study.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPoliciesPage extends Page {
	
	@FindBy(id="renew")
	private WebElement renewPolicy;
	
	@FindBy(id="cancel")
	private WebElement cancelPolicy;
	
	
	
	
	public AdminPoliciesPage(WebDriver driver)
	 {
			super(driver);
	 		this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	
	public void renewPolicy()
	{
		
		this.renewPolicy.click();
		assertTrue("In policy renew page",RenewSuccess.isDisplayed());
		
		
	}

	public void cancelPolicy()
	{
		
		this.cancelPolicy.click();
		assertTrue("In policy cancel page",CancelSuccess.isDisplayed());
		
	}

}
