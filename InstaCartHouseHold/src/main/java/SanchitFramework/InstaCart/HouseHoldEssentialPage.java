package SanchitFramework.InstaCart;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SanchitFramework.AbstractFunctions.WaitFunctions;

public class HouseHoldEssentialPage extends WaitFunctions {
	
		
		WebDriver driver;
		
		public HouseHoldEssentialPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(css = ".css-3w8d2s")
		List<WebElement> storesNearYou;
		
		@FindBy(css = ".css-1daqy1u")
		List<WebElement> availabilityTime;
		
		@FindBy(css = ".css-15uwigl")
		List<WebElement> productsAvailable;
		
		public void listOfProductsAvailable(){
			waitUntilObjectAppears(productsAvailable);
			productsAvailable.stream().forEach(prod->System.out.println(prod.getText()));
		}
		
		public void storeNameAndDeliveryTime() {
			for(int i = 0; i<storesNearYou.size(); i++) {
				waitUntilObjectAppears(storesNearYou);
				waitUntilObjectAppears(availabilityTime);
				System.out.println("Store " + storesNearYou.get(i).getText() + " is available to do " + availabilityTime.get(i).getText());
			}
		}

		
}
