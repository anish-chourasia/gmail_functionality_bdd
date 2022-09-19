package stepDefinitions;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPO;
import utilities.Driver;

public class loginSteps extends Driver{
	
	
	@Given("User Launch driver (.*)$")
	public void user_launch_driver_safari(String browser) throws Throwable {
		driver=Driver.setUp(browser);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {
		driver.get(url);
		System.out.println(driver);
		Thread.sleep(3000);
		
	}

	@When("User enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		System.out.println(driver);
		LoginPO.inputBox_LoginUsername(driver, username);
		Thread.sleep(3000);
		LoginPO.inputBox_LoginPassword(driver, password);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
	    LoginPO.clickNextButtonToLogin(driver);
	    Thread.sleep(5000);
	}

	@Then("^Page Title should contain (.*)$")
	public void page_title_should_contain_username(String username) throws InterruptedException {
	   
		String actualHomePageTitle = LoginPO.getHomePageTitle(driver);
	    System.out.println(actualHomePageTitle);
	    Thread.sleep(2000);
	    Assert.assertTrue(actualHomePageTitle.contains(username));
	    
	    Thread.sleep(3000);  
	    
	}
	
	
}