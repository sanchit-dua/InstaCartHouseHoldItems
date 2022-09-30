package SanchitFramework.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	//@BaseTest
	public WebDriver initializeDriver() throws IOException {
	
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream("/Users/sanchitdua/eclipse-workspace/SeleniumFrameworkDesign/src/main/java/SanchitFramework/Resources/Global.properties");
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	
	if (browserName.equalsIgnoreCase("chrome")){
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	else if (browserName.equalsIgnoreCase("edge")) {
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	
	else if (browserName.equalsIgnoreCase("firefox")) {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	return driver;
	
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}

}
