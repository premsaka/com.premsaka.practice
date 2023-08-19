package cucumberTestCases;

import org.openqa.selenium.WebDriver;

import com.premsaka.practice.browserutility.BrowserUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Login {
	BrowserUtility browserutility;
	WebDriver driver;
	LoginPage lp;
	@Before
	public void setupMethods() {
		
		browserutility=new  BrowserUtility();
		driver=browserutility.BrowserUtility("CHROME", driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@Given("Open browser and navigate to application")
	public void open_browser_and_navigate_to_application() {
	
		
	}

	@And("I check the login page is lunch sucessfully")
	public void i_check_the_login_page_is_lunch_sucessfully() {
	  System.out.println("skipped");
	}

	@When("^I enter the (.*) and (.*) and clickon login button$")
	public void i_enter_the_username_and_password_and_clickon_login_button(String username, String passwrod) throws InterruptedException {
		Thread.sleep(2000);
		lp=new LoginPage(driver);
		Thread.sleep(2000);
	   lp.sentUserName(username);
		Thread.sleep(2000);
	   lp.sentPassword(passwrod);
		Thread.sleep(2000);
	   lp.clickLoginButton();
	}

	@Then("I see the home page is loading sucessfully")
	public void i_see_the_home_page_is_loading_sucessfully() {
	  System.out.println("sklpeed step");
	}

	@And("I logout from the application")
	public void i_logout_from_the_application() {
		
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
