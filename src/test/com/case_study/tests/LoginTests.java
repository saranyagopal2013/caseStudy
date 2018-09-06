package com.case_study.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.case_study.pages.HomePage;
import com.case_study.pages.LoginPage;


public class LoginTests {
	
	
	 WebDriver driver;
	 @BeforeClass
	    public static void setProperty() 
	    {
	        System.setProperty("webdriver.chrome.driver", 
	                "C:\\Users\\Student\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    }
	@Before
	public void setup() {
		
		
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/HomeInsurance");
	}
	
	
	@Test()
	public void verifyLoginSucess() throws InterruptedException 
	{
		

		   LoginPage login=new LoginPage(driver);
		   login.loginTo("sara","sara123");
		   HomePage home=new HomePage(driver);
	       home.clickGetQuote();
	  
	   
	 
	    
	     
	     
		
	}
	
	
//	@Test
//	public void verifyLoginFail() 
//	{
//		
//	   	 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("sara1");
//	   	 driver.findElement(By.cssSelector("input[id='password']")).sendKeys("sara12");
//	   	 driver.findElement(By.xpath("//input[@value='Login']")).click();
//	   	
//		
//	}
	
	@After
	public void tearDown() 
	{
		
		driver.close();
		
	}
	

}
