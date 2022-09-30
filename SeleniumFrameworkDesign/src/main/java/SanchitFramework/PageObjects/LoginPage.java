package SanchitFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id = "userEmail")
	WebElement email;
	
	@FindBy(id = "userPassword")
	WebElement password;
	
	@FindBy(id = "login")
	WebElement loginButton;
	
	public void openURL() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public void successfulLogin(String UserId, String UserPassword) {
		email.sendKeys(UserId);
		password.sendKeys(UserPassword);
		loginButton.click();
	}
}
