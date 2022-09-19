package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPO {

	static By useAnotherAccount_Element=By.xpath("//*[text()='Use another account']");
//	static By loginUsername_Box_Element=By.xpath("//*[text()='Email or phone']");
	static By loginUsername_Box_Element=By.cssSelector("#identifierId");
	static By loginClickNext_Element=By.xpath("//*[text()='Next']");
//	static By loginPassword_Box_Element=By.xpath("//*[text()='Enter your password']");
	static By loginPassword_Box_Element=By.cssSelector("#password div.aCsJod.oJeWuf div div.Xb9hP input"); //inspect - copy selector
	
	static By homePageTitle_Element = By.cssSelector("head title");

	
	public static void click_UseAnotherAccount(WebDriver driver)	{
		driver.findElement(useAnotherAccount_Element).click();
	}
	
	public static void inputBox_LoginUsername(WebDriver driver, String username) throws InterruptedException	{
		driver.findElement(loginUsername_Box_Element).sendKeys(username);
		driver.findElement(loginClickNext_Element).click();
	}
	
	public static void inputBox_LoginPassword(WebDriver driver, String password)	{
		driver.findElement(loginPassword_Box_Element).sendKeys(password);
	}
	
	public static void clickNextButtonToLogin(WebDriver driver)	{
		driver.findElement(loginClickNext_Element).click();
	}
	
	public static String getHomePageTitle(WebDriver driver)	{
		return driver.findElement(homePageTitle_Element).getText();
	}
}

