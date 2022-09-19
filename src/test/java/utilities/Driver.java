package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	protected static WebDriver driver;

	@SuppressWarnings("deprecation")
	// @BeforeTest
	public static WebDriver setUp(String browser) throws IOException {

		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				System.out.println("Chrome Browser Selected\n");
			}

			if (browser.equalsIgnoreCase("safari")) {
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println("Safari Browser Selected\n");
			}

			if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
//			driver.get(prop.getProperty("testUrl"));
				driver.manage().window().maximize();
				System.out.println("Firefox Browser Selected\n");
			}
		}
		return driver;
	}

	// @AfterTest
	public static void tearDown(WebDriver driver) {
		driver.close();
		System.out.println("Driver teardown successful\n");
	}

}