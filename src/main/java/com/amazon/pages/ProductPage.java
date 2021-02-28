package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class ProductPage extends TestBase{
	
	
	
	//We Can select Elements by xpath
	@FindBy(xpath="//div[@class='a-box-inner']//span[@id='newBuyBoxPrice']")
	WebElement productPrice;
	
	//We can select elemnts by CSS
	@FindBy(xpath = "//div[@class='a-box-inner']//div[@class='a-section']//input[@id='add-to-cart-button']")
	WebElement addToCartButton;
	
	
	//Initializing Page Objects
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}


	public String getProductPrice() {
		return productPrice.getText();
	}
	
	public ProceedToCheckoutPage addToCart() {
		addToCartButton.click();
		return new ProceedToCheckoutPage();
	}
	
	
}
