package SanchitFramework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SanchitFramework.AbstractFunctions.WaitFunctions;

public class PaymentPage extends WaitFunctions{
	
	WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By countryList = By.cssSelector(".ta-results span.ng-star-inserted");
	
	@FindBy(css = ".form-group .text-validated")
	WebElement countryDropdown;
	
	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement indiaOption;
	
	@FindBy(css = ".action__submit")
	WebElement placeOrderButton;
	
	public void placeOrder() {
		countryDropdown.sendKeys("india");
		waitUntilObjectAppears(countryList);
		indiaOption.click();
		placeOrderButton.click();
	}
	

}
