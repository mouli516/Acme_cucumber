package com.Acme.Leads;

import com.acme.GenericLibrary.BaseTest;
import com.acme.GenericLibrary.FileLibrary;
import com.acme.GenericLibrary.IAutoconstant;
import com.acme.GenericLibrary.WebDriverCommonLib;
import com.acme.pages.CreateLead;
import com.acme.pages.HomePage;
import com.acme.pages.LeadPage;
import com.acme.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CreateNewLead implements IAutoconstant {
	
	
	@Given("User Opened the Chrome browser")
	public void OpenBrowser() throws Throwable
	{
		BaseTest bt = new BaseTest();
		bt.openbrowser();
	}
	
	@And("user is on Acme_Crm Loginpage")
	public void user_is_on_Acme_Crm_Loginpage() throws Throwable
	{
		FileLibrary flib = new FileLibrary();
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		wlib.verify(wlib.getpagetitle(), flib.getpropdata("LoginTitle",PROP_PATH )," Home Page");
	}
	
	@When("^User Enter valid (.*) and (.*)$")
	public void user_enter_valid_User_name_and_passsword(String UserName,String Passsword) throws Throwable {
		
	    LoginPage lp = new LoginPage();
	    lp.logintoapp(UserName, "123456");
	}
	
	@And("User is on Home Page")
	public void User_is_on_Home_Page() throws Throwable{
		FileLibrary flib = new FileLibrary();
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		wlib.verify(wlib.getpagetitle(), flib.getpropdata("hometitle",PROP_PATH )," Home Page");
	}

	@When("User Clicks On LeadsButton")
	public void user_clicks_on_leads_button() {
		HomePage hp = new HomePage();
		hp.clickonleads();
	    
	}

	@And("User is On LeadsPage")
	public void user_is_on_leads_page() throws Throwable {
		
		FileLibrary flib = new FileLibrary();
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		wlib.verify(wlib.getpagetitle(), flib.getpropdata("L",PROP_PATH )," Home Page");
	    
	}

	@When("User ClicksOn Create New LeadButton")
	public void user_clicks_on_create_new_lead_button() {
		
	   LeadPage lp = new LeadPage();
	   lp.clickonnewleadd();
	}
	@And("User in New Leads Page")
	public void User_is_On_LeadsPage() throws Throwable
	{
		FileLibrary flib = new FileLibrary();
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		wlib.verify(wlib.getpagetitle(), flib.getpropdata("createLead",PROP_PATH )," Home Page");
	}

	@When("^User Enters (.*) and (.*) in Comopany and Lastname textFields$")
	public void user_enters_wipro_and_mouli_nadipena_in_comopany_and_lastname_text_fields(String company,String lastname) {
		
		CreateLead cnl = new CreateLead();
		cnl.createlead(company,lastname);
	   
	}

	@Then("NewLead Created and user is in Lead Details Page")
	public void new_lead_created_and_user_is_in_lead_details_page() throws Throwable {
		
		FileLibrary flib = new FileLibrary();
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		wlib.verify(wlib.getpagetitle(), flib.getpropdata("LeadsDetails",PROP_PATH )," Home Page");
		
	   
	}
	

}
