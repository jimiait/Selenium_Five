package session4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByClass {

	/*
	 * When we use By Class we have provision to store all variable to Global. See
	 * By USER_NAME_FIELD as i.e Every time you go to new page make sure to validate
	 * the page. i.e Dashboard.
	 */

	WebDriver driver;

	By USER_NAME_FIELD = By.xpath("//input[@id='username']");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By LOGIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD_HEADER_FIELD = By.xpath("//h2[contains(text(), 'Dashboard')]");
	By CUSTOMERS_MENU_FIELD = By.xpath("//span[contains(text(), 'Customers')]");
	By ADD_CUSTOMER_MANU_FIELD = By.xpath("//a[contains(text(), 'Add Customer')]");

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
	public void addContact() throws InterruptedException {

//		We can call login Test Method here or 

		String userName = "demo@techfios.com"; // also we can store value in variable and use it like userName.
		driver.findElement(USER_NAME_FIELD).sendKeys(userName);
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BUTTON_FIELD).click();

		Assert.assertEquals("Page Not Found", "Dashboard- iBilling", driver.getTitle());
		driver.findElement(CUSTOMERS_MENU_FIELD).click();
		driver.findElement(ADD_CUSTOMER_MANU_FIELD).click();

		Thread.sleep(3000);

	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
