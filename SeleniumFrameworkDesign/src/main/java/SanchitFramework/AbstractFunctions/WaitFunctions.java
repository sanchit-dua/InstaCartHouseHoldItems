package SanchitFramework.AbstractFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFunctions {
	
	WebDriver driver;
	
	public WaitFunctions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitUntilObjectAppears(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void waitUntilObjectDisappears(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

}
