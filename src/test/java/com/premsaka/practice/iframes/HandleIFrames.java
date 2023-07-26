package com.premsaka.practice.iframes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.premsaka.practice.browserutility.BrowserUtility;

public class HandleIFrames {
	BrowserUtility browserutility;
	WebDriver driver;
	
	@BeforeMethod
	public void setupDriver() {
		browserutility=new  BrowserUtility();
		driver=browserutility.BrowserUtility("CHROME", driver);
	}
	
	
	@Test()
	public void lunchBrowser() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("frm1"))));
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		//System.out.println(driver.findElement(By.id("frm1")).getText());
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("selectnav1"))));
		driver.findElement(By.id("selectnav1")).click();
		Select select=new Select(driver.findElement(By.id("selectnav1")));		
		select.selectByVisibleText("- Java");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).sendKeys("PremSaka");
	}
	
	@Test
	public void testIframes() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().window().maximize();
		List<WebElement> iframes=driver.findElements(By.tagName("iframe"));
		for(WebElement elements:iframes) {
			String FRAME=elements.getAttribute("id");
			if(FRAME.startsWith("frm1")||FRAME.startsWith("frm2")||FRAME.startsWith("frm3")) {
			driver.switchTo().frame(elements);
			Actions action=new Actions(driver);
			action.moveToElement(driver.findElement(By.id("selectnav1")));
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("selectnav1"))));
			driver.findElement(By.id("selectnav1")).click();
			Select select=new Select(driver.findElement(By.id("selectnav1")));		
			select.selectByIndex(2);
			driver.switchTo().defaultContent();
			}
		}
	}
	
	@AfterTest
	public void closeBroser() {
		driver.quit();
	}

}
