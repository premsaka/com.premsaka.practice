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
			break;
			
		}
		return driver;
	}
}
