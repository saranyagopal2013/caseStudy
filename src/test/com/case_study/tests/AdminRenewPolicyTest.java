package com.case_study.tests;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.case_study.pages.AdminPoliciesPage;
import com.case_study.pages.AdminSearchPage;
import com.case_study.pages.LoginPage;

public class AdminRenewPolicyTest 
{
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
	public void AdminRenewPolicyTesting() throws InterruptedException 
	{
		 driver.get("http://localhost:8080/HomeInsurance");

			login=new LoginPage(driver);
			login.loginToAdmin("sid","sid123");
			
			AdminSearchPage admin=new AdminSearchPage(driver);
			admin.adminSearch("sara");
			
			AdminPoliciesPage policy=new AdminPoliciesPage(driver);
			policy.renewPolicy();
			
			
	}

}
