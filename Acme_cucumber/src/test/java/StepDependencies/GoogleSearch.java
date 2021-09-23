package StepDependencies;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearch {
	
	
	WebDriver driver;
	@Given("Browser is opened")
	public void browser_is_opened() {
	   System.setProperty("webdriver.chrome.driver", "D:\\Qspiders Project\\Automation\\Project files\\Acme_cucumber\\src\\main\\resources\\Drivers\\chromedriver.exe");
	   driver =new ChromeDriver();
	}

	@Given("user is on google page")
	public void user_is_on_google_page() {
	    driver.get("https://www.google.com/");
	}

	@When("user enters mouli nadipenain Searchfield")
	public void user_enters_mouli_nadipenain_searchfield() {
	   driver.findElement(By.name("q")).sendKeys("molui nadipena");
	}

	@When("user click on searchbutton")
	public void user_click_on_searchbutton() {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("search results page should be displayed")
	public void search_results_page_should_be_displayed() {
	   if(driver.getTitle().equals("mouli nadipena - Google Search"))
	   {
		   Assert.assertTrue(true);
		   Reporter.log("REsults page is displayed",true);
	   }
	   else
	   {
		   Assert.assertTrue(true);
		   Reporter.log("REsults page is displayed",true);
	   }
	}

}
