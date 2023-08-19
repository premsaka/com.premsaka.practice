package com.premsaka.practice.browserutility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserUtility {
	private final String CHROMEDRIVER="drivers/chromedriver.exe";
	private final String FIREFOXDRIVER="drivers/geckodriver.exe";
	private final String EDGEDRIVER="";
	WebDriver driver;
	RemoteWebDriver driverRm; 
	public WebDriver BrowserUtility(String BROSWERNAME, WebDriver driver) {
		switch(BROSWERNAME){
		case "CHROME":
			System.setProperty("WebDeriver.chromeDriver", CHROMEDRIVER);
			driver= new ChromeDriver();
			break;
		case "FIREFOX":
			System.setProperty("WebDriver.geckodriver", FIREFOXDRIVER);
			driver=new FirefoxDriver();
			break;	
		case "SAUCELABS":
			driver= new ChromeDriver();
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName("Windows 11");
			browserOptions.setBrowserVersion("latest");
			Map<String, Object> sauceOptions = new HashMap<>();
			sauceOptions.put("username", "oauth-igetcode-d1b2f");
			sauceOptions.put("accessKey", "e5561e90-566f-4784-ac13-df5d8528040d");
			sauceOptions.put("build", "selenium-build-SI11F");
			sauceOptions.put("name", "<your test name>");
			browserOptions.setCapability("sauce:options", sauceOptions);
			URL url;
			try {
				url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
				driverRm= new RemoteWebDriver(url, browserOptions);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return driver;
	}
}
