package SanchitFramework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SanchitFramework.AbstractFunctions.WaitFunctions;

public class ProductsPage extends WaitFunctions {
	
WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	String product = "ZARA COAT 3";
	By productSelection = By.xpath("parent::h5/parent::div/button[@style='float: right;']");
	By spinner = By.cssSelector(".ng-animation");
	By toastMessage = By.id("toast-container");
	
	@FindBy(xpath = "//div/h5/b")
	List<WebElement> listOfProducts;
	
	@FindBy(xpath = "//*[@routerlink='/dashboard/cart']")
	WebElement moveToCartButton;
	
	public void selectProduct() {
		for(WebElement element:listOfProducts) {
			if (element.getText().equalsIgnoreCase(product)) {
				element.findElement(productSelection).click();
				break;
			}
		}
		
		
	}
	
	public void moveToCart() {
		waitUntilObjectAppears(toastMessage);
		waitUntilObjectDisappears(spinner);
		moveToCartButton.click();
	}

}
