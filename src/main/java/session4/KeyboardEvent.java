package session4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEvent {
	
	WebDriver driver;
	
	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void Keyboard() {
		
		/*
		 * ACTION CLASS:
		 * Actions action = new Actions(driver);
		 * action.sendKeys(Keys.ENTER).build().perform();
		 * Action Class required .build().perform();
		 * .KEYS has lots of keyboard options
		 */

			By USER_NAME_FIELD = By.xpath("//input[@id='username']");
			By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
			By LOGIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
			By DASHBOARD_HEADER_FIELD = By.xpath("//h2[contains(text(), 'Dashboard')]");

			String userName = "demo@techfios.com";
			driver.findElement(USER_NAME_FIELD).sendKeys(userName);
			driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
//			driver.findElement(LOGIN_BUTTON_FIELD).click();
			
			//Action Class
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
//			action.sendKeys(Keys.RETURN).build().perform();// perform same as Keys.ENTER
			
			//Assertion
			String dashboardHeader = driver.findElement(DASHBOARD_HEADER_FIELD).getText(); // put in String variable.
			System.out.println("Header: " + dashboardHeader); //just to test and printed DashBoard.
			 Assert.assertEquals("Page Not Found", "Dashboard", dashboardHeader);
		
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	


}
