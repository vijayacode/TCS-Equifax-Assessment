package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class HomePage extends TestBase{
	
	
	
	//We Can select Elements by xpath
	@FindBy(xpath="//input[@type='text']")
	WebElement input_type;
	
	//We can select elemnts by CSS
	@FindBy(css = "#nav-search-submit-button")
	WebElement searchSubmit;
	
	
	//Initializing Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public SearchResultsPage enterSearchKeyword() {
		waitForElement(driver, input_type);
		input_type.sendKeys(prop.getProperty("search"));
		searchSubmit.click();
		return new SearchResultsPage();
	}
	
	
}
