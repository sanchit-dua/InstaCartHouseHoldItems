package SanchitFramework.TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("harshad420@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Harshad@420");
		driver.findElement(By.id("login")).click();
		
		List<WebElement> Items = driver.findElements(By.xpath("//div/h5/b"));
		
		for (WebElement item:Items) {
			
			if (item.getText().contains("ZARA")){
				
				item.findElement(By.xpath("parent::h5/parent::div/button[@style='float: right;']")).click();
				break;
			}
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animation")));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(" .cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		driver.findElement(By.cssSelector(".form-group .text-validated")).sendKeys("india");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results span.ng-star-inserted")));
		
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
	}

}
