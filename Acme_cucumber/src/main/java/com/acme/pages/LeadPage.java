package com.acme.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acme.GenericLibrary.BaseTest;

public class LeadPage {
	
	@FindBy(xpath = "//input[@value='New Lead']") private WebElement newleadbtn;
	
	public LeadPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}

	public WebElement getNewleadbtn() {
		return newleadbtn;
	}

	public void setNewleadbtn(WebElement newleadbtn) {
		this.newleadbtn = newleadbtn;
	}
	
	public void clickonnewleadd()
	{
		newleadbtn.click();
	}

}
