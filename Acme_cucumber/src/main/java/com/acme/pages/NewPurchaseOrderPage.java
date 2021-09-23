package com.acme.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acme.GenericLibrary.BaseTest;
import com.acme.GenericLibrary.WebDriverCommonLib;

public class NewPurchaseOrderPage {
	
	@FindBy(xpath = "//input[@name='property(Subject)']") private WebElement subjectTextBox;
	@FindBy(xpath = "//img[@title='Vendor Name Lookup']") private WebElement vendorLookupBtn;
	@FindBy(xpath = "//a[text()='sanju']") private WebElement vender;
	@FindBy(xpath = "//img[@title='Product Name Lookup']") private WebElement productLookBtn;
	@FindBy(xpath = "//a[text()='silver']") private WebElement product;
	@FindBy(xpath = "//input[@name='property(txtQty1)']") private WebElement Qtybtn;
	@FindBy(xpath = "//img[@title='PriceBook Name Lookup']") private WebElement pricebooklookbtn;
	@FindBy(xpath = "//a[text()='selling price']") private WebElement selllist;
	@FindBy(xpath = "(//input[@name='Button' and @value='Save'])[2]") private  WebElement savebtn;
	
	public NewPurchaseOrderPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void selectExistingvender(String subject) throws Throwable
	{
		subjectTextBox.sendKeys(subject);
		vendorLookupBtn.click();
		WebDriverCommonLib wb = new WebDriverCommonLib();
		wb.getWindowHandleclick("Zoho CRM - Vendor Name Lookup", vender);
		Thread.sleep(2000);
		wb.scrolldown(savebtn);
		productLookBtn.click();
		wb.getWindowHandleclick("Zoho CRM - Product Name Lookup", product);
		Qtybtn.sendKeys("5");
		pricebooklookbtn.click();
		wb.getWindowHandleclick("Zoho CRM - Price Book Name Lookup", selllist);
		savebtn.click();
	}
 
}
