package com.acme.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acme.GenericLibrary.BaseTest;

public class CreateLead {
	
	@FindBy(xpath = "//input[@name='property(Company)']") private WebElement companytextfld;
	@FindBy(xpath = "//input[@name='property(Last Name)']") private WebElement lastnametextfld;
    @FindBy(xpath = "(//input[@value='Save'])[2]") private WebElement savebtn;
	
	public CreateLead()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}


	public WebElement getCompanytextfld() {
		return companytextfld;
	}


	public void setCompanytextfld(WebElement companytextfld) {
		this.companytextfld = companytextfld;
	}


	public WebElement getLastnametextfld() {
		return lastnametextfld;
	}


	public void setLastnametextfld(WebElement lastnametextfld) {
		this.lastnametextfld = lastnametextfld;
	}
	
	public void createlead(String company,String lastname)
	{
		companytextfld.sendKeys(company);
		lastnametextfld.sendKeys(lastname);
		savebtn.click();       
	}
	
}
