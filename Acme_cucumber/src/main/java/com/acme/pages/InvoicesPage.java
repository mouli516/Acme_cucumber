package com.acme.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acme.GenericLibrary.BaseTest;

public class InvoicesPage {
	
	
	@FindBy(xpath = "//input[@value='New Invoice']") private WebElement NewInvoiceTab;
	
	public InvoicesPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	
	public void ClickOnNewInvoicetab()
	{
		NewInvoiceTab.click();
	}

}

