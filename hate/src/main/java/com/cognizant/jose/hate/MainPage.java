package com.cognizant.jose.hate;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;


public class MainPage {
	
	@FindBy (id ="quote")
	public WebElement quote;
	
	@FindBys({
		@FindBy(id = "quote"),
		@FindBy(tagName = "h2")
	})
	public WebElement quoteText;
	
	
	public boolean quoteFindThread() {
		boolean found = false;

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(quote.getText().contains("I HATE YOU!")) {
			found = true;
		}
		
		return found;

	}


	
	

}
