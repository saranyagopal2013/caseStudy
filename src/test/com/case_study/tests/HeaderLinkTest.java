package com.case_study.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.case_study.pages.HomePage;
import com.case_study.pages.LoginPage;

public class HeaderLinkTest {
	
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
			home.clickHome();
			Thread.sleep(3000);
			
			home.clickGetQuoteLink();
			driver.navigate().back();
			Thread.sleep(3000);
			
			home.clickRetriveQuoteLink();
			driver.navigate().back();
			Thread.sleep(3000);
			
			home.clickMyPolicyLink();
			driver.navigate().back();
			Thread.sleep(3000);
			
			home.clickLogoutLink();
		
			Thread.sleep(3000);
			

}
}