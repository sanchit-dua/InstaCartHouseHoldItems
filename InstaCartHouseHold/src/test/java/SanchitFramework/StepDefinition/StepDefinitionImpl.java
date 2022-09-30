 package SanchitFramework.StepDefinition;

import java.io.IOException;

import SanchitFramework.InstaCart.Configuration;
import SanchitFramework.InstaCart.HouseHoldEssentialPage;
import SanchitFramework.InstaCart.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends Configuration{
	
	public MainPage mainPage;
	public HouseHoldEssentialPage houseHoldEssentialPage;
	@Given("Instacart Application is launched")
	public void Instacart_Application_is_launched() throws IOException {
		mainPage = launchApplication();
	}
	
	@When("HouseHold Essential page is opened")
	public void HouseHold_Essential_page_is_opened() {
		houseHoldEssentialPage = mainPage.goToHouseHoldEssential();
	}
	
	@Then("List of products is listed")
	public void List_of_products_is_listed() {
		
		houseHoldEssentialPage.listOfProductsAvailable();
	}
	
	@And("List of stores with their delivery time is listed")
	public void List_of_stores_with_their_delivery_time_is_listed(){
		houseHoldEssentialPage.storeNameAndDeliveryTime();
	}

}
