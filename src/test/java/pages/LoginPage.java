package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(name = "username")
	private WebElement txt_username;
	@FindBy(name="password")
	private WebElement txt_password;
	@FindBy(xpath = "//button")
	private WebElement loginButton;
	@FindBy(xpath="//h5")
	private WebElement loginPage;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void sentUserName(String username) {
		txt_username.sendKeys(username);
	}
	public void sentPassword(String passwrod) {
		txt_password.sendKeys(passwrod);
	}
	public void clickLoginButton() {
		loginButton.click();
	}
	public void validateLoginPage() {
		
	}
}
