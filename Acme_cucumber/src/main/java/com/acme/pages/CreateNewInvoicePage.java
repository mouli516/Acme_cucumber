package com.acme.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acme.GenericLibrary.BaseTest;
import com.acme.GenericLibrary.WebDriverCommonLib;

public class CreateNewInvoicePage {
	
	
	@FindBy(name = "property(Subject)") private WebElement SubjectButton;
	@FindBy(xpath = "//img[@title='SalesOrder Lookup']") private WebElement SalesOredrLookUp;
	@FindBy(xpath = "//img[@title='Account Name Lookup']") private WebElement AccountNameLookUp;
	@FindBy(xpath = "//a[text()='QSpiders Banaswadi']") private WebElement SelectAccount;
	@FindBy(xpath = "//a[text()='bluewings']") private WebElement SelectProduct;
	@FindBy(xpath = "//img[@title='Product Name Lookup']") private WebElement ProductNameLookUp;
	@FindBy(name = "property(txtQty1)") private WebElement QntyTextBox;
	@FindBy(xpath = "//img[@title='PriceBook Name Lookup']") private WebElement PriceBookLookUp;
	@FindBy(xpath = "(//a[text()='selling price'])[1]") private WebElement SelectPrice;
	@FindBy(xpath = "(//input[@value='Save'])[2]") private WebElement SaveButton;
	
	public CreateNewInvoicePage()
	{
		PageFactory.initElements(BaseTest.driver,this);
	}
	
	
	public void CreateNewInvoices(String Subjectname,String Qnty) throws Throwable
	{
		SubjectButton.sendKeys(Subjectname);
		AccountNameLookUp.click();
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		wlib.getWindowHandleclick("Zoho CRM - Account Name Lookup", SelectAccount);
		ProductNameLookUp.click();
		wlib.getWindowHandleclick("Zoho CRM - Product Name Lookup", SelectProduct);
		QntyTextBox.sendKeys(Qnty);
		PriceBookLookUp.click();
		wlib.getWindowHandleclick("Zoho CRM - Price Book Name Lookup", SelectPrice);
		wlib.scrolldown(SaveButton);
		SaveButton.click();
	}
	
	
	
	
	
	
	

}
