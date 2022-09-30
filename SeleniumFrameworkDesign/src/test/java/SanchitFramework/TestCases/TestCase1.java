package SanchitFramework.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import SanchitFramework.BaseTest.BaseTest;
import SanchitFramework.PageObjects.CartPage;
import SanchitFramework.PageObjects.LoginPage;
import SanchitFramework.PageObjects.PaymentPage;
import SanchitFramework.PageObjects.ProductsPage;

public class TestCase1 extends BaseTest{

	@Test
	
	public void submitOrder() throws IOException {
	
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openURL();
		loginPage.successfulLogin("harshad420@gmail.com", "Harshad@420");
		
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.selectProduct();
		productsPage.moveToCart();
	
		CartPage cartPage = new CartPage(driver);
		Assert.assertTrue(cartPage.checkCartProduct());
		cartPage.checkout();
		
		PaymentPage paymentPage = new PaymentPage(driver);
		paymentPage.placeOrder();
	}

}
