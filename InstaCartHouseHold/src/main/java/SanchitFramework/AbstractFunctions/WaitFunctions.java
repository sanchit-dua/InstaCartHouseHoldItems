package SanchitFramework.AbstractFunctions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFunctions {
	
	WebDriver driver;
	
	public WaitFunctions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitUntilObjectAppears(List<WebElement> productsAvailable) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(productsAvailable));
	}
	
	

}
