package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class SearchResultsPage extends TestBase{
	
	
	
	//We Can select Elements by xpath
	@FindBy(xpath="//span[@data-component-type='s-search-results']//div[@data-index='1']//span[@class='a-price-whole']")
	WebElement wholePrice;
	
	@FindBy(xpath="//span[@data-component-type='s-search-results']//div[@data-index='1']//span[@class='a-price-fraction']")
	WebElement fractionPrice;
	
	@FindBy(xpath="//span[@data-component-type='s-search-results']//div[@data-index='1']//span[@class='a-price-symbol']")
	WebElement priceSymbol;
	
	//We can select Elements by CSS
	@FindBy(xpath = "//span[@data-component-type='s-search-results']//div[@data-index='1']//a[@class='a-link-normal a-text-normal']")
	WebElement selectFirstProduct;
	
	
	//Initializing Page Objects
	public SearchResultsPage() {
		PageFactory.initElements(driver, this);
	}

	public String getPriceOfFirstItem() {
		return String.format("%s%s.%s", priceSymbol.getText(), wholePrice.getText(), fractionPrice.getText());
	}
	
	public ProductPage navigateToProductPage() {
		selectFirstProduct.click();
		return new ProductPage();
	}
	
	
}
