package SanchitFramework.InstaCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	WebDriver driver;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".css-1npa5ir path[fill-rule='evenodd']")
	WebElement hamburgerButton;
	
	@FindBy(css = "div[aria-controls='more-ways-to-shop']")
	WebElement waysToShop;
	
	@FindBy(xpath = "//div[text()='Household essentials']")
	WebElement houseHoldEssentialButton;
	
	public void openUrl() {
		driver.get("https://www.instacart.ca/");
	}
	
	public HouseHoldEssentialPage goToHouseHoldEssential() {
		
		hamburgerButton.click();
		waysToShop.click();
		houseHoldEssentialButton.click();
		HouseHoldEssentialPage houseHoldEssentialPage = new HouseHoldEssentialPage(driver);
		return houseHoldEssentialPage;
	}

}
