package com.acme.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import com.acme.GenericLibrary.BaseTest;
import com.acme.GenericLibrary.WebDriverCommonLib;

public class PotentialPage {
	
	
	
	@FindBy(xpath = "(//input[@name='chk'])[2]") private WebElement chechbox;
	@FindBy(xpath = "//input[@value='Create Task']") private WebElement createtaskbtn;
	
	@FindBy(xpath = "//a[text()='Call']") private WebElement calllink;
	@FindBy(xpath = "//a[text()='3']") private WebElement calander3;
	@FindBy(xpath = "//select[@name='property(status)']")private WebElement Statusdropdown;
	@FindBy(xpath = "//select[@name='property(priority)']")private WebElement prioritydropdown;
	@FindBy(xpath = "//input[@value='Save']") private WebElement savebtn;
	@FindBy(xpath = "//img[@title='Subject Name Lookup']") private WebElement subjectNameLookup;
	
	public PotentialPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void createnewpotential() throws Throwable
	{
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		chechbox.click();
		
		createtaskbtn.click();
		subjectNameLookup.click();
		//wlib.windowtitles();
		wlib.getWindowHandleclick("Zoho CRM - Subject Name Lookup", calllink);
		
		wlib.selectOptionsBytext(Statusdropdown, "Completed");
		wlib.selectOptionsBytext(prioritydropdown, "Highest");
		savebtn.click();
	}
	
	
	
	
 
}
