package SanchitFramework.InstaCart;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HouseHoldEssentials extends Configuration {
	
	@Test(dataProvider="getData")
	
	public void houseHoldEssentialAssignment() throws IOException {
		
		
		MainPage mainPage = launchApplication();
		HouseHoldEssentialPage houseHoldEssentialPage = mainPage.goToHouseHoldEssential();
		
		houseHoldEssentialPage.listOfProductsAvailable();
		houseHoldEssentialPage.storeNameAndDeliveryTime();
		
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		List<HashMap<String,String>> data = getJsonDataToMap("//src//test//java//SanchitFramework//Data//test.json");
		return new Object[][] {{data.get(0)}};
	}
	
	

}
