package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePagePO {

	static By clickComposeTab_Element=By.xpath("//*[text()='Compose']");
	static By emailRecipientBox_Element=By.xpath("//*[@name='to']");
	static By emailSubjectBox_Element=By.xpath("//*[@name='subjectbox']");
	static By emailBody_Element=By.xpath("//*[@aria-label='Message Body'][@role='textbox']");
	static By click_EmailSendButton_Element=By.xpath("//*[text()='Send']");
	
	static By clickSentTab_Element=By.xpath("//*[@aria-label='Sent']");
	static By openSentEmailUsingGivenSubject_Element=By.xpath("//table[@role='grid']//td[@class='xY a4W']/div[@role='link']/div/div[@class='y6']/span[@class='bog']/span[text()='Incubyte']");
	
	static By deleteGroupOptions_Element=By.xpath("//div[@class='iH bzn']//div[@class='G-tF']//div[2][@class='G-Ni G-aE J-J5-Ji']\n");
			
	static By deleteSentEmail_Element=By.xpath("//div[@aria-label='Delete']//div[@class='asa']");
	
	static By logout_OpenAccount_Element = By.cssSelector("a[class='gb_A gb_La gb_f'][href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com&service=mail']");
	static By logout_ClickSignOut_Element = By.xpath("//*[text()='Sign out']");
	
	
	static WebDriverWait wait=null;
	
	public static void click_ComposeTab(WebDriver driver)	{
		driver.findElement(clickComposeTab_Element).click();
	}
	
	public static void newEmailRecipientBox(WebDriver driver, String recipient)	{
		driver.findElement(emailRecipientBox_Element).sendKeys(recipient);
	}
	
	public static void newEmailSubjectBox(WebDriver driver, String subject)	{
		driver.findElement(emailSubjectBox_Element).sendKeys(subject);
	}
	
	public static void newEmailBodyBox(WebDriver driver, String emailbody)	{
		driver.findElement(emailBody_Element).sendKeys(emailbody);
	}
	
	public static void click_EmailSendButton(WebDriver driver)	{
		driver.findElement(click_EmailSendButton_Element).click();
	}
	
	public static void clickSentTab(WebDriver driver)	{
		driver.findElement(clickSentTab_Element).click();
	}
	
	public static void openSentEmailUsingGivenSubject(WebDriver driver)	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(60, 1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(openSentEmailUsingGivenSubject_Element));
		driver.findElement(openSentEmailUsingGivenSubject_Element).click();
	}
	
	public static void deleteLastSentEmail(WebDriver driver) throws InterruptedException	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(60, 1));
		
		WebElement groupElement = driver.findElement(deleteGroupOptions_Element);
		Actions action=new Actions(driver);
		action.moveToElement(groupElement).build().perform();
		
		driver.findElement(deleteSentEmail_Element).click();
		Thread.sleep(4000);
	}
	
	public static void logoutFromGmail(WebDriver driver) throws InterruptedException	{
		driver.findElement(logout_OpenAccount_Element).click();
		Thread.sleep(3000);
		driver.switchTo().frame("account");
		driver.findElement(logout_ClickSignOut_Element).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		
	}
	
}