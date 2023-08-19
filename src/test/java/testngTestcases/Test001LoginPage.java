package testngTestcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.premsaka.practice.browserutility.BrowserUtility;

import pages.LoginPage;

public class Test001LoginPage {
	WebDriver driver;
	BrowserUtility browserutility;
	LoginPage lp;
	@BeforeTest
	public void browserSetup() {

		browserutility=new  BrowserUtility();
		driver=browserutility.BrowserUtility("CHROME", driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test
	public void loginPage() throws InterruptedException {
		lp=new LoginPage(driver);
		Thread.sleep(5000);
		lp.sentUserName("Admin");
		lp.sentPassword("Admin123");
		lp.clickLoginButton();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
	}
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
