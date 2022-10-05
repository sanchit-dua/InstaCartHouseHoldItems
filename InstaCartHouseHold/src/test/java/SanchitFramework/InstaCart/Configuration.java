package SanchitFramework.InstaCart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Configuration {
	
public WebDriver driver;
	
	@BeforeMethod
	public WebDriver initializeDriver() throws IOException {
	
	
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
				"//src//main//java//SanchitFramework//Resources//Global.properties");
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
	
	public   List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		
		String js = FileUtils.readFileToString(new File(System.getProperty("user.dir") + filePath), 
				StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(js, new TypeReference <List<HashMap<String,String>>>(){});
		return data;
	}

}
