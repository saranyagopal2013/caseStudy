package com.case_study.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PropertyDetailsPage extends Page{
	
	WebDriver driver;
	 
		@FindBy(id="marketvalue")
		private WebElement marketValue;

		@FindBy(name="yearbuilt")
		private WebElement yearOfBuilt;

		@FindBy(id="squarefootage")
		private WebElement squareFootage;

		@FindBy(name="dwellingtype")
		private WebElement dwellingType;

		@FindBy(name="roofmaterial")
		private WebElement roofMaterial;

		@FindBy(id="garagetype")
		private WebElement garageType;
		

		@FindBy(name="fullbath")
		private WebElement fullBaths;
		

		@FindBy(id="halfbath")
		private WebElement halfBaths;
		
		@FindBy(id="no")
		private WebElement SwimmingPoolFalse;
		
		@FindBy(id="yes")
		private WebElement SwimmingPoolTrue;
		
		@FindBy(xpath="//input[@value='Continue']")
		private WebElement continueButton;
		
		
		public PropertyDetailsPage(WebDriver driver)
		 {
		 		this.driver = driver;
		        PageFactory.initElements(driver, this);
		 }
		
		
		 public  void dwellingTypeDropDown(int index) {
		      Select drop = new Select(dwellingType);
		      drop.selectByIndex(index);  
		}
		 
		 public  void roofMaterialDropDown(int index) {
		      Select drop = new Select(roofMaterial);
		      drop.selectByIndex(index);  
		}
		 
		 public  void garageTypeDropDown(int index) {
		      Select drop = new Select(garageType);
		      drop.selectByIndex(index);  
		}
		 
		 public  void fullBathsDropDown(int index) {
		      Select drop = new Select(fullBaths);
		      drop.selectByIndex(index);  
		}
		 
		 public  void halfBathsDropDown(int index) {
		      Select drop = new Select(halfBaths);
		      drop.selectByIndex(index);  
		      
		}
		 
		 public void SetSwimmingPool(Boolean pool)
		 {
			 if(pool==true)
			 {
				 this.SwimmingPoolTrue.click();
			 }
			 else
			 {
				 this.SwimmingPoolFalse.click();
			 }
		 }
		 
		 
		 public void PropertyDetails(String marketvalue,String yearbuilt,String squarefoot,int dwellingtype,int roofmaterial,int garagetype,int fullbath,int halfbath,Boolean pool)
		    
		    {
				this.marketValue.sendKeys(marketvalue);
				this.yearOfBuilt.sendKeys(yearbuilt);
				this.squareFootage.sendKeys(squarefoot);
				this.dwellingTypeDropDown(dwellingtype);
				this.roofMaterialDropDown(roofmaterial);
				this.garageTypeDropDown(garagetype);
				this.fullBathsDropDown(fullbath);
				this.halfBathsDropDown(halfbath);
				this.SetSwimmingPool(pool);
				this.continueButton.click();
				assertTrue("In coverage Details Page",coverage.isDisplayed());
				
			}


}
