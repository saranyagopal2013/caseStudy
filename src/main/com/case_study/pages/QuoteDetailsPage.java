package com.case_study.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuoteDetailsPage {
	
	WebDriver driver;
	
	@FindBy(name="summary")
	private WebElement quoteSummary;
	
	@FindBy(xpath="//input[value='Buy Policy']")
	private WebElement buyPolicy;
	
	public QuoteDetailsPage(WebDriver driver)
	 {
	 		this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	
	public void quoteDetails()
	{
		this.quoteSummary.click();
	}
	
	public void quoteSummary()
	{
		this.buyPolicy.click();
	}

}
