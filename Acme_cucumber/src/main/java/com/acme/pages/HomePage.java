package com.acme.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acme.GenericLibrary.BaseTest;

public class HomePage {
	
	
	@FindBy(xpath = "//a[text()='Leads']") private WebElement leadstab;
	@FindBy(xpath = "//a[text()='Invoices']") private WebElement invoicetab;
	@FindBy(id="scrollright") private WebElement scrollright;
	@FindBy(xpath = "//a[text()='Purchase Orders']") private WebElement purchasetab;
	@FindBy(xpath = "//a[text()='Potentials']") private WebElement potentialtab;
	@FindBy(xpath = "//a[text()='Accounts']") private WebElement AccountsTab;
 	
	
	public HomePage()
	{
		PageFactory.initElements(BaseTest.driver,this);
	}


	public WebElement getInvoicetab() {
		return invoicetab;
	}


	public void setInvoicetab(WebElement invoicetab) {
		this.invoicetab = invoicetab;
	}


	public WebElement getLeadstab() {
		return leadstab;
	}
	
	public void setLeadstab(WebElement leadstab) {
		this.leadstab = leadstab;
	}
	
	
	public WebElement getScrollright() {
		return scrollright;
	}


	public void setScrollright(WebElement scrollright) {
		this.scrollright = scrollright;
	}


	public void clickonleads()
	{
		leadstab.click();
	}
	
	public void clickoninvoices()
	{
		invoicetab.click();
	}
	public void scrooltorignt() throws Throwable
	{
		for(int i=1;i<55;i++)
		{
			scrollright.click();
			
		}
		
	}
	
	public void clickonpurchasetab()
	{
		purchasetab.click();
	}
	
	public void clickonpotentials()
	{
		potentialtab.click();
	}
	
	public void ClickOnAccounts()
	{
		AccountsTab.click();
	}

}
