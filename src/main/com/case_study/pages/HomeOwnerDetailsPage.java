package com.case_study.pages;



import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeOwnerDetailsPage extends Page {
	
	
	 WebDriver driver;
	 
		@FindBy(name="fname")
		private WebElement firstName;

		@FindBy(name="lname")
		private WebElement lastName;

		@FindBy(id="dob")
		private WebElement dateOfBirth;

		@FindBy(id="yes")
		private WebElement retiredTrue;
		
		@FindBy(id="no")
		private WebElement retiredFalse;

		@FindBy(name="ssn")
		private WebElement ssn;

		@FindBy(id="email")
		private WebElement email;
		
		@FindBy(xpath="//input[@value='Continue']")
		private WebElement continueButton;
		
		
		
		public HomeOwnerDetailsPage(WebDriver driver)
		 {		super(driver);
		 		this.driver = driver;
		        PageFactory.initElements(driver, this);
		 }
		
		public void SetRetired(String retired)
		{
			if(retired.equals("yes"))
			{
				this.retiredTrue.click();
			}
			else
				this.retiredFalse.click();
		}
		
		public void HomeOwnerDetails(String fname,String lname,String dob,String retired,String ssn,String email) throws InterruptedException
	    
	    {
			this.firstName.sendKeys(fname);
			this.lastName.sendKeys(lname);
			this.dateOfBirth.sendKeys(dob);
			this.SetRetired(retired);
			this.ssn.sendKeys(ssn);
			this.email.sendKeys(email);
			this.continueButton.click();
			Thread.sleep(5000);
			 assertTrue("HomeLocation page is displayed", marketValue.isDisplayed());
			
			
			
		}
		


}
