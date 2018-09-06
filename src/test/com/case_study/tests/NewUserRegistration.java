package com.case_study.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.case_study.pages.NewUserRegistrationPage;

public class NewUserRegistration {
	
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
	
	
	@Test// vaild input data
	public void AnewUserRegistrationSucess() 
	{
		NewUserRegistrationPage register=new NewUserRegistrationPage(driver);
		register.newUserRegistration("siddha2014","sidd1234","sidd1234");
		
		
		
    }
	
//	@Test//invaild data input
//	public void BnewUserRegistrationFail1() 
//	{
//
//		NewUserRegistrationPage register=new NewUserRegistrationPage(driver);
//		register.newUserRegistration("sara","sara123","sara123");
//		
//		
//    }
//	
//	@Test//mismatch password and re password
//	public void CnewUserRegistrationFail2() 
//	{
//
//		NewUserRegistrationPage register=new NewUserRegistrationPage(driver);
//		register.newUserRegistration("sara","sara1234","sara123");
//		
//		
//    }
}
