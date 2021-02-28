package com.amazon.util;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	
	
		public static long PAGE_LOAD_TIMEOUT = 40;
		public static long IMPLICIT_WAIT = 30;
		public static long ELEMENT_VISIBLE_TIME = 10;
		
		private WebDriverWait wait;
		
		public void waitForElement(WebDriver driver, WebElement locator) {
			try {
			wait = new WebDriverWait(driver, ELEMENT_VISIBLE_TIME);
			wait.until(ExpectedConditions.visibilityOf(locator));
			}catch(Exception e) {
				throw new NoSuchElementException(String.format("%s is not visible", locator));
			}
		}
		


}
