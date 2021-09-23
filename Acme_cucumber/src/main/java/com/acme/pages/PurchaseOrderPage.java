package com.acme.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acme.GenericLibrary.BaseTest;

public class PurchaseOrderPage {
	
	@FindBy(xpath = "//input[@value='New Purchase Order']") private WebElement newpurchasebutton;
	
	public PurchaseOrderPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void clickOnNewPurchaseButton()
	{
		newpurchasebutton.click();
	}

}
