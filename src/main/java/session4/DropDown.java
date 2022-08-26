package session4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	WebDriver driver;
	Select sel;

	By USER_NAME_FIELD = By.xpath("//input[@id='username']");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By LOGIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD_HEADER_FIELD = By.xpath("//h2[contains(text(), 'Dashboard')]");
	By CUSTOMERS_MENU_FIELD = By.xpath("//span[contains(text(), 'Customers')]");
	By ADD_CUSTOMER_MANU_FIELD = By.xpath("//a[contains(text(), 'Add Customer')]");
	By CUSTOMER_FULL_NAME_FIELD = By.xpath("//input[@id='account']");
	By COMPANY_DROPDOWN_FIELD = By.xpath("//select[@id='cid']");
	
	By COUNTRY_NAME_FIELD = By.xpath("//select[@id='country']");
//	By CUSTOMER_FULL_NAME_FIELD = By.xpath("//input[@id='account']");
//	By CUSTOMER_FULL_NAME_FIELD = By.xpath("//input[@id='account']");
//	By CUSTOMER_FULL_NAME_FIELD = By.xpath("//input[@id='account']");
//	By CUSTOMER_FULL_NAME_FIELD = By.xpath("//input[@id='account']");
//	By CUSTOMER_FULL_NAME_FIELD = By.xpath("//input[@id='account']");

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

//		We can call login Test Method here or we can do it on global.

		String userName = "demo@techfios.com"; // also we can store value in variable and use it like userName.
		driver.findElement(USER_NAME_FIELD).sendKeys(userName);
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BUTTON_FIELD).click();

		Assert.assertEquals("Page Not Found", "Dashboard- iBilling", driver.getTitle());
		driver.findElement(CUSTOMERS_MENU_FIELD).click();
		driver.findElement(ADD_CUSTOMER_MANU_FIELD).click();
		driver.findElement(CUSTOMER_FULL_NAME_FIELD).sendKeys("Sraven Tagore");
		
		sel = new Select(driver.findElement(COMPANY_DROPDOWN_FIELD));
		sel.selectByVisibleText("Amazon");
		//sel.selectByIndex(13); either one will work for selecting option.
		sel = new Select(driver.findElement(COUNTRY_NAME_FIELD));
		sel.selectByVisibleText("Bangladesh");
		
		Thread.sleep(3000);

	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
