package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class ProceedToCheckoutPage extends TestBase{
	
	
	
	//We Can select Elements by xpath
	@FindBy(xpath="//div[@id='hlb-subcart']//span[@class='a-color-price hlb-price a-inline-block a-text-bold']")
	WebElement productPrice;
	
	
	//Initializing Page Objects
	public ProceedToCheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public String getCartPrice() {
		return productPrice.getText();
	}
	
	
}
