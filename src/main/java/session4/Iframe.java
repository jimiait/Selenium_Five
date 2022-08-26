package session4;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Iframe {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void iframe() throws InterruptedException {

		/*
		 * ERROR shows: NoSuchFrameException: No frame element found by name or id
		 * packageFrame. The way we did code it should not give that error but ORACLE
		 * made their code such different way. Some webSite will work the way we did
		 * code. Solution to Oracle website code is we have bring back webDriver to
		 * default place first. note: driver.switchTo().parentFrame(); and
		 * driver.switchTo().defaultContent(); both will give same result.
		 * 
		 */

		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("java.awt")).click();
//		String pack = driver.findElement(By.xpath("//h2[@title='Packages']")).getText();
//		Assert.assertEquals("Page not found", "Packages", pack);
//		System.out.println(pack);

		driver.switchTo().parentFrame();
//		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("Adjustable")).click();
//		String interfa = driver.findElement(By.xpath("//h2[@title='Interfaces']")).getText();
//		Assert.assertEquals("Page not found", "Interfaces", interfa);
//		System.out.println(interfa);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//h2[@title='Interface Adjustable']"));
//		String intAdj = driver.findElement(By.xpath("//h2[@title='Interface Adjustable']")).getText();
//		Assert.assertEquals("Page not found", "Interface Adjustable", intAdj);
//		System.out.println(intAdj);

	}

	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
