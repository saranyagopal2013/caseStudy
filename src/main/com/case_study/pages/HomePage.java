package com.case_study.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page
{
 WebDriver driver;
	 
	 @FindBy(className="home")
	  private WebElement homeLink;
	 
	 @FindBy(id="getQuote")
	   private WebElement getQuoteLink;
	 
	 @FindBy(className="retrieveQuote")
	 private WebElement retriveQuoteLink;
	 
	 @FindBy(id="mypolicy")
	 private WebElement myPolicyLink;
	 
	 @FindBy(className="logout")
	 private WebElement logoutLink;
	 
	 @FindBy(xpath="//a[@class='getbutton']")
	 protected WebElement getQuote;
	 
	 @FindBy(xpath="//a[@class='quotebutton']")
	 private WebElement retriveQuote;
	 
	 public HomePage(WebDriver driver)
	 
	 {
		 	super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	
	 public void clickGetQuote()
	 {

        getQuote.click();
        assertTrue("HomeLocation page is displayed",residenceType.isDisplayed());
        
     }
	 public void clickRetriveQuote()
	 {

        retriveQuote.click();
     }
	 public void clickHome()
	 {

        homeLink.click();
        assertTrue("Home page is displayed",homePage.isDisplayed());
     }
	 public void clickGetQuoteLink()
	 {

		 getQuoteLink.click();
		  assertTrue("HomeLocation page is displayed",residenceType.isDisplayed());
		 
     }
	 public void clickRetriveQuoteLink()
	 {

		 retriveQuoteLink.click();
		 
		 
     }
	 public void clickMyPolicyLink()
	 {

		 myPolicyLink.click();
     }
	 
	 public void clickLogoutLink()
	 {

		 logoutLink.click();
     }
	 
	
	
}
