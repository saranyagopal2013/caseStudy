package com.case_study.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSearchPage extends Page 
{
WebDriver driver;
	
	@FindBy(id="username")
	private WebElement searchTab;
	
	@FindBy(xpath="//input[@type='submit']")
	 private WebElement submit;
	
	@FindBy(name="home")
	private WebElement homeLink;
	
	@FindBy(name="logout")
	private WebElement logoutLink;
	
	
	public AdminSearchPage(WebDriver driver)
	 {
			super(driver);
	 		this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	
	public void adminSearch(String username)
	{
		this.searchTab.sendKeys(username);
		this.submit.click();
		//assertTrue("In policy confirmation page",policyConfirm.isDisplayed());
		
	}

}
