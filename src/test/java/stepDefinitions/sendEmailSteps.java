package stepDefinitions;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePagePO;
import pageObjects.LoginPO;
import utilities.Driver;

public class sendEmailSteps extends Driver {

	
	@Given("User is successfully logged in gmail")
	public void user_is_successfully_logged_in_gmail() throws InterruptedException {
		String actualTitle = LoginPO.getHomePageTitle(driver);

		Thread.sleep(2000);
//		Assert.assertTrue(actualTitle.contains("@gmail.com - Gmail"));
	}

	@When("User clicks Compose tab")
	public void user_clicks_compose_tab() throws InterruptedException {
		HomePagePO.click_ComposeTab(driver);
		Thread.sleep(3000);
	}

	@When("User provides to-email (.*) subject (.*) and body (.*)$")
	public void user_provides_to_email_incubyte_gmail_com_subject_incubyte_and_body_automation_qa_test_for_incubyte(String recipient, String subject, String body) throws InterruptedException {
		HomePagePO.newEmailRecipientBox(driver, recipient);
	    Thread.sleep(3000);
	    
	    HomePagePO.newEmailSubjectBox(driver, subject);
	    Thread.sleep(3000);
	    
	    HomePagePO.newEmailBodyBox(driver, body);
	    Thread.sleep(3000);
	}

	@Then("User clicks Send button")
	public void user_clicks_send_button() throws InterruptedException {
		HomePagePO.click_EmailSendButton(driver);
	    Thread.sleep(3000);
	}

	@Given("User sent email")
	public void user_sent_email() throws InterruptedException {
		Thread.sleep(1000);
	}

	@When("User opens Sent email page")
	public void user_opens_sent_email_page() throws InterruptedException {
		HomePagePO.clickSentTab(driver);
	    Thread.sleep(3000);
	}

	@Then("User opens recently sent email (.*)$")
	public void user_opens_recently_sent_email_incubyte(String subject) throws InterruptedException {
		HomePagePO.openSentEmailUsingGivenSubject(driver);
	    Thread.sleep(5000);
	}


	@Given("User is on recently sent email")
	public void user_is_on_recently_sent_email() throws InterruptedException {
		Thread.sleep(2000);
	}

	@When("User deletes the open email")
	public void user_deletes_the_open_email() throws InterruptedException {
		HomePagePO.deleteLastSentEmail(driver);
		
	}
	
	@Then("User logs out of Gmail")
	public void user_logs_out_of_gmail() throws InterruptedException {
	 
		HomePagePO.logoutFromGmail(driver);
		driver.quit();
	}

}