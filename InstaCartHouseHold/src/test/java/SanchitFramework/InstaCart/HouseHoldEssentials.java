package SanchitFramework.InstaCart;

import java.io.IOException;
import org.testng.annotations.Test;

public class HouseHoldEssentials extends Configuration {
	
	@Test
	
	public void houseHoldEssentialAssignment() throws IOException {
		
		
		MainPage mainPage = launchApplication();
		HouseHoldEssentialPage houseHoldEssentialPage = mainPage.goToHouseHoldEssential();
		
		houseHoldEssentialPage.listOfProductsAvailable();
		houseHoldEssentialPage.storeNameAndDeliveryTime();
		
		
		
	}
	

}
