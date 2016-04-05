package demo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.beust.jcommander.Parameter;

public class MultipleBrowserSearchTest {

	public WebDriver driver;
	String baseUrl = "http://10.13.6.55:8013/kiwi/";
	String loginName = "u1@testb.dom";
	String passWd = "p";



	@Test
	public void testLoginKiwi() {

		driver.get(baseUrl);
		try {

			Thread.sleep(5000);

		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		WebElement userName = driver.findElement(By
				.xpath("//*[@id='textfield-1018-inputEl']"));
		WebElement passWord = driver.findElement(By
				.xpath("//*[@id='textfield-1019-inputEl']"));
		WebElement loginBtn = driver.findElement(By
				.xpath("//*[@id='button-1020-btnIconEl']"));
		WebElement loginLogo = driver.findElement(By
				.xpath("//*[@id='container-1016-innerCt']"));

		Assert.assertTrue(loginLogo.isDisplayed());
		Assert.assertTrue(userName.isDisplayed());

		userName.sendKeys(loginName);
		passWord.sendKeys(passWd);
		loginBtn.click();

		try {

			Thread.sleep(5000);

		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		Assert.assertTrue(driver.getPageSource().contains("Inbox"));
	}

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String Browser) {

		if (Browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.firefox.bin",
					"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver();

		} else if (Browser.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver",
					"C:\\Program Files (x86)\\Internet Explorer\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			driver = new ChromeDriver();

		}

	}

	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}

}
