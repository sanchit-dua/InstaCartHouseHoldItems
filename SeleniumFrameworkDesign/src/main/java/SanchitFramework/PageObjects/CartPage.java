package SanchitFramework.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SanchitFramework.AbstractFunctions.WaitFunctions;

public class CartPage extends WaitFunctions{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='cartSection'] //h3")
	List<WebElement> listOfProductsInCart;
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutButton;
	
	public boolean checkCartProduct() {
		Boolean match = listOfProductsInCart.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
		return match;
	}
	
	public void checkout() {
		checkoutButton.click();
	}

}
