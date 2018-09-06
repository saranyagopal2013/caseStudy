package com.case_study.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
	
	WebDriver driver;
	
	public Page()
	{
		
	}
	
	public Page(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='getbutton']")
	protected WebElement getQuoteButton;
	
	@FindBy(name="residenceType")
	protected WebElement residenceType;
	
	@FindBy(name="fname")
	protected WebElement firstName;
	
	@FindBy(id="marketvalue")
	protected WebElement marketValue;
	
	@FindBy(xpath="//h2[text()='Coverage Details']")
	protected WebElement coverage;
	

	@FindBy(xpath="//h2[text()='Policy Confirmation']")
	protected WebElement policyConfirm;
	
	@FindBy(xpath="//h2[text()='Get Started Page']")
	protected WebElement homePage;
	
	@FindBy(xpath="//h2[text()='Admin Screen']")
	protected WebElement AdminPage;
	
	@FindBy(xpath="//h2[text()='Policy Renewed Successfully']")
	protected WebElement RenewSuccess;
	
	@FindBy(xpath="//h2[text()='Policy Cancelled Successfully']")
	protected WebElement CancelSuccess;
	

	
	

}
