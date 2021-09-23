package com.acme.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acme.GenericLibrary.BaseTest;

public class LoginPage {
	
	@FindBy(xpath = "//input[@id='userName']") private WebElement username;
	@FindBy(name = "j_password") private WebElement password;
	@FindBy(xpath = "//input[@alt='Sign In']") private WebElement signinbtn;
	

	public LoginPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}


	public WebElement getUsername() {
		return username;
	}


	public void setUsername(WebElement username) {
		this.username = username;
	}


	public WebElement getPassword() {
		return password;
	}


	public void setPassword(WebElement password) {
		this.password = password;
	}


	public WebElement getSigninbtn() {
		return signinbtn;
	}


	public void setSigninbtn(WebElement signinbtn) {
		this.signinbtn = signinbtn;
	}
	public void logintoapp(String validUsername,String validpassword) throws Throwable
	{
		Thread.sleep(3000);
		username.sendKeys(validUsername);
		password.sendKeys(validpassword);
		signinbtn.click();
	}
}