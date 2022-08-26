package session4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollUpDown {
	
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
	public void scrollUpDown() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,5000)");
		Thread.sleep(2000);
		js.executeScript("scroll(0,0)"); //it will take you back up.
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,6000)");
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
