package com.case_study.pages;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class LoginPage  extends HomePage{

	 WebDriver driver;
	 
	 @FindBy(id="username")
	 private WebElement userName;
	 
	 @FindBy(id="password")
	 private WebElement password;
	 
	 @FindBy(xpath="//input[@value='Login']")
	 private WebElement login;
	 
	 @FindBy(id="new")
	 private WebElement register;
//	 
//	 public LoginPage()
//	 {
//		 
//	 }
	 
	 public LoginPage(WebDriver driver)
	 
	 {
		 	super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);

	  }

	 public void setUserName(String name) 
	 {
		userName.sendKeys(name);
	 }

	 public void setPassword(String pass) 
	 {
		password.sendKeys(pass);
	 }

	
	 public void clickLogin()
	 {

        login.click();
     }
	 
	 public void registerUser()
	 {

        register.click();
     }
	

	    /**

	     * This POM method will be exposed in test case to login in the application

	     * @param strUserName

	     * @param strPasword

	     * @return
	     * @throws InterruptedException 

	     */

	 	
	    public void loginTo(String strUserName,String strPasword) throws InterruptedException
	    
	    {
	    	
	    	Thread.sleep(5000);
	    	   //	assertTrue("Login page displauyed",userName.isDisplayed());
	    		this.setUserName(strUserName);
		        this.setPassword(strPasword);
		        this.clickLogin();
		        
		        assertTrue("Home page is displayed",getQuote.isDisplayed());
		        
         }
 public void loginToAdmin(String strUserName,String strPasword) throws InterruptedException
	    
	    {
	    	
	    	Thread.sleep(5000);
	    	   //	assertTrue("Login page displauyed",userName.isDisplayed());
	    		this.setUserName(strUserName);
		        this.setPassword(strPasword);
		        this.clickLogin();
		        
		        assertTrue("Admin page is displayed",AdminPage.isDisplayed());
		        
         }

	 
	 
	 
	
	 

}
