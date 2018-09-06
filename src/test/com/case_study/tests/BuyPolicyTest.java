package com.case_study.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.case_study.pages.BuyPolicyPage;
import com.case_study.pages.CoverageDetailsPage;
import com.case_study.pages.GetQuoteLocationPage;
import com.case_study.pages.HomeOwnerDetailsPage;
import com.case_study.pages.HomePage;
import com.case_study.pages.LoginPage;
import com.case_study.pages.Page;
import com.case_study.pages.PropertyDetailsPage;
import com.case_study.pages.QuoteDetailsPage;

public class BuyPolicyTest {
	
	 WebDriver driver;
	 LoginPage login;
	 @BeforeClass
	    public static void setProperty() 
	    {
	        System.setProperty("webdriver.chrome.driver", 
	                "C:\\Users\\Student\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    }
	@Before
	public void setup() throws InterruptedException {
		
		
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       
        
	}
	
	
	@Test
	public void BuyPolicyTesting() throws InterruptedException 
	{
		 driver.get("http://localhost:8080/HomeInsurance");

			login=new LoginPage(driver);
			login.loginTo("sara","sara123");
			
			HomePage home=new HomePage(driver);
			home.clickGetQuote();
		
			GetQuoteLocationPage location=new GetQuoteLocationPage(driver);
			location.locationDetails(1,"5400 South","hidden ridge","new jersey","maple shade","657840",1);
		
			HomeOwnerDetailsPage homeOwner=new HomeOwnerDetailsPage(driver);
			homeOwner.HomeOwnerDetails("siddharth","saravanan","1995-03-06","no","654321678","sudraja@gmail.com");
		
			PropertyDetailsPage property=new PropertyDetailsPage(driver);
			property.PropertyDetails("350000","2004","4500",1,1,1,1,1,true);
		
			CoverageDetailsPage coverage=new CoverageDetailsPage(driver);
			coverage.coverageDetails();
			
			QuoteDetailsPage quote=new QuoteDetailsPage(driver);
			quote.quoteDetails();
			quote.quoteSummary();
			
			BuyPolicyPage policy=new BuyPolicyPage(driver);
			policy.buyPolicy("2018-09-04");
			

	}

	@After
	public void close() 
	{
		driver.close();
	}
}
