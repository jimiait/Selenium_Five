package session4;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverOver {

	WebDriver driver;

	By PRODUCT_DROPDOWN_MANU_FIELD = By.xpath("//div[@id='unified-masthead-navigation']/nav/ul/li[2]/a/span");
	By NETWORKING_MANU_FIELD = By.xpath("//a[text()= 'Networking']");
	By HOME_NETWORKING_MANU_FIELD = By.xpath("//a[text()= 'Networking']/parent::li/descendant::a[3]");

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.dell.com/en-us");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void mouseHover() {

		/*
		 * Mouse Hover Over Actions action = new Actions(driver); action.move Action
		 * Class required .build().perform();
		 * 
		 */

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(PRODUCT_DROPDOWN_MANU_FIELD)).build().perform();
		action.moveToElement(driver.findElement(NETWORKING_MANU_FIELD)).build().perform();
		driver.findElement(HOME_NETWORKING_MANU_FIELD).click(); // this one dosen't need action class cuz it is visible.

	}

	// @After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
