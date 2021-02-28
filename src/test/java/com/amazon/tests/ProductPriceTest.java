package com.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProceedToCheckoutPage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.SearchResultsPage;


public class ProductPriceTest extends TestBase{
	
	HomePage homepage;

	
	public ProductPriceTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initializatio();
		
		homepage = new HomePage();
	}
	
	
	@Test(priority=1)
	public void pageTitleVerify() {
		String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
	}
	
	@Test(priority=2, dependsOnMethods={"pageTitleVerify"}, alwaysRun=true)
	public void productPriceTest() {
		SearchResultsPage searchResults = homepage.enterSearchKeyword();
		String priceOnSearch = searchResults.getPriceOfFirstItem();
		System.out.println(String.format("Search Price: %s", priceOnSearch));
		ProductPage productPage = searchResults.navigateToProductPage();
		String priceOnProductPage = productPage.getProductPrice();
		
		System.out.println(String.format("Search Price: %s and Product Page Price %s", priceOnSearch, priceOnProductPage));
		
		Assert.assertEquals(priceOnSearch, priceOnProductPage, "Comparing Price on Search Results with Price on Product Page");
		
		
		ProceedToCheckoutPage proceedToCheckoutPage = productPage.addToCart();
		
		String cartPrice = proceedToCheckoutPage.getCartPrice();
		
		System.out.println(String.format("Search Price: %s and Cart Price %s", priceOnSearch, cartPrice));
		
		Assert.assertEquals(priceOnSearch, cartPrice, "Comparing Price on Search Results with Price on Proceed to Checkou Page");
		
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}

	
}
