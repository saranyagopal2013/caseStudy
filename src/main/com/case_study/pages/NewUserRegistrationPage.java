package com.case_study.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewUserRegistrationPage 
{
	WebDriver driver;

	@FindBy(name="regname")
	private WebElement userId;

	@FindBy(name="regpassword")
	private WebElement password;
	
	@FindBy(name="password_confirm")
	private WebElement rePassword;
	
	@FindBy(xpath="//input[@value='Register']")
	 private WebElement Register;
	
	public NewUserRegistrationPage(WebDriver driver)
	 {
	 		this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	
	public void newUserRegistration(String userid,String password,String reentryPassword)
	{   LoginPage l=new LoginPage(driver);
		l.registerUser();
		this.userId.sendKeys(userid);
		this.password.sendKeys(password);
		this.rePassword.sendKeys(reentryPassword);
		this.Register.click();
		
	}
	
	
	

}
