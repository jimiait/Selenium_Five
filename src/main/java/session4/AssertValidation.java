package session4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssertValidation {

	/*
	 * Assert method Assert.assertTrue("Page did not display",
	 * dashBordHeaderElement.isDisplayed());
	 * Assert.assertTrue("Page did not display",
	 * dashBordHeaderElement.isDisplayed()); To validate any page we need Assert
	 * Class. Assert.assertEquals("Page Not Found", "Dashboard- iBilling",
	 * driver.getTitle());
	 * .getText(); 
	 * .getTitle();
	 */

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
	};

	@Test
	public void assertValidation() throws InterruptedException {

		By USER_NAME_FIELD = By.xpath("//input[@id='username']");
		By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
		By LOGIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By DASHBOARD_HEADER_FIELD = By.xpath("//h2[contains(text(), 'Dashboard')]");

		String userName = "demo@techfios.com";
		driver.findElement(USER_NAME_FIELD).sendKeys(userName);
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BUTTON_FIELD).click();

		String dashboardHeader = driver.findElement(DASHBOARD_HEADER_FIELD).getText(); // put in String variable.
//		System.out.println("Header: " + dashboardHeader); //just to test and printed DashBoard.
		// Assert.assertEquals("Page Not Found", "Dashboard", dashboardHeader); //NO.1

//		There is another option we can find the dashboard result. Search for <title>Dashboard -iBilling</title>
//		Assert.assertEquals("Page Not Found", "Dashboard- iBilling", driver.getTitle()); // NO.2

		Thread.sleep(3000);

	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
