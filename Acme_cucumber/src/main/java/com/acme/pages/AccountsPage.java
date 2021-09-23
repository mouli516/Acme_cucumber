package com.acme.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acme.GenericLibrary.BaseTest;

public class AccountsPage {
	@FindBy(xpath = "//input[@value='New Account']") private WebElement newaccounttab;
	
	
	public  AccountsPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void clickOnNewAccountTab()
	{
		newaccounttab.click();
	}

}