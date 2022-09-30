package SanchitFramework.InstaCart;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Configuration {
	
public WebDriver driver;
	
	@BeforeMethod
	public WebDriver initializeDriver() throws IOException {
	
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	
	}
	
	public MainPage launchApplication() throws IOException {
		
		driver = initializeDriver();
		MainPage mainPage = new MainPage(driver);
		mainPage.openUrl();
		return mainPage;
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}

}
