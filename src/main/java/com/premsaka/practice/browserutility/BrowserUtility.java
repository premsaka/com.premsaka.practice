package com.premsaka.practice.browserutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtility {
	private final String CHROMEDRIVER="drivers/chromedriver.exe";
	private final String FIREFOXDRIVER="drivers/geckodriver.exe";
	private final String EDGEDRIVER="";
	WebDriver driver;
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
		}
		return driver;
	}
}
