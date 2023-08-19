package mobileTesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TestBasic {
	AppiumDriver driver;
	DesiredCapabilities desiredCapabilities;
	@BeforeTest
	public void setUpMobiledevice() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	}
	
	@Test
	public void test() throws MalformedURLException {
		 URL remoteUrl=new URL("http://localhost:4723/wd/hub");
		 driver = new AppiumDriver(remoteUrl, desiredCapabilities);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Chrome\"]"));
		driver.findElement(By.id("XSqSscr")).clear();
		driver.findElement(By.id("XSqSsc")).sendKeys("ipaddress");
		driver.findElement(By.id("XSqSsc")).sendKeys(Keys.ENTER);
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
