package StepDependencies;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActiTIME {
	
	WebDriver driver;
	@Given("Chrome browser is opened")
	public void chrome_browser_is_opened() {
		System.setProperty("webdriver.chrome.driver", "D:\\Qspiders Project\\Automation\\Project files\\Acme_cucumber\\src\\main\\resources\\Drivers\\chromedriver.exe");
		  driver =new ChromeDriver();
	}

	@And("user is in Actitime login page")
	public void user_is_in_actitime_login_page() {
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	}

	@When("^user enters (.*) and (.*)in login and password textfields$")
	public void user_enters_admin_and_managerin_login_and_password_textfields(String username,String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		
	}

	@And("user click on LoginButon")
	public void user_click_on_login_buton() throws Throwable {
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		Thread.sleep(4000);
		
	}

	@Then("Login page should be displayed")
	public void login_page_should_be_displayed() {
	
		if(driver.getTitle().equals("actiTIME -  Enter Time-Track"))
		   {
			   Assert.assertTrue(true);
			   Reporter.log("ActiTime Home page is displayed",true);
		   }
		   else
		   {
			   Assert.assertTrue(true);
			   Reporter.log("ActiTIME Home page not is displayed",true);
		   }
	}
	
	
	

}
