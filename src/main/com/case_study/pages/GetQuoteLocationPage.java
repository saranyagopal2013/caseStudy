package com.case_study.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GetQuoteLocationPage extends Page
{
	 WebDriver driver;
	 
	@FindBy(name="residenceType")
	private WebElement residenceType;

	@FindBy(name="Address_Line_1")
	private WebElement addressLine1;

	@FindBy(name="Address_Line_2")
	private WebElement addressLine2;

	@FindBy(id="state")
	private WebElement state;

	@FindBy(name="city")
	private WebElement city;

	@FindBy(id="zipcode")
	private WebElement zipcode;

	@FindBy(name = "ResidentUse")
	private WebElement residenceUse;
	
	@FindBy(xpath="//input[@value='Continue']")
	 private WebElement Continue;

	
	
    public GetQuoteLocationPage(WebDriver driver)
	 {
    		super(driver);
	 		this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	
	
	public void setResidenceType() {
		residenceType.click();
	}
	
	 public  void residenceTypeDropDown(int index) {
	      Select drop = new Select(residenceType);
	      drop.selectByIndex(index);  
	}



	public void setAddressLine1(String address1) {
		addressLine1.sendKeys(address1);
	}


	public void setAddressLine2(String address2) {
		addressLine2.sendKeys(address2);
	}

	public void setState(String State) {
		state.sendKeys(State);
	}

	public void setCity(String City) {
		city.sendKeys(City);
	}

	public void setZipcode(String Zipcode) {
		zipcode.sendKeys(Zipcode);
	}


	public void setResidenceUse() {
		residenceUse.click();
	}
	 public  void residenceUseDropDown(int index1) {
	      Select drop = new Select(residenceUse);
	      drop.selectByIndex(index1);  
	}

	public void setContinue() throws InterruptedException {
		Continue.click();
		Thread.sleep(3000);
		 assertTrue("HomeLocation page is displayed",firstName.isDisplayed());
	}
	

	public void locationDetails(int index,String address1,String address2,String state,String city,String zipcode,int index2) throws InterruptedException
    
    {
		this.residenceTypeDropDown(index);
		this.setAddressLine1(address1);
		this.setAddressLine2(address2);
		this.setState(state);
		this.setCity(city);
		this.setZipcode(zipcode);
		this.residenceUseDropDown(index2);
		this.setContinue();
		
		
		
     }
	
	
  
}
